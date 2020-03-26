// github.com/andy489

#include <bits/stdc++.h>
using namespace std;
const int N = 1509;
int n;
int a[N];

void input() {
    scanf("%d", &n);
    for (int i = 1; i <= n; i++)
        scanf("%d", &a[i]);
}

void sol() {
    int K = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
            K ^= (a[i] > a[j]);
        }
    }
    if (K) {
        printf("YES\n");
    }
    else {
        printf("NO\n");
    }
}

int main() {
    int test;
    scanf("%d", &test);
    while (test--){
        input();
        sol();
    }
    return 0;
}
