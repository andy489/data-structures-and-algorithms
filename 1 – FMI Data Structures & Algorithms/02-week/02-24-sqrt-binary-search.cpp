/*
Напишете функция, която пресмята корен квадратен от дадено естествено число
с точност epsilon = 0.00001 и времева сложност log(N)
*/

#include <iostream>

using namespace std;

double my_abs(double d) {
    return d > 0 ? d : -d;
}

double sqrt_x(int x) {
    double left = 0.0;
    double right = 1e9;
    double mid;
    double eps = 1e-5;

    while (true) {
        mid = (left + right) / 2;

        if (my_abs(mid * mid - x) < eps) {
            return mid;
        } else if (mid * mid - x > 0) {
            right = mid;
        } else {
            left = mid;
        }
    }
}

int main() {
    int x;
    cin >> x;

    cout << sqrt_x(x);

    return 0;
}