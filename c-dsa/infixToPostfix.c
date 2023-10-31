#include <stdio.h>
#include <ctype.h>
#include <string.h>

char stack[100];
int top = -1;
void push(char a)
{
    top ++;
    stack[top] = a;
}

char pop(){
    int val = stack[top];
    top = top - 1;
    return val;
}

int isoperator(char ch){
    return(ch=='+'||ch=='-'||ch =='^'||ch=='*'||ch=='/');
}

int precedence(char ch){
    if(ch == '^'){
        return 3;
    }
    else if(ch =='*'||ch =='/'){
        return 2;
    }
    else if(ch=='+'|| ch=='-'){
        return 1;
    }
    else{
        return -1;
    }
}

int main(){
    char infix[100], postfix[100];
    int i,j=0;
    printf("Enter the string : ");
    scanf("%s",infix);
    for(int i = 0; i < strlen(infix);i++){
        if(isalnum(infix[i])){
            postfix[j] = infix[i];
            j++;
        }
        else if(infix[i] == '('){
            push(infix[i]);
        }
        else if(infix[i] == ')'){
            while(stack[top] != '('){
                int value = pop();
                postfix[j] = value;
                j++;
            }
            top--;
        }
        else if(isoperator(infix[i])){
            while(precedence(stack[top]) > precedence(infix[i])){
                int value = pop();
                postfix[j] = value;
                j++;
            }
            push(infix[i]);
            
        }
        
    }
    j++;
    postfix[j] = '\0';
    
    printf("The Postfix Expression is : ");
    for(int i = 0; i<=j;i++){
        printf("%c ",postfix[i]);
    }
    
    
    
    
    
    
    
    return 0;
}
