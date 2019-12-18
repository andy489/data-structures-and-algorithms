#include <bits/stdc++.h>
using namespace std;

int main() 
{
    unordered_map<string, int> nameTax;

    int N,M,i,tax;
    string name;
    cin>>N>>M;
    for(i=0;i<N;++i)
    {
        cin>>name>>tax;
        nameTax[name]=tax;
    }
    size_t sum(0);
    for(i=0;i<M;++i)
    {
        cin>>name;
        sum+=nameTax[name];
    }
    cout<<sum;
    return 0;
}
