// Fractional Knapsack

#include<stdio.h>

void Knapsack(int object, float capacity, float weight[], float profit[]){
    float valueofx[20];
    float totalprofit;
    int i;
    
    for(int i = 0; i< object;i++){
        if(weight[i] > capacity){
            break;
        }
        else{
            totalprofit = totalprofit + profit[i];
            capacity = capacity - weight[i];
            valueofx[i] = 1;
        }
    }
    if(i < object){ // If there is yet values and the fraction part begins
        valueofx[i] = capacity/weight[i];
        totalprofit = totalprofit + (valueofx[i]*profit[i]);
    }
    
    printf("The Max Profits are : %f\n", totalprofit);
    printf("The value of x is : ");
    for(int i = 0; i<object;i++ ){
        printf("%f   ", valueofx[i]);
    }
}


int main(){
    printf("Fractional Kanpsack\n");
    float weight[20];
    float profit[20];
    float ratio[20];
    int objects;
    float capacity;
    printf("Enter the capacity of the knapsack : \n");
    scanf("%f", &capacity);
    printf("Enter the number of objects : \n");
    scanf("%d", &objects);
    printf("Enter weights of each object : \n");
    for(int i = 0;i<objects;i++){
        scanf("%f", &weight[i]);
    }
    printf("Enter profits of each object : \n");
    for(int i = 0;i<objects;i++){
        scanf("%f", &profit[i]);
    }
    for(int i = 0;i<objects;i++){
        ratio[i] = profit[i]/weight[i];
    }
    // Now we arrange the profits in ascending order
    for(int i = 0;i<objects;i++){
        for(int j = i+1;j<objects;j++){
            if(ratio[i]<ratio[j]){
                int temp = ratio[i];
                ratio[i] = ratio[j];
                ratio[j] = temp;
                
                temp = weight[i];
                weight[i] = weight[j];
                weight[j] = temp;
                
                temp = profit[i];
                profit[i] = profit[j];
                profit[j] = temp;
            }
        }
    }
    Knapsack(objects, capacity, weight, profit);
    
    return 0;
}
