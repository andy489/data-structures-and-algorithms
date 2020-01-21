//https://www.hackerrank.com/contests/sda-exam-27-01-19-/challenges/challenge-1796/

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

void DLR(Node* root)
{
    if(root)
    {
        cout<<root->data<<' ';
        DLR(root->l);
        DLR(root->r);
    }
}

void LDR(Node* root) 
{   //sorted
    if(root)
    {
        LDR(root->l);
        cout<<root->data<<' ';
        LDR(root->r);
    }
}

Node* minDataNode(Node* root)
{
    if(root==nullptr||root->l==nullptr) return root;
    return minDataNode(root->l);
}

Node* del(Node* root, int a)
{
    if(root==nullptr) return nullptr;
    else if(a>root->data) root->r=del(root->r,a);
    else if(a<root->data) root->l=del(root->l,a);
    else
    {
        if(root->l&&root->r)
        {
            Node* tmp=minDataNode(root->r);
            root->data=tmp->data;
            root->r=del(root->r,tmp->data);
        }
        else if(root->l)
        {
            Node* tmp=root;
            root=root->l;
            delete tmp;
        }
        else if(root->r)
        {
            Node* tmp=root;
            root=root->r;
            delete tmp;
        }
        else
        {
            delete root;
            root=nullptr;
        }        
    }
    return root;    
}

void print_odd_lvl(Node* root)
{
    if(root==nullptr) return;
    queue<Node*>q;
    q.push(root);
    int r=1;
    while(!q.empty())
    {
        int s=(int)q.size();
        while(s--)
        {
            Node* curr=q.front();
            q.pop();
            if(curr->l) q.push(curr->l);
            if(curr->r) q.push(curr->r);
            if(r&1) cout<<curr->data<<' ';
        }
        ++r;
    }    
}

int main()
{
    int q,a;
    string cmd;
    cin>>q;
    while(q--)
    {
        cin>>cmd;
        if(cmd=="add")
        {
            cin>>a;
            root=add(root,a);
        }
        else if(cmd=="print")
        {
            DLR(root);
        }
        else if(cmd=="remove")
        {
            cin>>a;
            root=del(root,a);
        }
        else if(cmd=="print_odd_layers")
        {
           print_odd_lvl(root);
        }
    }
    return 0;
}
