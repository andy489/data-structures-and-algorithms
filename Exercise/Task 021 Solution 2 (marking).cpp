#include <iostream>
using namespace std;
#define FIELD (size_t)15e6

int main() {
    int N, M, a, b, i, c, d;
    cin >> N >> M;

    int* opening = new int[FIELD];
    int* closing = new int[FIELD];

    while (N--) {
        cin >> a >> b;
        opening[a] += 1;
        closing[++b] += 1;
    }
    for (i = 0;i < FIELD - 1;++i) {
        opening[i + 1] += opening[i];
        closing[i + 1] += closing[i];
    }
    int overlapping(0);
    while (M--) {
        cin >> c >> d;
        overlapping+=opening[d]-closing[c];
    }
    cout << overlapping;
}
