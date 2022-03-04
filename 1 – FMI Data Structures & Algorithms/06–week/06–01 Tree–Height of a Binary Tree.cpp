// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem

int height(Node *root) {
    if (root == nullptr)
        return -1;
    else {
        int left_height = height(root->left);
        int right_height = height(root->right);
        
        return (left_height > right_height ? left_height : right_height) + 1;
    }
}
