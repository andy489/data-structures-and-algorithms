// Auto Correct Trie
#include <iostream>
#include <map>
#include <string>
using namespace std;

struct Node
{
	bool end;
	map<char, Node*> children;
	Node(bool end = false) :end(end) {}
};

struct Trie
{
	Node* root = new Node();

	void insert(const string& word)
	{
		Node* curr = root;
		int len(word.length()), i;
		
		for (i = 0; i < len; ++i)
		{
			if (curr->children.count(word[i]) == 0)
			{
				curr->children[word[i]] = new Node();
			}
			curr = curr->children[word[i]];
		}
		curr->end = true;
	}

	void dfs(Node* curr, string& prefix)
	{
		if (curr->end)
		{
			cout << prefix << endl;
		}
		for (pair<char,Node*>kvp: curr->children)
		{
			prefix.push_back(kvp.first);
			dfs(kvp.second, prefix);
			prefix.pop_back();
		}
	}

	void displayWords(string& prefix)
	{
		Node* curr = root;
		int len(prefix.length()), i;

		for (i = 0;i < len;++i)
		{
			if (curr->children.count(prefix[i])==0)
			{
				return;
			}
			curr = curr->children[prefix[i]];
		}
		dfs(curr, prefix);
	}
};

int main()
{
	Trie autoComplete;

	autoComplete.insert("unicorn");
	autoComplete.insert("upgrade");
	autoComplete.insert("triathlon");
	autoComplete.insert("upload");
	autoComplete.insert("unicellular");
	autoComplete.insert("tricycle");
	autoComplete.insert("unicycle");
	autoComplete.insert("triangle");
	autoComplete.insert("upstage");

	string prefix = "up";
	autoComplete.displayWords(prefix);

	return 0;
}
