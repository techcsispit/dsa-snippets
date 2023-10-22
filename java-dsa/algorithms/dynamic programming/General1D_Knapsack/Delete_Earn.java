//link to the problem statement: https://leetcode.com/problems/delete-and-earn/

import java.util.*;

public class Delete_Earn {
    HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
    List<Integer> list=new ArrayList<>();
    public int deleteAndEarn(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int small=nums[i];
            int p=i;
            for(int j=i+1;j<nums.length;j++){
                if(small>nums[j]){
                    small=nums[j];
                    p=j;
                }
            }
            int temp=nums[i];
            nums[i]=small;
            nums[p]=temp;
        }
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.replace(nums[i],hm.get(nums[i])+1);
            } else {
                hm.put(nums[i],1);
            }
        }
        list=new ArrayList<>(hm.keySet());
        Collections.sort(list);
        return maxPoints(list);
    }

    int maxPoints(List<Integer> nums){
        int[] pts=new int[nums.size()];
        int earn1=0,earn2=0;
        for(int i=0;i<nums.size();i++){
            int curEarn=nums.get(i)*hm.get(nums.get(i));
            if(i>0&&(nums.get(i) == nums.get(i-1)+1)){
                int temp=earn2;
                earn2=Math.max(curEarn+earn1,earn2);
                earn1=temp;
            } else {
                int temp=earn2;
                earn2+=curEarn;
                earn1=temp;
            }
        }
        return earn2>earn1?earn2:earn1;
    }




    public static void main(String[] args) {
        Delete_Earn ob=new Delete_Earn();
        System.out.println(ob.deleteAndEarn(new int[]{2,3,3,5,7,7}));
    }

}
