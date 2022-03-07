// https://codeforces.com/problemset/problem/522/A

#include <iostream>
#include <algorithm>
#include <list>
#include <unordered_map>
#include <sstream>

using namespace std;

char ascii_to_lower(char in) {
    if (in <= 'Z' && in >= 'A') {
        return (char) (in - ('Z' - 'z'));
    }

    return in;
}

unordered_map<string, list<string>> adj;

int depth = 0;

void dfs(const string &nick, int d) {
    depth = (d > depth ? d : depth);

    for (const auto &kvp: adj[nick]) {
        dfs(kvp, d + 1);
    }
}

int main() {
    int n;
    cin >> n;

    string line;
    getline(cin, line);
    while (n--) {
        getline(cin, line);

        istringstream iss(line);

        string parent, trash, child;

        iss >> child;
        iss >> trash;
        iss >> parent;

        transform(parent.begin(), parent.end(), parent.begin(), ascii_to_lower);
        transform(child.begin(), child.end(), child.begin(), ascii_to_lower);

        adj[parent].push_back(child);
    }

    dfs("polycarp", 0);

    cout << depth + 1;

    return 0;
}
