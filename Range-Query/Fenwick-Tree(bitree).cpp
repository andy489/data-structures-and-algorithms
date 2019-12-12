#include <bits/stdc++.h>
using namespace std;

static const int SIZE = 1 << 18;

int n, q;
int arr[SIZE];
int bitree[SIZE];

void input() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
}

void update(int index, int value) { 
    index++; 
    while (index <= n) { 
        bitree[index] += val; 
        index += index & (-index); 
    } 
}

int find_sum(int index) { 
    int sum = 0;
    index++; 
    while (index > 0) { 
        sum += bitree[index];
        index -= index & (-index); 
    } 
    return sum; 
} 

void build() {  
    for (int i = 0; i < n; i++) {
        update(i, arr[i]); 
    }
} 

void solve() {
    cin >> q;
    for (int i = 0; i < q; i++) {
        int l, r;
        cin >> l >> r;
        cout << find_sum(r) - find_sum(l - 1) << "\n";
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    input();
    build();
    solve();

    return 0;
}
