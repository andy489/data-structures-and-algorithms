// github.com/andy489

#include<iostream>
#include <vector>
using namespace std;

int merge(vector<int>&a,vector<int>&l,vector<int>&r){
    int lc(l.size()),rc(r.size()),i(0),j(0),k(0),inv(0);
    while(i<lc&&j<rc){
        if(l[i]<r[j])a[k++]=l[i++];
        else{
            a[k++]=r[j++];
            inv+=lc-i;
        }
    }
    while(i<lc)a[k++]=l[i++];
    while(j<rc)a[k++]=r[j++];
    return inv;
}

int merge_sort(vector<int>&a){
    int n=(int)a.size(),i,inv(0);
    if(n<2){
        return 0;
    }
    int mid=n/2;
    vector<int>l(mid),r(n-mid);
    for(i=0;i<mid;++i){
        l[i]=a[i];
    }
    for(i=mid;i<n;++i){
        r[i-mid]=a[i];
    }
    
    inv+=merge_sort(l);
    inv+=merge_sort(r);
    inv+=merge(a,l,r);
    return inv;
}

vector<int> init(){
    int n,i;    
    cin>>n;
    vector<int>a(n);
    for(i=0;i<n;++i){
        cin>>a[i];
    }
    return a;
}

int main()
{
    int q;
    cin>>q;
    while (q--) {
        vector<int>a=init();
        int inv=merge_sort(a);
        cout<<(inv%2?"NO\n":"YES\n");
    }
    return 0;
}
