public class Subsetsum_and_Coolnumbers {

    boolean possible(int sum,int[] arr,int n){
        if(n<0 || sum<0){
            return false;
        }
        else if(sum == arr[n] || sum==0){
            return true;
        }else if(sum<arr[n]){
            return possible(sum,arr,n-1);
        } else {
            //boolean store=possible(sum-arr[n],arr,n-1)+possible(sum,arr,n);
            if(possible(sum-arr[n],arr,n-1) ==true || possible(sum,arr,n-1)==true){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Subsetsum_and_Coolnumbers ob=new Subsetsum_and_Coolnumbers();
        System.out.println(ob.possible(28,new int[]{3,4,5,8,9},4));
    }
}
