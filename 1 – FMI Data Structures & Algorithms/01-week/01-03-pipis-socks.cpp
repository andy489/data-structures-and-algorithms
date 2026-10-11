/*
We will generate all N * (N - 1) / 2 possible pairs of socks
and collect them in a vector<PairSocks>. After that we will sort
the vector by key - diff (the difference between first and second
sock in the pair). Finally we will display the k-th pair.
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Pair_socks {
    int a, b, diff;
public:
    int get_diff() const {
        return this->diff;
    }

    Pair_socks(int p, int q) {
        if (p > q) {
            swap(p, q);
        }

        a = p;
        b = q;
        diff = b - a;
    }

    friend ostream &operator<<(ostream &os, const Pair_socks &pair) {
        os << pair.a << ' ' << pair.b << '\n';
        return os;
    };
};

struct by_diff {
    bool operator()(Pair_socks const &a, Pair_socks const &b) const {
        return a.get_diff() < b.get_diff();
    }
};

int main() {
    int n, k;
    cin >> n >> k;

    vector<int> socks(n);

    for (int i = 0; i < n; ++i) {
        cin >> socks[i];
    }

    vector<Pair_socks> pairs; //vector with all {n choose 2} pairs

    pairs.reserve(n * n - 1 / 2);

    for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
            pairs.emplace_back(socks[i], socks[j]);
        }
    }

    // Sorting all pairs by key
    sort(pairs.begin(), pairs.end(), by_diff());

    cout << pairs[k - 1] << endl;

    return 0;
}