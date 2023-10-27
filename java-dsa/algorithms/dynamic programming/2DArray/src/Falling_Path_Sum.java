//link to problem statement: https://leetcode.com/problems/minimum-falling-path-sum/

/*Solution explanation: We start traversing the matrix row-wise from last row to first. Initially, our dp array, in
 this case t[][], has no valid value for minimum falling path sum so we consider matrix[][] to be 1 *n , i.e, only one row,
the last. Hence t[m-1][i] = matrix[m-1][i].
  Once the last row is filled, now we can consider matrix to be 2*n(the last two rows). In second last row of t[][], now
  we consider the value at matrix[i][j] and also the minimum sum below that.
  The formula for minimum sum is: Current element + Minimum sum value at( t[i+1][j],t[i+1][j+1],t[i+1][j-1])

  If the first element of 2nd last row of
  t[][] is to be considered, we compare values at t[i+1][0] and t[i+1][1] and add the lesser to matrix[i][j]. This is stored
  in t[i][0](first element ofsecond last row). If the last element of 2nd row is to be considered, we compare values at t[i+1][j] and
  t[i+1][j-1] and add the lesser to matrix[i][j] before storing it in t[i][j]. For any other non-edge element 2nd last row of
  t[][], we compare values at t[i+1][j+1],t[i+1][j-1] and t[i+1][j] and add the least to matrix[i][j] before storing in
  t[i][j].The role of t[][] is to store the minimum sum from any particular index to the end. Hence we continue this
  process till all rows of t[][] are filled.
    Lastly, once the first row of t[][] is filled, we can choose the smallest value of sum from that row using linear
    search and return it.
 */


import java.util.Scanner;

public class Falling_Path_Sum{
    int m;
    int n;

    public int minFallingPathSum(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        return minsum(matrix);
    }

    int minsum(int[][] grid) {
        int[][] t = new int[m][n];
        for (int i = 0; i < n; i++) {
            t[m - 1][i] = grid[m - 1][i];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    t[i][j] = grid[i][j] + Math.min(t[i + 1][j], t[i + 1][j + 1]);
                } else if (j == n - 1) {
                    t[i][j] = grid[i][j] + Math.min(t[i + 1][j], t[i + 1][j - 1]);
                } else {
                    int a = Math.min(t[i + 1][j], t[i + 1][j + 1]);
                    t[i][j] = grid[i][j] + Math.min(a, t[i + 1][j - 1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : t[0]) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Falling_Path_Sum ob = new Falling_Path_Sum();
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
        System.out.println(ob.minFallingPathSum(a));
    }
}