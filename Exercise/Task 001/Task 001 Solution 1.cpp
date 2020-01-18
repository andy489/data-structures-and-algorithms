#include <vector>
#include <stdio.h>
#include <algorithm>
using namespace std;
#define MAXREM 99
int main(){ int n,k,i,a,res(0);
    vector<int>r(MAXREM);
    scanf("%d%d",&n,&k);
    for(i=0;i<n;++i){ scanf("%d",&a);
        ++r[a%k];
    }
    for(i=1;i<(k+1)/2;++i){    
        res+=max(r[i],r[k-i]);   
    }
    if(r[0]) ++res;
    if(k%2==0&&r[k/2]) ++res;
    printf("%d",res);    
}
