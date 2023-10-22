//link to the problem statement: https://leetcode.com/problems/uncrossed-lines/

public class Uncrossed_Lines {
    int[][] t;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //return maxLines(nums1,nums2,nums1.length-1,nums2.length-1);
        return maxLines(nums1,nums2);
    }

    int maxLines(int[] nums1,int[] nums2,int m,int n){//Recursive
        if(m<0 || n<0){
            return 0;
        } else if(nums1[m]==nums2[n]){
            int a=1+maxLines(nums1,nums2,m-1,n-1);
            return a;
        } else {
            int a=maxLines(nums1,nums2,m-1,n);
            int b=maxLines(nums1,nums2,m,n-1);
            return a>b?a:b;
        }
    }

    int maxLines(int[] nums1,int[] nums2){
        t=new int[nums1.length+1][nums2.length+1];
        for(int i=1;i<nums1.length+1;i++){
            for (int j=1;j<nums2.length+1;j++){
                if(nums1[i-1] == nums2[j-1]){
                    t[i][j]=1 + t[i-1][j-1];
                } else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[nums1.length][nums2.length];
    }

    public static void main(String[] args) {
        Uncrossed_Lines ob=new Uncrossed_Lines();
        System.out.println(ob.maxUncrossedLines(new int[]{2,5,1,2,5},new int[]{10,5,2,1,5,2}));
    }
}
