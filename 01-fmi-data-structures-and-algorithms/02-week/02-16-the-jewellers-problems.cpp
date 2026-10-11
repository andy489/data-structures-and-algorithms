#include <iostream>
#include <vector>

using namespace std;

int partition(vector<int> &stones, int start, int end) {
    int mid_index = start + (end - start) / 2;
    swap(stones[mid_index], stones[end]);

    int pivot_index = stones[end], pIndex = start;

    for (int i = start; i < end; ++i) {
        if (stones[i] <= pivot_index) {
            swap(stones[i], stones[pIndex++]);
        }
    }
    
    swap(stones[pIndex], stones[end]);

    return pIndex;
}

void quick_sort(vector<int> &stones, int start, int end) {
    if (start >= end) {
        return;
    }

    int pivot = partition(stones, start, end);
    quick_sort(stones, start, pivot - 1);
    quick_sort(stones, pivot + 1, end);
}

bool is_pair_present(vector<int> &stones, int sum) {
    int left = 0;
    int right = stones.size() - 1;

    while (left < right) {
        if (stones[left] + stones[right] == sum) {
            return true;
        } else if (stones[left] + stones[right] > sum) {
            --right;
        } else {
            ++left;
        }
    }

    return false;
}

int main() {
    int n;
    cin >> n;

    vector<int> stones(n);
    for (int i = 0; i < n; ++i) {
        cin >> stones[i];
    }

    quick_sort(stones, 0, n - 1);

    for (int st : stones) {
        if (is_pair_present(stones, st)) {
            return cout << "true", 0;
        }
    }

    return cout << "false", 0;
}
