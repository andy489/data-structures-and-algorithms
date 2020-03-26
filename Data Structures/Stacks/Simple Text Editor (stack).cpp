// github.com/andy489

#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main(){
    stack<int>S;
    stack<char>R;

    string s, txt;

    int q, type, k;
    cin >> q;
    while (q--){
        cin >> type;
        switch (type){
        case 1:
            cin >> txt;
            s.append(txt);
            S.push(txt.length());
            S.push(1);
            break;
        case 2:
            int i;
            cin >> k;
            for (i = 0;i < k;++i){
                R.push(s.back());
                s.pop_back();
            }
            S.push(k);
            S.push(2);
            break;
        case 3:
            cin >> k;
            cout << s[k-1] << '\n';
            break;
        case 4:
            type = S.top();
            S.pop();
            if (type == 1){
                int length = S.top();
                S.pop();
                for (i = 0;i < length;++i){
                    s.pop_back();
                }
            }
            else{
                int size = S.top();
                S.pop();
                for (i = 0;i < size;++i){
                    s.push_back(R.top());
                    R.pop();
                }
            }
            break;
        }
    }
    return 0;
}
