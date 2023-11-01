#include<stdio.h>
#include<stdlib.h>
#define MAX 5
int queue[MAX];
int front = -1;
int rear = -1;

void enqueue(int a){
    int data = a;
    if(front == -1 && rear == -1){
        front = rear = 0;
        queue[rear] = data;
    }
    else if(rear == MAX - 1){
        printf("Overflow  !!!");
    }
    else{
        rear++;
        queue[rear] = data;
    }
    
}

int dequeue(){
    if(front == rear){
        front = rear = -1;
    }
    else if(front == -1 && rear == -1){
        printf("Underflow");
    }
    else{
        int val = front;
        front++;
        return val;
    }
}

int main(){
    int visited[MAX] = {0,0,0,0,0};
    int arr[MAX][MAX] = {{0,1,0,1,0},
                         {1,0,1,0,1},
                         {0,1,0,1,0},
                         {1,0,1,0,1},
                         {0,1,0,1,0}};
    int i =  5;
    visited[i] = 1;
    printf("%d \t",i);
    enqueue(i);
    while(front < rear){
        int value = dequeue();
        for(int j = 0 ; j < MAX ; j++){
            if(arr[value][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                printf("%d \t",j);
                enqueue(j);
            }
        }
    }
    
    
    return 0;
}

