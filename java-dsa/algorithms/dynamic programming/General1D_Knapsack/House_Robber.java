//link to the problem statement: https://leetcode.com/problems/house-robber/

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
