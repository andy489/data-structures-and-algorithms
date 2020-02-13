#include <bits/stdc++.h>
using namespace std;

unordered_map<int,long>fibo;

long fibonacci(int n){
    if(fibo.count(n)){
        return fibo[n];
    }
    else{
        return fibo[n]=fibo[n-1]+fibo[n-2];
    }    
}

string solve(long n){
    fibo[0]=0;
    fibo[1]=1;
    int i=0;
    while(fibonacci(i)<n){
        fibonacci(i);
        ++i;
    }
    return fibonacci(i)==n?"IsFibo\n":"IsNotFibo\n";    
}

int main(){
    int t;
    cin >> t;
    while(t--){
        long n;
        cin>>n;
        cout<<solve(n);
    }
    return 0;
}
