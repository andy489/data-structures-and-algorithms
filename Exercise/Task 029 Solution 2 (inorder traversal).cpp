/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node struct is defined as follows:
	struct Node {
		int data;
		Node* left;
		Node* right;
	}
*/

void LDR(Node* root,vector<int>&arr){
    if(root){
        LDR(root->left,arr);
        arr.push_back(root->data);
        LDR(root->right,arr);
    }
}

bool checkBST(Node* root) {
    vector<int>arr;
    LDR(root,arr);
    int i,n((int)arr.size());
    for(i=0;i<n-1;++i){
        if(arr[i]>=arr[i+1]) return false;
    }
    return true;
}
