// github.com/andy489

// https://www.hackerrank.com/challenges/tree-top-view/problem

void topView(Node *root) {
    if (root == nullptr)
        return;
    queue <pair<int, Node *>> q;
    int hd(0);
    q.push({hd, root});

    map<int, int> m;
    while (!q.empty()) {
        auto cur = q.front();
        q.pop();
        hd = cur.first;
        if (cur.second->left)
            q.push({hd - 1, cur.second->left});
        if (cur.second->right)
            q.push({hd + 1, cur.second->right});
        if (!m.count(hd))
            m[hd] = cur.second->data;
    }
    for (const auto &kvp:m)
        cout << kvp.second << ' ';
}

// https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/Trees/Top%20View%20of%20BT.md
