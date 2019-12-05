#include <bits/stdc++.h>
using namespace std;
struct Apartment{ double x,y,dist;
    Apartment(double x=0.0,double y=0.0):x(x),y(y){
        dist=x*x+y*y;
    } bool operator<(const Apartment& ap) const{
        if (this->dist==ap.dist)return x<ap.x;
        return this->dist<ap.dist;
    }
};
int main(){ int N,K,i; double x,y;
    scanf("%d %d",&N,&K);
    priority_queue<Apartment> nearest;
    stack<Apartment> S;
    for(i=0;i<K;++i){
        scanf("%lf %lf",&x,&y);    
        nearest.emplace(x,y);
    } for(i=K;i<N;++i){
        scanf("%lf %lf",&x,&y);
        if (Apartment(x,y)<nearest.top()){
            nearest.pop();nearest.emplace(x,y);
        }
    } while(!nearest.empty()){
        S.push(nearest.top()),nearest.pop();
    } while(!S.empty()){
       printf("%.0lf %.0lf\n",S.top().x,S.top().y),S.pop();
    }
}

