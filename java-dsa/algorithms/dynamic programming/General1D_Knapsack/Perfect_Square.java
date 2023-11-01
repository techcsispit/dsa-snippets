//link to the problem statement: https://leetcode.com/problems/perfect-squares/

/*Solution explanation- In this problem, we are told to break down a number into squares, with the condition that the no.of
 * squares should be the least. Looking at the constraints, which say that n<= 10000, we know that that first number whose
 * square exceeds 10000 is 101, hence that will be our maximum dimensions in terms of rows, and columns can be n+1 for our dp 
 * array. Each row number represent the limit of numbers whose squares can be used for that entire row. Example, at row 5,
 * when i and row index=4, squares upto 4 can be used to calculate min squares. Then, at row 6, squares upto 6 can be used for the same.
 * Each column of our dp array simply represents a particular number. Hence at dp[i][j] we are storing minimum squares to 
 * calculate j using squares of upto i. Example, at dp[4][25], squares of 1,2,3 and 4 can be used to calculate mininmum squares
 * to obtain 25. 
 * 
 * Initially, when j=0(i.e. first column or when min square of 0 is to be found), answer is 0 hence we can assign entire
 * column with 0. Also, during first row, when only square of 0 is available to evaluate min squares for all numbers, the
 * no.of squares required would be infinity as 0^2=0. So we assign entire first row as INTEGER.MAX_VALUE-1. For dp[1][1]
 * and onwards, we need to check if the current value of i^2 exceeds that of j, because if it doesn't, the no.of squares
 * remains the same for dp[i-1][j] and dp[i][j]. Example, you are at dp[6][25] but since 6*6 exceeds 25 it is practically not
 * useful to count min squares to obtain 25 using 6. Hence, till the index where i*i>j, we assign dp[i-1][j] to dp[i][j].
 * Once i*i<=j, that's when we can really use i^2 to calculate min squares to obtain j. Hence, at dp[i][j], for this 
 * condition, we assign the minimum between 1+(value to the left) or value just above.i.e Math.min(dp[i-1][j],1+dp[i][j-1]).
 * We continue this process till dp[100][n] and return dp[100][n] as our answer.   
 */

public class Perfect_Square {
    public int numSquares(int n){
        //int coins=minCount(n,1,0);
        //return coins;
        return minCount2(n);
    }

    int minCount(int no, int pointer, int count){//Recursive
        if(no ==0){
            return count;
        }else if(pointer >no){
            return Integer.MAX_VALUE-1;
        } else{
            int min=Math.min(minCount(no-(pointer*pointer),pointer,count+1),
                    minCount(no,pointer+1,count));
            return min;
        }
    }

    int minCount2(int no){//Dynamic programming
        int[][] t=new int[101][no+1];
        for(int i=0;i<=no;i++){
            t[0][i] = Integer.MAX_VALUE-1;
        }
        for(int i=0;i<=100;i++){
            t[i][0] = 0;
        }
        for(int i=1;i<=100;i++){
            for(int j=1;j<=no;j++){
                if((i*i)>j){
                    t[i][j] = t[i-1][j];
                }else{
                    t[i][j] = Math.min(1+t[i][j-(i*i)],t[i-1][j]);
                }
            }
        }
        return t[100][no];
    }

    public static void main(String[] args) {
        Perfect_Square ob=new Perfect_Square();
        System.out.println(ob.numSquares(7168));
    }
}
