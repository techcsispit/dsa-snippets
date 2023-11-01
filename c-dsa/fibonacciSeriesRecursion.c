#include <stdio.h>

int rec(int n){
    if(n==0){
        return 0;
    }
    if(n==1){
        return 1;
    }
    if(n>1){
        return rec(n-1) + rec(n-2);
    }
}
int main() 
{
    int n;
    printf("Fibonacci Series using Recursion\n");
    printf("Enter the number of terms : ");
    scanf("%d",&n);
    for(int i = 0; i< n;i++){
        printf("%d ",rec(i));
    }
    return 0;
}