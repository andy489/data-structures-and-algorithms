// github.com/andy489

#include <iostream>
#include <vector>
#include <climits>

using namespace std;

int partition(std::vector<int> &seq, int left, int right);

/*
Function that returns the K-th smallest element in an unsorted collection
of element assuming that all elements in the collection are distinct
*/

int KthSmallest(std::vector<int> &seq, int left, int right, int K) {
    if (K > 0 && K <= right - left + 1) { // Bounds of seq

        // Partition the array around last element and get
        // position of pivot element in sorted sequence
        int pos = partition(seq, left, right);

        if (pos - left == K - 1) return seq[pos]; // SUCCESS! (position == K)
        // Position is further
        else if (pos - left > K - 1) return KthSmallest(seq, left, pos - 1, K);
        else return KthSmallest(seq, pos + 1, right, K - pos + left - 1);
    }
    // If k is more than number of elements in array
    else return INT_MAX;
}

/*
Partition function from QuickSort(), which takes the last
element as pivot and moves all smaller element to left of it
and greater elements to right. Pure classic masterpiece!
*/

int partition(vector<int> &seq, int left, int right) {
    int X = seq[right], i = left, j;
    for (j = left; j <= right - 1; ++j) {
        if (seq[j] <= X)
            swap(seq[i++], seq[j]);
    }
    swap(seq[i], seq[right]);
    return i;
}

int main() {
    vector<int> seq = {0, 1, 1, 13, 8, 21, 3, 34, 5, 55, 2};
    int N = (int) seq.size(), K(0);
    cin >> K; // K is in scope

    return cout << "K-th smallest element is " << KthSmallest(seq, 0, N - 1, K), 0;
}
