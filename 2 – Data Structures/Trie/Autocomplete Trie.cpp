// AutoComplete Trie

#include <iostream>
#include <map>

using namespace std;

struct Node {
    bool end;
    map<char, Node *> children;

    explicit Node(bool end = false) : end(end) {}
};

struct Trie {
    Node *root = new Node();

    void insert(const string &word) const {
        Node *curr = root;
        const int LEN = word.length();

        for (int i = 0; i < LEN; ++i) {
            if (!curr->children.count(word[i])) {
                curr->children[word[i]] = new Node();
            }

            curr = curr->children[word[i]];
        }

        curr->end = true;
    }

    void dfs(Node *curr, string &prefix) {
        if (curr->end) {
            cout << prefix << endl;
        }

        for (const auto& kvp : curr->children) {
            prefix.push_back(kvp.first);
            dfs(kvp.second, prefix);
            prefix.pop_back();
        }
    }

    void search(string &prefix) {
        Node *curr = root;
        int len(prefix.length()), i;

        for (i = 0; i < len; ++i) {
            if (!curr->children.count(prefix[i])) {
                return;
            }

            curr = curr->children[prefix[i]];
        }

        dfs(curr, prefix);
    }
};

int main() {
    Trie auto_complete;

    string prefix;

    auto_complete.insert("unicorn velociraptor");
    auto_complete.insert("rewrite");
    auto_complete.insert("unpack");
    auto_complete.insert("reconsider");
    auto_complete.insert("upgrade");
    auto_complete.insert("undo");
    auto_complete.insert("underestimate");
    auto_complete.insert("uphill");
    auto_complete.insert("redo");

    cout << "Enter number of prefixes to autocomplete: ";
    int n;
    cin >> n;

    for (int i = 0; i < n; ++i) {
        cin >> prefix;
        auto_complete.search(prefix);
    }

    return 0;
}
