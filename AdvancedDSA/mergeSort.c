// Merge Sort
// Time Complexity = O(n logn)
#include <stdio.h>


void Merge(int arr[], int l, int mid, int r){
    int i,j,k,n1,n2;
    n1 = mid-l+1; // Assume array size 7, mid = 3 l = 0 r = 7
    n2 = r-mid; // Hence we can get the array sizes of both these arrays
    
    int L[n1],R[n2];
    for(int i = 0; i<n1;i++){
        L[i] = arr[l+i]; // As l = 0 so basically we are putting the values in array 
    }
    for(int j = 0;j<n2;j++){
        R[j] = arr[mid+1+j]; // Place the latter values in the next array
    }
    i = 0; // Initialize first array to the lowest
    j = 0; // Initialize second array to the lowest
    k = l; // Initialize the main array with the initial value
    
    while(i < n1 && j < n2){
        if(L[i] < R[j]){
            arr[k] = L[i];
            i++;
        }
        else{
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    while(i < n1){
        arr[k] = L[i];
        i++;
        k++;
    }
    while(j < n2){
        arr[k] = R[j];
        j++;
        k++;
    }
}

void MergeSort(int arr[], int l, int r){
    if(l<r){
        int mid = (l+r)/2;
        MergeSort(arr, l, mid);
        MergeSort(arr, mid+1,r);
        Merge(arr, l, mid, r);
    }
}


int main()
{
    printf("Merge Sort\n");
    int arr[] = {356,36467,36,38,646,346,3,846};
    int n = sizeof(arr)/sizeof(arr[0]);
    MergeSort(arr, 0, n-1);
    
    for(int i = 0; i<n;i++){
        printf("%d \t",arr[i]);
    }

    return 0;
}


