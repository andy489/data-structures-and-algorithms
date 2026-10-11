// https://www.hackerrank.com/challenges/self-balancing-tree/problem

/* Node is defined as :
typedef struct node
{
    int val;
    struct node* left;
    struct node* right;
    int ht;
} node; */

int getHeight(node *n) {
    if (n == nullptr) {
        return -1;
    } else {
        return n->ht;
    }
}

int getBalance(node *n) {
    if (n == nullptr) {
        return 0;
    }

    return getHeight(n->left) - getHeight(n->right);
}

node *leftRotation(node *x) {
    node *y = x->right;
    node *T = y->left;

    y->left = x;
    x->right = T;

    x->ht = 1 + max(getHeight(x->left), getHeight(x->right));
    y->ht = 1 + max(getHeight(y->left), getHeight(y->right));

    return y;
}

node *rightRotation(node *x) {
    node *y = x->left;
    node *T = y->right;

    y->right = x;
    x->left = T;

    x->ht = 1 + max(getHeight(x->left), getHeight(x->right));
    y->ht = 1 + max(getHeight(y->left), getHeight(y->right));

    return y;
}

node *insert(node *root, int val) {
    if (root == nullptr) {
        root = new node;

        root->left = nullptr;
        root->right = nullptr;

        root->val = val;
        root->ht = 0;

        return root;
    }

    if (root->val > val) {
        root->left = insert(root->left, val);
    } else if (root->val < val) {
        root->right = insert(root->right, val);
    } else {
        return root;
    }

    root->ht = 1 + max(getHeight(root->right), getHeight(root->left));

    int balance = getBalance(root);

    int leftBalance = 0;
    int rightBalance = 0;

    if (balance > 1) {
        leftBalance = getBalance(root->left);
    }
    if (balance < -1) {
        rightBalance = getBalance(root->right);
    }

    if (balance > 1 && leftBalance >= 0) {
        return rightRotation(root);
    }

    if (balance > 1 && leftBalance < 0) {
        root->left = leftRotation(root->left);
        return rightRotation(root);
    }

    if (balance < -1 && rightBalance <= 0) {
        return leftRotation(root);
    }

    if (balance < -1 && rightBalance > 0) {
        root->right = rightRotation(root->right);
        return leftRotation(root);
    }
    
    return root;
}
