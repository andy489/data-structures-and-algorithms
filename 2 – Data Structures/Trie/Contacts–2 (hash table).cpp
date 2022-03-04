// https://www.hackerrank.com/challenges/contacts/problem

#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    unordered_map<string, int> prefixes;
    string name, operation;

    int q;
    cin >> q;

    while (q--) {
        cin >> operation >> name;

        if (operation == "add") {
            string prefix("");

            for (const char &c : name) {
                prefix += c;
                prefixes[prefix]++;
            }
        } else {
            cout << prefixes[name] << endl;
        }
    }

    return 0;
}