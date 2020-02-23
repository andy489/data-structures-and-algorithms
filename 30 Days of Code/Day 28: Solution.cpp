#include <iostream>
#include <regex>
#include <set>
using namespace std;

int main(){
    int n;
    cin >> n;
    regex e(".+@gmail.com$");
    multiset<string>db;
    while(n--){
        string firstName, email;
        cin>>firstName>>email;
        if(regex_match(email,e)){
            db.insert(firstName);
        }
    }
    for(const auto&it:db){
        cout<<it<<'\n';
    }
    return 0;
}
