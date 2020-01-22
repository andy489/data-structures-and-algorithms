//https://www.hackerrank.com/contests/sda-2019-2020-test4/challenges/challenge-2273
#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n,c;
    cin>>n;
    priority_queue<int,vector<int>,greater<int>>pq;
    while(n--)
    {
        cin>>c;
        if(c==-1&&!pq.empty())
        {             
            cout<<pq.top()<<' ';
            pq.pop();
        }
        else 
        {
            pq.push(c);
        }
    }    
    return 0;
}
