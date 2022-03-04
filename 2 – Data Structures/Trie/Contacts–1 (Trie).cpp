// https://www.hackerrank.com/challenges/contacts/problem

#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

struct Node {
    int count;
    unordered_map<char, Node *> symbols;

    explicit Node(int count) : count(count) {}
};

struct Trie {
    Node *root;

    Trie() {
        root = new Node(0);
    }

    void add(string name) const {
        Node *traverse = root;

        for (const char &c:name) {
            if (traverse->symbols.count(c)) {
                traverse->symbols[c]->count++;
            } else {
                traverse->symbols[c] = new Node(1);
            }

            traverse = traverse->symbols[c];
        }
    }

    [[nodiscard]] int find(const string& name) const {
        int cnt = 0;
        Node *traverse = root;
        
        for (const char &c:name) {
            if (traverse->symbols.count(c)) {
                traverse = traverse->symbols[c];
            } else {
                return cnt;
            }
        }
        
        cnt = traverse->count;
        return cnt;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    Trie t;
    string operation, name;

    int q;
    cin >> q;

    while (q--) {
        cin >> operation >> name;
        
        if (operation == "add") {
            t.add(name);
        } else {
            cout << t.find(name) << endl;
        }
    }
    
    return 0;
}
