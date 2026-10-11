/*
We will use greedy algorithm.
First we will sort the products prices by descending order
and then we will discount every k-th product.
In that way we will avoid paying most expensive products.
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;

    vector<int> p(n);

    for (int i = 0; i < n; ++i) {
        cin >> p[i];
    }

    sort(p.begin(), p.end(), greater<>());

    int min_bill = 0;

    for (int i = 0; i < n; ++i) {
        if ((i + 1) % k) { // true if not 0
            min_bill += p[i];
        }
    }

    cout << min_bill << endl;

    return 0;
}