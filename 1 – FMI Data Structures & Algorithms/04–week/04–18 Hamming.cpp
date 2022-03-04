#include <iostream>
#include <queue>

using namespace std;
typedef long long ll;

ll getMin(ll a, ll b) {
    return a > b ? b : a;
}

ll getMin(ll a, ll b, ll c) {
    return getMin(a, b) > c ? c : getMin(a, b);
}

int main() {
    int n;
    cin >> n;

    queue<ll> two, three, five;

    if (n == 0) {
        return 0;
    } else if (n == 1) {
        cout << 1;
        return 0;
    } else {
        two.push(2);
        three.push(3);
        five.push(5);

        cout << 1 << ", ";

        ll prev_hamming = 1;
        while (n > 1) {
            ll hamming = getMin(two.front(), three.front(), five.front());

            if (hamming == two.front()) {
                two.pop();
            } else if (hamming == three.front()) {
                three.pop();
            } else {
                five.pop();
            }

            if (hamming != prev_hamming) {
                --n;
                
                if (n > 1) {
                    cout << hamming << ", ";
                } else {
                    cout << hamming;
                }

                two.push(2 * hamming);
                three.push(3 * hamming);
                five.push(5 * hamming);

                prev_hamming = hamming;
            }
        }
    }

    return 0;
}
