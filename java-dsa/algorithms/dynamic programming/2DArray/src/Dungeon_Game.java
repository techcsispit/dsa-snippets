//link to problem statement: https://leetcode.com/problems/dungeon-game/


/*Solution explanantion: While filling row 1 of dp[][] array, assume that the dungeon matrix has only one row(the last row)
and for each index from [m-1][n-1] in dungeon to 0, what is the minimum health. Say if the last row of dungeon
is [10, 30, -5], we know when dungeon[][] is 1x1 i.e.[-5] the minimum health is 6 so dp[1][1] is 6, and when dungeon[][]
 is 1x2 i.e [30,-5] the minimum health is 1 so dp[1][2]=1. For [10,30,-5] again it is 1. So we clearly see a pattern.
 When we iterate through the last row, we add negative healths and subtract positive healths, provided the subtraction
 gives a result greater than 0, otherwise dp[1][j] =1.
Same process for last column of dungeon[][]. Let the column be
3
1
-5
Now again we traverse from bottom to top in dungeon[][] array's last column and fill column 1 of dp[][].
Obviously for dp[1][1] the answer is 6 as dungeon[m-1][n-1]=-5. Then for dp[2][1] we subtract 1 from 6(6-1=5) and store.
 Similarly for dp[3][1] we subtract 3 from 5 and store. This concludes the hard part of the question.

Now to fill rows 2 and below in dp[][] array just do the classic minimum sum mechanism. Since the knight can travel down
 or right, we will take the minimum value from top and left of our current position in dp[][] array. Say at dp[i][j]
 we will compare dp[i-1][j] and dp[i][j-1] and choose the smaller value. Also, along with the smaller value, if
 the value at current position we are comparing in dungeon[][] array is negative, we add it to dp[i][j] and if it is
 positive, we subtract, but if the result of subtraction is <=0, we store dp[i][j]=1.
At the end we return dp[m][n] which has the minimum health of the knight. Thankyou. */


import java.util.Scanner;

public class Dungeon_Game {
    int[][]t;
    int m;
    int n;
    public int calculateMinimumHP(int[][] dungeon) {
        m=dungeon.length;
        n=dungeon[0].length;
        t=new int[m+1][n+1];
        int a= minHP(dungeon);
        return a;
    }
    int minHP(int[][] dungeon){
        for(int i=0;i<m+1;i++){
            t[i][0]=1;
        }
        for(int i=0;i<n+1;i++){
            t[0][i]=1;
        }
        int sum=1;
        for(int i=m-1;i>=0;i--) {
            sum+=(-1*dungeon[i][n-1]);
            if(sum<=0) sum=1;
            t[m-i][1]=sum;
        }
        sum=1;
        for(int i=n-1;i>=0;i--){
            sum+=(-1*dungeon[m-1][i]);
            if(sum<=0) sum=1;
            t[1][n-i]=sum;
        }
        for(int i=2;i<=m;i++){
            for(int j=2;j<=n;j++){
                t[i][j] = Math.min(t[i-1][j],t[i][j-1]) + (dungeon[m-i][n-j]>0?0:Math.abs(dungeon[m-i][n-j]));
                if((t[i][j]-dungeon[m-i][n-j]>0) && dungeon[m-i][n-j]>0){
                    t[i][j]-=dungeon[m-i][n-j];
                } else if((t[i][j]-dungeon[m-i][n-j]<0) && dungeon[m-i][n-j]>0){
                    t[i][j]=1;
                }
            }
        }
        return t[m][n];
    }

    public static void main(String[] args) {
        Dungeon_Game ob = new Dungeon_Game();
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of rows: ");
        ob.m = sc.nextInt();
        System.out.println("Number of columns: ");
        ob.n = sc.nextInt();
        int[][] a = new int[ob.m][ob.n];
        System.out.println("Enter elements: ");
        for (int i = 0; i < ob.m; i++) {
            for (int j = 0; j < ob.n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(ob.calculateMinimumHP(a));
    }
}
