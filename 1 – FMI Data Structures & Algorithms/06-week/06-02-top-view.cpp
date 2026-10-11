// https://www.hackerrank.com/challenges/tree-top-view/problem

void topView(Node *root) {
    if (root == nullptr) {
        return;
    }

    queue <pair<int, Node *>> q;

    int horizontal_distance = 0;
    
    q.push({hd, root});

    map<int, int> m;

    while (!q.empty()) {
        auto cur = q.front();
        q.pop();
        horizontal_distance = cur.first;

        if (cur.second->left) {
            q.push({horizontal_distance - 1, cur.second->left});
        }
        if (cur.second->right) {
            q.push({horizontal_distance + 1, cur.second->right});
        }
        if (!m.count(horizontal_distance)) {
            m[horizontal_distance] = cur.second->data;
        }
    }
    for (const auto &kvp:m) {
        cout << kvp.second << ' ';
    }
}