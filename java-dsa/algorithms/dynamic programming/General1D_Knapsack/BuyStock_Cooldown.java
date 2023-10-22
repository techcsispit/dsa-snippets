//link to the problem statement: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

import java.util.HashMap;

public class BuyStock_Cooldown {
    int len;
    HashMap<String,Integer> hm;
    public int maxProfit(int[] prices) {
        hm=new HashMap<>();
        len=prices.length;
        return Profit(prices,false,0);
    }

    int Profit(int[] prices,boolean buy,int index){
        if(index>=len){
            return 0;
        }else if(hm.containsKey(index +" " +((buy)?1:0))){
            return hm.get(index + " " + ((buy)?1:0));
        } else if(buy == true && index==len-1){
            return prices[len-1];
        } else if(buy==false){
            int a=Profit(prices,buy,index+1);
            buy=true;
            int b=(prices[index]*-1)+Profit(prices,buy,index+1);
            buy=false;
            hm.put(index + " " + ((buy)?1:0), a>b?a:b);
            return hm.get(index + " " + ((buy)?1:0));
        } else {
            int a=Profit(prices,buy,index+1);
            buy = false;
            int b=prices[index] + Profit(prices,buy,index+2);
            buy=true;
            hm.put(index + " " + ((buy)?1:0), a>b?a:b);
            return hm.get(index + " " + ((buy)?1:0));
        }
    }

    public static void main(String[] args) {
        BuyStock_Cooldown ob=new BuyStock_Cooldown();
        System.out.println(ob.maxProfit(new int[]{1}));
    }

}
