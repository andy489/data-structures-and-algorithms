// github.com/andy489

#include <iostream>

size_t countInversions(size_t *arr, size_t n) {
    size_t inversions(0), i, j;
    for (i = 0; i < n - 1; ++i)
        for (j = i + 1; j < n; ++j)
            if (arr[i] > arr[j])
                inversions++;
    return inversions;
}

int main() {
    size_t Q, i(0), n;
    std::cin >> Q;
    while (Q--) {
        std::cin >> n;
        size_t *soldiers = new size_t[n];
        for (i = 0; i < n; ++i)
            std::cin >> soldiers[i];
        std::cout << countInversions(soldiers, n) << '\n';
        delete[] soldiers;
    }
    return 0;
}
