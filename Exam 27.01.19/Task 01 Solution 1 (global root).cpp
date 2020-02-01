#include <bits/stdc++.h>
using namespace std;

struct Node{
    Node *left=nullptr,*right=nullptr;
    int data;
    Node(int data):data(data){}
};

Node* root; //it will be set to default value nullptr, because it's global variable

Node* add(Node* root,int data){
    if(root==nullptr){
        return new Node(data);
    }
    else if(data>root->data){
        root->right=add(root->right,data);
    }
    else if(data<root->data){
        root->left=add(root->left,data);
    }
    return root;
}

void print(Node* root){
    if(root!=nullptr){
        cout<<root->data<<' ';
        print(root->left);        
        print(root->right);
    }
}

int main() {
    int q,data;
    cin>>q;
    string command;
    while(q--){
        cin>>command;
        if(command=="add"){
            cin>>data;
            root=add(root,data);
        }
        else if(command=="print"){
            print(root);
        }
    }
    return 0;
}
