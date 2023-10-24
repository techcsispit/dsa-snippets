import java.util.Scanner;

public class Queue {
    int cap;
    int front;
    int rear;
    int Q[]; //An array to give a demo of how FIFO approach works in Queues
    Queue(int n){
        cap=n;
        front=-1;
        rear=-1;
        Q=new int[cap];
    }
    void addint(int v) {
        if (front == -1) {
            Q[++front] = v;
            rear++;
        } else if(front != -1){
            if (rear < cap - 1) {
                Q[++rear] = v;
            } else {
                System.out.println("Holder is full.");
            }
        }
    }
    int removeint(){
        //if(front == rear){
          //  return -999;
        //} else {
            int a=Q[front];
            Q[front]=0;
            if(front != rear){
                front++;
            }
            return a;
        //}
    }
    void show(){
        for(int i=0;i<cap;i++){
            System.out.print(Q[i] + "\t");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Queue ob=new Queue(5);
        while(true){
            System.out.println("1.Add integer 2.Remove integer 3.Exit");
            int ch=sc.nextInt();
            if(ch == 1){
                System.out.print("Enter a number: ");
                int a=sc.nextInt();
                System.out.println();
                ob.addint(a);
                ob.show();
            } else if(ch == 2){
                System.out.println("Element is" + ob.removeint());
                ob.show();
            }
            else {
                break;
            }
        }
    }
}

