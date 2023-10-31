// Dijikstra's Algorithm

#include<stdio.h>
#include<stdbool.h> // for bool
#include<limits.h> // for int max
# define V 9  // The value of V is 9 declared globally

int MinDistance(int dist[], bool process[]){
    int min = INT_MAX;
    int parent;
    
    for(int i = 0; i< V;i++){
        if(process[i] == false && dist[i]<=min){
            min = dist[i];
            parent = i;
        }
    }
    return parent;
}

void PrintSolution(int dist[]){
    printf("Vertex \t\t\t Distance\n");
    for(int i = 0; i < V; i++){
        printf("%d \t\t\t %d\n", i, dist[i]);
    }
}

void Dijikstra(int graph[V][V], int source){
    int dist[V]; // Initialize array distance of size 9
    bool process[V]; // Initialize array of type bool to store the process
    // Now we need to initialize all distances as infinite and processes as false
    for(int i = 0; i<V;i++){
        dist[i] = INT_MAX;
        process[i] = false;
    }
    // The source distance needs to be made 0
    dist[source] = 0;
    // Now we need to find the shortest distance of each vertex
    for(int i = 0 ; i < V-1 ; i++){ // V-1 because vertex because last vertex has no other route left
        int u = MinDistance(dist, process);
        // u gets the parent if available
        process[u] = true; // Since it gets processed
        for(int v = 0;v<V;v++){
            // If the process is processes and there is a edge on the graph of u to v and the distance 
            // is not max and the distance is less than the distance v then update
            if(!process[v] && graph[u][v] && dist[u] != INT_MAX && dist[u] + graph[u][v] < dist[v]){
                dist[v] = dist[u] + graph[u][v];
            }  
        }
    }
    PrintSolution(dist);
}

int main(){
    int graph[V][V]={
        {0,4,0,0,0,0,0,8 ,0},
        {4,0,8,0,0,0,0,11,0},
        {0,8,0,7,0,4,0,0,2 },
        {0,0,7,0,9,14,0,0,0},
        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
    
    Dijikstra(graph, 0);
    
    return 0;
} 
