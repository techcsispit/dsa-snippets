#include <iostream>

bool isPowerOfTwo(int n) {
    if (n <= 0) {
        return false;
    }
    return (n & (n - 1)) == 0;
}

int main() {
    int n;
    std::cout << "Enter a number: ";
    std::cin >> n;
    if (isPowerOfTwo(n)) {
        std::cout <<"Yes\n";
    } else {
        std::cout <<"No\n";
    }
    return 0;
}
