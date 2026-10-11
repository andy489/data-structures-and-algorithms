// Binary Search Tree (BST)

#include <iostream>
#include <string>

using namespace std;

struct BST_Node {
    BST_Node *left;
    BST_Node *right;

    int data;
};

BST_Node *get_new_node(int data) {
    auto *new_node = new BST_Node();
    new_node->data = data;
    new_node->left = new_node->right = nullptr;

    return new_node;
}

BST_Node *insert(BST_Node *root, int data) {
    if (root == nullptr) {
        root = get_new_node(data);
    } else if (data <= root->data) {
        root->left = insert(root->left, data);
    } else {
        root->right = insert(root->right, data);
    }

    return root;
}

bool search(BST_Node *root, int data) {
    if (root == nullptr) {
        return false;
    } else if (root->data == data) {
        return true;
    } else if (data <= root->data) {
        return search(root->left, data);
    } else {
        return search(root->right, data);
    }
}

BST_Node *min_val_address_node(BST_Node *root) {
    if (root == nullptr || root->left == nullptr) {
        return root;
    }

    return min_val_address_node(root->left);
}

BST_Node *min_val_add_node(BST_Node *root) {
    if (root == nullptr) {
        return root;
    }

    while (root->left != nullptr) {
        root = root->left;
    }

    return root;
}

BST_Node *max_val_address_node(BST_Node *root) {
    if (root == nullptr || root->right == nullptr) {
        return root;
    }

    return max_val_address_node(root->right);
}

BST_Node *remove(BST_Node *root, int data) {
    if (root == nullptr) {
        return root;
    } else if (data < root->data) {
        root->left = remove(root->left, data);
    } else if (data > root->data) {
        root->right = remove(root->right, data);
    } else { // we found it, now we must delete it
        if (root->left == nullptr && root->right == nullptr) { // case 1: no child
            delete root;
            root = nullptr;
        } else if (root->left == nullptr) { //one child
            // case 2.1: right child
            BST_Node *temp = root;
            root = root->right;
            delete temp;
        } else if (root->right == nullptr) { // case 2.2: left child
            BST_Node *temp = root;
            root = root->left;
            delete temp;
        } else { // case 3: two children
            BST_Node *temp = min_val_address_node(root->right); // find_max(root->left)
            root->data = temp->data;
            root->right = remove(root->right, temp->data);
        }
    }

    return root;
}

int find_height_of_bin_tree(BST_Node *root) { // works for BT also. Time complexity O(n)
    // we are counting edges (right definition)
    if (root == nullptr) {
        return -1;
    }
    //return max(findHeightOfBinaryTree(root->left), find_height_of_bin_tree(root->right));
    int leftHeight = find_height_of_bin_tree(root->left);
    int rightHeight = find_height_of_bin_tree(root->right);

    return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
}

bool is_bst_util(BST_Node *root, int minValue, int maxValue) {
    if (root == nullptr) {
        return true;
    }

    if (root->data > minValue && root->data < maxValue
        && is_bst_util(root->left, minValue, root->data)
        && is_bst_util(root->right, root->data, maxValue)) {
        return true;
    } else {
        return false;
    }
}

bool is_bin_search_tree(BST_Node *root) {
    return is_bst_util(root, -1e9, 1e9);
}

void print(BST_Node *root, int left_lim, int right_lim) {
    if (root == nullptr) { // base case
        return;
    }
    //If value of root's key is greater than left_lim, then recursively call in left subtree
    if (left_lim < root->data) {
        print(root->left, left_lim, right_lim);
    }
    //If value of root's key is smaller than right_lim, then recursively call in right subtree
    if (right_lim > root->data) {
        print(root->right, left_lim, right_lim);
    }
    // If value of root's key is in range, then print the root's key
    if (left_lim <= root->data && right_lim >= root->data) {
        cout << root->data << " ";
    }
}

void help() {
    std::cout << "Functionality in BST" << endl;
    std::cout << "A - Insert node with key" << endl;
    std::cout << "S - Search for node with key" << endl;
    std::cout << "M - Finds node with max/min data" << endl;
    std::cout << "F - Finds Height of BT" << endl;
    std::cout << "? - Checks whether a tree is BST" << endl;
    std::cout << "P - Print in Range as Array" << endl;
    std::cout << "X - Delete node with key" << endl;
    std::cout << "H - Help (Menu)" << endl;
    std::cout << "Q - Quit" << endl;
}

void test() {
    BST_Node *root = nullptr; // to store address of root node
    // this is pointer to root and not the root itself
    // initially setting the root to NULL for an empty  tree

    help();

    while (true) {
        string command;
        cout << "Enter command: ";
        cin >> command;

        command = tolower(command[0]);

        if (command == "q") {
            break;
        }

        switch (command[0]) {
            case 'a': {
                int data;
                cout << "Enter data (int) of node to be added to BST: ";
                cin >> data;
                root = insert(root, data);
                break;
            }
            case 's': {
                int data;
                cout << "Enter a key of node to be searched: ";
                cin >> data;
                cout << (search(root, data) ? "~found" : "~not found") << endl;
                break;
            }
            case 'x': {
                int data;
                cout << "Enter key of node to be deleted: ";
                cin >> data;
                remove(root, data);
                break;
            }
            case 'f': {
                cout << "Height of BT is: ";
                cout << find_height_of_bin_tree(root) << endl;
                break;
            }
            case 'm': {
                BST_Node *min_max;
                cout << "What node do you want to seek min or max [min/max]? ";
                string info;
                cin >> info;

                if (info == "min") {
                    min_max = min_val_add_node(root);

                    if (min_max == nullptr) {
                        cout << "~Tree is empty" << endl;
                        break;
                    }
                    cout << "Node with minimum data is " << min_max->data << endl;
                    break;
                } else if (info == "max") {
                    min_max = max_val_address_node(root);

                    if (min_max == nullptr) {
                        cout << "~Tree is empty" << endl;
                        break;
                    }

                    min_max = max_val_address_node(root);
                    cout << "Node with maximum data is " << min_max->data << endl;
                    break;
                } else {
                    cout << "~wrong input" << endl;
                }

                break;
            }
            case 'p': {
                int left, right;
                cout << "Left boundary: ";
                wcin >> left;
                cout << "Right boundary: ";
                wcin >> right;
                print(root, left, right);
                cout << endl;
                break;
            }
            case '?': {
                cout << (is_bin_search_tree(root) ? "~Tree is BST" : "~Tree is not BST") << endl;
                break;
            }
            case 'h': {
                help();
                break;
            }
            case ' ':
            case '\n':
                break;
            default:
                cout << "invalid command" << endl;
        }
    }
}

int main() {
    test();
    return 0;
}
