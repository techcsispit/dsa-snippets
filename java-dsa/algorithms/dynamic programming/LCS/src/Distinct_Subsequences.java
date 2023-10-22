//link to the problem statement: https://leetcode.com/problems/distinct-subsequences/

import java.util.*;

public class Distinct_Subsequences {
    HashMap<String,Integer> hm;
    int dcs(String s,String t,int m,int n){
        if(n>=t.length()){
            return 1;
        } else if(m>=s.length()){
            return 0;
        } else if(s.charAt(m) != t.charAt(n)){
            return dcs(s,t,m+1,n);
        } else if(hm.containsKey(m+" "+n)){
            return hm.get(m+" "+n);
        } else {
            int a=dcs(s,t,m+1,n+1);
            int b=dcs(s,t,m+1,n);
            hm.put(m+" "+n,a+b);
            return a+b;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Distinct_Subsequences ob=new Distinct_Subsequences();
        ob.hm=new HashMap<>();
        System.out.println(ob.dcs(sc.next(),sc.next(),0,0));
    }
}
