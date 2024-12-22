import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class abc {
    public static void main(String[] args) {
        try {
            // Create the URL object
            URL url = new URL("https://leetcode.com/graphql/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0"); // Mimic a browser
            conn.setDoOutput(true);

            // GraphQL query to fetch questions
            String query = """
            {
                "query": "query { problemsetQuestionList(categorySlug: \"\", limit: 10) { questions { titleSlug } } }"
            }
            """;

            // Send request
            try (OutputStream os = conn.getOutputStream()) {
                os.write(query.getBytes());
            }

            // Check response code
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        System.out.println(responseLine);
                    }
                }
            } else {
                // Read error response
                InputStream errorStream = conn.getErrorStream();
                if (errorStream != null) {
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(errorStream))) {
                        String responseLine;
                        while ((responseLine = br.readLine()) != null) {
                            System.out.println("Error Response: " + responseLine);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





