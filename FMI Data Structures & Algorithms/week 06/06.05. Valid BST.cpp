// github.com/andy489

#include <iostream>

using namespace std;

int testpreorder(int ar[], int N) {
    int i, j;
    i = -1;
    while (++i < N - 1) {
        j = i + 1;
        while (ar[j] < ar[i] && j < N)
            j++;
        while (j < N) {
            if (ar[j] < ar[i])
                return 0;
            ++j;
        };
    }
    return 1;
}

int main() {
    int cases, N, *ar, i;
    cin >> cases;
    while (cases--) {
        cin >> N;
        ar = (int *) malloc(sizeof(int) * N);
        i = -1;
        while (++i < N)
            cin >> *(ar + i);
        cout << (testpreorder(ar, N) ? "YES" : "NO") << '\n';
    }
    return 0;
}
