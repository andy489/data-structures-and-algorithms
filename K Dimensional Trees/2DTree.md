![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/KDtree%2001.png)

```cpp
#include <stdio.h>
#include <vector>
using namespace std;

struct Node
{
	vector<int> point;
	Node* left, * right;
	Node(vector<int>& p, Node* left = nullptr, Node* right = nullptr) :
		point(p), left(left), right(right) { }
};

class KDtree
{
	Node* root = nullptr;

	Node* insertNode2(Node* root, vector<int>& p, int level) {
		if (root == nullptr) {
			return new Node(p);
		}
		int coord = level % 2;
		if (p[coord] < root->point[coord]) {
			root->left = insertNode2(root->left, p, level + 1);
		}
		else {
			root->right = insertNode2(root->right, p, level + 1);
		}
		return root;
	}

	void squareDB(vector<int>& D, vector<int>& B, Node* root, int level) {
		if (root == nullptr) {
			return;
		}
		if (level % 2 == 0) {
			if (root->point[0] < D[0]) {
				squareDB(D, B, root->right, level + 1);
			}
			else if (root->point[0] > B[0]) {
				squareDB(D, B, root->left, level + 1);
			}
			else {
				if (root->point[1] <= D[1] && root->point[1] >= B[1]) {
					printf("%d %d\n", root->point[0], root->point[1]);
				}
				squareDB(D, B, root->left, level + 1);
				squareDB(D, B, root->right, level + 1);
			}
		}
		else {
			if (root->point[1] > D[1]) {
				squareDB(D, B, root->left, level + 1);
			}
			else if (root->point[1] < B[1]) {
				squareDB(D, B, root->right, level + 1);
			}
			else {
				if (root->point[0] >= D[0] && root->point[0] <= B[0]) {
					printf("%d %d\n", root->point[0], root->point[1]);
				}
				squareDB(D, B, root->left, level + 1);
				squareDB(D, B, root->right, level + 1);
			}
		}
	}

	bool arePointsSame(vector<int>& p1, vector<int>& p2)
	{
		int SIZE = (int)p1.size(), i;
		for (i = 0; i < SIZE; ++i)
			if (p1[i] != p2[i]) {
				return false;
			}
		return true;
	}

	bool searchRec(Node* root, vector<int> point, int level) {
		if (root == nullptr) {
			return false;
		}
		if (arePointsSame(root->point, point)) {
			return true;
		}
		int cd = level % 2; // Current dimension
		if (point[cd]<root->point[cd]){
			return searchRec(root->left, point, level + 1);
		}
		return searchRec(root->right, point, level + 1);
	}

	void printKD(Node* node) {
		if (node == nullptr) {
			return;
		}
		printKD(node->left);
		printf("%d %d\n", node->point[0], node->point[1]);
		printKD(node->right);
	}

public:

	void insert(vector<int> p) {
		root = insertNode2(root, p, 0);
	}
	void print() {
		printKD(root);
	}
	void inSquare(vector<int> D, vector<int> B) {
		squareDB(D, B, root, 0);
	}
	bool search(vector<int> point) {
		return searchRec(root, point, 0);
	}
};

int main()
{
	KDtree kd;
	kd.insert({ 3,4 });
	kd.insert({ 1,2 });
	kd.insert({ 4,1 });
	kd.insert({ -1,2 });
	kd.insert({ 10,8 });
	kd.insert({ -2,1 });
	kd.insert({ 9,9 });
	kd.insert({ 2,3 });
	kd.insert({ 8,8 });
	kd.insert({ 2,6 });
	kd.insert({ 1,7 });
	kd.insert({ -1,-1 });
	kd.insert({ 3,-2 });
	kd.insert({ 8,-3 });
	printf("%s","All points in KD tree, LDR printed:\n");
	kd.print();
	printf("%s","\nFind all points in square ABCD defined by:\nupper left point D(0,8) and lower right point B(3,5)\n");
	kd.inSquare({ 0,8 }, { 3,5 });
	printf("%s","\nIs there point with coordinates (8,9)?\n");
	kd.search({ 8,9 }) ? printf("%s","~found\n") : printf("%s", "~not found\n");
	return 0;
}
```
