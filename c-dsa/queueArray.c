
#include <stdio.h>
#include <stdlib.h>
#define MAX 5
int queue[MAX];
int front  = -1;
int rear = -1;

void enqueue(void);
void dequeue(void);
void peep(void);
void display(void);


int main()
{
    int choice;
    printf("Queue using Arrays");
    while(1){
        printf("\nChoose from the options give below");
        printf("\n1. Insert element into the queue");
        printf("\n2. Delete element from the queue");
        printf("\n3. Display the first element of the queue");
        printf("\n4. Display the queue");
        printf("\n5. Exit\n");
        scanf("%d", &choice);
        switch(choice){
            case 1:
                enqueue();
                break;
            case 2: 
                dequeue();
                break;
            case 3: 
                peep();
                break;
            case 4:
                display();
                break;
            case 5: 
                exit(0);
                break;
            default:
                printf("Choose from the options given below.. ");
                break;
        }
    }

    return 0;
}

void enqueue(){
    int value;
    printf("Enter the element to be inserted : ");
    scanf("%d", &value);
    if(rear == MAX - 1){
        printf("Overlfow");
    }
    else if(front == -1 && rear == -1){
        front = rear = 0;
        queue[rear] = value;
    }
    else{
        rear++;
        queue[rear] = value;
    }
}
void dequeue(){
    if(front == -1 && rear == -1){
        printf("Queue is empty");
    }
    else if(front == rear){
        front = rear = -1;
    }
    else{
        front++;
    }
}
void peep(){
    if(front == -1){
        printf("Queue is empty");
    }
    else{
        printf("%d", queue[front]);
    }
}
void display(){
    if(front == -1 || front > rear){
        printf("Queue is Empty");
    }
    for(int i = front; i <= rear; i++){
        printf("%d \t", queue[i]);
    }
}

