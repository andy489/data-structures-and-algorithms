// github.com/andy489

#include <iostream>

using namespace std;

long long cnt_inv(const int *arr, int n) {
    long long cnt_inv = 0;

    for (int i = 0; i < n - 1; ++i) {
        for (int j = i + 1; j < n; ++j) {
            if (arr[i] > arr[j]) {
                cnt_inv++;
            }
        }
    }

    return cnt_inv;
}

int main() {
    int q, n;
    cin >> q;
    while (q--) {
        cin >> n;
        int *soldiers = new int[n];

        for (int i = 0; i < n; ++i) {
            cin >> soldiers[i];
        }

        cout << cnt_inv(soldiers, n) << endl;

        delete[] soldiers;
    }

    return 0;
}
