// github.com/andy489

#include <iostream>
#include <queue>

typedef long long ll;

using namespace std;

int main() {
    ll n, i;
    cin >> n;

    queue<ll> q;
    for (i = 1; i <= 9; ++i)
        q.push(i);

    ll next;
    int lastDigit;
    while (q.front() <= n) {
        next = q.front();
        cout << next << ' ';
        q.pop();
        lastDigit = next % 10;
        if (lastDigit < 2)
            q.push(next * 10 + lastDigit + 2);
        else if (lastDigit > 7)
            q.push(next * 10 + lastDigit - 2);
        else {
            q.push(next * 10 + lastDigit - 2);
            q.push(next * 10 + lastDigit + 2);
        }
    }
    return 0;
}
