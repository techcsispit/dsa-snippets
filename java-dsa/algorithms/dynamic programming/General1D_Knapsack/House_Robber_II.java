//link to the problem statement: https://leetcode.com/problems/house-robber-ii/description/

import java.util.HashMap;

public class House_Robber_II {
    HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
    public int rob(int[] nums) {
        if(nums.length==0) return nums[0];
        int arr1[] = new int[nums.length-1];
        int arr2[] = new int[nums.length-1];
        for(int i=0;i<=arr1.length;i++){
            if(i==0){
                arr1[i] = nums[i];
                continue;
            } else if( i== arr1.length){
                arr2[i-1] = nums[i];
                continue;
            }
            arr1[i]=nums[i];
            arr2[i-1] = nums[i];
        }
        int a=mp(0,arr1,hm);
        hm=new HashMap<>();
        int b=mp(0,arr2,hm);
        return a>b?a:b;
    }


    int mp(int index, int[] money, HashMap<Integer,Integer> hm){
        if(money.length == 1){
            return money[0];
        } else if(money.length ==2){
            return money[0]>money[1]?money[0]:money[1];
        }else if(hm.containsKey(index)){
            return hm.get(index);
        } else if(index >= money.length){
            return 0;
        } else {
            int a= mp(index+2,money,hm);
            int b=mp(index+3,money,hm);
            hm.put(index, money[index] + (a>b?a:b));
            return hm.get(index);
        }
    }

    public static void main(String[] args) {
        House_Robber_II ob=new House_Robber_II();
        System.out.println(ob.rob(new int[]{1,2,3,1}));
    }
}
