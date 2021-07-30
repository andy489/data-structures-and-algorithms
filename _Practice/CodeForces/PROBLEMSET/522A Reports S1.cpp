// github.com/andy489

// https://codeforces.com/problemset/problem/522/A

#include <iostream>
#include <list>
#include <string>
#include <unordered_map>

using namespace std;

void toLower(char &ch) {
    if (ch >= 'A' && ch <= 'Z')
        ch = ch + 'a' - 'A';
}

void lower(string &str) {
    for (string::iterator it = str.begin(); it != str.end(); ++it) {
        toLower(*it);
    }
}

unordered_map<string, list<string>> adj;
int depth = 0;

void dfs(string nick, int d) {
    depth = (d > depth ? d : depth);
    for (auto kvp: adj[nick]) {
        dfs(kvp, d + 1);
    }
}

int main() {
    int n;
    cin >> n;
    cin.ignore();
    string line;
    while (n--) {
        std::getline(std::cin, line);
        string parent, child;
        int i = 0, len = line.length();
        for (; line[i] != ' ';)
            child.push_back(line[i++]);
        for (; line[++i] != ' ';) {}
        ++i;
        for (; i < len;)
            parent.push_back(line[i++]);
        lower(parent);
        lower(child);
        adj[parent].push_back(child);
    }
    dfs("polycarp", 0);
    return cout<< depth + 1, 0;
}
