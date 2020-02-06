#include <iostream>
#include <vector>
using namespace std;

vector<int>l, r;
int k;

void swap_nodes(int lvl, int node)
{
    if (node == -1)return;
    if (lvl % k == 0) swap(l[node], r[node]);
    swap_nodes(lvl + 1, l[node]);
    swap_nodes(lvl + 1, r[node]);
}

void LDR(int root) {
    if (root != -1) {
        LDR(l[root]);
        cout << root << ' ';
        LDR(r[root]);
        if (root == 1)cout << '\n';
    }
}

int main() {
    int n, lc, rc, i(0);
    cin >> n;
    l.push_back(0);
    r.push_back(0);
    while (n--) {
        cin >> lc >> rc;
        l.push_back(lc);
        r.push_back(rc);
    }
    int q;
    cin >> q;
    while (q--) {
        cin >> k;
        swap_nodes(1, 1);
        LDR(1);
    }
    return 0;
}
