// github.com/andy489

/// binary search (sorted array)

#include <iostream>

using namespace std;

long searchFirst(long target, long *sortedArr, long arrSize) {
    if (arrSize == 0) return -2;
    long pivot = arrSize / 2;
    int lastEncounter = -2;
    long start(0);
    while (start < arrSize) {
        if (sortedArr[pivot] < target) start = pivot;
        else if (sortedArr[pivot] > target) arrSize = pivot;
        else {
            lastEncounter = pivot;
            arrSize = pivot; // search first
        }
        if (pivot != (arrSize + start) / 2) pivot = (arrSize + start) / 2;
        else break;
    }
    return lastEncounter + 1;
}

long searchLast(long target, long *sortedArr, long arrSize) {
    if (arrSize == 0) return -2;
    long pivot = arrSize / 2;
    long lastEncounter = -2;
    long start(0);
    while (start < arrSize) {
        if (sortedArr[pivot] < target) start = pivot;
        else if (sortedArr[pivot] > target) arrSize = pivot;
        else {
            lastEncounter = pivot;
            start = pivot; // search last
        }
        if (pivot != (arrSize + start) / 2) pivot = (arrSize + start) / 2;
        else break;
    }
    return lastEncounter + 1;
}

void printResult(long *result, long N) {
    long i(0);
    for (; i < N; i += 2)
        cout << result[i] << ' ' << result[i + 1] << '\n';
}

int main() {
    long N, Q, i(0);
    cin >> N;
    long *sortedArr = new long[N];
    for (; i < N; ++i)
        cin >> sortedArr[i];
    //sort(sortedArr, sortedArr+n);
    cin >> Q;
    long *result = new long[2 * Q];
    long indx(0);
    for (i = 0; i < Q; ++i) {
        long P;
        cin >> P;
        result[indx++] = searchFirst(P, sortedArr, N);
        result[indx++] = searchLast(P, sortedArr, N);
    }
    printResult(result, 2 * Q);
}
