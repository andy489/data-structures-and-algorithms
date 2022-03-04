#include <iostream>
#include <random>

using namespace std;

random_device rd;
mt19937 random_number(rd());

struct treap_node {
    int value;

    int sum;
    int carry;

    int priority;
    int subtree_size;

    treap_node *left;
    treap_node *right;

    explicit treap_node(int val) {
        value = val;
        sum = val;
        carry = 0;
        priority = random_number();
        subtree_size = 1;
        left = right = nullptr;
    }

    void pull() {
        subtree_size = 1;
        subtree_size += left ? left->subtree_size : 0;
        subtree_size += right ? right->subtree_size : 0;

        sum = value;
        sum += left ? (left->sum + left->carry * left->subtree_size) : 0;
        sum += right ? (right->sum + right->carry * right->subtree_size) : 0;
    }

    void push() {
        value += carry;
        sum += subtree_size * carry;

        if (left) {
            left->carry += carry;
        }

        if (right) {
            right->carry += carry;
        }

        carry = 0;
    }
};

int get_size(treap_node *node) {
    return node ? node->subtree_size : 0;
}

treap_node *root;

void split(treap_node *node, treap_node *&left, treap_node *&right, int pos, int add) {
    if (node == nullptr) {
        left = right = nullptr;
        return;
    }

    node->push();

    int current_pos = add + get_size(node->left);

    if (pos <= current_pos) {
        split(node->left, left, node->left, pos, add);
        right = node;
    } else {
        split(node->right, node->right, right, pos, current_pos + 1);
        left = node;
    }

    node->pull();
}

void merge(treap_node *&node, treap_node *left, treap_node *right) {
    if (!left) {
        node = right;
        return;
    }
    if (!right) {
        node = left;
        return;
    }

    left->push();
    right->push();

    if (left->priority > right->priority) {
        merge(left->right, left->right, right);
        node = left;
    } else {
        merge(right->left, left, right->left);
        node = right;
    }

    node->pull();
}

void insert(int pos, int val) {
    if (!root) {
        root = new treap_node(val);
        return;
    }

    treap_node *from;
    treap_node *to;

    auto *mid = new treap_node(val);

    split(root, from, to, pos, 0);
    merge(from, from, mid);
    merge(root, from, to);
}

void erase(treap_node *&node, int value) {
    if (node->value == value) {
        merge(node, node->left, node->right);
    } else {
        if (value < node->value) {
            erase(node->left, value);
        } else {
            erase(node->right, value);
        }
    }

    node->pull();
}

void output(treap_node *node) {
    if (!node) {
        return;
    }

    output(node->left);
    cout << node->value << endl;
    output(node->right);
}

void build() {
    int n;
    cin >> n;

    for (int i = 0; i < n; ++i) {
        int num;
        cin >> num;

        insert(i, num);
    }
}

void update(int from, int to, int add) {
    treap_node *t1;
    treap_node *t2;
    split(root, t1, t2, from, 0);

    treap_node *t3;
    split(t2, t2, t3, to - from + 1, 0);

    t2->carry += add;

    merge(root, t1, t2);
    merge(root, root, t3);
}

int find_sum(int from, int to) {
    treap_node *t1;
    treap_node *t2;

    split(root, t1, t2, from, 0);

    treap_node *t3;
    split(t2, t2, t3, to - from + 1, 0);

    int result = t2->sum;

    merge(root, t1, t2);
    merge(root, root, t3);

    return result;
}

void solve() {
    int q;
    cin >> q;
    for (int i = 0; i < q; ++i) {
        char type;
        cin >> type;

        type = tolower(type);

        int from, to;
        cin >> from >> to;
        --from, --to;

        if (type == 'u') {
            int add;
            cin >> add;

            update(from, to, add);
        } else {
            cout << find_sum(from, to) << endl;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    build();

    solve();

    return 0;
}
