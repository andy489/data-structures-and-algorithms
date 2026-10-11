// https://www.hackerrank.com/challenges/is-binary-search-tree/problem

bool isBST(Node *root, Node *min = nullptr, Node *max = nullptr) {
    if (root == nullptr) {
        return true;
    }

    if (min && (root->data) <= (min->data)) {
        return false;
    }

    if (max && (root->data) >= (max->data)) {
        return false;
    }

    return isBST(root->left, min, root) && isBST(root->right, root, max);
}

bool checkBST(Node *root) {
    return isBST(root);
}
