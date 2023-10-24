import java.util.Scanner;

class Node1{ //Class for node
    int data;
    Node1 next;
    Node1(){
        data=0;
        next=null;
    }
}


class Linkedlist1{ //Class for linked list
    Node1 start;
    Linkedlist1(){
        start=null;
    }
    void insert(int x){
        Node1 newNode=new Node1();
        newNode.data = x;
        if(start == null){
            start = newNode;
        } else if(x>start.data){
            boolean check = false;
            Node1 temp=start;
            while(temp != null){
                Node1 nextNode = temp.next; //Comparing two adjacent elements each time so see where newnode fits
                if(nextNode == null){ //Executed only if newnode.data contains biggest entry
                    nextNode=new Node1();
                    nextNode.data = 2147483647;
                }
                if(temp.data < newNode.data && nextNode.data>newNode.data){ //Ideal condition
                    newNode.next = nextNode;
                    temp.next = newNode;
                    check = true;
                    break;
                } else if(temp.next != null) {//Iteration
                    temp = temp.next;
                } else if(temp.next == null){
                    break;
                }
            }
            if(check == false){
                temp.next = newNode;
            }
        } else if(x< start.data){
            newNode.next = start;
            start = newNode;
        }
    }
    boolean search(int x){
        boolean present= false;
        Node1 temp = start;
        while(temp != null){
            if(temp.data == x){
                present=true;
                break;
            }
            temp=temp.next;
        }
        return present;
    }
    void display(){
        Node1 temp = start;
        while (temp != null){
            if(temp.data != 2147483647) {
                System.out.print(temp.data + "\t");
            }
            temp=temp.next;
        }
        System.out.println();
    }

    void remove(int r){
        Node1 T=new Node1();
        T.data=r;
        boolean checker = false;
        if(start == null){
            System.out.println("Element not present!");
        }
        else if(T.data == start.data){
            start=start.next;
            System.out.println("Element removed.");
        }
        else {
            Node1 trav=start;
            Node1 nextn=start.next;
            while(nextn!=null){
                if(nextn.data == r || trav.data == r){
                    trav.next=nextn.next;
                    checker=true;
                    break;
                }
                nextn=nextn.next;
                trav=trav.next;
            }
            if(checker == true){
                System.out.println("Element removed.");
            } else {
                System.out.println("Element not present!");
            }
        }
    }
    void reverse(){
        Node1 T1=new Node1();
        T1=start;
        int size=0;
        while(T1 != null ){
            size++;
            if(T1.next !=null && T1.next.data == 2147483647){
                T1.next = null;
                break;
            } else if(T1.next == null){
                break;
            }
            T1=T1.next;
        }
        Node1 S=start;
        start=T1;
        int size1=size;
        for(int i=0;i<size;i++){
            if(i == size-2){
                //T1.next=start;
                T1.next=S;
                S.next=null;
                break;
            }
            //Node1 Y=start;
            Node1 Y=S;
            int a=1;
            while(a < size1-1){
                if(a == size1-2){
                    T1.next = Y.next;
                    T1=T1.next;
                }
                Y=Y.next;
                a++;
            }
            size1--;
        }
    }
}
class Linked_List{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Linkedlist1 ob=new Linkedlist1();
        while(true){
            System.out.println("1.Enter element in ascending order \n 2.Search element \n 3.Display list \n 4.Remove element \n 5.Reverse list \n 6.Exit");
            int ch=sc.nextInt();
            if(ch == 1){
                System.out.println("Please enter element to be inserted: ");
                ob.insert(sc.nextInt());
            } else if(ch ==2){
                System.out.println("Please enter element to be searched: ");
                if(ob.search(sc.nextInt()) == true){
                    System.out.println("Element found.");
                } else {
                    System.out.println("Element not found.");
                }
            } else if(ch ==3){
                ob.display();
            } else if(ch == 6){
                break;
            } else if(ch == 4){
                System.out.println("Please enter element to be removed: ");
                ob.remove(sc.nextInt());
            } else if(ch == 5){
                ob.reverse();
            }
        }
    }
}
