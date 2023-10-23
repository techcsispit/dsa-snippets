//link to the problem statement: https://leetcode.com/problems/longest-increasing-subsequence/

/*A CONTRIBUTION HERE WOULD BE QUITE GRATEFUL*/


import java.util.HashMap;

public class LIS {
    int len;
    public int lengthOfLIS(int[] nums) { //Recursive
        len=nums.length;
        return LIS1(nums,0,Integer.MIN_VALUE);
    }
    int LIS1(int[] nums,int index,int curr){
        if(index>=len){
            return 0;
        } else if(nums[index]<=curr){
            return LIS1(nums,index+1,curr);
        }else{
            int a=1+LIS1(nums,index+1,nums[index]);
            int b=LIS1(nums,index+1,curr);
            return a>b?a:b;
        }
    }

    public static void main(String[] args) {
        LIS ob=new LIS();
        System.out.println(ob.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(ob.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(ob.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}
