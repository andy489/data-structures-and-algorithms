// https://www.hackerrank.com/contests/practice-7-sda/challenges/grand-hotel

#include <vector>
#include <unordered_map>

using namespace std;
typedef vector<int> vi;

#define f(i, n) for((i) = 0; (i) < (n) - 1; ++(i))
#define s(a) scanf("%d", &(a))

int main() {
    int n, i, cnt = 0;
    s(n);
    
    vi keys(n), doors(n);
    unordered_map<int, int> key_chain;

    f(i, n) s(keys[i]);
    f(i, n) s(doors[i]);

    f(i, n) {
        ++key_chain[keys[i]]; // collect key

        if (key_chain.count(doors[i])) {
            if (key_chain[doors[i]]) {
                --key_chain[doors[i]];
            } else {
                ++cnt;
            }
        } else {
            ++cnt;
        }
    }

    printf("%d", cnt);

    return 0;
}