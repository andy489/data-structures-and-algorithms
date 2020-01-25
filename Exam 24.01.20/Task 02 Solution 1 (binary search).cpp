#include <bits/stdc++.h>
using namespace std;

vector<int>arr; //array is sorted
int n;

void bs(int e){    
    int l(0),r(n-1),m,ans(-1); //l=left;r=right;m=middle  
    while(l<=r){
        m=(r-l)/2+l;
        if(arr[m]>e){
            r=m-1;
        }
        else if(arr[m]<e){
            l=m+1;
        }
        else{
            ans=m;
            break;
        }
    }
    if(ans==-1){
        cout<<l<<'\n';
    }
    else{
        int rp(m),lp(m); //rp=right position; lp=left position
        while(rp<n&&arr[rp]==arr[m]){
            ++rp;
        }
        while(lp>=0&&arr[lp]==arr[m]){
            --lp;
        }
        cout<<lp+1<<' '<<rp-1<<"\n";
    }
}

int main() 
{
    int i,q,e;
    cin>>n;
    arr.resize(n);
    for(i=0;i<n;++i){
        cin>>arr[i]; 
    }    
    cin>>q;//q=queries
    while(q--){
        cin>>e;//e=element
        bs(e);//bs=binary search
    }    
    return 0;
}
