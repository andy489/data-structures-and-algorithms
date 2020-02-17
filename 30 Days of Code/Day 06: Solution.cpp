#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n,i;
    cin>>n;
    string s;
    while(n--){
        cin>>s;
        int S=(int)s.length();
        ostringstream ostr_even,ostr_odd;
        for(i=0;i<S;++i){
            if(i==0||(i&1)==0){
                ostr_even<<s[i];
            }
            else{
                ostr_odd<<s[i];
            }
        }
        cout<<ostr_even.str()<<' '<<ostr_odd.str()<<'\n';
    }
    return 0;
}
