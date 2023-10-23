//link to the problem statement: https://leetcode.com/problems/coin-change/

import java.util.HashMap;

public class Coin_change {
    public int change(int amount, int[] coins) {
        //return now(coins.length-1, amount,coins);
        return now1(amount,coins);
    }
    int now(int index,int amount, int[] coins){ //Recurise slow
        if(amount == 0){
            return 1;
        } else if(amount<0 || index< 0){
            return 0;
        }  else {
            int no_of_ways=now(index,amount-coins[index],coins) +
                    now(index-1,amount,coins);
            return no_of_ways;
        }
    }

    int now1(int amount, int[] coins){ //Dynamic programming fast
        int[][] t=new int[coins.length+1][amount+1];
        for(int i=0;i<= coins.length;i++){
            for(int j=0;j<=amount;j++) {
                if (i == 0) {
                    t[i][j] = 0;
                } else if (j == 0) {
                    t[i][j] = 1;
                }else if(j<coins[i-1]){
                    t[i][j] = t[i-1][j];
                }else{
                    int no_of_ways=t[i][Math.abs(j-coins[i-1])] + t[i-1][j];
                    t[i][j] = no_of_ways;
                }
            }
        }
        return t[coins.length][amount];
    }


    public static void main(String[] args) {
        Coin_change ob=new Coin_change();
        //System.out.println(ob.change(500,new int[]{3,5,7,8,9,10,11}));
        System.out.println(ob.change(5,new int[]{1,2,5}));
        System.out.println(ob.change(500,new int[]{2,7,13}));
    }
}
