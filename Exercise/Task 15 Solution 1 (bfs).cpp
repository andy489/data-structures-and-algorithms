#include <iostream>
#include <vector>
#include <queue>
#include <sstream>
using namespace std;

struct Node{
    Node* left, * right;
    int data;
    Node(int data, Node* left = nullptr, Node* right = nullptr) :
        data(data), left(left), right(right) {}
};

vector<Node*>nodes;
Node* root;
ostringstream ostr;

void inorder(Node* root){
    if (root){
        inorder(root->left);
        ostr << root->data<<' ';
        inorder(root->right);
    }
}

void bfs(Node* root,int k){
    queue<Node*>q;
    q.push(root);
    int r(1);
    while (!q.empty()){
        int s = (int)q.size();
        while (s--){
            Node* cur = q.front();
            q.pop();
            if (r % k == 0)swap(cur->left, cur->right);            
            if (cur->left)q.push(cur->left);
            if(cur->right)q.push(cur->right);            
        }
        ++r;
    }
}

int main(){
    int n, i, l, r;
    cin >> n;

    nodes.resize(n + 1);

    for (i = 1;i <= n;++i){
        nodes[i] = new Node(i);
    }    

    for (i = 1;i <= n;++i){        
        cin >> l >> r;
        if(l!=-1)nodes[i]->left = nodes[l];
        if(r!=-1)nodes[i]->right = nodes[r];
    }
    
    root = nodes[1];

    int q,k;
    cin >> q;

    while (q--){
        cin >> k;
        bfs(root, k);
        inorder(root);
        ostr << '\n';
    }
    cout << ostr.str();
    return 0;
}
