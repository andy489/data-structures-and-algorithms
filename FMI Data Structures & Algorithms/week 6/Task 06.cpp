#include <iostream>
#include <string>
using namespace std;

struct Node
{
    double val;
    Node* left, * right;
    int hei, bal;

    Node(double value, Node* left = nullptr, Node* right = nullptr, int hei = 0, int bal = 0) :
        val(value), left(left), right(right), hei(hei), bal(bal) { }

    void Add(double VAL) 
    {
        if (val > VAL) 
        {
            if (left) left->Add(VAL);            
            else left = new Node(VAL);            
        }
        else if (val < VAL) 
        {
            if (right) right->Add(VAL);            
            else right = new Node(VAL);            
        }
        else cout << VAL << " already added\n";        
        calcHei();
        calcBal();
        fix();
    }

    void Remove(double VAL) {
        if (VAL < val) 
        {
            if (left) 
            {
                if (left->val == VAL && !left->left && !left->right) 
                {
                    delete left;
                    left = nullptr;
                }
                else left->Remove(VAL);                
            }
            else cout << VAL << " not found to remove\n";            
        }
        else if (VAL > val) 
        {
            if (right) 
            {
                if (right->val == VAL && !right->left && !right->right) 
{
                    delete right;
                    right = nullptr;
                }
                else right->Remove(VAL);                
            }
            else cout << VAL << " not found to remove\n";            
        }
        else if (VAL == val) 
        {
            if (!left && right) 
            {
                val = right->val;
                left = right->left;
                right = right->right;
            }
            else if (!right && left) 
            {
                val = left->val;
                right = left->right;
                left = left->left;
            }
            else if (right && left) 
            {
                Node* iter = right;
                while (iter->left) 
                    iter = iter->left;                
                val = iter->val;
                if (right && !right->left && !right->right) 
                {
                    delete right;
                    right = nullptr;
                }
                else right->Remove(val);
            }
        }
        calcHei();
        calcBal();
        fix();
    }

    int Depth(int max)
    {
        int l = 0, r = 0;
        if (left) l = left->Depth(max + 1);
        if (right) r = right->Depth(max + 1);
        max = l > max ? l : max;
        max = r > max ? r : max;
        return max;
    }

    void print(int indent)
    {
        if (right)
            right->print(indent + 1);
        cout << val << endl;
        if (left)
            left->print(indent + 1);
    }

    void RotateRight()
    {
        if (!left)
            return;
        Node* LeftRight = left->right;
        Node* Right = right;

        swap(val, left->val);
        right = left;
        left = left->left;
        right->left = LeftRight;
        right->right = Right;
        if (left) left->calcBal();
        if (right)
        {
            right->calcHei();
            right->calcBal();
        }
        calcHei();
        calcBal();
    }

    void rotateLeft()
    {
        if (!right) return;
        Node* RightLeft = right->left;
        Node* Left = left;

        swap(val, right->val);
        left = right;
        right = right->right;
        left->right = RightLeft;
        left->left = Left;
        if (right) right->calcBal();
        if (left)
        {
            left->calcHei();
            left->calcBal();
        }
        calcHei();
        calcBal();
    }

    void fix() 
    {
        if (bal > 1)
        {   // Right is heavier
            if (right->bal >= 1)
            {   // RR rotations
                rotateLeft();
            }
            else if (right->bal <= 1)
            {   // RL rotations
                right->RotateRight();
                rotateLeft();
            }
        }
        else if (bal < -1)
        {   // Left is heavier
            if (left->bal <= 1)
            { // LL rotations
                RotateRight();
            }
            else if (left->bal >= 1)
            {   // LR rotations
                left->rotateLeft();
                RotateRight();
            }
        }
    }

    void calcHei()
    {
        hei = 0;
        if (left)
            hei = left->hei + 1 > hei ? left->hei + 1 : hei;
        if (right)
            hei = right->hei + 1 > hei ? right->hei + 1 : hei;
    }

    void calcBal()
    {
        if (left)
        {
            if (right)
                bal = right->hei - left->hei;
            else
                bal = 0 - left->hei - 1;
        }
        else if (right)
            bal = right->hei + 1;
        else bal = 0;
    }
};

struct AVLTree
{
    Node* root;

    bool count(Node* root, double value)
    {   // Recursive Search
        if (root == nullptr)return false;
        if (root->val == value)return true;
        if (value < root->val) return count(root->left, value);
        else return count(root->right, value);
    }

    void LDR(Node* current) 
    {    // Left-Data-Right DFS
        if (current == nullptr) return;
        LDR(current->left);
        cout << current->val << ' ';
        LDR(current->right);
    }

public:
    AVLTree()
    {
        root = nullptr;
    }

    void Print()
    {
        if (root)
            root->print(0);
    }

    int Depth()
    {
        if (root)
            return root->Depth(0);
        return 0;
    }

    void add(double value)
    {
        Node* it = root;
        if (root)
            root->Add(value);
        else root = new Node(value);

    }

    void remove(double Value)
    {
        if (root)
        {
            if (root->val == Value)
            {
                if (!root->left && !root->right)
                {
                    delete root;
                    root = nullptr;
                }
                else if (!root->left && root->right)
                {
                    root->val = root->right->val;
                    root->left = root->right->left;
                    root->right = root->right->right;
                }
                else if (!root->right && root->left)
                {
                    root->val = root->left->val;
                    root->right = root->left->right;
                    root->left = root->left->left;
                }
                else if (root->right && root->left)
                {
                    Node* iter = root->right;
                    while (iter->left)
                        iter = iter->left;
                    root->val = iter->val;

                    if (root->right && !root->right->left && !root->right->right)
                    {
                        delete root->right;
                        root->right = nullptr;
                    }
                    else root->right->Remove(root->val);
                }
            }
            else root->Remove(Value);
        }
        else cout << Value << " not found to remove\n";
    }

    bool contains(double val)
    {
        if (!root) return false;
        return count(root, val);
    }

    void print()
    {
        if (!root) return;
        LDR(root);
        cout << '\n';
    }
};

int main()
{
    AVLTree tree;
    string operation;
    double num;
    int N, i;

    cin >> N;
    cout.setf(ios::fixed);
    cout.precision(6);

    for (i = 0; i < N; ++i) {
        cin >> operation;
        if (operation != "print")
            cin >> num;
        if (operation == "add")
            tree.add(num);
        else if (operation == "remove")
            tree.remove(num);
        else if (operation == "contains")
        {
            if (tree.contains(num))
                cout << "yes" << '\n';
            else
                cout << "no" << '\n';
        }
        else if (operation == "print")
            tree.print();
    }

    return 0;
}
