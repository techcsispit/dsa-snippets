//link to the problem statement: https://leetcode.com/problems/frog-jump/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Frog_Jump {
    List<Integer> list;
    HashMap<String,Boolean> hm;
    public boolean canCross(int[] stones) {
        list=new ArrayList<>();
        hm=new HashMap<>();
        for(int i=0;i<stones.length;i++){
            list.add(i,stones[i]);
        }
        return frogCross(list,1,1);
    }
    boolean frogCross(List<Integer> stones,int position,int k){
        if(stones.contains(position)==false){
            return false;
        } else if(hm.containsKey(position+" "+k)){
            return hm.get(position+" "+k);
        }else if(position == stones.get(stones.size()-1)){
            return true;
        } else {
            boolean a=frogCross(stones,position+k+1,k+1);
            boolean b=frogCross(stones,position+k,k);
            boolean c=false;
            if(k!=1) c=frogCross(stones,position+k-1,k-1);
            hm.put(position+" "+k,a||b||c);
            return hm.get(position+" "+k);
        }
    }

    public static void main(String[] args) {
        Frog_Jump ob=new Frog_Jump();
        System.out.println(ob.canCross(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println(ob.canCross(new int[]{0,1,3,4,8,9,11}));
    }
}
