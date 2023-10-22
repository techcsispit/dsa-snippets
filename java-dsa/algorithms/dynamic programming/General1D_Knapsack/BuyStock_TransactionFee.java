//link to the problem statement: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

import java.util.HashMap;

public class BuyStock_TransactionFee {
    int len;
    HashMap<String,Integer> hm;
    public int maxProfit(int[] prices, int fee) {
        len=prices.length;
        hm=new HashMap<>();
        return Profit(prices,0,false,fee);
    }
    int Profit(int[] prices, int index, boolean buy,int fee){
        if(index>=len){
            return 0;
        } else if(hm.containsKey(index+ " " + (buy?1:0))){
            return hm.get(index + " " +(buy?1:0));
        }else if(buy==true && index==len-1){
            return prices[len-1] - fee;
        } else if(buy==false){
            int a=Profit(prices,index+1,buy,fee);
            buy = true;
            int b=(prices[index]*-1) + Profit(prices,index+1,buy, fee);
            buy=false;
            hm.put(index + " " + (buy?1:0),a>b?a:b);
            return hm.get(index + " " + (buy?1:0));
        }else{
            int a=Profit(prices,index+1,buy,fee);
            buy=false;
            int b=(prices[index]-fee) + Profit(prices,index+1,buy,fee);
            buy=true;
            hm.put(index+ " "+(buy?1:0),a>b?a:b);
            return hm.get(index+" "+(buy?1:0));
        }
    }

    public static void main(String[] args) {
        BuyStock_TransactionFee ob=new BuyStock_TransactionFee();
        System.out.println(ob.maxProfit(new int[]{1,3,7,5,10,3},3));
    }
}
