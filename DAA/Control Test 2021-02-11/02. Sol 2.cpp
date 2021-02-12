#include <iostream>
#include <algorithm>
using namespace std;

int n, k;
int hotels[100010];

void init(){
    scanf("%d %d",&n,&k);

    for(int i=0;i<n;i++){
        scanf("%d",&hotels[i]);
    }

    sort(hotels,hotels+n);
}

bool check(int dist){
    int lastInd = 0, fitted = 1;

    for(int i=1;i<n;i++){
        if(hotels[i] - hotels[lastInd] >= dist){
            lastInd=i;
            fitted++;
        }
    }

    return fitted>=k;
}

void solve(){
    int left=1,right = 2*int(1e9),mid, ans=-1;

    while(left<=right){
        mid = left + (right-left)/2;

        if(check(mid)){
            left = mid+1;
            ans = mid;
        }
        else{
            right = mid-1;
        }
    }

    printf("%d\n",ans);
}

int main() {
    init();
    solve();
}
