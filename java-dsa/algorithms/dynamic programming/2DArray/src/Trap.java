//link to the problem statement: https://leetcode.com/problems/trapping-rain-water/

import java.util.*;

class Trap {
    int len;
    int lh;
    public int trap(int[] height) {
        if(height.length<=1 ||singleBarrier(height)==true){
            return 0;
        }
        len=height.length;
        /*int max=0;
        List<Integer> l=new ArrayList<Integer>();
        for(int i:height){
            l.add(i);
            max=max>i?max:i;
        }
        l.remove((Integer) max);
        max=0;
        for(int i:l){
            max=max>i?max:i;
        }
        lh=max;*/
        int a=0,b=0;
        for(int i=0;i<len;i++){
            if(height[i] !=0){
                a=i;
                break;
            }
        }
        for(int i=a+1;i<len;i++){
            if(height[i] !=0){
                b=i;
                break;
            }
        }
        return count(height,0,a,b);
    }

    int count(int[] height,int elevation,int CurBar, int NextBar){
        if( singleBarrier(height) == true){ //elevation>=lh
            return 0;
        } else if(NextBar>=len){
            height=modify(height);
            for(int i=0;i<len;i++){
                if(height[i] !=0){
                    CurBar=i;
                    break;
                }
            }
            for(int i=CurBar+1;i<len;i++){
                if(height[i] !=0){
                    NextBar=i;
                    break;
                }
            }
            return count(height,elevation+1,CurBar,NextBar);
        } else {
            int no_of_drops=1*(NextBar-CurBar-1);
            int a=CurBar,b=NextBar;
            for(int i=NextBar+1;i<len;i++){
                if(height[i]!=0){
                    CurBar = NextBar;
                    NextBar =i;
                    break;
                }
            }
            if(a==CurBar && b==NextBar){
                CurBar=NextBar;
                NextBar=len;
            }
            return no_of_drops +count(height,elevation,CurBar,NextBar);
        }
    }

    int[] modify(int[] arr){
        int ind=0;
        for(int i:arr){
            arr[ind++] = i==0?0:i-1;
        }
        return arr;
    }

    boolean singleBarrier(int[] arr){
        int nonzero=0;
        for(int i:arr){
            nonzero=i!=0?++nonzero:nonzero;
            if(nonzero >=2){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trap ob=new Trap();
        System.out.println(ob.trap(new int[]{4,2,0,3,2,5}));
        System.out.println(ob.trap( new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(ob.trap(new int[]{0,2,0}));
        System.out.println(ob.trap(new int[]{4,2,3}));
    }
}
