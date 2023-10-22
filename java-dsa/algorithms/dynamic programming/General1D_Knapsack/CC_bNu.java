//link to the problem statement: https://leetcode.com/problems/coin-change/

public class CC_bNu {
    int[][]t;
    public int coinChange(int[] coins, int amount) { 
        t=new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length;i++){
            int small=coins[i];
            int p=i;
            for(int j=i+1;j<coins.length;j++){
                if(coins[j]<coins[i]){
                    small=coins[j];
                    p=j;
                }
            }
            int temp=coins[i];
            coins[i] = small;
            coins[p] = temp;
        }
        int a= lc1(coins,amount);
        return a==2147483646?-1:a;

    }

    int lc1(int[] coins,int amount){
        for(int i=0;i<=amount;i++){
            t[0][i] = 2147483646;
        }
        for(int i=0;i<=coins.length;i++){
            t[i][0] = 0;
        }
        for(int i=1;i<=amount;i++){
            if(i%coins[0] == 0){
                t[1][i] = i/coins[0];
            }else{
                t[1][i] = 2147483646;
            }
        }
        for(int i=2;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j>coins[i-1]){
                    t[i][j] = Math.min(1+t[i][j-coins[i-1]],t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[coins.length][amount];
    }

    int min(int a,int b){
        if(a==-1||b==-1 ){
            return a>b?a:b;
        }
        return a<b?a:b;
    }
    public static void main(String[] args) {
        CC_bNu ob=new CC_bNu();
        System.out.println(ob.coinChange(new int[]{1,3,5},11));
        System.out.println(ob.coinChange(new int[]{83,186,408,419},6249));
        System.out.println(ob.coinChange(new int[]{1,2},2));
        System.out.println(ob.coinChange(new int[]{3,7,405,436},8839));
    }
}
