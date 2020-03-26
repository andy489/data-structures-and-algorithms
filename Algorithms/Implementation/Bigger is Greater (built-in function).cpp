// github.com/andy489

// Second Solution (built-in function)
#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int main() {
    int t;
    cin>>t;
    string w;
    while(t--) {
        cin >> w;
        if (next_permutation(w.begin(), w.end()))
            cout << w << '\n';
        else
            cout << "no answer\n";
    }
}
