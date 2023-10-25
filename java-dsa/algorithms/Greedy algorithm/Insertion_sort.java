import java.util.*;
class Insertion_sort{
    int[] arr;
    void sort(){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && key < arr[j]) {
              arr[j + 1] = arr[j];
              --j;
            }
            arr[j + 1] = key;
          }
          for(int i:arr){System.out.println(i+"\t");}
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        int a=sc.nextInt();
        Insertion_sort ob=new Insertion_sort();
        ob.arr=new int[a];
        for(int i=0;i<a;i++){
            ob.arr[i]=sc.nextInt();
        }
        System.out.println("Sorting array now: ");
        ob.sort();
        sc.close();
    }
}