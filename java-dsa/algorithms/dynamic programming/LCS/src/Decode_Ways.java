//link to the problem statement: https://leetcode.com/problems/decode-ways/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Decode_Ways {
    int len;
    HashMap<Integer,Integer> hm;
    public int numDecodings(String s) {
        len=s.length();
        hm=new HashMap<>();
        return numDecode(s+" ",0);
    }

    int numDecode(String s,int index){//Memoized
        if(hm.containsKey(index)){
            return hm.get(index);
        } else if(s.charAt(index)=='0'){
            return 0;
        } else if(index>=len-1){
            return 1;
        } else if(s.charAt(index)>='3' || (s.charAt(index)=='2' &&s.charAt(index+1)>='7')){
            hm.put(index,numDecode(s,index+1));
            return hm.get(index);
        } else {
            int One=numDecode(s,index+1);
            int Two=numDecode(s,index+2);
            hm.put(index,One+Two);
            return hm.get(index);
        }
    }

    public static void main(String[] args) {
        Decode_Ways ob=new Decode_Ways();
        System.out.println(ob.numDecodings("12"));
        System.out.println("226");
        System.out.println(ob.numDecodings("111111111111111111111111111111111111111111111"));
    }
}
