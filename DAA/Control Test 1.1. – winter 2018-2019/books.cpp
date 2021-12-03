#include <cstdio>
#include <vector>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);

    vector<int> v(n);

    for (int i = 0; i < n; ++i) {
        scanf("%d", &v[i]);
    }

    int res = n;

    for (int i = n - 1; i >= 0; --i) {
        if (v[i] == res) {
            res--;
        }
    }

    return printf("%d", res), 0;
}
