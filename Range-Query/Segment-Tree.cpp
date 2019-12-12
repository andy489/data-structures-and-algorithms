#include <bits/stdc++.h>
using namespace std;

static const int SIZE = 1 << 18;

int n, q;
int arr[SIZE];

struct segment_node {
    int value;
    int carry;

    int from;
    int to;

    segment_node* left;
    segment_node* right;

    void push() {
        value += (to - from + 1) * carry; // for min or max just value += carry
        
        if (left) {
            left->carry += carry;
            right->carry += carry;
        }

        carry = 0;
    }
};

segment_node* root;
segment_node memory_holder[2 * SIZE];
int memory_cnt;

void input() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
}

void build(segment_node* node, int f, int t) {
    node->from = f;
    node->to = t;
    node->carry = 0;

    if (f == t) {
        node->value = arr[f];
        node->left = node->right = nullptr;
        return;
    }

    node->left = &memory_holder[memory_cnt++]; // new Node;
    node->right = &memory_holder[memory_cnt++]; // new Node;

    int mid = (f + t) / 2;
    build(node->left, f, mid);
    build(node->right, mid + 1, t);

    node->value = node->left->value + node->right->value;
}

void update(segment_node* node, int f, int t, int v) {
    node->push();

    if (t < node->from || f > node->to) {
        return;
    }

    if (f <= node->from && node->to <= t) {
        node->carry += v;
        node->push();
        return;
    }

    update(node->left, f, t, v);
    update(node->right, f, t, v);

    node->value = node->left->value + node->right->value;
}

int find_sum(segment_node* node, int f, int t) {
    node->push();

    if (t < node->from || f > node->to) {
        return 0;
    }

    if (f <= node->from && node->to <= t) {
        return node->value;
    }

    return find_sum(node->left, f, t) + find_sum(node->right, f, t);
}

void solve() {
    cin >> q;
    for (int i = 0; i < q; i++) {
        char type;
        cin >> type;

        int l, r;
        cin >> l >> r;
        
        if (type == 'U') {
            int v;
            cin >> v;
            update(root, l, r, v);
        } else {
            cout << find_sum(root, l, r) << "\n";
        }
        
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    input();
    root = new segment_node();
    build(root, 0, n - 1);
    solve();

    return 0;
}
