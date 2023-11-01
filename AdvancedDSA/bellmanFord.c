// Bellman Ford

#include<stdio.h>
#include<limits.h>

#define V 5

void BellmanFord(int graph[V][V], int source){
    int dist[V];
    int pred[V]; // Predecessor Array
    for (int i = 0; i < V;i++){
        dist[i] = INT_MAX;
        pred[i] = -1;
    }
    dist[source] = 0;
    
    for(int i = 0; i < V-1; i++){
        for(int j = 0; j<V;j++){
            if(dist[j] != INT_MAX){
                for(int k = 0; k <V;k++){
                    if(graph[j][k] != 0 && dist[j] + graph[j][k] < dist[k]){
                        dist[k] = dist[j] + graph[j][k];
                        pred[k] = j;
                    }
                }
            }
        }
    }
    for(int j = 0; j<V;j++){
            if(dist[j] != INT_MAX){
                for(int k = 0; k <V;k++){
                    if(graph[j][k] != 0 && dist[j] + graph[j][k] < dist[k]){
                        printf("Negative Edge Cycle Present");
                        return;
                    }
                }
            }
        }
        
    printf("Vertex \t     Distance \t Predecessor \n");
    for (int i = 0; i<V;i++){
        printf("%d \t\t", i);
        if(dist[i] == INT_MAX){
            printf("M\t\t");
        }
        else{
            printf("%d\t\t", dist[i]);
        }
        if(pred[i] == -1){
            printf("N \n");
        }
        else{
            printf("%d \n", pred[i]);
        }
    }
}


int main(){
    int graph[V][V] = {
        {0,6,0,7,0},
        {0,0,5,8,-4},
        {0,-2,0,0,0},
        {0,0,-3,0,9},
        {2,0,7,0,0}
    };
    
    BellmanFord(graph, 0);
    
    return 0;
}
