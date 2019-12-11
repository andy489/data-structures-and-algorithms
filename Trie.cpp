// AutoComplete Trie
#include <iostream>
#include <vector>
#include <map>
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
			cout << prefix << '\n';
		}
		for (pair<char, Node*>kvp : curr->children)
		{
			prefix.push_back(kvp.first);
			dfs(kvp.second, prefix);
			prefix.pop_back();
		}
	}

	void search(string& prefix)
	{
		Node* curr = root;
		int len(prefix.length()), i;

		for (i = 0;i < len;++i)
		{
			if (curr->children.count(prefix[i]) == 0)
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

	string prefix;

	autoComplete.insert("unicorn celociraptor");
	autoComplete.insert("rewrite");
	autoComplete.insert("unpack");
	autoComplete.insert("reconsider");
	autoComplete.insert("upgrade");
	autoComplete.insert("undo");
	autoComplete.insert("underestimate");
	autoComplete.insert("uphill");
	autoComplete.insert("redo");

	for (size_t i = 0; i < 3; i++)
	{
		cin >> prefix;
		autoComplete.search(prefix);
	}

	return 0;
}
