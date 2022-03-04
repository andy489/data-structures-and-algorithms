// https://www.hackerrank.com/contests/daa-2020-2021-winter-test2/challenges/dp-1-todo-change-the-name/problem

#include <iostream>
#include <vector>

using namespace std;

const int MOD = 1e9 + 7;
typedef long long ll;

int n;
string s;
vector<int> res;
vector<ll> fibonacci_nums;

void init() {
    cin >> s;
    n = s.size();
}

void preprocess_fibonacci_numbers(int n) {
    fibonacci_nums.resize(n + 1);
    fibonacci_nums[1] = 1, fibonacci_nums[2] = 2;

    for (int i = 3; i <= n; ++i) {
        fibonacci_nums[i] = (fibonacci_nums[i - 1] + fibonacci_nums[i - 2]) % MOD;
    }
}

void get_repetitions() {
    for (int i = 0; i < n; ++i) {
        if (s[i] == 'm' || s[i] == 'w') {
            cout << 0;
            exit(0);
        }

        if (s[i] == 'n' || s[i] == 'u') {
            int j = i + 1;

            while(j < n && s[j] == s[j - 1]){
                ++j;
            }

            int curr = j - i;

            res.push_back(curr);

            i = j - 1;
        }
    }
}

int calc_answer(ll ans = 1) {
    for (int x: res) ans = (ans * fibonacci_nums[x] % MOD);
    return ans;
}

int main() {
    init();

    preprocess_fibonacci_numbers(n);

    get_repetitions();

    cout << calc_answer();

    return 0;
}
