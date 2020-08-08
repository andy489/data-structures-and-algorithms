// github.com/andy489

/*
We will generate all N*(N-1)/2 possible pairs of socks
and collect them in a vector<PairSocks>.
After that we will sort
the vector by key - diff (the difference between first and second sock in the pair).
Finally we will display the k-th pair.
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class PairSocks {
    int a, b, diff;
public:
    const int getDiff() const;

    PairSocks(int p, int q);

    friend std::ostream &operator<<(std::ostream &os, const PairSocks &pair);
};

struct byDiff {
    bool operator()(PairSocks const &a, PairSocks const &b) const {
        return a.getDiff() < b.getDiff();
    }
};

int main() {
    size_t n, k, i(0), j;
    cin >> n >> k;

    vector<int> socks(n);
    for (; i < n; ++i)
        cin >> socks[i];

    vector<PairSocks> pairs; //vector with all {n choose 2} pairs
    pairs.reserve(n * n - 1 / 2);
    for (i = 0; i < n; ++i)
        for (j = i + 1; j < n; ++j)
            pairs.push_back(PairSocks(socks[i], socks[j]));
    // Sorting all pairs by key
    sort(pairs.begin(), pairs.end(), byDiff()); //using operator ()
    return cout << pairs[k - 1], 0; //using operator <<
}

const int PairSocks::getDiff() const {
    return this->diff;
}

PairSocks::PairSocks(int p, int q) {
    if (p < q)
        a = p, b = q;
    else
        a = q, b = p;
    diff = b - a;
}

std::ostream &operator<<(std::ostream &os, const PairSocks &pair) {
    os << pair.a << ' ' << pair.b << '\n';
    return os;
};
