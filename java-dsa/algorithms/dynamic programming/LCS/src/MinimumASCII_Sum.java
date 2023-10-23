//link to the problem statement: https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/

import java.util.HashMap;

public class MinimumASCII_Sum {
    HashMap<String,String> hm;
    public int minimumDeleteSum(String s1, String s2) {
        hm=new HashMap<>();
        String common= lcs(s1,s2,s1.length(),s2.length());
        int count=0,index=0;
        for (int i=s1.length()-1;i>=0;i--){
            if(index<common.length() &&common.charAt(index)==s1.charAt(i)){
                index++;
            } else {
                count+=s1.charAt(i);
            }
        }
        index=0;
        for (int i=s2.length()-1;i>=0;i--){
            if(index<common.length() && common.charAt(index)==s2.charAt(i)){
                index++;
            } else {
                count+=s2.charAt(i);
            }
        }
        return count;
    }
    String lcs(String X,String Y,int m,int n){
        if (m == 0 || n == 0) {
            return "";
        } else if(hm.containsKey(m+" "+n)){
            return hm.get(m+" "+n);
        }else if(X.charAt(m-1) ==Y.charAt(n-1)){
            hm.put(m+" "+n,X.charAt(m-1)+lcs(X,Y,m-1,n-1));
            return hm.get(m+" "+n);
        } else {
            String a=lcs(X,Y,m-1,n);
            String b=lcs(X,Y,m,n-1);
            int ascii_a=0;
            for(int i=0;i<a.length();i++){
                ascii_a+=a.charAt(i);
            }
            int ascii_b=0;
            for(int i=0;i<b.length();i++){
                ascii_b+=b.charAt(i);
            }
            hm.put(m+" "+n,ascii_a>ascii_b?a:b);
            return hm.get(m+" "+n);
        }
    }

    public static void main(String[] args) {
        MinimumASCII_Sum ob=new MinimumASCII_Sum();
        System.out.println(ob.minimumDeleteSum("sea","eat"));
        System.out.println(ob.minimumDeleteSum("delete","leet"));
    }
}
