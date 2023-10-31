#include<stdio.h>
#include<stdlib.h>
#define MAX 5
int queue[MAX];
int front = -1;
int rear = -1;

void enqueue(){
    int data;
    printf("Enter the data for insertion");
    scanf("%d",&data);
    if(front == -1 && rear == -1){
        front = rear = 0;
        queue[rear] = data;
    }
    else if(front == (rear+1)%MAX){
        printf("Overflow  !!!");
    }
    else{
        rear = (rear + 1)%MAX;
        queue[rear] = data;
    }
    
}

void dequeue(){
    if(front == rear){
        front = rear = -1;
    }
    else if(front == -1 && rear == -1){
        printf("Underflow");
    }
    else{
        front = (front + 1)%MAX;
    }
}

void peep(){
    printf("The topmost element of the queue is : %d ",queue[front]);
}

void display(){
    int count = 0;
    int i = front;
    while(i != rear){
        printf("%d \t",queue[i]);
        i = (i + 1)%MAX;
    }
    printf("%d",queue[rear]);
}


int main(){
    int choice;
    printf("Citcular Queue using Array \n");
    while(1){
        printf("\nEnter from the above choices : \n");
        printf("1. Enqueue \n");
        printf("2. Dequeue \n");
        printf("3. Peep \n");
        printf("4. Display \n");
        printf("5. Exit \n");
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
            default:
                printf("Choose only from the above options...");
                break;
        }
        
            
    }
    
    
    return 0;
}

