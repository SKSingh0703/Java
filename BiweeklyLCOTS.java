import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

public class BiweeklyLCOTS {

    public String kthDistinct(String[] arr, int k) {
        LinkedHashSet<Integer> hs = new LinkedHashSet<>();
        HashSet<Integer> rem = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if (rem.contains(arr[i])) {
                continue;
            }
            if (hs.contains(arr[i])) {
                hs.remove(arr[i]);
                rem.add(arr[i]);
            }
            else{
                hs.add(arr[i]);
            }
        }
        Iterator<String> iterator = hs.iterator();
        int index = 1;
        String kthElement = null;
        
        while (iterator.hasNext()) {
            kthElement = iterator.next();
            if (index == k) {
                return kthElement;
            }
            index++;
        }           
        }
    }





    public static void main(String[] args) {
        
    }
}
