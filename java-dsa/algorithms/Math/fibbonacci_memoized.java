import java.util.*;
class fibbonacci_memoized{
    HashMap<Long,Long> hm;
    long n;
    long fib(long x){
        if(x<=1){ 
            return 0;
        } else if(x==2){
            return 1;
        } else if(hm.containsKey(x)){
            return hm.get(x);
        }else {
            hm.put(x, fib(x-1) + fib(x-2));
            return hm.get(x);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        fibbonacci_memoized ob=new fibbonacci_memoized();
        System.out.println("Please enter the n'th fibbonacci term to be found: ");
        ob.n=sc.nextLong();
        ob.hm=new HashMap<>();
        System.out.println("The n'th term is: "+ob.fib(ob.n));
    }
}