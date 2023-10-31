//Polynomial Addition

#include <stdio.h>
#include<stdlib.h>

struct node
{
    int coeff;
    int expo;
    struct node *next;

};

struct node * insert(struct node * head,int coeff,int expo)
{
    struct node *temp;
    struct node *newp=malloc(sizeof(struct node));
    newp->coeff=coeff;
    newp->expo=expo;
    newp->next=NULL;
    if(head==NULL||expo>head->expo)
    {
        newp->next=head;
        head=newp;
    }
    else
    {
        temp=head;
        while(temp->next!=NULL && temp->next->expo>=expo)
        {
            temp=temp->next;
        }
        newp->next=temp->next;
        temp->next=newp;
    }
    return head;
}


void print(struct node *head)
{
    struct node *temp=head;
    while(temp!=NULL)
    {
        printf("%d^%d",temp->coeff,temp->expo);
        temp=temp->next;
        if(temp!=NULL)
            printf(" + ");
    }
}



struct node * create(struct node *head)
{
    int n,i,coeff,expo;
    printf("\nEnter the Number of Terms : ");
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        printf("Enter Coefficient for term %d : ",i+1);
        scanf("%d",&coeff);
        printf("Enter Exponent for term %d : ",i+1);
        scanf("%d",&expo);
        head=insert(head,coeff,expo);
        print(head);
    }
    return head;
}



int main()
{
    struct node *ptr1,*ptr2,*head3=NULL,*head1=NULL,*head2=NULL;
    printf("Enter the First Polynomial");
    head1=create(head1);
    printf("Enter the Second Polynomial");
    head2=create(head2);
    
    ptr1=head1;
    ptr2=head2;
    while(ptr1!=NULL && ptr2!=NULL)
    {
        if(ptr1->expo==ptr2->expo)
        {
            head3 = insert(head3,ptr1->coeff + ptr2->coeff,ptr1->expo);
            ptr1=ptr1->next;
            ptr2=ptr2->next;
        }
        else if(ptr1 -> expo > ptr2 -> expo){
            head3 = insert(head3,ptr1->coeff,ptr1->expo);
            ptr1= ptr1->next;
        }
        else {
            head3 = insert(head3,ptr2->coeff,ptr2->expo);
            ptr2 = ptr2 ->next;
        }
    }
        while(ptr1 != 0){
            head3 = insert(head3,ptr1->coeff,ptr1->expo);
            ptr1= ptr1->next;
        }
        while(ptr2 != 0){
            head3 = insert(head3,ptr2->coeff,ptr2->expo);
            ptr2 = ptr2 ->next;
        }
    printf("The result is : ");
    print(head3);
 return 0;
}
            
            
            
            
            
            
            
            
            
