 //link to the problem statment: https://leetcode.com/problems/max-chunks-to-make-sorted/

public class Max_Chunks {
    public int maxChunksToSorted(int[] arr) {
        int chunks=0;
        boolean status=true;//If true we can consider current elem as a chunk
        int point=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] ==i && status==true){
                chunks++;
            } else if(i==point&& arr[i]<point&&status==false){
                chunks++;
                status=true;
            }else if(arr[i]!=i&&arr[i]>point){
                status=false;
                point=arr[i];
            }
        }
        return chunks;
    }

    public static void main(String[] args) {
        Max_Chunks ob=new Max_Chunks();
        System.out.println(ob.maxChunksToSorted(new int[]{1,2,3,4,5,0}));
    }
}
