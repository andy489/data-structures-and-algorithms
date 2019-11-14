void levelOrder(Node* root) {
	if (root == nullptr)return;
	queue<Node*>Q;
	Q.push(root);
	while (!Q.empty())
	{
		Node* curr = Q.front();
		Q.pop();
		cout << curr->data << ' ';
		if (curr->left != nullptr)Q.push(curr->left);
		if (curr->right != nullptr)Q.push(curr->right);
	}
}
