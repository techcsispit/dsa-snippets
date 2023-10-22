//link to the problem statement: https://leetcode.com/problems/minimum-cost-for-tickets/

import java.util.*;

public class MinCost_Tickets {
    int len;
    List<Integer> list;
    List<Integer> cost;
    HashMap<Integer,Integer> hm;
    public int mincostTickets(int[] days, int[] costs) {
        len=days.length;
        list=new ArrayList<>();
        cost=new ArrayList<>();
        hm=new HashMap<>();
        for(int i:days){
            list.add(i);
        }
        for(int i:costs){
            cost.add(i);
        }
        return minCost(list,1);
    }
    int minCost(List<Integer> days,int currDay){
        if(currDay>days.get(len-1)){
            return 0;
        } else if(hm.containsKey(currDay)){
            return hm.get(currDay);
        }else if(days.contains(currDay)){
            int a= cost.get(2) + minCost(days,currDay+30);
            int b=cost.get(1) + minCost(days,currDay+7);
            int c=cost.get(0)+minCost(days,currDay+1);
            hm.put(currDay,Math.min(a,Math.min(b,c)));
            return hm.get(currDay);
        }else {
            for(int i=0;i<=365;i++){
                currDay+=1;
                if(days.contains(currDay)){
                    break;
                }
            }
            hm.put(currDay,minCost(days,currDay));
            return hm.get(currDay);
        }
    }

    public static void main(String[] args) {
        MinCost_Tickets ob=new MinCost_Tickets();
        System.out.println(ob.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31},new int[]{2,7,15}));
    }
}
