// https://www.hackerrank.com/challenges/30-regex-patterns/problem

#include <iostream>
#include <regex>
#include <set>

using namespace std;

int main() {
    int n;
    cin >> n;
    
    regex e(".+@gmail.com$");
    
    multiset<string> db;
    while (n--) {
        string first_name, email;
        cin >> first_name >> email;
        if (regex_match(email, e)) {
            db.insert(first_name);
        }
    }

    for (const auto &it:db) {
        cout << it << '\n';
    }

    return 0;
}
