//link to the problem statement: https://leetcode.com/problems/min-cost-climbing-stairs/

import java.util.*;
public class Climbing_stairs {
    HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
    public int minCostClimbingStairs(int[] cost) {
        int a=mc(0,cost,hm);
        int b=mc(1,cost,hm);
        return a>b?b:a;
    }
    int mc(int index, int[] cost, HashMap<Integer, Integer> hm){
        if(index>=cost.length){
            return 0;
        }
        else if(cost.length == 2){
            return cost[0]>cost[1]?cost[1]:cost[0];
        } else if(hm.containsKey(index)){
            return hm.get(index);
        } else {
            int c= mc(index+1,cost,hm);
            int d= mc(index + 2, cost,hm);
            hm.put(index,cost[index] +  (c>d?d:c));
            return hm.get(index);
        }
    }

    public static void main(String[] args) {
        Climbing_stairs ob=new Climbing_stairs();
        System.out.println(ob.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
