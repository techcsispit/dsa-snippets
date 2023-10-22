//link to the problem statement: https://leetcode.com/problems/trapping-rain-water/

import java.util.ArrayList;
import java.util.List;

public class Trap2 {
    int[][]t;
    int lh;
    int len;
    int trap(int[] height){
        if(height.length<=1||singleBarrier(height)==true){
            return 0;
        }
        len=height.length;
        int max=0;
        //List<Integer> l=new ArrayList<Integer>();
        for(int i:height){
            //l.add(i);
            max=max>i?max:i;
        }
        //l.remove((Integer) max);
        //max=0;
        //for(int i:l){
          //  max=max>i?max:i;
        //}
        lh=max;
        t=new int[lh][len];
        return count(height);
    }

    int count(int[] height){
        for(int i=0;i<len;i++){
            int depth=height[i]>lh?lh:height[i];
            for(int j=0;j<depth;j++){
                t[j][i]=-1;
            }
        }
        int CurBar=0,NextBar=0;
        for(int i=0;i<t[0].length;i++){
            if(t[0][i]==-1){
                CurBar=i;
                break;
            }
        }
        for(int i=CurBar+1;i<t[0].length;i++){
            if(t[0][i]==-1){
                NextBar=i;
                break;
            }
        }
        for(int i=0;i<lh;i++){
            for(int j=CurBar;j<len;j++){
                if(NextBar >=len){
                    break;
                } else if((NextBar-CurBar>=2)){
                    for(int k=CurBar+1;k<NextBar;k++){
                        t[i][k]=1;
                    }
                    //j=NextBar;
                    CurBar=NextBar;
                    for(int k=CurBar+1;k<len;k++){
                        if(t[i][k]==-1){
                            NextBar=k;
                            break;
                        }
                    }
                    NextBar=NextBar==CurBar?len:NextBar;
                } else {
                    CurBar=NextBar;
                    for(int k=CurBar+1;k<len;k++){
                        if(t[i][k]==-1){
                            NextBar=k;
                            break;
                        }
                    }
                    NextBar=NextBar==CurBar?len:NextBar;
                }
            }
            if(i<lh-1){
                for(int k=0;k<len;k++){
                    if(t[i+1][k]==-1){
                        CurBar=k;
                        break;
                    }
                }
                for(int k=CurBar+1;k<len;k++){
                    if(t[i+1][k]==-1){
                        NextBar=k;
                        break;
                    }
                }
            }
        }
        int no_of_drops=0;
        for(int i=0;i<lh;i++){
            for(int j=0;j<len;j++){
                no_of_drops=t[i][j]==1?++no_of_drops:no_of_drops;
            }
        }
        return no_of_drops;
    }

    boolean singleBarrier(int[] arr){
        int zero=0;
        for(int i:arr){
            zero=i==0?++zero:zero;
        }
        return zero==arr.length-1;
    }
    public static void main(String[] args) {
        Trap2 ob = new Trap2();
        //System.out.println(ob.trap(new int[]{4, 2, 0, 3, 2, 5}));
        //System.out.println(ob.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        //System.out.println(ob.trap(new int[]{0, 2, 0}));
        //System.out.println(ob.trap(new int[]{1, 3, 0, 3, 0 }));
        System.out.println(ob.trap(new int[]{0, 7, 1, 4, 6}));
    }
}
