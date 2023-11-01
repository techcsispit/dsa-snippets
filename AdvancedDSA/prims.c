#include <stdio.h>
#include <stdbool.h>
#include <limits.h>
#define V 5

int minKey(int key[], bool visited[]){
    int min = INT_MAX;
    int min_index;
    for(int i = 0;i<V;i++){
        if(visited[i]==false && key[i]<min){
            min = key[i];
            min_index = i;
        }
    }
    return min_index;
}

void Prims(int graph[V][V]){
    int parent[V];
    int key[V];
    bool visited[V];
    
    for(int i = 0;i<V;i++){
        key[i] = INT_MAX;
        visited[i] = false;
    }
    
    key[0] = 0;
    parent[0] = -1;
    
    for(int i = 0 ; i<V-1;i++){
        int u = minKey(key, visited);
        visited[u] = true;
        for(int v = 0;v<V;v++){
            if(graph[u][v] && visited[v] == false && graph[u][v] < key[v]){
                key[v] = graph[u][v];
                parent[v] = u;
            }
    }
}
    printf("Edge \tWeight\n");
    for (int i = 1; i < V; i++)
        printf("%d - %d \t%d \n", parent[i], i,
               graph[i][parent[i]]);
}
int main()
{
    printf("Prim's Algorithm\n");
    int graph [V][V] = {
        { 0, 2, 0, 6, 0 },
        { 2, 0, 3, 8, 5 },
        { 0, 3, 0, 0, 7 },
        { 6, 8, 0, 0, 9 },
        { 0, 5, 7, 9, 0 }
    };
    
    Prims(graph);

    return 0;
}


