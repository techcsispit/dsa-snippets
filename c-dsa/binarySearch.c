#include <stdio.h>

int main()
{
    printf("Binary Search Algorithm \n");
    int data = 7;
    int arr[10] = {1,2,3,4,5,6,7,8,9,10};
    int l = 0 ,r = 9, m;
    m = (l + r)/2;
    while(l<=r){
        
        if(arr[m] < data){
            l = m+1;
            m = (l+r/2);
        }
        else if(arr[m] == data){
            printf("Found at location %d", m+1);
            break;
        } 
        else{
            r = m -1;
            m = (l+r)/2;
        }
    }
    if(l > r){
        printf("Not found");
    }
    

    return 0;
}