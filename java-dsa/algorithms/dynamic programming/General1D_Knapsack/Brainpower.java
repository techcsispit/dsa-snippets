//link to the problem statement: https://leetcode.com/problems/solving-questions-with-brainpower/

import java.util.HashMap;
import java.util.Scanner;

public class Brainpower {
    HashMap<Long,Long> hm;
    public long mostPoints(int[][] questions) {
        hm=new HashMap<>();
        return maxPoints(questions,0,hm);
    }

    long maxPoints(int[][] questions, int m, HashMap<Long,Long> hm){
        if(m>=questions.length){
            return 0;
        } else if(hm.containsKey((long)m)){
            return hm.get((long)m);
        } else{
            long a=questions[m][0] + maxPoints(questions,m+1+questions[m][1],hm);
            long b=maxPoints(questions,m+1,hm);
            hm.put((long)m,a>b?a:b);
            return hm.get((long)m);
        }
    }

    public static void main(String[] args) {
        Brainpower ob = new Brainpower();
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of rows: ");
        int m = sc.nextInt();
        System.out.println("Number of columns: ");
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        System.out.println("Enter elements: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(ob.mostPoints(a));
    }
}
