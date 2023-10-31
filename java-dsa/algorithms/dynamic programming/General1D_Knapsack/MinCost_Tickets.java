//link to the problem statement: https://leetcode.com/problems/minimum-cost-for-tickets/

/*Solution explanation: Here we are given an array of n days during which we are going to travel. We can buy a ticket whenever
 * we are travelling during a listed(day number is present in days[]) day. Hence, to avail everything at minimum cost, our 
 * choice diagram looks something like this:
 * 1] If our control variable for present day is present in days[], calculate min_cost for travel assuming we buy any of the 
 * three tickets given in costs[] on that particular day.
 * 2] If our control variable for present day is currently an unlisted day, increment it till we reach a day listed in days array
 * 3] If our control variable for day numeber is greater than the final value in days[] array, we return 0 as we do not need 
 * to purchase any tickets for this period. 
 * Using the technique of memoization, we store the min cost for that listed day along with the day number in an hashmap. 
 * Lastly, whenever our control variable for day number is identical to a key stored in the hashmap, we return the min
 * cost associated with that key.
 *  
 */

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
