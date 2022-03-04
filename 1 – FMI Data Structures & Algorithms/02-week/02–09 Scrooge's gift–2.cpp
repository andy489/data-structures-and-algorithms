/*
Look up for the cheapest toy in the array (recursively:
which one is cheaper - the first or the cheaper in all
other toys except the first one?) and move it in front
of the array. After that recursively repeat the same
operation for the remaining array (without the first element)
*/

#include <iostream>

using namespace std;

int get_index_of_min_price_rec(int *toys, int start, int end) {
    // recursive function to get the index of the smallest element in RANGE from array
    if (start == end) {
        return start; // base case (exit case)
    }
    return (toys[get_index_of_min_price_rec(toys, start + 1 /* incrementing lower bound of range */, end)]
            < toys[start]) ? get_index_of_min_price_rec(toys, start + 1, end) : start; // recursive call
}

void swap(int &lego, int &doll) {
    int temp = lego;
    lego = doll;
    doll = temp;
}

int main() {
    int n, k;
    cin >> n >> k;

    int *toys = new int[n];

    for (int i = 0; i < n; ++i) {
        cin >> toys[i];
    }

    int cnt_toys = 0;

    while (true) {
        int cheaper_toy_index = get_index_of_min_price_rec(toys, cnt_toys, n - 1);
        k -= toys[cheaper_toy_index]; // spending money

        if (k >= 0) { // while still having money -> buy toys
            if (cnt_toys == n - 1) { // if bought all the toys
                ++cnt_toys;
                break;
            } // move the cheapest toy to the FRONT of the CURRENT array
            
            swap(toys[cheaper_toy_index], toys[cnt_toys]);
            ++cnt_toys;
        } else {
            break;
        }
    }

    cout << cnt_toys;

    return 0;
}
