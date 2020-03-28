// github.com/andy489

#include <stdio.h>
#include <algorithm>
using namespace std;

// Complete the minimumSwaps function below.
int minimumSwaps(int* a,int n) {
    int i,countSwaps(0);
    for (i=1;i<n;++i){
        if(a[i]!=i){
            int j=i;
            while(a[j]!=j){
                swap(a[j],a[a[j]]);
                ++countSwaps;
                j=a[j];
            }
        }
    }
    return countSwaps;
}

int main(){
    int n,i;
    scanf("%d",&n);
    int* a=new int[++n];
    for(i=1;i<n;++i){
        scanf("%d",a+i);
    }
    int ans = minimumSwaps(a, n);
    printf("%d",ans);
    return 0;
}
