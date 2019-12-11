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

int min(int a, int b)
{
    return a > b ? b : a;
}

int main()
{
    int N, blast;std::cin >> N >> blast;

    std::vector<int>monsters(N);
    std::vector<int> uniqueMonsters;uniqueMonsters.reserve(N);

    for (int i = 0; i < N; i++) std::cin >> monsters[i];

    if (N == 0)
    {
        std::cout << 0;
        return 0;
    }
    else if (N == 1)
    {
        std::cout << 1;
        return 0;
    }
    else
    {
        int countBlasts(0);

        mergeSort(monsters);

        int curr(-1);
        for (size_t i = 0; i < N; i++)
        {
            if (monsters[i] == curr)
            {
                continue;
            }
            else
            {
                curr = monsters[i];
                uniqueMonsters.push_back(curr);
            }
        }
        size_t newN = uniqueMonsters.size();
        for (int i = newN - 1; i >= 0; i--)
        {
            if (uniqueMonsters[i] - countBlasts * blast <= 0)
            {
                std::cout << countBlasts;
                return 0;;
            }
            else
            {
                countBlasts++;
            }
        }
    }
    std::cout << uniqueMonsters.size();
    //for (auto i : uniqueMonsters)    std::cout << i << ' ';

    return 0;
}
