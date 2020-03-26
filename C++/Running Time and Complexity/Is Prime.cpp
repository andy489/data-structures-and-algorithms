// github.com/andy489

#include <iostream>
using namespace std;

bool is_prime(size_t n){
    size_t i;
    if(n==1) {
        return false;
    }
    for(i=2;i*i<=n;++i){
        if(n%i==0){
            return false;
        }
    }
    return true;
}

int main() {
    size_t n,p;
    cin>>n;
    while(n--){
        cin>>p;
        cout<<(is_prime(p)?"Prime\n":"Not prime\n");
    }
    return 0;
}
