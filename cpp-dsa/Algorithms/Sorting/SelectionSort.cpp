#include<bits/stdc++.h>
using namespace std;


void selectionSort(int arr[], int n) {
    // Find the minimum element in the unsorted part of the array
    int minIndex = 0;
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(arr[j]<arr[minIndex]){
                minIndex = j;
            }
        }
        // Swap the minimum element with the first element in the unsorted part
        swap(arr[i],arr[minIndex]);
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
    selectionSort(a,n);
    for(int i=0;i<n;i++){
        cout<<a[i]<<" ";
    }
}