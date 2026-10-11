// https://www.hackerrank.com/contests/si-practice-5/challenges/1-129

#include <iostream>
#include <queue>

typedef long long ll;

using namespace std;

const int DIGITS = 9;

int main() {
    ll n;
    cin >> n;

    queue<ll> q;

    for (int i = 1; i <= DIGITS; ++i) {
        q.push(i);
    }

    ll next;
    short last_digit;

    while (q.front() <= n) {
        next = q.front();
        q.pop();

        cout << next << ' ';
        
        last_digit = next % 10;

        if (last_digit < 2) {
            q.push(next * 10 + last_digit + 2);
        } else if (last_digit > 7) {
            q.push(next * 10 + last_digit - 2);
        } else {
            q.push(next * 10 + last_digit - 2);
            q.push(next * 10 + last_digit + 2);
        }
    }
    
    return 0;
}
