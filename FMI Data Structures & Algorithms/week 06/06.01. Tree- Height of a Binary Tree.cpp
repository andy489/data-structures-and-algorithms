// github.com/andy489

// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem

int height(Node *root) {
    if (root == nullptr)
        return -1;
    else {
        int leftHeight = height(root->left);
        int rightHeight = height(root->right);
        return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
    }
}
