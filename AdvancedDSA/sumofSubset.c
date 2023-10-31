// Sum of Subset

#include<stdio.h>
#include<stdlib.h>

int arr[10];
int m , n;
int valueofx[10];

void SumOfSubset(int sum, int element, int totalsum){
    valueofx[element] = 1; // Set the element as 1 by default
    if(sum + arr[element] == m){
        printf("Subset Found : ");
        for(int i = 0; i<=element;i++){
            if(valueofx[i] == 1){
                printf("%d  ", arr[i]);
            } 
        }
        printf("\n");
    }
    else if(sum + arr[element] + arr[element+1] <= m){
        SumOfSubset(sum + arr[element], element+1,totalsum-arr[element]);
    }
    if(sum + totalsum - arr[element] >=m && sum + arr[element+1] <= m){
        valueofx[element] = 0;
        SumOfSubset(sum, element+1, totalsum-arr[element]);
    }
}

int main(){
    int totalsum;
    printf("Sum of Subsets Problem \n");
    printf("Enter the number of elements :");
    scanf("%d", &n);
    printf("Enter the Elements : ");
    for(int i = 0;i<n;i++){
        scanf("%d", &arr[i]);
        totalsum = totalsum+arr[i];
    }
    printf("Enter the sum we want : ");
    scanf("%d",&m);
    
    SumOfSubset(0,0,totalsum);
    return 0;
}
