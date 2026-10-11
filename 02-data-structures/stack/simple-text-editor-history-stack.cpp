// https://www.hackerrank.com/challenges/simple-text-editor/problem

#include <iostream>
#include <stack>

using namespace std;

stack<string> history;

int main() {
    int n;
    string elem, str;
    cin >> n;

    int query, k;
    while (n--) {
        cin >> query;
        if (query == 1) {
            // append string w to str
            cin >> elem;
            history.push(str);
            str = str.append(elem);
        } else if (query == 2) {
            // erase last k characters from str
            cin >> k;
            history.push(str);
            str = str.substr(0, str.size() - k);
        } else if (query == 3) {
            // returns the kth character
            cin >> k;
            cout << str[k - 1] << endl;
        } else if (query == 4) {
            // undo the last operation of type [1,2]
            str = history.top();
            history.pop();
        }
    }
    
    return 0;
}
