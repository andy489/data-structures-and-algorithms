#include <iostream>
#include <cmath>

using namespace std;

long long can_print(int l1, int l2, long long t) {
    return (long long) (floor(t / l1) + floor(t / l2));
}

long long bS_on_answer(int l1, int l2, long long n) {
    long long left = 0;
    long long right = n * max(l1, l2);
    long long ans = 0;

    while (left <= right) {
        long long mid = left + (right - left) / 2;

        if (can_print(l1, l2, mid) >= n) {
            ans = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return ans;
}

int main() {
    int l1;
    int l2;

    cout << "1st printer time for page: ";
    cin >> l1;

    cout << "2nd printer time for page: ";
    cin >> l2;

    cout << "number of pages: ";
    long long n;
    cin >> n;

    cout << "Minimum time for printing "
         << n
         << " lists is: "
         << bS_on_answer(l1, l2, n);

    return 0;
}
