// github.com/andy489

#include <iostream>
#include <cmath>

using namespace std;
typedef unsigned long long ull;

ull func(int l1, int l2, ull t) { // return num of lists printed by both printers for time t
    return (ull) (floor(t / l1) + floor(t / l2));
}

int bS_on_answer(int l1, int l2, ull N) {
    START:
    ull left(0), right(N * max(l1, l2));

    ull ans(0);

    while (left <= right) {
        ull mid = left + (right - left) / 2;
        ull f = func(l1, l2, mid);

        if (f == N)
            ans = mid, right = mid - 1;
        else if (f < N)
            left = mid + 1;
        else
            right = mid - 1;
    }
    if (ans == 0) {
        ++N;
        goto START;
    } else 
        return ans;
}

int main() {
    int l1, l2;
    cout << "1st printer time for page: ";
    cin >> l1;
    cout << "2nd printer time for page: ";
    cin >> l2;
    cout << "Number of pages: ";
    ull N;
    cin >> N;

    return cout << "Minimum time for printing " << N
                << " lists is: " << bS_on_answer(l1, l2, N), 0;
}
