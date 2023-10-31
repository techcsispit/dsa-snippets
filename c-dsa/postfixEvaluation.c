#include <stdio.h>
#include <ctype.h>
#include <string.h>
char stack[100];
int top = -1;
void push(char a){
    top++;
    stack[top] = a;
}
char pop(){
    int val = stack[top];
    top--;
    return val;
}
int main()
{   
    int c;
    char postfix[100];
    printf("Postfix Evaluation \n");
    printf("Enter the Expression to be evaluated : ");
    scanf("%s",postfix);
    for(int i = 0; i<strlen(postfix);i++){
        if(isdigit(postfix[i])){
            push(postfix[i]-48);
        }
        else{
            int a = pop();
            int b = pop();
            switch(postfix[i])
            {
                case '+':
                   c = b + a;
                   break;
                case '-':
                   c = b - a;
                   break;
                case '*':
                   c = b * a;
                   break;
                case '/':
                   c = b / a;
                   break;
            }
            push(c);
        }
        
    }
    
    printf("The result is : %d",pop());

    return 0;
}