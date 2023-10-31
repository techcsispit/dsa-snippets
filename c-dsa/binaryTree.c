#include <stdio.h>
#include <stdlib.h>

struct node {
    int data; // Stores the data of the node 
    struct node *left;  // a pointer variable that points to the nodes present in the left subtree
    struct node *right; // a pointer variable that points to the nodes present in the right subtree 
};

struct node *create(){   // This is a function of type struct node since the create function will return the address of the root node
    int x;
    struct node *newnode;
    newnode = (struct node*)malloc(sizeof(struct node)); // address of the created node is stored in the newnode pointer
    printf("Enter the value to be inserted in the node (-1 for no node):\n ");
    scanf("%d",&x);
    if (x == -1){
        return 0;
    }
    newnode->data = x;
        printf("Enter the values for the left subtree of %d\n",x);
        newnode -> left = create();
        printf("Enter the values for the right subtree of %d\n",x);
        newnode -> right = create();
        return newnode;
    
}

void preorder(struct node *root){  // Root -> Left -> Right
    if(root == 0){
        return;
    }   
    else{
        printf("%d \t",root->data);
        preorder(root->left);
        preorder(root->right);
    }
}

void inorder(struct node *root){
    if(root == 0){
        return;
    }
    else{
        inorder(root->left);
        printf("%d \t",root->data);
        inorder(root->right);
    }
}

void postorder(struct node *root){
        if(root == 0){
        return;
    }
    else{
        postorder(root->left);
        postorder(root->right);
        printf("%d \t",root->data);
    }
}

int main(){
    struct node *root;
    root = 0;
    root = create();  // We store the address of the root node in the root pointer
                      // because we can traverse all nodes of the tree if we have the root node address with us
                      
    printf("Preorder is : ");
    preorder(root);
    printf("Postorder is : ");
    postorder(root);
    printf("Inorder is : ");
    inorder(root);
    return 0;
}



