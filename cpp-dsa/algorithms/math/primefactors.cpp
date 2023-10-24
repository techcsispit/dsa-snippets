#include <iostream>
#include <vector>

using namespace std;


int main() {
    int n;
    cout << "Enter a positive integer: ";
    cin >> n;
    vector<int> factors;
    int d = 2;
    while (n > 1) {
        while (n % d == 0) {
            factors.push_back(d);
            n /= d;
        }
        d++;
        if (d * d > n) {
            if (n > 1) {
                factors.push_back(n);
            }
            break;
        }
    }
    cout << "Prime factors of " << n << " are: ";
    for (int i = 0; i < factors.size(); i++) {
        cout << factors[i] << " ";
    }
    cout << endl;
    return 0;
}
