public class Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        String rev="";
        String s1=s;
        while(s1.length()!=0){
            rev+=s1.charAt(s1.length()-1);
            s1=s1.substring(0,s1.length()-1);
        }
        return lcs(s,rev)+"";
    }
    String lcs(String X,String Y){
        int[][] t=new int[X.length()+1][Y.length()+1];
        for(int i=1;i<X.length()+1;i++){
            for(int j=1;j<Y.length()+1;j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                } else if(X.charAt(i-1) == Y.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                } else {
                    t[i][j] = 0;
                }
            }
        }
        int max=0,r=0,c=0;
        for(int i=0;i<=X.length();i++){
            for(int j=0;j<=Y.length();j++){
                if(t[i][j]>max) {
                    max = t[i][j];
                    r = i;
                    c = j;
                }
            }
        }
        String lps="";
        int max1=max;
        while(t[r][c]!=0){
            if(t[r-1][c-1] ==max-1){
                lps+=X.charAt(--r);
                c--;
                max--;
            }
        } 
        return lps;
    }

    boolean isPalindrome(String s){
        StringBuilder sb=new StringBuilder(s);
        String r=sb.reverse().toString();
        return r.equalsIgnoreCase(s);
    }

    public static void main(String[] args) {
        Longest_Palindromic_Substring ob=new Longest_Palindromic_Substring();
        System.out.println(ob.longestPalindrome("babad"));
    }
}
