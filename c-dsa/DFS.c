#include <stdio.h>
int visited[5] = {0,0,0,0,0};
int arr[5][5] = {{0,1,0,1,0},
                {1,0,1,0,1},
                {0,1,0,1,0},
                {1,0,1,0,1},
                {0,1,0,1,0}};
void DFS(int a){
    visited[a] = 1;
    printf("%d \t",a);
    for(int i = 0;i<5;i++){
        if(arr[a][i] == 1 && visited[i] == 0){
            DFS(i);
        }
    }
}

int main(){
    
    DFS(3);                     
    return 0;                         
}