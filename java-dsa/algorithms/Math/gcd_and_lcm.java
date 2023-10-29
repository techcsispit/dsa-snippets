import java.util.Scanner;

public class gcd_and_lcm {
    long n;
    long m;
    long gcd(long x,long y){
        if(x==0) return y;
        else if(y==0) return x;
        else return gcd(y,x%y);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        gcd_and_lcm ob=new gcd_and_lcm();
        System.out.println("Please enter two positive numbers: ");
        ob.n=sc.nextLong();
        ob.m=sc.nextLong();
        long gcd=ob.gcd(ob.n, ob.m);
        System.out.println("GCD is: " +gcd);
        System.out.println("LCM is= " + (ob.m*ob.n)/gcd);
    }    
}
