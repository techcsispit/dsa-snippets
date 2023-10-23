//link to the problem statement: https://leetcode.com/problems/triangle/

import java.util.*;

public class Triangle {
    int m;
    public int minimumTotal(List<List<Integer>> triangle) {
        m=triangle.size();
        return minsum(triangle);
    }
    int minsum(List<List<Integer>> triangle){
        int[][] t=new int[m][m];
        for(int i=0;i<m;i++){
            t[m-1][i]=triangle.get(m-1).get(i);
        }
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int a=triangle.get(i).get(j) + Math.min(t[i+1][j],t[i+1][j+1]);
                t[i][j]=a;
            }
        }
        return t[0][0];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Triangle ob=new Triangle();
        List<List<Integer>> a=new ArrayList<>();
        System.out.println("Enter size of triangle: ");
        ob.m=sc.nextInt();
        System.out.println("Enter elements:");
        for(int i=0;i<ob.m;i++){
            List<Integer> l=new ArrayList<>();
            for(int j=0;j<=i;j++){
                l.add(j, sc.nextInt());
            }
            a.add(i,l);
            System.out.println();
        }
        System.out.println(ob.minimumTotal(a));
    }
}
