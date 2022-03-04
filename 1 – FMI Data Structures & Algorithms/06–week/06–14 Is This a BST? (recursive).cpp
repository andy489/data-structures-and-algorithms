// https://www.hackerrank.com/challenges/is-binary-search-tree/problem

bool checkBSTUtil(Node *root, Node *l = nullptr, Node *r = nullptr) {
    if (!root) {
        return true;
    }

    if (l != nullptr && root->data <= l->data) {
        return false;
    }

    if (r != nullptr && root->data >= r->data) {
        return false;
    }

    return checkBSTUtil(root->left, l, root) && checkBSTUtil(root->right, root, r);
}

bool checkBST(Node *root) {
    return checkBSTUtil(root);
}
