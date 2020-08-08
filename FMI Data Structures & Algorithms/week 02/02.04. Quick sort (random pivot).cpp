// github.com/andy489

#include <iostream>
#include <vector>
#include <ctime>

using namespace std;

int partition(vector<int> &collection, int start, int end) {
    size_t pivIndex = start + rand() % ((end - start) + 1);
    //size_t pivIndex = start + (end - start) / 2;
    swap(collection[pivIndex], collection[end]);

    int pivot = collection[end];
    pivIndex = start;

    for (int i = start; i < end; ++i)
        if (collection[i] <= pivot)
            std::swap(collection[i], collection[pivIndex++]);
    swap(collection[pivIndex], collection[end]);
    return pivIndex;
}

void quickSort(vector<int> &collection, int start, int end) {
    if (start >= end) return;
    int pivot = partition(collection, start, end);
    quickSort(collection, start, pivot - 1);
    quickSort(collection, pivot + 1, end);
}

int main() {
    srand((size_t)time(0));
    vector<int> collection = {5, -3, 1, 9, 0, 22, 3, 8, 4, -2, 9};
    int SIZE = (int) collection.size();

    quickSort(collection, 0, SIZE - 1);

    for (const auto &element : collection)
        cout << element << ' ';
    return 0;
}
