/*1.Set the first element as the minimum value.
2.Compare the minimum value with the next element in the array.
3.If the next element is smaller than the minimum value, set the next element as the new minimum value.
4.Repeat step 3 until the end of the array is reached.
5.Swap the minimum value with the first element of the unsorted part of the array.
6.Repeat steps 1-5 for the remaining unsorted part of the array.*/

#include <iostream>
#include <vector>
using namespace std;

int main(){
    int n;
    cin>>n;
    vector<int> arr(n);
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    for(int i=0;i<n-1;i++){
        int min = i;
        for(int j=i+1;j<n;j++){
            if(arr[j]<arr[min]){
                min = j;
            }
        }
        swap(arr[i],arr[min]);
    }
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
}