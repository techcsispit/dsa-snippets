//link to the problem statement: https://leetcode.com/problems/maximal-square/
import java.util.Scanner;

public class Maximal_Square {
    int[][] t;
    int ms(char[][] matrix){
        int r= matrix.length;
        int c=matrix[0].length;
        t=new int[r][c];
        int max=0;
        for(int i=0;i<c;i++){
            t[0][i]=matrix[r-1][c-1-i]-48;
            if(t[0][i]>max) max=t[0][i];
        }
        for(int i=0;i<r;i++){
            t[i][0]=matrix[r-1-i][c-1]-48;
            if(t[i][0]>max) max=t[i][0];
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[r-1-i][c-1-j] == '1'){
                    t[i][j]=1+Math.min(Math.min(t[i][j-1],t[i-1][j]),t[i-1][j-1]);
                    if(t[i][j]>max){
                        max=t[i][j];
                    }
                } else {
                    t[i][j]=0;
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Maximal_Square ob=new Maximal_Square();
        char[][] arr=new char[4][5];
        System.out.println("Please enter numbers:\n");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=sc.next().charAt(0);
            }
        }
        System.out.println(ob.ms(arr));
    }
}
