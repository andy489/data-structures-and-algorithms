#include <iostream>
#include <unordered_map>
using namespace std;

struct Node {    
    int counter;
    unordered_map<char, Node*> children;
    Node() :counter(0) {}
};

struct Trie { Node* root = new Node();
    void insert(const string& word) {
        Node* curr = root;
        curr->counter++;
        int len((int)word.size()), i;

        for (i = 0; i < len; ++i) {
            if (curr->children.count(word[i]) == 0)            
                curr->children[word[i]] = new Node;            
            curr = curr->children[word[i]];
            curr->counter++;
        }        
    }  

    size_t countWords(string& prefix) {
        Node* curr = root;
        int len(prefix.length()), i;

        for (i = 0;i < len;++i) {
            if (curr->children.count(prefix[i]) == 0) return 0;            
            curr = curr->children[prefix[i]];
        }        
        return curr->counter;
    }
};

int main() {  
    cin.tie(nullptr);
    cin.sync_with_stdio(false);
    Trie autoComplete;

    int N, Q, i; cin >> N >> Q;
    string word, prefix;    

    for (i = 0; i < N; ++i) { cin >> word;
        autoComplete.insert(word);
    }
    while (Q--) { cin >> prefix;
        cout << autoComplete.countWords(prefix) << '\n';
    } return 0;
}
