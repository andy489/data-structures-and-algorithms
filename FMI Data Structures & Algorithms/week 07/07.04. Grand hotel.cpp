// github.com/andy489

// https://www.hackerrank.com/contests/practice-7-sda/challenges/grand-hotel

#include <vector>
#include <unordered_map>

using namespace std;
typedef vector<int> vi;

#define f(i, n) for(i=0;i<n-1;++i)
#define s(a) scanf("%d", &a)

int main() {
    int n, i, r, c(0);
    s(n);
    vi keys(n), doors(n);
    unordered_map<int, int> keyChain;
    f(i, n) s(keys[i]);
    f(i, n) s(doors[i]);
    f(i, n) {
        keyChain[keys[i]]++; // collect key
        if (keyChain.count(doors[i])) {
            if (keyChain[doors[i]]) keyChain[doors[i]]--;
            else c++;
        } else c++;
    }
    return printf("%d", c), 0;
}
