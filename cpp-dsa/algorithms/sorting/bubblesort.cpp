/*
 * 1. Start from the first element of the array and compare it with the next element.
 * 2. If the first element is greater than the next element, swap them.
 * 3. Move to the next pair of elements and repeat step 2 until the end of the array is reached.
 * 4. If any swaps were made in step 2, repeat steps 1-3 until no more swaps are made.
 * 5. The array is now sorted.
 */

#include <iostream>
#include <vector>

using namespace std;

void bubbleSort(vecotr<int> arr, int n)
{
    for (int i = n - 1; i >= 0; i--)
    {
        // Flag to optimize the algorithm by checking if any swaps are made
        bool swapped = false;

        for (int j = 0; j < i; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                // Swap arr[j] and arr[j+1]
                swap(arr[j], arr[j + 1]);
                swapped = true;
            }
        }

        // If no two elements were swapped in inner loop, the array is already sorted
        if (!swapped)
            break;
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
    bubbleSort(vec, n);

    for (int val : vec)
        cout << val << " ";
}
