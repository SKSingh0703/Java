import java.util.*;
public class ArraysList {

//     public static void printArrayList(ArrayList<Integer> list){
//         for(int i=0;i<list.size();i++){
//             System.out.print(list.get(i)+"  ");
//         }
//     }

//     public static void SwapTwoNumbers(ArrayList<Integer> list,int i,int j){
//         int temp=list.get(j);
//         list.set(j,list.get(i) );
//         list.set(i,temp );
//         return;

//     }

//     public static int ContainerWithMostWater(ArrayList<Integer> height){
//         int maxwater=0,currWater=0,lp=0,rp=height.size()-1;
//         while(lp<rp){
//             currWater=(rp-lp)*Math.min(height.get(rp), height.get(lp));
//             maxwater=Math.max(maxwater,currWater);
//             if(height.get(rp)< height.get(lp)) rp--;
//             else lp++;
//         }
//         return maxwater;
//     }

//     public static boolean SumTarget(ArrayList<Integer> list,int target){
//         int i= 0,j=list.size()-1;
//         while(i<j){
//             if(list.get(i)==list.get(j)) return true;
//             else if(list.get(i)+list.get(j)>target) j--;
//             else i++;
//         }
//         return false;
//     }

//     public static boolean PairsuminrotatedArray(ArrayList<Integer> list,int target){
//         int bp=-1;
//         int n=list.size();
//         for(int i=0;i<list.size();i++){
//             if(list.get(i)>list.get(i+1)){
//                 bp=i;
//                 break;
//             }
//         }
//         int lp=bp,rp=bp+1;
//         while (lp!=rp) {
//             if(list.get(rp)+list.get(lp)==target) return true;
//             else if(list.get(rp)+list.get(lp)>target) lp=(n+lp-1)%n;
//             else rp=(rp+1)%n;
//         }
//         return false;
//     }
//     public static boolean MonotonicOrNot(ArrayList<Integer> nums){
//         if(nums.get(0)>nums.get(1)){
//             for(int i=0;i<nums.size()-1;i++){
//                 if(nums.get(i)<nums.get(i+1)){
//                     return false;
//                 }
//             }
//         }
//         else{
//             for(int j=0;j<nums.size()-1;j++){
//                 if(nums.get(j)>nums.get(j+1)){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

//     public static boolean MonotonicBV(ArrayList<Integer> nums){
//         boolean inc =true;
//         boolean dec=true;
//         for(int i=0;i<nums.size()-1;i++){
//             if(nums.get(i)>nums.get(i+1)){
//                 inc=false;
//             }
//             if(nums.get(i)<nums.get(i+1)){
//                 dec=false;
//             }
//         }
//         return inc||dec;
//     }
//     public static void MostFrequentNumber(ArrayList<Integer> nums,int key){
//         int maxelement=Integer.MIN_VALUE;
//         int tempelement=-1;
//         int cursor=-1;
//         for(int i=0;i<nums.size();i++){
//             maxelement=Math.max(maxelement,nums.get(i));
//         }
//         int temp[]=new int[maxelement];
//         for(int i=0;i<nums.size()-1;i++){
//             if(nums.get(i)==key){
//                 temp[nums.get(i+1)]++;
//             }
//         }
//         for(int i=0;i<temp.length;i++){
//             if(tempelement<temp[i]){
//                 tempelement=temp[i];
//                 cursor=i;
//             }
//         }
//         System.out.println(cursor);

//     }
//     public static boolean Duplicate(ArrayList<Integer> list,int target){
//         for(int i=0;i<list.size();i++){
//             for(int j=i+1;j<list.size();j++){
//                 if(list.get(i)==list.get(j)){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
//     public static boolean search(ArrayList<Integer> list ,int target){
//         for(int i=0;i<list.size();i++){
//             if(list.get(i)==target) return true;
//         }
//         return false;
//     }

//     public static void LonelyNumbers(ArrayList<Integer> nums){
//         ArrayList<Integer> temp=new ArrayList<>();
//         for(int i=0;i<nums.size();i++){
//             if((!Duplicate(nums, nums.get(i))) &&  ((!search(nums, nums.get(i)+1)) && (!search(nums, nums.get(i)-1))) ){
//                 temp.add(nums.get(i));
//             } 
//         }
//         System.out.print(temp);

//     }

//     public static void Lonely(ArrayList<Integer> nums){
//         int temp[]=new int[107];
//         ArrayList<Integer> list=new ArrayList<>();
//         for(int i=0;i<nums.size();i++){
//             // temp[nums.get(i)+1]++;
//             // temp[nums.get(i)-1]++;
//             for(int k=i+1;k<nums.size();k++){
//                 if(nums.get(i)==nums.get(k)){
//                     temp[nums.get(i)]++;
//                 }
//             }
       
//         }
//         for(int i=0;i<nums.size();i++){
//             if(temp[nums.get(i)]==0 && temp[nums.get(i)+1]==0 &&temp[nums.get(i)-1]==0){
//                 list.add(nums.get(i));
//             }
//         }
//         System.out.print(list);
//         for(int i=0;i<temp.length;i++){
//             System.out.print(temp[i]+ " ");
//         }
//     }

//     public static boolean check(ArrayList<Integer> list,int ci){
//         for(int i=0;i<ci;i++){
//             for(int j=ci+1;j<list.size();j++){
//                 if(2*list.get(ci)==list.get(i)+list.get(j)){
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }
//     public static boolean beautifulArrayList(int n){
//         ArrayList<Integer> nums=new ArrayList<>();
//         nums.add(1);
//         return beautifulArrayList(n,nums,0);
//     }

//     public static boolean beautifulArrayList(int n,ArrayList<Integer> nums,int j){
//         if(nums.size()==j) {
//             System.out.println(nums);
//             return true;
//         }
//         for(int i=1;i<=n;i++){
//             if(check(nums, i)){
//                 nums.add(i);
//                 if(beautifulArrayList(n,nums,i+1)) return true;
//                 nums.remove(i);
//             }
            
//         }
//         return false;
//     }

    public static void main(String[] args) {
//         ArrayList<Integer> list =new ArrayList<>();
//         list.add(1);
//         list.add(3);
//         list.add(5);
//         list.add(3);
//         // list.add(100);
//         // list.add(10);
//         // list.add(7);
//         // list.add(8);
//         // list.add(9);
//         // list.add(0);
//         // int max=Integer.MIN_VALUE;
//         // for(int i=0;i<list.size();i++){
//         //     max=Math.max(max, list.get(i));
//         // }
//         // SwapTwoNumbers(list, 0, 7);
//         // System.out.println("The Max Element is :"+max);
//         // printArrayList(list);
//         // ArrayList<ArrayList<Integer>> mainlist=new ArrayList<>();
//         // mainlist.add(list);
//         // System.out.println(MonotonicBV(list));
//         // MostFrequentNumber(list, 1);
        
//         System.out.print(beautifulArrayList(4));
    }
}
// // for size n domain =Integers[1 to N]  2Nums(k) =Numns(i)+Nums(k)
// //Arrangement 
// //Recursion Satisfy the Condition
