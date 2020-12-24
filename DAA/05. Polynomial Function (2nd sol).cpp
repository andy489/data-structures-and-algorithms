// https://www.hackerrank.com/contests/rmq-test-1/challenges/polynomial-function/problem

#include <cstdio>

using namespace std;

const int maxN=300009;
const int mod=1000000007;

long long tree[4*maxN],kPow[maxN]={1},ans,nums[maxN];
int n,k,q;

void init(){
    scanf("%d %d",&n,&k);

    for(int i=0;i<n;i++){
        scanf("%lld",&nums[i]);
        kPow[i+1]=kPow[i]*k;
        if(kPow[i+1]>mod)kPow[i+1]%=mod;
        if(nums[i]>mod)nums[i]%=mod;
    }
}

void build(int from,int to,int ind){
    if(from==to){
        tree[ind]=nums[from];
        return;
    }

    build(from,(from+to)/2,ind*2+1);
    build((from+to)/2+1,to,ind*2+2);

    tree[ind]=tree[ind*2+1]*kPow[to-(from+to+2)/2+1]+tree[ind*2+2];
    if(tree[ind]>mod)tree[ind]%=mod;
}

void look(int qFrom,int qTo,int cFrom,int cTo,int ind){
    if(cFrom>qTo || cTo<qFrom)return;

    if(cFrom>=qFrom && cTo<=qTo){
        ans=ans + tree[ind]*kPow[qTo-cTo];
        if(ans>mod)ans%=mod;
        return;
    }

    look(qFrom,qTo,cFrom,(cFrom+cTo)/2,ind*2+1);
    look(qFrom,qTo,(cFrom+cTo)/2+1,cTo,ind*2+2);
}

void update(int qInd,long long qVal,int cFrom,int cTo,int ind){
    if(cFrom>qInd || cTo<qInd)return;

    if(cFrom==cTo){
        tree[ind]=qVal;
        return;
    }

    update(qInd,qVal,cFrom,(cFrom+cTo)/2,ind*2+1);
    update(qInd,qVal,(cFrom+cTo)/2+1,cTo,ind*2+2);

    tree[ind]=tree[ind*2+1]*kPow[cTo-(cFrom+cTo+2)/2+1]+tree[ind*2+2];
    if(tree[ind]>mod)tree[ind]%=mod;
}

void workQs(){
    long long q,qType,from,to;

    scanf("%lld",&q);

    for(int i=0;i<q;i++){
        scanf("%lld %lld %lld",&qType,&from,&to);

        if(qType==1){
            ans=0;
            look(from-1,to-1,0,n-1,0);
            printf("%lld\n",ans);
        }
        else{
            update(from-1,to,0,n-1,0);
        }
    }
}

int main(){
    init();
    build(0,n-1,0);
    workQs();
}
