// github.com/andy489

#include <stdio.h>
#define MAXREM 100
int main(){ int n,k,i,a,res(0);
    int* r = new int[MAXREM];
    scanf("%d%d",&n,&k);
    for(i=0;i<n;++i){ scanf("%d",&a);
        ++r[a%k];
    }
    int end=(k+1)/2;
    for(i=1;i<end;++i){    
        res+=(r[i]>r[k-i]?r[i]:r[k-i]);   
    }
    if(r[0]) ++res;
    if(!(k&1)&&r[k/2]) ++res;
    printf("%d",res);    
}
