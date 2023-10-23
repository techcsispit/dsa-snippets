import java.util.HashMap;

public class Power_Value {
    HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
    public int getKth(int lo, int hi, int k) {
        int len=hi-lo+1;
        int[] arr=new int[len];
        int[] powerarr=new int[len];
        for(int i=lo;i<=hi;i++){
            arr[i-lo] = i;
            int power=calcpower(i,i,0);
            powerarr[i-lo] = power;
        }
        for(int i=0;i<len;i++){
            int large=powerarr[i];
            int p=i;
            for(int j=i+1;j<len;j++){
                if(large>powerarr[j]){
                    large=powerarr[j];
                    p=j;
                }
            }
            int temp=powerarr[i];
            powerarr[i] = large;
            powerarr[p] = temp;
            temp=arr[i];
            arr[i] = arr[p];
            arr[p] = temp;
        }
        arr = sorted(arr, powerarr,true);
        //for(int i=0;i<len;i++){
          //  System.out.println(arr[i] + "   " + i + "  "+ powerarr[i]);
        //}
        return arr[k-1];
    }
    int calcpower(int og_a,int a, int p){
        if(a==1){
            hm.put(og_a,p);
            return p;
        }
        else if(hm.containsKey(a)){
            hm.put(og_a, p + hm.get(a));
            return p + hm.get(a);
        }
        else if(a%2 == 0){
            return calcpower(og_a,a/2,++p);
        }
        else if(a%2 !=0){
            return calcpower(og_a,a*3+1,++p);
        }
        return p;
    }

    int[] sorted(int[] arr,int[] powerarr, boolean boy){
        if(boy !=false){
            boy=false;
            for(int i=0;i<arr.length-1;i++){
                if(powerarr[i] == powerarr[i+1]&& arr[i]>arr[i+1]){
                    int temp=arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                    boy = true;
                }
            }
            return sorted(arr,powerarr, boy);
        } else {
            return arr;
        }
    }

    public static void main(String[] args) {
        Power_Value ob=new Power_Value();
        System.out.println(ob.getKth(6,282,62));
    }
}
