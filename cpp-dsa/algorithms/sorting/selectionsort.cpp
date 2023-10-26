/*
 * 1. Set the first element as the minimum value.
 * 2. Compare the minimum value with the next element in the array.
 * 3. If the next element is smaller than the minimum value, set the next element as the new minimum value.
 * 4. Repeat step 3 until the end of the array is reached.
 * 5. Swap the minimum value with the first element of the unsorted part of the array.
 * 6. Repeat steps 1-5 for the remaining unsorted part of the array.
 */

#include <iostream>
#include <vector>
using namespace std;

void selectionSort(vector<int> arr, int n)
{
    // Find the minimum element in the unsorted part of the array
    int minIndex = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (arr[j] < arr[minIndex])
            {
                minIndex = j;
            }
        }
        // Swap the minimum element with the first element in the unsorted part
        swap(arr[i], arr[minIndex]);
    }
}

int main()
{
    int n;
    cout << "Enter the Array size and the Array: \n";
    cin >> n;
    vector<int> vec(0, n);
    for (int i = 0; i < n; i++)
        cin >> vec[i];

    cout << "The Sorted Array is as follows: \n";
    selectionSort(vec, n);
    for (int val : vec)
        cout << val << " ";
}