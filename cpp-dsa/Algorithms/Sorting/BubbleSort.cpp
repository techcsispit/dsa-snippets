#include<bits/stdc++.h>
using namespace std;

void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        // Flag to optimize the algorithm by checking if any swaps are made
        bool swapped = false;

        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j+1]
                swap(arr[j], arr[j + 1]);
                swapped = true;
            }
        }

        // If no two elements were swapped in inner loop, the array is already sorted
        if (!swapped) {
            break;
        }
    }
}

int main(){
    int n;
    cout<<"Enter The Array size and the array: \n";
    cin>>n;
    int a[n];
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    cout<<"The sorted array is as follows: \n";
    bubbleSort(a,n);
    for(int i=0;i<n;i++){
        cout<<a[i]<<" ";
    }
}
