#include <iostream>
#include <string>
using namespace std;

int main()
{
    string s;
    cin >> s;
    try{
        int n;
        n=stoi(s);
        cout<<n;
    }
    catch(...){
        cout<<"Bad String";
    }
    return 0;
}
