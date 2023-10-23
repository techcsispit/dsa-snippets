import java.util.HashMap;

public class Jump_GameII {
    HashMap<Integer,Integer> hm;
    public int jump(int[] nums,int index,int jumps) {
        if (index >= nums.length-1 ){
            return jumps;
        } else if(nums[index]==0 ){
            return 0;
        } else if(hm.containsKey(index)){
            return jumps + hm.get(index);
        }else {
            int a=Integer.MAX_VALUE;
            for (int i=nums[index];i > 0;i--){
                int b = jump(nums,index+i,jumps+1);
                if (b<a && b!=0) a=b;
            }
            hm.put(index,a);
            return a;
        }
    }

    public static void main(String[] args) {
        Jump_GameII ob=new Jump_GameII();
        ob.hm=new HashMap<>();
        //System.out.println(ob.jump(new int[]{2,3,1,1,4},0,0));
        //System.out.println(ob.jump(new int[]{2,3,0,1,4},0,0));
        //System.out.println(ob.jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5},
          //      0,0));
        System.out.println(ob.jump(new int[]{9,8,2,2,0,2,2,0,4,1,5,7,9,6,6,0,6,5,0,5},0,0));
    }
}
