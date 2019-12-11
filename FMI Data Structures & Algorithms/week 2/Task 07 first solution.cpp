#include <iostream>
#include <vector>

size_t merge(std::vector<int>& A, std::vector<int>& L, std::vector<int>& R)
{
    size_t leftCount(L.size()), rightCount(R.size());
    size_t i(0), j(0), k(0), inv(0);

    while (i < leftCount && j < rightCount)
    {
        if (L[i] < R[j]) A[k++] = L[i++];
        else
        {
            A[k++] = R[j++];
            inv += leftCount - i;
        }
    }
    while (i < leftCount) A[k++] = L[i++];
    while (j < rightCount) A[k++] = R[j++];
    return inv;
}

size_t mergeSort(std::vector<int>& A)
{
    size_t n(A.size());
    size_t mid, i, inv(0);
    if (n < 2) return inv;

    mid = n / 2;

    std::vector<int> L(mid), R(n - mid);

    for (i = 0;i < mid;i++) L[i] = A[i];
    for (i = mid;i < n;i++) R[i - mid] = A[i];

    inv += mergeSort(L);
    inv += mergeSort(R);
    inv += merge(A, L, R);

    return inv;
}

int main()
{
    size_t N;std::cin >> N;
    std::vector<int>buildings(N);
    for (size_t i = 0; i < N; i++) std::cin >> buildings[i];
    
    std::cout << mergeSort(buildings);

    //for (auto i : buildings) std::cout << i << ' ';

    return 0;
}
