//link to the problem statement: https://leetcode.com/problems/target-sum/description/

import java.util.HashMap;

public class Target_sum {
    int sum;
    int no_of_ways(int index,int[] nos, int op){ //index and op start at 0
         if(index == nos.length && op == sum){
            return 1;
        } else if(nos.length ==0 || index>=nos.length){
            return 0;
        }  else {
            int p= no_of_ways(index+1,nos,op+nos[index]);
            int n=no_of_ways(index+1,nos,op-nos[index]);
            return p + n;
        }
    }

    public static void main(String[] args) {
        Target_sum ob=new Target_sum();
        ob.sum=1;
        System.out.println(ob.no_of_ways(0,new int[]{1,1,2,3},0));
        ob.sum=3;
        System.out.println(ob.no_of_ways(0,new int[]{4,6,5},0));
        System.out.println(ob.no_of_ways(0,new int[]{1,1,1,1,1},0));
    }
}
