// https://www.hackerrank.com/challenges/waiter/problem

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

vector<bool> is_prime;
vector<int> nth_prime;

void sieve_of_eratosthenes() {
    const int N = 1e4;
    is_prime.resize(N + 1, true);

    is_prime[0] = is_prime[1] = false;

    for (int i = 2; i * i <= N; ++i) {
        if (is_prime[i]) {
            for (int j = i * i; j <= N; j += i) {
                is_prime[j] = false;
            }
        }
    }

    const int FIRST_1200_PRIMES = 1200;

    nth_prime.reserve(FIRST_1200_PRIMES);

    int p = 2, j = 2;
    while (p < FIRST_1200_PRIMES + 2) {
        if (is_prime[j]) {
            nth_prime.push_back(j);
            ++p;
        }

        ++j;
    }

    int b = 0;
}

int main() {
    sieve_of_eratosthenes();

    int n, q;
    cin >> n >> q;

    vector<stack<int>> stacks(q + 2);

    int a;
    while (n--) {
        cin >> a;
        stacks[0].push(a);
    }

    int c = 0, p;
    for (int i = 0; i < q; ++i) {
        while (!stacks[i % 2].empty()) {
            p = stacks[i % 2].top();
            stacks[i % 2].pop();

            if (p % nth_prime[c]) {
                stacks[(i + 1) % 2].push(p);
            } else {
                stacks[i + 2].push(p);
            }
        }

        ++c;
    }

    for (int i = 2; i < q + 2; ++i) {
        while (!stacks[i].empty()) {
            cout << stacks[i].top() << endl;
            stacks[i].pop();
        }
    }

    for (int i = 0; i < 2; ++i) {
        while (!stacks[i].empty()) {
            cout << stacks[i].top() << endl;
            stacks[i].pop();
        }
    }

    return 0;
}
