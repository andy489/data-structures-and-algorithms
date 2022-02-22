// https://www.hackerrank.com/challenges/30-dictionaries-and-maps/problem

#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
    int q;
    cin >> q;

    unordered_map<string, string> phone_book;

    string name, phone;

    while (q--) {
        cin >> name >> phone;
        phone_book[name] = phone;
    }
    
    while (cin >> name) {
        if (phone_book.count(name)) {
            cout << name << '=' << phone_book[name];
        } else {
            cout << "Not found";
        }
        cout << endl;
    }
    
    return 0;
}
