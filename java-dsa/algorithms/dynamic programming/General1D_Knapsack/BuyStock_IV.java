//Link to the problem statement: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

import java.util.HashMap;

public class BuyStock_IV {
    int k;
    int len;
    HashMap<String,Integer> hm;
    public int maxProfit(int k, int[] prices) {
        len=prices.length;
        this.k=k;
        hm=new HashMap<>();
        return Profit(prices,0,false,0);
    }
    int Profit(int[] prices,int index,boolean buy,int MaxTransactions){//RECURSIVE
        if(index>=len || MaxTransactions==k){
            return 0;
        } else if(buy == false &&hm.containsKey(index+" B "+(k-MaxTransactions))){
            return hm.get(index+" B "+(k-MaxTransactions));
        }else if(buy == true &&hm.containsKey(index+" S "+(k-MaxTransactions))){
            return hm.get(index+" S "+(k-MaxTransactions));
        }else if(buy==false){
            int a=Profit(prices,index+1,true,MaxTransactions);
            a=a-prices[index];
            int b=Profit(prices,index+1,false,MaxTransactions);
            hm.put(index+" B "+(k-MaxTransactions),a>b?a:b);
            return hm.get(index + " B " + (k-MaxTransactions));
        } else {
            int a=prices[index];
            a=a+Profit(prices,index+1,false,MaxTransactions+1);
            int b=Profit(prices,index+1,true,MaxTransactions);
            hm.put(index+" S "+(k-MaxTransactions),a>b?a:b);
            return hm.get(index + " S " + (k-MaxTransactions));
        }
    }

    public static void main(String[] args) {
        BuyStock_IV ob=new BuyStock_IV();
        System.out.println(ob.maxProfit(2,new int[]{2,1,4,5,2,9,7}));
        System.out.println(ob.maxProfit(2,new int[]{3,2,6,5,0,3}));
        System.out.println(ob.maxProfit(2,new int[]{2,4,1}));
    }
}
