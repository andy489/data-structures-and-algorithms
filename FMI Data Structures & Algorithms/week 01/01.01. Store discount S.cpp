// github.com/andy489

/*
We well use greedy algorithm.
First we will sort the products prices by descending order
and then we will discount every k-th product.
In that way we will avoid paying most expensive products.
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, k, i(1);
    cin >> n >> k;
    vector<int> p(n + 1);
    for (; i <= n; ++i)
        cin >> p[i];
    sort(p.begin() + 1, p.end(), greater<int>());
    int min(0);
    for (i = 1; i <= n; i++)
        if (i % k)
            min += p[i];
    return cout << min, 0;
}


