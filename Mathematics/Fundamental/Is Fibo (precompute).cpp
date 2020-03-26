// github.com/andy489

#include <iostream>
#include <unordered_set>
using namespace std;
#define MAX 10000000000LL

int main(){
    unordered_set<long long>fibo;
    long f1(0),f2(1),f3;
    fibo.insert(f1);
    fibo.insert(f2);
    while (f2 < MAX) {
        f3 = f1 + f2;
        fibo.insert(f3);
        f1 = f2; f2 = f3;
    }
    
    int q,i;
    cin>>q;
    while(q--){
        long long n;
        cin>>n;
        cout<<(fibo.count(n)?"IsFibo\n":"IsNotFibo\n");
    }      
    return 0;
}
