package Stormlight;

import java.util.Scanner;

public class Size_of_squares {
    int sizeOfSquares(int l,int b){
        if(l==b){ //
            return l;
        } else if(l==0 || b==0){
            return l==0?b:l;
        }else if(l>b){
            return sizeOfSquares(l%b,b);
        } else {
            return sizeOfSquares(l,b%l);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Size_of_squares ob=new Size_of_squares();
        int l,b;
        System.out.println("Please enter length of field:");
        l=sc.nextInt();
        System.out.println("Please enter breadth of field:");
        b=sc.nextInt();
        System.out.println(ob.sizeOfSquares(l,b));
    }
}
/*SAMPLE I/O : l=1600 and b=800
            Square of largest dimension which can equally divide block = 800
            l=1400 and b=800
            Square of largest dimension which can equally divide block = 200
 */