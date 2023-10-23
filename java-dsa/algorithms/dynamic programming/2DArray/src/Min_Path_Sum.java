//link to the problem statement: https://leetcode.com/problems/minimum-path-sum/

import java.util.Scanner;

public class Min_Path_Sum {
    int[][] t;
    int m;
    int n;
    public int minPathSum(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        t=new int[m][n];
        return minsum(grid);
    }

    int minsum(int[][] grid){
        int p=0;
        for(int i=0;i<n;i++){
            p+=grid[m-1][n-1-i];
            t[0][i]=p;
        }
        p=0;
        for(int i=0;i<m;i++){
            p+=grid[m-1-i][n-1];
            t[i][0]=p;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                t[i][j]=Math.min(t[i-1][j]+grid[m-2-(i-1)][n-2-(j-1)],t[i][j-1]+grid[m-2-(i-1)][n-2-(j-1)]);
            }
        }
        return t[m-1][n-1];
    }

    public static void main(String[] args) {
        Min_Path_Sum ob=new Min_Path_Sum();
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
        System.out.println(ob.minPathSum(a));


        //DISPLAY CODE REUSABLE
        /*for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(t[i][j]);
            }
            System.out.println();
        }*/
    }

}
