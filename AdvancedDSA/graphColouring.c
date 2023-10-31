// Graph Colouring

#include <stdio.h>
#include <conio.h>

int graph[50][50], color[50];

void PutColor(int k){
    color[k] = 1; // Give color 1 to every coming call by default
    for(int i = 0; i< k;i++){
        if(color[i]==color[k] && graph[i][k] != 0){
            color[k] = color[i] + 1;
        }
    }
}

int main(){
    int n;
    printf("Graph Colouring \n");
    printf("Enter the no. of vertices : ");
    scanf("%d", &n);
    printf("Enter the adjacency matrix : ");
    for(int i = 0;i<n;i++){
        for(int j = 0;j<n;j++){
            scanf("%d", &graph[i][j]);
        }
    }
    
    for(int i = 0; i<n;i++){
        PutColor(i);
    }
    
    printf("The colours for the vertices are : \n");
    for(int i = 0; i<n;i++){
        printf("Vertex %d has color : %d\n", i, color[i]);
    }
}
