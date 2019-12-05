#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>
#include <algorithm>
using namespace std;

struct Point
{
    int x, type;
    Point(int x = 0, int type = 0) :x(x), type(type) {}  
};

struct cmp
{
    bool operator()(const Point& l, const Point& r) const
    {
        if (l.x == r.x)
        {
            return l.type > r.type;
        }
        else return l.x < r.x;
    }
};

int main()
{
    int n, q, i, l, r, a(0), p(0);
    cin >> n >> q;

    vector<Point> arr;
    arr.reserve(2 * n + q + 10);
    queue<int> queries;

    for (i = 0; i < n; ++i)
    {
        cin >> l;
        arr.push_back({ l,1 });
        cin >> r;
        arr.push_back({ r,-1 });
    }

    for (i = 0; i < q; i++)
    {
        cin >> l;
        arr.push_back({ l,0 });
        queries.push(l);
    }

    sort(arr.begin(), arr.end(),cmp());

    unordered_map<int,int> ans;

    n = arr.size();
    for (i = 0; i < n; ++i)
    {
        a += arr[i].type;
        if (arr[i].type == 0)
        {
            ans[arr[i].x]=a;
        }
    }

    while (!queries.empty())
    {
        a = queries.front(),queries.pop();
        cout << ans[a] << ' ';
    }

    return 0;
}
