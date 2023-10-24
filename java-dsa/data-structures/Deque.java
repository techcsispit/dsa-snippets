import java.util.*;
class Deque
{
    int[] N;
    int fctr;
    int rctr;


    Deque(int A)
    {
        N = new int[A];
        fctr = -1;
        rctr = -1;
    }
    void pushfront(int k) {
        if(rctr < N.length - 1) {
            for(int i = rctr; i> fctr; i--) {
                N[i+1] = N[i];
            }
            N[fctr +1] = k;
            rctr++;
        }
    }
    int popfront() {
        int element= N[fctr +1];
        N[fctr +1]= 0;
        fctr++;
        return element;
    }
    void pushrear(int k) {
        if(rctr < N.length-1) {
            N[++rctr] = k;
        }
    }
    int poprear() {
        int element = N[rctr];
        //rear--;
        for(int i = rctr; i> fctr; i--) {
            N[i] = N[i-1];
        }
        N[fctr++] =0;
        return  element;
    }

    void display()
    {
        for(int i=0;i< N.length;i++)
        {
            System.out.print(N[i] + "\t");
        }
        System.out.println("front=" + fctr +" and rear=" + rctr);
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Please enter the array size: ");
        int s=sc.nextInt();
        Deque ob=new Deque(s);
        while(true)
        { //infinite loop
            System.out.println("1.Add front \t 2.Remove front \t 3.Add rear \t 4.Remove rear \t 5.Exit");
            int ch=sc.nextInt();
            if(ch == 1)
            {
                System.out.print("Please enter an element to be added:");
                ob.pushfront(sc.nextInt());
                System.out.println();
                ob.display();
            }
            else if(ch == 2)
            {
                System.out.println(ob.popfront());
                ob.display();
            }
            else if(ch == 3)
            {
                System.out.print("Please enter an element to be added:");
                ob.pushrear(sc.nextInt());
                ob.display();
            }
            else if(ch == 4)
            {
                System.out.println(ob.poprear());
                ob.display();
            }
            else if( ch == 5){
                break;
            }
        }
    }
}

