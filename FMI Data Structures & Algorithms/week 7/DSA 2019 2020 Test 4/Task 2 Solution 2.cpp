#include <iostream>
#include <queue>
#include <set>
#include <unordered_map>

using namespace std;

struct Point
{
    int x, type;

    Point(int val = 0, int type = 0) : x(val), type(type) {}

    bool operator<(const Point& p) const
    {
        if (x == p.x) return type > p.type;
        else return x < p.x;
    }
};

int main()
{
    int n, q, a, b, t, c(0);
    cin >> n >> q;

    multiset<Point> ms;

    while (n--)
    {
        cin >> a >> b;
        Point p1({ a, 1 }), p2({ b, -1 });
        ms.insert(p1);
        ms.insert(p2);
    }

    queue<int> quiries;

    for (int i = 0; i < q; i++)
    {
        cin >> t;
        quiries.push(t);
        ms.insert(t);
    }

    unordered_map<int, int> um;

    auto it = ms.begin();

    while (it != ms.end())
    {
        c += it->type;
        if (it->type == 0)
        {
            um[it->x] = c;
        }
        it++;
    }

    while (!quiries.empty())
    {
        auto iter = um.find(quiries.front());
        if (iter != um.end())
            cout << iter->second << ' ';
        quiries.pop();
    }

    return 0;
}
