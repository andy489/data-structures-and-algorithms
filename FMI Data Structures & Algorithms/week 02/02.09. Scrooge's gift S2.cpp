// github.com/andy489

/*
Idea: look up for the cheapest toy in the array (recursively:
which one is cheaper -
the first or the cheaper in all other toys except the first one?)
and move it in front of the array.
After that recursively repeat the same operation
for the remaining array (without the first element)
*/

#include <iostream>

using namespace std;

int getIndexOfMinPrice(int *toys, int start, int end) {
    // recursive function to get the index of the smallest element in RANGE from array
    if (start == end)
        return start; // base case (exit case)
    return (toys[getIndexOfMinPrice(toys, start + 1 /* incremanting lower bound of range */, end)]
            < toys[start]) ? getIndexOfMinPrice(toys, start + 1, end) : start; // recursive call
}

void swap(int &lego, int &doll) {
    int temp = lego;
    lego = doll;
    doll = temp;
}

int main() {
    int N, K, i(0);
    cin >> N >> K;
    int *toys = new int[N];
    for (; i < N; i++)
        cin >> toys[i];

    int countToys(0);

    while (true) {
        int cheaperToyIndex = getIndexOfMinPrice(toys, countToys, N - 1);
        K -= toys[cheaperToyIndex]; // spending money
        if (K >= 0) { // while still having money -> buy toys
            if (countToys == N - 1) { // if bought all the toys
                ++countToys;
                break;
            } // move the cheapest toy to the FRONT of the CURRENT array
            swap(toys[cheaperToyIndex], toys[countToys]);
            ++countToys;
        } else break;
    }
    return cout << countToys, 0;
}
