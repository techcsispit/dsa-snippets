//link to the problem statement: https://leetcode.com/problems/partition-equal-subset-sum/

import java.util.HashMap;

public class Partition_Equal_Subsetsum {
    HashMap<String,Boolean> hm;
    public boolean canPartition(int[] nums) {
        int sum=0;
        hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0 || nums.length==1) return false;
        else {
            return checkSum(nums.length-1,nums,sum/2);
        }
    }
    boolean checkSum(int index,int[] arr,int sum){
        if(index<0 || sum<0){
            return false;
        } else if(hm.containsKey(index+" "+sum)){
            return hm.get(index+" "+sum);
        }else if(sum ==0 || sum == arr[index]){
            return true;
        } else {
            if(checkSum(index-1,arr,sum-arr[index]) || checkSum(index-1,arr,sum)){
                hm.put(index+" "+sum,true);
                return true;
            }
            hm.put(index+" "+sum,false);
            return false;
        }
    }

    public static void main(String[] args) {
        Partition_Equal_Subsetsum ob=new Partition_Equal_Subsetsum();
        System.out.println(ob.canPartition(new int[]{1,2,3,5}));
        System.out.println(ob.canPartition(new int[]{1,5,11,5}));
        System.out.println(ob.canPartition(new int[]{1,1,1,1}));
    }
}
