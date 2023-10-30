//link to the problem statement: https://leetcode.com/problems/unique-paths-ii/

/*Solution explanation: We create an array t[][] to store the no.of unique paths originating from a particular index.
 * To start, we initially consider only the last column of the matrix. If the last column is clear without any obstacles, 
 * i.e. there is 1 unique path, we can store 1 in first column of t. If there is an obstacle at any point in the last 
 * column of the matrix, then a control variable 'a' initialized to 1 will be assigned the value 0 and all the subsequent
 * indexes of t[][] first column from that praticular point will have 0 unique paths. Similar approach for first row of t.
 * 1 will be stored in every index(left-right) until an obstacle is not encountered in the last row of matrix(right-left)
 * after which 0 will be stored in t.
 * 
 * Once the first row and column are dealt with, we will shift focus to all other cells of t array. Starting with t[1][1],
 * we will first check if there is an obstacle at matrix[m-2][n-2] or not, and if there is, we will place 0 at t[1][1].
 * Similarly, if there are no obstacles for a particular index, the no.of unique paths becomes the no. of paths if you 
 * traverse downward first in og grid + the no.of paths if you traverse rightward first in og grid. Hence, if no obstacles,
 * t[i][j]= t[i-1][j] + t[i][j-1]. Once all cells of t are filled, return t[m-1][n-1] as that contains total unique paths.
 */

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
