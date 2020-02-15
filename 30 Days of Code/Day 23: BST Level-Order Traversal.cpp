
void levelOrder(Node* root)
{
    if (root==nullptr) return;
    queue<Node*>q;
    q.push(root);
    
    while(!q.empty())
    {
        int s=(int)q.size();
        while(s--)
        {
            Node* curr=q.front();
            q.pop();
            if(curr->left) q.push(curr->left);
            if(curr->right) q.push(curr->right);
            cout<<curr->data<<' ';            
        }
    }
}
