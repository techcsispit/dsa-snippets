import java.util.Scanner;

class fibbonacci_iterative{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter no.of terms of fibbonacci to be displayed: ");
        int n=sc.nextInt();
        int prev=0,curr=1,next=1;
        for(int i=1;i<=n;i++){
            System.out.println(prev + "\t");
            prev=curr;
            curr=next;
            next=prev+curr;
        }
    }
}