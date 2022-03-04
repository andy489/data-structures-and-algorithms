// https://www.hackerrank.com/challenges/simple-text-editor/problem

#include <iostream>
#include <stack>

using namespace std;

int main() {
    stack<int> S;
    stack<char> R;

    string str, txt;

    int q, type, k;
    cin >> q;
    while (q--) {
        cin >> type;
        switch (type) {
            case 1:
                cin >> txt;
                str.append(txt);
                S.push(txt.length());
                S.push(1);
                break;
            case 2:
                int i;
                cin >> k;
                for (i = 0; i < k; ++i) {
                    R.push(str.back());
                    str.pop_back();
                }
                S.push(k);
                S.push(2);
                break;
            case 3:
                cin >> k;
                cout << str[k - 1] << endl;
                break;
            case 4:
                type = S.top();
                S.pop();

                if (type == 1) {
                    int length = S.top();
                    S.pop();
                    for (i = 0; i < length; ++i) {
                        str.pop_back();
                    }
                } else {
                    int size = S.top();
                    S.pop();

                    for (i = 0; i < size; ++i) {
                        str.push_back(R.top());
                        R.pop();
                    }
                }
                break;
            default:
                cout << "invalid cmd" << endl;
        }
    }
    return 0;
}
