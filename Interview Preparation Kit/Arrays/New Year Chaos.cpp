// github.com/andy489

#include <stdio.h>
#include <vector>
#include <algorithm>
#define N (int)1e5
using namespace std;

// Complete the minimumBribes function below.
void minimumBribes(const vector<int>& a,int n) {
    int i,j,ans(0);
    for (i = n - 1; i >= 0; i--) {
        if (a[i] - (i + 1) > 2) {
            printf("%s\n","Too chaotic");
            return;
        }
        for (j = max(0, a[i] - 2); j < i; j++)
            if (a[j] > a[i]) ++ans; //count bribes
    }
    printf("%d\n",ans);
}

vector<int> a(N);

int main(){
    int t,n,i;
    scanf("%d",&t);
    while(t--){
        scanf("%d",&n);
        for(i=0;i<n;++i){
            scanf("%d",&a[i]);
        }
        int ans(0);
        minimumBribes(a,n);
    }
    return 0;
}
