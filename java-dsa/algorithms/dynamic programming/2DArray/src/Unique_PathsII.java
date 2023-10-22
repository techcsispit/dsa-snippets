//link to the problem statement: https://leetcode.com/problems/unique-paths-ii/

import java.util.Scanner;

public class Unique_PathsII {
    int m;
    int n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m=obstacleGrid.length;
        n=obstacleGrid[0].length;
        return no_of_ways(obstacleGrid);
    }
    int no_of_ways(int[][]grid){
        int[][]t=new int[m][n];
        int a=1;
        for(int i=0;i<m;i++){
            if(grid[m-1-i][n-1]==1){
                a=0;
            }
            t[i][0]=a;
        }
        a=1;
        for(int i=0;i<n;i++){
            if(grid[m-1][n-1-i]==1){
                a=0;
            }
            t[0][i]=a;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(grid[m-1-i][n-1-j]==1){
                    t[i][j]=0;
                }else{
                    t[i][j]=t[i-1][j] + t[i][j-1];
                }
            }
        }
        return t[m-1][n-1];
    }

    public static void main(String[] args) {
        Unique_PathsII ob=new Unique_PathsII();
        Scanner sc=new Scanner(System.in);
        System.out.println("Number of rows: ");
        ob.m=sc.nextInt();
        System.out.println("Number of columns: ");
        ob.n=sc.nextInt();
        int[][]a=new int[ob.m][ob.n];
        System.out.println("Enter elements: ");
        for(int i=0;i<ob.m;i++){
            for(int j=0;j<ob.n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println(ob.uniquePathsWithObstacles(a));
    }
}
