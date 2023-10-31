#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
    struct node *prev;
};

struct node *front = 0, *rear = 0, *newnode, *temp;

void enqueue(){
    newnode = (struct node*)malloc(sizeof(struct node));
    printf("\n Enter the data : ");
    scanf("%d", &newnode -> data);
    if(front == 0 && rear == 0){
        front = rear = newnode;
        newnode -> next = 0;
        newnode -> prev = 0;
    }
    else{
        rear -> next = newnode;
        newnode -> prev = rear;
        rear = newnode;
        newnode -> next = 0;
    }
    
}

void dequeue(){
    if(front == 0 && rear == 0){
        printf("\n Queue is empty...");
    }
    else{
        temp = front;
        front = front -> next;
        front -> prev = 0;
        free(temp);
    }
}

void peep(){
    if(front == 0 && rear == 0){
    printf("\n Queue is empty...");
    }
    else{
        printf("\n The first element of the queue is : %d", front->data);
    }
}

void display(){
    temp = front;
    while(temp != 0){
        printf("%d \t",temp -> data);
        temp = temp -> next;
    }
}

int main()
{
    int choice;
    printf("Queue using Doubly Linked List (Shasvat Shah - 60004220126)");
    while(1){
        printf("\n 1. Enqueue ");
        printf("\n 2. Dequeue ");
        printf("\n 3. Peep ");
        printf("\n 4. Display  ");
        printf("\n 5. Exit ");
        printf("\n Choose from the abovce given numbers : ");
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
        }
    }
    return 0;
}

