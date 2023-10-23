//link to the problem statement: https://leetcode.com/problems/jump-game/

public class Jump_Game {
    boolean[] arr;
    int[] arr2;
    public boolean canJump(int[] nums) {
        arr=new boolean[nums.length];
        arr2=new int[nums.length];
        return jumpToLast(nums,0);
    }

    boolean jumpToLast(int[] nums,int index){
        if(index>=nums.length-1){
            return true;
        } else if(arr2[index]!=0){
            return arr[index];
        } else if(nums[index]==0&&index!=nums.length-1){
            return false;
        } else {
            for(int i=index;i<index+nums[index];i++){
                boolean possible=jumpToLast(nums,i+1);
                arr[i] = possible;
                arr2[i]=1;
                if(possible==true){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Jump_Game ob=new Jump_Game();
        System.out.println(ob.canJump(new int[]{2,3,1,1,4}));
        System.out.println(ob.canJump(new int[]{3,2,1,0,4}));
        System.out.println(ob.canJump(new int[]{2,0,0}));
    }
}
