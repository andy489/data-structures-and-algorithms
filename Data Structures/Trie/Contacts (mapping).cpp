// github.com/andy489

#include <iostream>
#include <unordered_map>
using namespace std;

int main(){
    unordered_map<string, int>prefixes;
    string name, oper;
    cin.tie(nullptr);
    int q;
    cin >> q;
    while (q--){
        cin >> oper >> name;
        if (oper == "add"){
            string prefix("");
            for (const char& c : name){
                prefix+=c;
                prefixes[prefix]++;
            }
        }
        else{
            cout << prefixes[name] << '\n';
        }
    }       
    return 0;
}
