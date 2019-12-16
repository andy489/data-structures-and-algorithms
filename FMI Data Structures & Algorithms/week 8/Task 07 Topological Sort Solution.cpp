#include <bits/stdc++.h>
using namespace std;

vector<list<int>>adj;
vector<bool> visited;

vector<int> top_sort;
vector<int> indexes;

void dfs(int s)
{
    visited[s]=true;
    for(const auto& child:adj[s])
    {
        if(!visited[child])
        {
            dfs(child);   
        }
    }    
    top_sort.push_back(s);
    indexes[s]=top_sort.size()-1;
}

int main()
{
    int q,V,E,a,b,w,i;
    cin>>q;
    
    while(q--)
    {      
        cin>>V>>E;
        
        adj.assign(V,list<int>());
        visited.assign(V,0);
        top_sort.clear();
        indexes.assign(V,0);        
        
        while(E--)
        {
            cin>>a>>b>>w;
            adj[a-1].push_back(b-1);
        }
        
        for(i=0;i<V;++i)
        {
            if(!visited[i])
            {
                dfs(i);
            }            
        }
        
        int reverse_edges(0);
        
        for(i=0;i<V;++i)
        {
            for(const auto&child:adj[i])
            {
                if(indexes[i]<indexes[child])
                {
                    reverse_edges++;                    
                }
            }            
        }
        reverse_edges?cout<<"true ":cout<<"false ";        
    }    
    return 0;
}
