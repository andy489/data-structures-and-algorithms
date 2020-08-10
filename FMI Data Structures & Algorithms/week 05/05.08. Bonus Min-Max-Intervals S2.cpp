// github.com/andy489

// https://www.hackerrank.com/contests/practice-5-sda/challenges/min-max-intervals

#include <iostream>
#include <set>
#include <vector>

using namespace std;

auto inp(int n) {
    vector<int> v;
    v.reserve(n);
    while (n--) {
        int t;
        cin >> t;
        v.push_back(t);
    }
    return v;
}

long long sum(int n) {
    return (long long) n * (n + 1) >> 1;
}

template<size_t N>
class Inserted {
    int inserted[N];
    int cnt, indMin, indMax;
public:
    constexpr Inserted() : cnt(), indMin(N), indMax(-1) {
        for (int &x: inserted)
            x = -1;
    }

    constexpr void insert(int pos, int val) {
        if (inserted[pos] != -1) return;
        if (pos < indMin) indMin = pos;
        if (pos > indMax) indMax = pos;
        inserted[pos] = val;
        cnt++;
    }

    constexpr void erase(int pos) {
        if (inserted[pos] == -1) return;
        int i(0);
        if (pos == indMin) {
            for (i = indMin + 1; i < N && inserted[i] == -1; i++);
            indMin = i;
        }
        if (pos == indMax) {
            for (i = indMax - 1; i >= 0 && inserted[i] == -1; i--);
            indMax = i;
        }
        inserted[pos] = -1;
        cnt--;
    }

    constexpr int &operator[](size_t n) {
        return inserted[n];
    }

    constexpr int operator[](size_t n) const {
        return inserted[n];
    }

    constexpr bool empty() const {
        return !cnt;
    }

    constexpr pair<int, int> Min() const {
        return {indMin, inserted[indMin]};
    }

    constexpr pair<int, int> Max() const {
        return {indMax, inserted[indMax]};
    }

    constexpr size_t size() const {
        return cnt;
    }
};

Inserted<2000001> s;

long long solve(const vector<int> &v, int k) {
    long long res = 0, currPos = 0;
    for (size_t i = 0; i < v.size(); i++) {
        if (!s.empty() && (abs(s.Min().first - v[i]) > k || abs(s.Max().first - v[i]) > k)) {
            auto eraseHelper = [&](auto it) {
                for (int i = it.second - 1; i >= currPos; i--)
                    s.erase(v[i]);
                currPos = it.second + 1;
                s.erase(it.first);
            };
            res += sum(s.size());
            if (v[i] < s.Min().first)
                while (!s.empty() && s.Max().first - v[i] > k)
                    eraseHelper(s.Max());
            else
                while (!s.empty() && v[i] - s.Min().first > k)
                    eraseHelper(s.Min());
            res -= sum(s.size());
        }
        s.insert(v[i], i);
    }
    res += sum(s.size());
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;
    auto v = inp(n);

    return cout << solve(v, k), 0;
}
