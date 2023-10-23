//link to the problem statement: https://leetcode.com/problems/maximum-product-subarray/

public class Maximum_Product_Subarray {
    int len;
    /*public int MaxProduct(int[] nums,int size,int CurPro){
        if(size==1){
            if(CurPro ==1){
                return CurPro*nums[size-1];
            }
            return nums[size-1]*CurPro>CurPro?nums[size-1]*CurPro:CurPro;
        } else if(nums[size-1]>0){
            return MaxProduct(nums,size-1,CurPro*nums[size-1]);
        } else {
            int a=MaxProduct(nums,size-1,1);
            int b=MaxProduct(nums,size-1,CurPro*nums[size-1]);
            if((a==0 &&b<=1) || (b==0 &&a<=1)){
            return 0;
            }
            int c = a >   b ? a : b;
            return c >CurPro? c :CurPro;
        }
    }*/

    public int maxProduct(int[] nums){
        int res=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]>res){
                res=nums[i];
            }
        }
        int MaxPro=1,MinPro=1;
        for(int n:nums){
            if(n ==0){
                MaxPro=1;
                MinPro=1;
                continue;
            }
            int temp=n*MaxPro;
            MaxPro =Math.max(temp,Math.max(n*MinPro,n));
            MinPro=Math.min(temp,Math.min(n*MinPro,n));
            res=Math.max(res,MaxPro);
        }
        return res;
    }

    public static void main(String[] args) {
        Maximum_Product_Subarray ob=new Maximum_Product_Subarray();
        System.out.println(ob.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(ob.maxProduct(new int[]{-2,0,-1}));
        System.out.println(ob.maxProduct(new int[]{-5,0,2}));
    }
}
