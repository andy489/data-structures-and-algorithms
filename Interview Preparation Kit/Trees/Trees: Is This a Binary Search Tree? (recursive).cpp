// github.com/andy489

/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node struct is defined as follows:
	struct Node {
		int data;
		Node* left;
		Node* right;
	}
*/

bool checkBSTUtil(Node* root,Node* l=nullptr,Node* r=nullptr){
    if(!root)return true;
    if(l!=nullptr&&root->data<=l->data){
        return false;
    }
    if(r!=nullptr&&root->data>=r->data){
        return false;
    }
    return checkBSTUtil(root->left,l,root)&&checkBSTUtil(root->right,root,r);
}    

bool checkBST(Node* root) {	
    return checkBSTUtil(root);    
}
