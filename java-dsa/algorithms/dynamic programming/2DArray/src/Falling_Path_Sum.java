//link to problem statement: https://leetcode.com/problems/minimum-falling-path-sum/
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