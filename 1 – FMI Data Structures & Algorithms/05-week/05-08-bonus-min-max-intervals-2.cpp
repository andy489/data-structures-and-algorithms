// https://www.hackerrank.com/contests/practice-5-sda/challenges/min-max-intervals

#include <iostream>
#include <set>
#include <vector>

using namespace std;

auto input(int n) {
    vector<int> arr;
    arr.reserve(n);

    while (n--) {
        int t;
        cin >> t;

        arr.push_back(t);
    }

    return arr;
}

long long sum(int n) {
    return (long long) n * (n + 1) >> 1;
}

template<int N>
class Inserted {
    int inserted[N]{};
    int cnt, ind_min, ind_max;
public:
    constexpr Inserted() : cnt(), ind_min(N), ind_max(-1) {
        for (int &x: inserted)
            x = -1;
    }

    constexpr void insert(int pos, int val) {
        if (inserted[pos] != -1) {
            return;
        }

        if (pos < ind_min) {
            ind_min = pos;
        }

        if (pos > ind_max) {
            ind_max = pos;
        }

        inserted[pos] = val;
        ++cnt;
    }

    constexpr void erase(int pos) {
        if (inserted[pos] == -1) {
            return;
        }

        int i;

        if (pos == ind_min) {
            for (i = ind_min + 1; i < N && inserted[i] == -1; ++i);
            ind_min = i;
        }

        if (pos == ind_max) {
            for (i = ind_max - 1; i >= 0 && inserted[i] == -1; --i);
            ind_max = i;
        }

        inserted[pos] = -1;
        --cnt;
    }

    constexpr int &operator[](size_t n) {
        return inserted[n];
    }

    constexpr int operator[](size_t n) const {
        return inserted[n];
    }

    [[nodiscard]] constexpr bool empty() const {
        return !cnt;
    }

    [[nodiscard]] constexpr pair<int, int> min() const {
        return {ind_min, inserted[ind_min]};
    }

    [[nodiscard]] constexpr pair<int, int> max() const {
        return {ind_max, inserted[ind_max]};
    }

    [[nodiscard]] constexpr size_t size() const {
        return cnt;
    }
};

Inserted<(int) 2e6 + 1> s;

long long solve(const vector<int> &arr, int k) {
    const int SIZE = arr.size();

    long long res = 0;
    long long curr_pos = 0;

    for (int i = 0; i < SIZE; ++i) {
        if (!s.empty() && (abs(s.min().first - arr[i]) > k || abs(s.max().first - arr[i]) > k)) {
            auto erase_helper_lambda = [&](auto it) {
                for (int i = it.second - 1; i >= curr_pos; --i) {
                    s.erase(arr[i]);
                }

                curr_pos = it.second + 1;
                s.erase(it.first);
            };
            
            res += sum(s.size());
            
            if (arr[i] < s.min().first) {
                while (!s.empty() && s.max().first - arr[i] > k) {
                    erase_helper_lambda(s.max());
                }
            } else {
                while (!s.empty() && arr[i] - s.min().first > k) {
                    erase_helper_lambda(s.min());
                }
            }
            
            res -= sum(s.size());
        }

        s.insert(arr[i], i);
    }

    res += sum(s.size());

    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    auto v = input(n);

    cout << solve(v, k);

    return 0;
}
