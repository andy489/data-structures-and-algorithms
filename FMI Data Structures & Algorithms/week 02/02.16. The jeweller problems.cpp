// github.com/andy489

#include <iostream>
#include <vector>

using namespace std;

int partition(vector<int> &stones, int start, int end) {
    int midIndex = start + (end - start) / 2;
    swap(stones[midIndex], stones[end]);

    int pivot = stones[end], pIndex = start;

    for (int i = start; i < end; ++i)
        if (stones[i] <= pivot)
            swap(stones[i], stones[pIndex++]);
    swap(stones[pIndex], stones[end]);
    return pIndex;
}

void quickSort(vector<int> &stones, int start, int end) {
    if (start >= end)
        return;
    int pivot = partition(stones, start, end);
    quickSort(stones, start, pivot - 1);
    quickSort(stones, pivot + 1, end);
}

bool isPairPresent(vector<int> &stones, int SUM) {
    int left(0), right(stones.size() - 1);

    while (left < right) {
        if (stones[left] + stones[right] == SUM)
            return true;
        else if (stones[left] + stones[right] > SUM)
            --right;
        else
            ++left;
    }
    return false;
}

int main() {
    int N, i(0);
    cin >> N;

    vector<int> stones(N);
    for (; i < N; ++i)
        cin >> stones[i];

    quickSort(stones, 0, N - 1);

    for (const auto &stone : stones)
        if (isPairPresent(stones, stone))
            return cout << "true", 0;
    return cout << "false", 0;
}
