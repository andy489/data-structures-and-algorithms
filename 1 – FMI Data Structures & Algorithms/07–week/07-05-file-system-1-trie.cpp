// https://www.hackerrank.com/contests/practice-7-sda/challenges/file-systems

#include <iostream>
#include <map>
#include <stack>
#include <utility>

using namespace std;

struct Node {
    string name;
    Node *parent;
    map<string, Node *> dirs;

    explicit Node(string name = "root2019", Node *parent = nullptr) : name(move(name)), parent(parent) {}
};

struct Trie {
    Node *root = new Node();
    Node *curr = root;

    Trie() = default;

    void mkdir(const string &DIR_NAME) const {
        if (curr->dirs.count(DIR_NAME) != 0) {
            cout << "Directory already exists" << endl;
        } else {
            curr->dirs[DIR_NAME] = new Node(DIR_NAME, curr);
        }
    }

    void ls() const {
        for (const auto &kvp : curr->dirs) {
            cout << kvp.first << ' ';
        }

        cout << endl;
    }

    void pwd() const {
        stack<string> S;
        Node *traverse = curr;

        while (traverse != root) {
            S.push(traverse->name);
            traverse = traverse->parent;
        }

        cout << '/';

        while (!S.empty()) {
            cout << S.top();
            cout << '/';
            S.pop();
        }

        cout << endl;
    }

    void cd(const string &DIR_NAME) {
        if (DIR_NAME == "..") {
            if (curr != root) {
                curr = curr->parent;
            } else {
                cout << "No such directory" << endl;
            }
        } else {
            if (curr->dirs.find(DIR_NAME) != curr->dirs.end()) {
                curr = curr->dirs[DIR_NAME];
            } else {
                cout << "No such directory" << endl;
            }
        }
    }
};

int main() {
    int n, i;
    cin >> n;

    string command, dir_name;
    Trie t;

    for (i = 0; i < n; ++i) {
        cin >> command;
        if (command == "mkdir") {
            cin >> dir_name;
            t.mkdir(dir_name);
        } else if (command == "cd") {
            cin >> dir_name;
            t.cd(dir_name);
        } else if (command == "ls") {
            t.ls();
        } else {
            t.pwd();
        }
    }

    return 0;
}