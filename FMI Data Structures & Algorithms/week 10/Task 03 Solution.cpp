#include <iostream>
#include <vector>
using namespace std;

int n, m, i;

vector<pair<int,int>> edges;
vector<int>p;

void init()
{
    for (i = 0;i < n;++i)
    {
        p[i] = i;      
    }
}

int find(int v)
{
    if (p[v] == v)
        return v;
    return p[v] = find(p[v]);
}

void uni(int x, int y)
{
    int r1 = find(x), r2 = find(y);
    if (r1 == r2) return;
    else
    {        
        p[r2] = r1;      
    }
}

int main()
{  
    cin.tie(nullptr);
    
    cin >> n >> m;
    p.resize(n+1);  
    
    int a, b;
    for (i = 0;i < m;++i)
    {
        cin >> a >> b;
        edges.emplace_back(a, b);
    }
    init();
    for (i = 0;i < m;++i)
    {
        uni(edges[i].first, edges[i].second);
    }

    int q, c;
    cin >> q;

    for (i = 0;i < q;++i)
    {
        cin >> c >> a >> b;
        if (c == 1)
        {
            cout << (find(a) == find(b));
        }
        else
        {
            uni(a, b);
        }
    }
}
