#include<iostream>
#include<cmath>
using namespace std;

int conv(int n, int b1, int b2) {
    int dec = 0;
    int i = 0;
    while(n > 0) {
        dec += (n % 10) * pow(b1, i);
        n /= 10;
        i++;
    }
    int b2n = 0;
    i = 0;
    while(dec > 0) {
        b2n += (dec % b2) * pow(10, i);
        dec /= b2;
        i++;
    }
    return b2n;
}
int main(){
    int n, b1, b2;
    cout<<"Enter a number, original base and base to be converted to: ";
    cin >> n >> b1 >> b2;
    cout << conv(n, b1, b2) << endl;
    return 0;
}
