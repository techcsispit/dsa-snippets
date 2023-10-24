import java.util.Scanner;
public class stack
{
    int Arr[]; //An array to give an idea of how LIFO approach works in Stacks
    int cap;
    int top;

    public stack(int c) {
        Arr = new int[c];
        cap = c;
        top = -1; //IMPORTANT
    }

    public void push(int elem) { //Pushing something at the top of a stack
        if(top < cap-1) {
            Arr[++top] = elem;
        } else {
            System.out.println("Stack is full");
        }
    }

    int pop () { //Removing something from the top of the stack
        if (top>=0) {
            return Arr[top--];
        }else{
            return -999;
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the capacity");
        stack stack = new stack(sc.nextInt());
        while(true) {
            System.out.println("1. Push\t2. Pop\t3. Exit");
            int choice = sc.nextInt();
            if(choice==1) {
                System.out.println("Enter the element");
                int elem = sc.nextInt();
                stack.push(elem);
            } else if (choice==2) {
                System.out.println("Element is " + stack.pop());
            } else {
                break;
            }
        }
    }


}
