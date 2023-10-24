/*1. Start from the first element of the array and compare it with the next element.
2. If the first element is greater than the next element, swap them.
3. Move to the next pair of elements and repeat step 2 until the end of the array is reached.
4. If any swaps were made in step 2, repeat steps 1-3 until no more swaps are made.
5. The array is now sorted.*/

#include<iostream>
#include<vector>
using namespace std;
int main(){
    int n;
    cin>>n;
    vector<int> arr(n);
    for(int i=0;i<n;i++) cin>>arr[i];
    bool swapped;
    for(int i=0;i<n-1;i++){
        swapped=false;
        for(int j=0;j<n-i-1;j++){
            if(arr[j]>arr[j+1]){
                swap(arr[j],arr[j+1]);
                swapped=true;
            }
        }
        if(!swapped) break;
    }
    for(int i=0;i<n;i++) cout<<arr[i]<<" ";
    return 0;
}
