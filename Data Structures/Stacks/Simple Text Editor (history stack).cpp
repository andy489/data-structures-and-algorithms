// github.com/andy489

#include<bits/stdc++.h>
using namespace std;
stack <int> s;
stack <string> history;

int main(){
    int n, query, k;
    string elem, S;
    cin >> n;

    while(n--){
        cin >> query;
        if (query == 1){
            // append string w to S
            cin >> elem;
            history.push(S);
            S = S.append(elem);
        }

        else if (query == 2){
            // erase last k characters from S
            cin >> k;
            history.push(S);
            S = S.substr(0,S.size() - k);
        }

        else if (query == 3){
            // returns the kth character
            cin >> k;
            cout << S[k - 1] << endl;
        }

        else if (query == 4){
            // undo the last operation of type [1,2]
            S = history.top();
            history.pop();
        }
    }
    return 0;
}
