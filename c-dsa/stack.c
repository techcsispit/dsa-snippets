#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<stdlib.h>

struct node {
    int data;
    struct node *next;
    struct node *prev;
};
struct node *temp,*top = 0, *newnode;

void push(){
    newnode = (struct node*)malloc(sizeof(struct node));
    printf("Enter data to be inserted in the stack : ");
    scanf("%d",&newnode -> data);
    newnode -> next = 0;
    if(top == 0){
        top = temp = newnode;
        newnode -> prev = 0;
    }
    else{
        newnode -> next = top;
        top -> prev = newnode;
        top = newnode;
    }
}

void pop(){
    top = top -> next;
    top -> prev = 0;
}

void peep(){
    printf("The topmost element of the stack is : %d ",top -> data);
}

void display(){
    int count = 0;
    temp = top;
    while(temp != 0){
        printf("%d  \t",temp->data);
        temp = temp -> next;
        count ++;
    }
    printf("Count is : %d",count);
}


int main(){
    int choice;
    printf("Stack using Doubly Linked List \n");
    while(1){
        printf("\nEnter from the above choices : \n");
        printf("1. Push \n");
        printf("2. Pop \n");
        printf("3. Peep \n");
        printf("4. Display \n");
        printf("5. Exit \n");
        scanf("%d", &choice);
        switch(choice){
            case 1:
                push();
                break;
            case 2:
                pop();
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

