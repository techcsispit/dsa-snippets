import java.util.Scanner;

public class factorial {
    long n;
    long fact(long x){
        if(x<=1){
            return 1;
        } else {
            return x*fact(x-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        factorial ob=new factorial();
        System.out.println("Please enter a positive number: ");
        ob.n=sc.nextLong();
        System.out.println("Factorial is: " + ob.fact(ob.n));
    }    
}
