import java.util.*;
import java.util.Arrays;
public class Stringsone {
    public static void printletters(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
    }

    public static boolean isPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static float getshortestpath(String str){
        int x=0,y=0;
        for(int i=0;i<str.length();i++){
            char dir=str.charAt(i);
            if(dir=='N') y++;
            else if(dir=='S') y--;
            else if(dir=='W') x--;
            else x++;
        }
        int x2=x*x,y2=y*y;
        return  (float)Math.sqrt(x2+y2);
    }

    public static void largest(String str[]){
        String largest=str[0];
        for(int i=0;i<str.length;i++){
            if(largest.compareTo(str[i])<0) largest=str[i];
        }
        
    }

    public static String touppercase(String str){
        StringBuilder sb=new StringBuilder("");
        char ch=Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public static int countlowercasevowels(String str){
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a' ||str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' ||str.charAt(i)=='u'){
                count++;
            }
        }
        return count;
    }

    ///false true//

    public static String compress(String str){
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<str.length();i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1) sb.append(count.toString());

        }
        return sb.toString();
    }
    public static boolean check(String str,char ch){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==ch) return true;
        }
        return false;
    }

    public static void checkAnalgram(String str1,String str2){
        if(str1.length()!=str2.length()){
            System.out.println("Strings are not Analgram");
            return;
        }
        for(int i=0;i<str1.length();i++){
            if(check(str2,str1.charAt(i)) == false){
                System.out.println("Strings are not Analgram");
                return;
            }
        }

        System.out.println("Analgram");
        return;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter first String:");
        String str1=sc.nextLine();
        System.out.println("Enter second String:");
        String str2=sc.nextLine();


        if(str1.length()==str2.length()){
            str1=str1.toLowerCase();
            str2=str2.toLowerCase();

            char[] str1chararray=str1.toCharArray();
            char[] str2chararray=str2.toCharArray();

            Arrays.sort(str1chararray);
            Arrays.sort(str2chararray);

            boolean result=Arrays.equals(str1chararray,str2chararray);
            System.out.println(result);
            if(result){
                System.out.println(str1+" and "+str2+" are Anagrams.");
            }
            else{
                System.out.println(str1+" and "+str2+" are not Anagrams!!!");
            }
        }
        else{
            System.out.println(str1+" and "+str2+" are not Anagrams!!!");
        }
        sc.close();
    }
}
