#include <bits/stdc++.h>

using namespace std;

ostringstream print(int n){
    ostringstream ostr;
    int i;
    for(i=1;i<11;++i){
        ostr<<n<<" x "<<i<<" = "<<n*i<<'\n';
    }
    return ostr;
}

int main(){
    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    cout<<print(n).str();
    return 0;
}
