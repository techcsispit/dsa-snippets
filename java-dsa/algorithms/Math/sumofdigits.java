import java.util.Scanner;

class sumofdigits{
    int sumOfDigits(int a){
        if(a==0){
            return 0;
        } else {
            return a%10 + sumOfDigits(a/10);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        sumofdigits ob=new sumofdigits();
        System.out.println("Please enter a number: ");
        int n=sc.nextInt();
        System.out.println("Sum of digits= " + ob.sumOfDigits(n));
    }
}