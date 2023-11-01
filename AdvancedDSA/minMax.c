// Min Max Theorum 
// Time Complexity : O(n)
#include <stdio.h>
int arr[100];
int min, max;
void minmax(int i,int j){
    if(i==j){
        min = max = arr[i];
    }
    else if(i==j-1){
        if(arr[i]>arr[j]){
            max = arr[i];
            min = arr[j];
        }
        else{
            max = arr[j];
            min = arr[i];
        }
    }
    else{
        int mid = (i+j)/2;
        minmax(i, mid);
        int max1 = max;
        int min1 = min;
        minmax(mid+1,j);
        if(max1>max){
            max = max1;
        }
        if(min1<min){
            min = min1;
        }
    }
}

int main()
{
    printf("MinMax Element Finding\n");
    int n;
    printf("Enter the size of the array : ");
    scanf("%d", &n);
    printf("Enter the elements of the array : ");
    for(int i = 0 ; i < n ; i++){
        scanf("%d", &arr[i]);
    }
    min = arr[0];
    max = arr[0];
    minmax(0, n-1);
        printf("\nMinimum element in an array : %d\n", min);
    printf("Maximum element in an array : %d\n", max);


    return 0;
}


