// github.com/andy489

#include <iostream>
using namespace std;

int main() {
    int t,i;
    cin >> t;
    while(t--){
        string s1,s2;
        cin>>s1>>s2;
        string chars = "abcdefghijlkmnopqrstuvwxyz";
        string output = "NO";
        for (i=0;i<26;++i){
            if (s1.find(chars[i])!=string::npos && s2.find(chars[i])!=string::npos){
                output = "YES";
                break;
            }
        }
        cout << output << endl;
    }
    return 0;
}
