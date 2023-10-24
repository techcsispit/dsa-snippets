/*
1.Suppose we have an array [5, 2, 9, 3, 7, 6, 8, 1, 4].
2.Choose the first element, 5, as the pivot.
3.Partition the array into two sub-arrays: [2, 3, 1, 4] and [9, 7, 6, 8].
4.Recursively apply the above two steps to the sub-arrays. For the first sub-array, choose 2 as the pivot, partition it into [1] and [3, 4]. For the second sub-array, choose 9 as the pivot, partition it into [7, 6, 8] and [9].
5.Concatenate the sorted sub-arrays to get the final sorted array: [1, 2, 3, 4, 5, 6, 7, 8, 9].
*/
#include <iostream>
#include <vector>
using namespace std;

int partition(vector<int>&arr, int low, int high, int pivot){
	int i = low;
	int j = low;
	while( i <= high){
		if(arr[i] > pivot){
			i++;
		}
		else{
			swap(arr[i],arr[j]);
			i++;
			j++;
		}
	}
	return j-1;
}

void quicksort(vector<int> &arr, int low, int high){
	if(low < high){
	int pivot = arr[high];
	int pos = partition(arr, low, high, pivot);
	
	quicksort(arr, low, pos-1);
	quicksort(arr, pos+1, high);
	}
}

int main(){
    int n;
    cin>>n;
    vector<int> arr(n);
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    quicksort(arr,0,n-1);
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
}