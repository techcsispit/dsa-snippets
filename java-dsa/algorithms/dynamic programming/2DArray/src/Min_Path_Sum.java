//link to the problem statement: https://leetcode.com/problems/minimum-path-sum/

/*Solution explanation: You create an array t which stores the minimum sum at a given index in inverted order. i.e. for
 * grid[m-1][n-1] the min sum will be stored in t array at 0,0 index. Once you initialize t[][] with the dimensions, you 
 * traverse through the last column from bottom to top while adding up all the integers and storing them top-down in t[][].
 * For example, min sum at grid[m-2][n-1] is stored at t[1][0] etc. Keep doing the same for the last horizontal row of grid.
 * 
 *   Once the first row and first columnn of t array are filled, now try to fill all the other cells row wise. For t[1][1],
 * this can be done by comparing t[1][0] and t[0][1] and finding the minimum amongst them before adding the current value
 * at grid[m-2][n-2]. Hence, in a general way, at t[i][j], we can compare t[i][j-1] and t[i-1][j] before adding the coin-
 * cidental value in grid array to the minimum amongst those. Value at t[m-1][n-1] is the answer.
 */


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
                t[i][j]=Math.min(t[i-1][j],t[i][j-1])+grid[m-2-(i-1)][n-2-(j-1)];
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
