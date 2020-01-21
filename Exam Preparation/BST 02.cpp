//https://www.hackerrank.com/contests/sda-2019-2020-test3/challenges/tree-specific-print/
#include <bits/stdc++.h>
using namespace std;

struct Node
{
    Node* l=nullptr,*r=nullptr;
    int data;
    Node(int data):data(data){}
};

Node* root;

Node* add(Node* root, int a)
{
    if(root==nullptr) return new Node(a);
    else if(a>root->data) root->r=add(root->r,a);
    else if(a<root->data) root->l=add(root->l,a);
    return root;
}

void spec_print(Node* root,int& d)
{
    if(root)
    {   
        if(root->data%d==0&&(root->l||root->r))
        cout<<root->data<<' ';
        spec_print(root->l,d);
        spec_print(root->r,d);
    }   
}

int main()
{
    int n,a,d;
    cin>>n;
    while(n--)
    {
        cin>>a;
        root=add(root,a);
    }
    cin>>d;
    spec_print(root,d);
    return 0;
}
