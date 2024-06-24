public class Recursion2 {
    public static int tillingproblem(int n){
        if(n==0 || n==1) return 1;
        int fnm1=tillingproblem(n-1);
        int fnm2=tillingproblem(n-2);
        return fnm1+fnm2;
    }
    public static void removeduplicates(String str,int index,StringBuilder newstr,boolean map[]){
        if(index==str.length()){
            System.out.println(newstr);
            return;
        }
        char currchar=str.charAt(index);

        if(map[currchar-'a']==true){
            removeduplicates(str, index +1, newstr, map);
        }
        else{
            map[currchar-'a']=true;
            newstr.append(currchar);
            removeduplicates(str, index, newstr, map);
        }
    }

    public static void printbinarystring(String str,StringBuilder newstr,int index){
        if(str.length()==index){
            System.out.println(newstr);
            return;
        }
        if(str.charAt(index)=='1' && str.charAt(index+1)=='1'){
            printbinarystring(str, newstr, index +1);
        }
        else{
            newstr.append(str.charAt(index));
            printbinarystring(str,newstr , index +1);
        }
    }

    public static int totalways(int n){
        if(n==1 ||n==2) return n;
        return totalways(n-1)+(n-1)*totalways(n-2);
    }

    public static void binarystring(int n,int lastdigit,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        binarystring(n-1,0, str+"0");
        if(lastdigit==0){
            binarystring(n-1,1, str+"1");
        }

        

    }
    public static void search(int target ,int nums[],int index ){
        if(index==nums.length) return;
        if(nums[index]==target){
            System.out.print(index +" ");
        }
        search(target, nums,  index+1);
    }

    public static void ConvertToString(int n){
        if(n==0) return;
        ConvertToString( n/10);
        int ld=n%10;
        if(ld==0) System.out.print("Zero ");
        else if(ld==1) System.out.print("One ");
        else if(ld==2) System.out.print("Two ");
        else if(ld==3) System.out.print("Three ");
        else if(ld==4) System.out.print("Four ");
        else if(ld==5) System.out.print("Five ");
        else if(ld==6) System.out.print("Six ");
        else if(ld==7) System.out.print("Seven ");
        else if(ld==8) System.out.print("Eight ");
        else if(ld==9) System.out.print("Nine ");
        
    }


    public static void LengthOfString(String str,int count){

        if(str.charAt(count)!=' ') count++;
        LengthOfString(str, count);
        System.out.print(count);
    }

    public static int Length(String str){
        if(str.isEmpty()){
            return 0;
        }
        return Length(str.substring(1))+1;
    }

    public static int NoOfSubstrings(String S,int i,int l,int n){
        if(n==1) return 1;
        if(n<=0) return 0;
        int res=NoOfSubstrings(S, i+1, l, n)+NoOfSubstrings(S, i, l-1, n)-NoOfSubstrings(S, i+1, l-1, n-2);
        if(S.charAt(i)==S.charAt(l)) res++;
        return res;
    }

    public static void TowerOfHanoi(int n,String src,String helper,String des){
        if(n==1){
            System.out.println("Transfer disk"+n+" from "+src +"to "+des);
            return;
        }
        TowerOfHanoi(n-1, src, helper, des);
        System.out.println("Transfer disk"+n+" from "+src +"to "+helper);
        TowerOfHanoi(n-1, helper,src, des);
    }


    public static void main(String[] args) {
        // int num[]={3,2,4,5,6,2,7,2,2};
        // search(2, num, 0);
        // String str="Sachin kumar singh";
        System.out.println(NoOfSubstrings("aba", 0, 2, 0));
        // ConvertToString(1947);
        TowerOfHanoi(3, "A","B","C");
        
    }
}
