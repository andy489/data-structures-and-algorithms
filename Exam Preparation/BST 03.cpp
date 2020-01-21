//https://www.hackerrank.com/contests/sda-2019-2020-test3/challenges/print-specific-level/
#include <bits/stdc++.h>
using namespace std;

struct Node
{
  Node *l=nullptr,*r=nullptr;
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

void print_lvl(Node* root, int s_lvl, int& lvl)
{
    if(root)
    {
        if(s_lvl==lvl) cout<<root->data<<' ';
        print_lvl(root->r,s_lvl+1,lvl);
        print_lvl(root->l,s_lvl+1,lvl);
    }    
}

void print_lvl(Node* root, int& lvl)
{
    if(root==nullptr) return;
    queue<Node*>q;
    q.push(root);
    int r=0;
    while(!q.empty())
    {
        int s=(int)q.size();
        while(s--)
        {   
            Node* curr=q.front();
            q.pop();
            if(curr->r)q.push(curr->r);
            if(curr->l)q.push(curr->l);            
            if(r==lvl) cout<<curr->data<<' ';
        }
        ++r;
        if(r>lvl)return;
    }    
}

int main()
{
    int n,a,l,ra;
    cin>>n;
    while(n--)
    {   
        cin>>a;
        root=add(root,a);
    }
    cin>>l;
    srand(size_t(time(0)));    
    ra=rand()%2;
    if(ra)
    {
        print_lvl(root,0,l);
    }
    else
    {
        print_lvl(root,l);
    }
    return 0;
}
