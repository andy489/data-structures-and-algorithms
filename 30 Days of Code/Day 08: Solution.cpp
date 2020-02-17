#include <iostream>
#include <unordered_map>
using namespace std;

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    int q,i;
    cin>>q;
    string name,phone;
    unordered_map<string, string>phoneBook;
    while(q--){
        cin>>name>>phone;
        phoneBook[name]=phone;
    }
    while(cin>>name){        
        if(phoneBook.count(name)){
            cout<<name<<'='<<phoneBook[name]<<'\n';
        }
        else{
            cout<<"Not found\n";
        }
    }
    return 0;
}
