import java.util.Scanner;

public class Quicksort {
	
	int[] qs(int[] ini) {
        if(ini.length <2) {
            return ini;
        } else {
            int pivot= ini[ini.length/2];
            int greater_than=0;
            int less_than=0;
            for(int i=0;i<ini.length;i++) {
                if(ini[i]< pivot) {
                    less_than++;
                } else if(ini[i]>pivot){
                    greater_than++;
                }
            }
            int[] g=new int[greater_than];
            int[] l=new int[less_than];
            less_than=0;
            greater_than=0;
            for(int i=0;i<ini.length;i++) {
                if(ini[i]<pivot) {
                    l[less_than++]=ini[i];
                } else if(ini[i]>pivot){
                    g[greater_than++]=ini[i];
                }
            }
            l=qs(l);
            g=qs(g);
            greater_than=0;
            for(int i=0;i<ini.length;i++) {
                if(i<l.length) {
                    ini[i] = l[i];
                }else if(i == l.length) {
                    ini[i] =pivot;
                }else{
                    ini[i] = g[greater_than++];
                }
            }
            return ini;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        Quicksort ob=new Quicksort();
        int[] arr=ob.qs(new int[] {55,44,66,99,11});
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i] + " \t");
        }
    }
}