// github.com/andy489

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
typedef vector<int> vi;
#define sz(x) ((int)x.size())

int upper_bound(const vi &vec, int l, int r, int target) {
    while (l < r) {
        int mid = (l + r) / 2;
        if (target > vec[mid])
            l = mid + 1;
        else
            r = mid;
    }
    if (vec[l] >= target)
        return l;
    else
        return -1;
}

int lower_bound(const vi &vec, int l, int r, int target) {
    while (l < r) {
        int mid = (l + r + 1) / 2;
        if (target >= vec[mid])
            l = mid;
        else
            r = mid - 1;
    }
    if (vec[l] <= target)
        return l;
    else
        return -1;
}

int main() {
    vi vec = {2, 14, 5, 3, 18, 7, 99, 15, 16, 8, -10, 67, 55, 45, -5, 67, 8, 34, 4, 23, 29};

    sort(vec.begin(), vec.end(), less<int>());

    for (const auto &el : vec)
        cout << el << ' ';
    cout << '\n';

    int K;
    cout << "Enter integer to search:\n";
    cin >> K;

    int upper = upper_bound(vec, 0, sz(vec) - 1, K);
    int lower = lower_bound(vec, 0, sz(vec) - 1, K);

    cout << "Smallest integer bigger than or equal to searched:\n";
    if (upper == -1)
        cout << "no such element\n";
    else
        cout << vec[upper] << '\n';

    cout << "Biggest integer smaller than or equal to searched:\n";
    if (lower == -1)
        cout << "no such element\n";
    else
        cout << vec[lower] << '\n';

    return 0;
}
