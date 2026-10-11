// https://www.hackerrank.com/challenges/is-binary-search-tree/problem

void LDR(Node *root, vector<int> &arr) {
    if (root) {
        LDR(root->left, arr);
        arr.push_back(root->data);
        LDR(root->right, arr);
    }
}

bool checkBST(Node *root) {
    vector<int> arr;

    LDR(root, arr);

    const int N = arr.size();

    for (int i = 0; i < N - 1; ++i) {
        if (arr[i] >= arr[i + 1]) {
            return false;
        }
    }

    return true;
}
