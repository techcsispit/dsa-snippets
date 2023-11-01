#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<stdlib.h>

struct node {
    int data;
    struct node *next;
};
struct node *temp,*start = 0, *newnode, *prevtemp;

void create(){
    newnode = (struct node*)malloc(sizeof(struct node));
    printf("Enter the data to be inserted : ");
    scanf("%d", &newnode -> data);
    newnode -> next = 0;
    if(start == 0){
        start = temp = newnode;
    }
    else {
        temp = start;
        while(temp -> next != 0){
            temp = temp -> next;
        }
        temp -> next = newnode;
        temp = newnode;
    }
}

void insertbegin(){
    newnode = (struct node*)malloc(sizeof(struct node));
    printf("Enter the data to be inserted");
    scanf("%d", &newnode -> data);
    newnode -> next = start;
    start = newnode;
}

void insertend(){
    create();
}

void insertatpos(){
    int pos;
    newnode = (struct node*)malloc(sizeof(struct node));
    printf("Enter the data to be inserted");
    scanf("%d", &newnode -> data);
    printf("Enter the position for insertion :");
    scanf("%d", &pos);
    temp = start;
    for(int i = 1; i< pos; i++){
        temp = temp -> next;
    }
    newnode -> next = temp -> next;
    temp -> next = newnode;
}

void deletebegin(){
    start = start -> next;
}

void deleteend(){
    temp = start;
    while(temp -> next != 0){
        prevtemp = temp;
        temp = temp -> next;
    }
    prevtemp -> next = temp -> next;
    temp = prevtemp;
    
}

void deleteatpos(){
    int pos;
    printf("Enter the position for deletion :");
    scanf("%d", &pos);
    temp = start;
    for(int i = 0; i<pos ;i++){
        prevtemp = temp;
        temp = temp -> next;
    }
    prevtemp -> next = temp -> next;
    
}

void display(){
    int count = 0;
    temp = start;
    while(temp != 0){
        printf("%d  \t",temp->data);
        temp = temp -> next;
        count ++;
    }
    printf("Count is : %d",count);
}


int main(){
    int choice;
    printf("Singly Linked List \n");
    while(1){
        printf("\nEnter from the above choices : \n");
        printf("1. Create Singly Linked List \n");
        printf("2. Insert elements from the start \n");
        printf("3. Insert elements from the end\n");
        printf("4. Insert elements from the given position \n");
        printf("5. Delete elements from the start\n");
        printf("6. Delete elements from the end\n");
        printf("7. Delete elements from the given position\n");
        printf("8. Display \n");
        printf("9. Exit \n");
        scanf("%d", &choice);
        switch(choice){
            case 1:
                create();
                break;
            case 2:
                insertbegin();
                break;
            case 3:
                insertend();
                break;
            case 4:
                insertatpos();
                break;
            case 5:
                deletebegin();
                break;
            case 6:
                deleteend();
                break;
            case 7: 
                deleteatpos();
                break;
            case 8:
                display();
                break;
            case 9:
                exit(0);
            default:
                printf("Choose only from the above options...");
                break;
        }
        
            
    }
    
    
    return 0;
}

