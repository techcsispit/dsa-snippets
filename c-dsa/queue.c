#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<stdlib.h>

struct node {
    int data;
    struct node *next;
    struct node *prev;
};
struct node *temp,*front = 0, *rear = 0, *newnode;

void enqueue(){
    newnode = (struct node*)malloc(sizeof(struct node));
    printf("Enter data to be inserted in the stack : ");
    scanf("%d",&newnode -> data);
    
    if(front == 0 && rear == 0){
        front = rear = newnode;
        newnode -> next = newnode -> prev = 0;
    }
    else{
        rear -> next = newnode;
        newnode -> prev = rear;
        rear = newnode;
    }
    
}

void dequeue(){
    front = front -> next;
    front -> prev = 0;
}

void peep(){
    printf("The topmost element of the queue is : %d ",front -> data);
}

void display(){
    int count = 0;
    temp = front;
    while(temp != 0){
        printf("%d  \t",temp->data);
        temp = temp -> next;
        count ++;
    }
    printf("Count is : %d",count);
}


int main(){
    int choice;
    printf("Queue using Doubly Linked List \n");
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

