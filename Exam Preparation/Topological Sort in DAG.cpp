//https://www.hackerrank.com/contests/sda-exam-27-01-19-/challenges/-1-12/problem
#include <bits/stdc++.h>
using namespace std;

vector<list<int>>adj;
vector<bool>visited;
vector<int>top_sort,indexes;

void dfs(int s)
{
    visited[s]=true;
    for(const auto& child:adj[s])
    {
        if(!visited[child])
        dfs(child);
    }
    top_sort.push_back(s);
    indexes[s]=top_sort.size()-1;
}

int main()
{
    int q;
    cin>>q;
    while(q--)
    {
        int n,m,a,b,w;
        cin>> n>>m;
        
        adj.assign(n,list<int>());
        visited.assign(n,false);
        top_sort.clear();
        indexes.assign(n,-1);
        while(m--)
        {
            cin>>a>>b>>w;
            --a;--b;
            adj[a].push_back(b);
        }
        
        for(w=0;w<n;++w)
        {
            if(!visited[w])
            {
                dfs(w);
            }
        }
        
        size_t cyc_edges(0);
        
        for(w=0;w<n;++w)
        {
            for(const auto& child:adj[w])
            {
                if(indexes[child]>indexes[w])
                {
                    ++cyc_edges;
                }
            }
        }        
        cout<<(cyc_edges>0?"true ":"false ");
    }
}
