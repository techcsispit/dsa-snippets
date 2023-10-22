//link to the problem statement: https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/

import java.util.*;

public class CheckValidPartition {
    List<Integer> L;
    public boolean validPartition(int[] nums) {
        L=new ArrayList<>();
        L.add(nums[0]);
        return vp(nums,0,L);
    }

    boolean vp(int[] nums,int index,List<Integer> l){
        if(index>=nums.length-1){
            if(l.size()<2) return false;
            return equal(l)||check(l);
        } else if(l.size()>3){
            return false;
        }else{
            if(l.size()<=1){
                l.add(nums[index+1]);
                return vp(nums,index+1,l);
            } else if(l.size()==2){
                if(equal(l)==true){
                    l.add(nums[index+1]);
                    boolean b=vp(nums,index+1,l);
                    l=new ArrayList<>();
                    l.add(nums[index+1]);
                    return b||vp(nums,index+1,l);
                } else {
                    l.add(nums[index+1]);
                    return vp(nums,index+1,l);
                }
            } else {
                if(equal(l)==true || check(l)==true){
                    l=new ArrayList<>();
                    l.add(nums[index+1]);
                    return vp(nums,index+1,l);
                }else {
                    return false;
                }
            }
        }
    }

    boolean equal(List<Integer> list){
        int a=list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)!=a){
                return false;
            }
        }
        return true;
    }
    boolean check(List<Integer> list){
        if(list.size()!=3) return false;
        int a=list.get(0);
        int factor=0;
        for(int i:list){
            if(i!=(a+factor++)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        CheckValidPartition ob=new CheckValidPartition();
        System.out.println(ob.validPartition(new int[]{4,4,4,5,6}));
        System.out.println(ob.validPartition(new  int[]{1,1,1,2}));
    }

}