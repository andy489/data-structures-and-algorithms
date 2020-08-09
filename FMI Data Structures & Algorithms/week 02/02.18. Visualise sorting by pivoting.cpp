// github.com/andy489

#include <iostream>
#include <vector>

using namespace std;
typedef vector<int> vi;

int partition(vi &col, int start, int end) {
    int pivIndx = (start + end + 1) / 2;
    //int pivIndx = (start + end) / 2;
    swap(col[pivIndx], col[end]);
    int pivot = col[end], i;
    pivIndx = start;
    for (i = start; i < end; ++i)
        if (col[i] < pivot)
            swap(col[i], col[pivIndx++]);
    swap(col[pivIndx], col[end]);
    for (const auto &el : col)
        cout << el << ' ';
    cout << '\n';
    return pivIndx;
}

void quickSort(vi &col, int start, int end) {
    if (start >= end) return;
    int pivot = partition(col, start, end);
    quickSort(col, start, pivot - 1);
    quickSort(col, pivot + 1, end);
}

int main() {
    int N, i(0);
    cin >> N;
    vi col(N);
    for (; i < N; ++i)
        cin >> col[i];
    quickSort(col, 0, N - 1);
}
