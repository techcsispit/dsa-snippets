#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *left;
    struct node *right;
};
struct node *newnode, *temp;

struct node *create(int a){
    newnode = (struct node*)malloc(sizeof(struct node));
    newnode -> data = a;
    newnode -> left = 0;
    newnode -> right = 0;
    return newnode;
}

struct node *insertBST(struct node *root,int a){
    if(root == 0) {
        return create(a);
    }
    else if(root -> data > a){
        root -> left = insertBST(root->left,a);
    }
    else if(root -> data < a){
        root -> right = insertBST(root->right,a);
    }
    return root;
}

struct node *minVal(struct node *root){
    temp = root;
    while(temp -> left != 0){
        temp = temp -> left;
    }
    return temp;
}

struct node *deleteBST(struct node *root, int a){
    if(root == 0){
        return root;
    }
    else if(root -> data > a){
        root -> left = deleteBST(root->left,a);
    }
    else if(root -> data < a){
        root -> right = deleteBST(root->right,a);
    }
    else{
        if(root -> left = 0){
            temp = root -> right;
            free(root);
            return temp;
        }
        else if(root -> right = 0){
            temp = root -> left;
            free(root);
            return temp;
        }
        struct node *minval = minVal(root->right);
        root->data = minval -> data;
        root -> right = deleteBST(root->right,minval->data);
    }
    return root;
}

void inorder(struct node *root){
    if(root == 0){
        return;
    }
    inorder(root->left);
    printf("%d \t",root->data);
    inorder(root->right);
}
int main()
{
    printf("Binary Search Tree\n ");
    int a,choice,val;
    struct node *root=NULL,*ptr;
    while(1)
    {
        printf("\n\n1. Insert Data in BST\n2. Delete Data from BST\n3. Inorder Traversal\n");
        scanf("%d",&choice);
        switch(choice){
            case 1: 
                printf("Enter data for insertion : ");
                scanf("%d",&a);
                root = insertBST(root,a);
                break;
            case 2:
                printf("Enter no. to be deleted : ");
                scanf("%d",&val);
                root = deleteBST(root,val);
                printf("\nInorder :\t");
                inorder(root);
            case 3:
                printf("\n Inorder :\t");
                inorder(root);
                break;
        }
    }   
    inorder(root);
    return 0;
}
