/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  
 
The Node struct is defined as follows:
    struct Node {
        int data;
        Node* left;
        Node* right;
    }
*/
    bool isBST(Node* root, Node* min = nullptr, Node* max = nullptr) {
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
 
    bool checkBST(Node* root) {
        return isBST(root);
    }
