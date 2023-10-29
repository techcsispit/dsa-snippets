import java.util.*;

class sieve_of_eratosthenes{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the number till where primes are to be found: ");
        int n=sc.nextInt();
        ArrayList<Integer> list =new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(list.contains(i) == false){
                System.out.println(i+"\t");
                int k=2;
                for(int j=i*k;j<=n;j=i*k){
                    list.add(j);
                    k++;
                }
            }
        }
    }
}