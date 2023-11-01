//link to the problem statement: https://leetcode.com/problems/house-robber/

/*Solution explanation: Staring at index 0 or 1, we are supposed to find maximum loot till end. So basically, there are
 * three conditions we need to keep in mind. If there is only 1 house in array, we loot it. Otherwise if we are done tr-
 * aversing through the array, we return 0. Also, since each time we loot a house we cannot loot its neighbour so the 
 * index parameter can only increase by either 2(1 house skipped as per rules) or 3(2 houses skipped as per rules).
 * 
 * 
 * Sometimes it may become necessary to avoid the next available house to loot as we may be shutting ourselves to potentially
 * bigger loot later on. Hence, we have to call the funtion each time by increasing index by 2 once and 3 once. Lastly,
 * using the technique of memoization, we can store the maximum loot from index i to end in an HashMap with the index as 
 * the key of the hashmap and the loot as the value. This gives innumerable benefits by declining repeated recursive calls.
 * In the end, we return the maximum loot stored at index 0.
 */

import java.util.HashMap;

public class House_Robber {
    HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
    public int rob(int[] nums) {
    int a=mp(0,nums,hm);
    int b=mp(1,nums,hm);
    return a>b?a:b;
    }
    int mp(int index, int[] money, HashMap<Integer,Integer> hm){
        if(money.length == 1){
            return money[0];
        } else if(hm.containsKey(index)){
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
        House_Robber ob=new House_Robber();
        int a= ob.rob(new int[]{1,2,3,1});
        System.out.println(a);
    }
}
