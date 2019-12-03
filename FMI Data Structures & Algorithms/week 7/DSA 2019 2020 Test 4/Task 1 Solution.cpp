#include <bits/stdc++.h>
using namespace std;

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    priority_queue<int,vector<int>,greater<int>> minHeap;
    int n,i,a,curr;
    scanf("%d",&n);
    for(i=0;i<=n;++i)
    {
        scanf("%d",&a);
        if  (a==-1 && !minHeap.empty())
        {
            curr=minHeap.top(), minHeap.pop();
            printf("%d ",curr);           
        }
        else if(a!=-1) minHeap.push(a);
    }
    return 0;
}
