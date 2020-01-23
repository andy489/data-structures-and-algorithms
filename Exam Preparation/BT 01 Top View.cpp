//https://www.hackerrank.com/challenges/tree-top-view/problem
#include<bits/stdc++.h>

using namespace std;

class Node {
    public:
        int data;
        Node *left;
        Node *right;
        Node(int d) {
            data = d;
            left = NULL;
            right = NULL;
        }
};

class Solution {
    public:
  		Node* insert(Node* root, int data) {
            if(root == NULL) {
                return new Node(data);
            } else {
                Node* cur;
                if(data <= root->data) {
                    cur = insert(root->left, data);
                    root->left = cur;
                } else {
                    cur = insert(root->right, data);
                    root->right = cur;
                }

               return root;
           }
        }

/*
class Node {
    public:
        int data;
        Node *left;
        Node *right;
        Node(int d) {
            data = d;
            left = NULL;
            right = NULL;
        }
};

*/
    void topView(Node * root) 
    {
        if(root==nullptr) return;
        queue<pair<int,Node*>>q;
        int hd(0);
        q.push({hd,root});
      
        map<int,int>m;
        while(!q.empty())
        {   
            auto cur=q.front();
            q.pop();
            hd=cur.first;
            if(cur.second->left) q.push({hd-1,cur.second->left});
            if(cur.second->right) q.push({hd+1,cur.second->right});
            if(!m.count(hd))m[hd]=cur.second->data;
        }
        for(const auto& kvp:m) cout<<kvp.second<<' ';
    }

}; //End of Solution

int main() {
    
    Solution myTree;
    Node* root = NULL;
    
    int t;
    int data;

    std::cin >> t;

    while(t-- > 0) {
        std::cin >> data;
        root = myTree.insert(root, data);
    }
  
    myTree.topView(root);

    return 0;
}
