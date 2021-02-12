#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

int n,k,q,ans[int(1e5)+5];
long long num[int(1e6)+5];
pair<long long,int> qs[int(1e5)+5];

void init(){
    scanf("%d %d %d",&n,&k,&q);

    for(int i=0;i<n;i++){
        scanf("%lld",&num[i]);
    }

    for(int i=0;i<q;i++){
        scanf("%lld",&qs[i].first);
        qs[i].second = i;
    }
}

void answerQs(long long value, int &firstQInd, int sumInd){
    while(qs[firstQInd].first<=value && firstQInd < q){
        ans[qs[firstQInd++].second] = sumInd;
    }
}

void solve(){
    long long sum=0;
    int answeredQs=0;

    sort(qs,qs+q);
    fill(ans,ans+q,-1);

    for(int i=0;i<k;i++){
        sum+=num[i];
    }

    answerQs(sum,answeredQs,0);

    for(int i=k;i<n;i++){
        sum = sum - num[i-k] + num[i];
        answerQs(sum,answeredQs,i-k+1);
    }
}

void printAns(){
    for(int i=0;i<q;i++){
        printf("%d\n",ans[i]);
    }
}

int main(){
    init();
    solve();
    printAns();
}
