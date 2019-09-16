#pragma once

#include <functional>
#include <stack>

template <typename ElementType, typename Compare = std::less<ElementType>>
class BinarySearchTree
{
private:
	struct BstNode
	{
		ElementType data;
		BstNode* left;
		BstNode* right;

		BstNode(const ElementType& value) : data(value), left(nullptr), right(nullptr) { }
	};
public:
	class Iterator
	{
		std::stack<BstNode*> walk;
		BstNode* root;

	public:
		Iterator(BstNode* root) : root(root)
		{
			if (root) pushAndExpand(root);
		}

		ElementType& Current()
		{
			if (EndReached()) throw std::exception();

			return walk.top()->data;
		}

		void Rewind()
		{
			walk = std::stack<BstNode*>();

			if (root) pushAndExpand(root);
		}

		void MoveNext()
		{
			if (walk.empty()) return;

			BstNode* p = walk.top();
			walk.pop();

			if (p->right) pushAndExpand(p->right);
		}

		bool EndReached() const
		{
			return walk.empty();
		}

	private:

		void pushAndExpand(BstNode* p)
		{
			walk.push(p);

			while (p->left)
			{
				walk.push(p->left);
				p = p->left;
			}
		}

	};

private:
	BstNode* rootNode;
	size_t size;
	Compare comesBefore;

public:
	BinarySearchTree() : rootNode(nullptr), size(0) { }

	~BinarySearchTree()
	{
		Clear();
	}

	BinarySearchTree(const BinarySearchTree & other) : rootNode(nullptr), size(0)
	{
		CopyFrom(other);
	}

	BinarySearchTree& operator=(const BinarySearchTree & other)
	{
		if (this != &other)
		{
			Clear();
			CopyFrom(other);
		}

		return *this;
	}

	void Insert(const ElementType& item)
	{
		BstNode** current = &rootNode;

		while (*current)
		{
			if ((*current)->data > item) current = &(*current)->left;
			else current = &(*current)->right;
		}

		// Here current should point to a pointer, whose value is nullptr
		*current = new BstNode(item);
		++size;
	}

	void Remove(const ElementType& item)
	{
		BstNode **pp = findPointerToNode(item);

		if (!pp)
			return; // The tree does not contain the item

		BstNode *temp = *pp; // remember where the box is

		if ((*pp)->left && (*pp)->right)
		{ // two successors
			BstNode** pmin = findPointerToMinNode(&(*pp)->right);
			*pp = *pmin;
			*pmin = (*pmin)->right;
			(*pp)->left = temp->left;
			(*pp)->right = temp->right;
		}
		else
		{ // 1 or zero successors
			*pp = (*pp)->left ? (*pp)->left : (*pp)->right;
		}

		delete temp; // free the box
		--size;
	}

	bool Contains(const ElementType& item) const
	{
		const BstNode* p = rootNode;

		while (p)
		{
			if (p->data == item)
				return true;

			p = (item < p->data) ? p->left : p->right;
		}

		return false;
	}

	void Clear()
	{
		if (Empty()) return;

		/*
		NodeIterator ni = getNodeIterator();

		do
		{
			Node* p = ni.Current();
			ni.MoveNext();
			delete p;

		} while (!ni.EndReached());
		*/

		std::stack<BstNode*> walk;
		walk.push(rootNode);

		BstNode* p = nullptr;

		while (!walk.empty())
		{
			p = walk.top();
			walk.pop();

			if (p->left) walk.push(p->left);
			if (p->right) walk.push(p->right);

			delete p;
		}
		size = 0;
		rootNode = nullptr;
	}

	size_t Size() const
	{
		return size;
	}

	bool Empty() const
	{
		return size == 0;
	}

	Iterator GetIterator()
	{
		return Iterator(rootNode);
	}


private:
	void CopyFrom(const BinarySearchTree & other)
	{

	}

	BstNode** findPointerToNode(const ElementType& item)
	{
		BstNode** pp = &rootNode;

		while (*pp)
		{
			if ((*pp)->data == item) return pp;

			pp = (item < (*pp)->data) ? &(*pp)->left : &(*pp)->right;
		}

		return nullptr;
	}

	BstNode** findPointerToMinNode(BstNode** root)
	{
		if (!root) throw std::exception();

		BstNode** pp = root;

		while ((*pp)->left) pp = &(*pp)->left;

		return pp;
	}
};


