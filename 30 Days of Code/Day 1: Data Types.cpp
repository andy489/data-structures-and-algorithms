#include <iostream>
#include <iomanip>
#include <limits>

using namespace std;

int main() {
    int i = 4;
    double d = 4.0;
    string s = "HackerRank ";
    
    int a;
    double b;
    string c;
    
    cin>>a>>b;
    while(cin>>c)
    {
        s.append(c);
        s.append(" ");
    }
    
    cout<<i+a<<'\n';
    cout.setf(ios::fixed);
   
    cout.precision(1);
    cout<<d+b<<'\n'<<s;    
    
    return 0;
}
