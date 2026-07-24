from google import genai

client = genai.Client(api_key="AIzaSyB6VWKw7H7eaU8rltDp3Sv0DMaVBmYL7Kg")

response = client.models.generate_content(
    model="gemini-2.5-flash",
    contents="Say hello in one sentence"
)
 
print(response.text)