#include <iostream>
#include <vector>

using namespace std;

struct Node {
    vector<int> point;
    Node *left, *right;

    explicit Node(vector<int> &p, Node *left = nullptr, Node *right = nullptr) :
            point(p), left(left), right(right) {}
};

class TwoDTree {
    Node *root = nullptr;

    Node *insert_node2(Node *root, vector<int> &p, int level) {
        if (root == nullptr) {
            return new Node(p);
        }

        int coord = level % 2;

        if (p[coord] < root->point[coord]) {
            root->left = insert_node2(root->left, p, level + 1);
        } else {
            root->right = insert_node2(root->right, p, level + 1);
        }
        return root;
    }

    void square_db(vector<int> &D, vector<int> &B, Node *root, int level) {
        if (root == nullptr) {
            return;
        }

        if (level % 2 == 0) {
            if (root->point[0] < D[0]) {
                square_db(D, B, root->right, level + 1);
            } else if (root->point[0] > B[0]) {
                square_db(D, B, root->left, level + 1);
            } else {
                if (root->point[1] <= D[1] && root->point[1] >= B[1]) {
                    cout << root->point[0] << ' ' << root->point[1] << endl;
                }

                square_db(D, B, root->left, level + 1);
                square_db(D, B, root->right, level + 1);
            }
        } else {
            if (root->point[1] > D[1]) {
                square_db(D, B, root->left, level + 1);
            } else if (root->point[1] < B[1]) {
                square_db(D, B, root->right, level + 1);
            } else {
                if (root->point[0] >= D[0] && root->point[0] <= B[0]) {
                    cout << root->point[0] << ' ' << root->point[1] << endl;
                }

                square_db(D, B, root->left, level + 1);
                square_db(D, B, root->right, level + 1);
            }
        }
    }

    bool search_rec(Node *root, vector<int> &point, int level) {
        if (root == nullptr) {
            return false;
        }

        if (root->point == point) {
            return true;
        }

        int cd = level % 2; // current dimension

        if (point[cd] < root->point[cd]) {
            return search_rec(root->left, point, level + 1);
        }

        return search_rec(root->right, point, level + 1);
    }

    void print_kd(Node *node) {
        if (node == nullptr) {
            return;
        }

        print_kd(node->left);
        cout << node->point[0] << ' ' << node->point[1] << endl;
        print_kd(node->right);
    }

public:

    void insert(vector<int> p) {
        root = insert_node2(root, p, 0);
    }

    void print() {
        print_kd(root);
    }

    void in_square(vector<int> D, vector<int> B) {
        square_db(D, B, root, 0);
    }

    bool search(vector<int> point) {
        return search_rec(root, point, 0);
    }
};

int main() {
    TwoDTree kd;

    kd.insert({3, 4});
    kd.insert({1, 2});
    kd.insert({4, 1});
    kd.insert({-1, 2});
    kd.insert({10, 8});
    kd.insert({-2, 1});
    kd.insert({9, 9});
    kd.insert({2, 3});
    kd.insert({8, 8});
    kd.insert({2, 6});
    kd.insert({1, 7});
    kd.insert({-1, -1});
    kd.insert({3, -2});
    kd.insert({8, -3});

    cout << "All points in KD tree, LDR printed:" << endl;

    kd.print();

    cout << "Find all points in square ABCD defined by:"
         << endl
         << "upper left point D(0,8) and lower right point B(3,5)"
         << endl;

    kd.in_square({0, 8}, {3, 5});

    cout << endl
         << "Is there point with coordinates (8,9)?"
         << endl;

    cout << (kd.search({8, 9}) ? "~found" : "~not found") << endl;

    return 0;
}