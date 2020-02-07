#include <iostream>
#include <vector>
#include <cmath>
#include <stack>
using namespace std;

bool is_prime(int n){
    int i,s((int)sqrt(n));
    for (i=2;i<=s;++i){
        if (n%i==0){
            return false;
        }
    }
    return true;
}

vector<int>precompute_first_1200_prime_no(){
    vector<int>prime_no{2,3,5,7};
    int i(11);
    while (true){
        if (is_prime(i)){
            prime_no.push_back(i);
            if (prime_no.size()==1200){
                break;
            }
        }++i;
    }
    return prime_no;
}

int main(){
    vector<int>prime_no=precompute_first_1200_prime_no();

    int n, q, a;
    cin >> n >> q;

    vector<stack<int>>s(q+2);

    while(n--){
        cin>>a;
        s[0].push(a);
    }

    int c(0),p;
    for (a=0;a<q;++a){
        while(!s[a%2].empty()){
            p=s[a%2].top();
            s[a%2].pop();
            if (p%prime_no[c]){
                s[(a+1)%2].push(p);
            }
            else{
                s[a+2].push(p);
            }
        }++c;
    }

    for(a=2;a<q+2;++a){
        while(!s[a].empty()){
            cout<<s[a].top()<<'\n';
            s[a].pop();
        }
    }

    for (a=0;a<2;++a){
        while (!s[a].empty()){
            cout<<s[a].top()<<'\n';
            s[a].pop();
        }
    }
    return 0;
}
