#include <iostream>
#include <vector>

using namespace std;


int main() {
    int n;
    cout << "Enter a number: ";
    cin >> n;
    cout << "Factors of " << n << ": ";
    vector<int> factors;
    for (int i = 1; i <= n; i++) {  
    if (n % i == 0) {
            factors.push_back(i);
        }
    }
    for (int factor : factors) {
        cout << factor << " ";
    }
    cout << endl;
    return 0;
}
