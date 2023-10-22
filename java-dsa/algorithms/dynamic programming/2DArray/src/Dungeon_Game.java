//link to problem statement: https://leetcode.com/problems/dungeon-game/
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
