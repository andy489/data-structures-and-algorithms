// https://www.hackerrank.com/contests/rmq-test-1/challenges/rmq-test/

#include <cstdio>
#include <algorithm>

using namespace std;
 
typedef long long ll;
 
const ll mxN = 1e6 + 5;
int n, a[mxN]; 
ll t[2 * mxN], lazy[2 * mxN];
 
void push(int v, int c1, int c2) {
    t[c1] += lazy[v];
    lazy[c1] += lazy[v];
    t[c2] += lazy[v];
    lazy[c2] += lazy[v];
    lazy[v] = 0;
}
 
ll combine(ll a, ll b){
    return min(a, b);
}
 
void update(int v, int tl, int tr, int l, int r, int addend) {
    if (l>r)
        return;
    if (tl == l && tr == r) {
        t[v] += addend;
        lazy[v]+=addend;
    } else{
        int tm = (tl + tr) >>1;
        int c1=v+1, c2=v+2*(tm-tl+1);
        push(v, c1, c2);
        update(c1, tl, tm, l, min(r,tm), addend);
        update(c2, tm + 1, tr, max(l,tm+1), r, addend);
        t[v] = combine(t[c1], t[c2]);
    }
}
 
ll query(int v, int tl, int tr, int l, int r) {
    if(l>r) return 1e18;
    if(l<=tl && tr<=r) {return t[v];}
    int tm=(tl+tr)>>1;
    int c1=v+1, c2=v+2*(tm-tl+1);
    push(v,c1,c2);
    return combine(query(c1, tl, tm, l, min(r, tm)), 
               query(c2, tm+1, tr, max(l, tm+1), r));
               
}
 
void build(int v, int tl, int tr) {
    if (tl == tr) {
        t[v] = a[tl];
    } else {
        int tm=(tl+tr)>>1;
        int c1=v+1, c2=v+2*(tm-tl+1);
        build(c1, tl, tm);
        build(c2, tm+1, tr);
        t[v] = combine(t[c1], t[c2]);
    }
}
 
int main() {
    int q, cmd, l, r, val;
    scanf("%d%d", &n, &q);
    for (ll i = 0; i < n; i++)
        scanf("%d", &a[i]);
    build(0, 0, n - 1);
    while (q--) {
        scanf("%d", &cmd);
        switch(cmd){
            case 1:
                scanf("%d%d", &l, &r);
                printf("%lld\n", query(0, 0, n - 1, l, r));
                break;
            case 2:
                scanf("%d%d", &l, &val);
                update(0, 0, n - 1, l, l, val);
                break;
            case 3:
                scanf("%d%d%d", &l, &r, &val);
                update(0, 0, n - 1, l, r, val);
        }
    }
    return 0;
}
