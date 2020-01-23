//https://www.hackerrank.com/contests/sda-2019-2020-test4/challenges/challenge-2274
#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n, q, s, e;
    cin >> n >> q;
    vector<pair<int, int>>a;
    while (n--)
    {
        cin >> s >> e;
        a.emplace_back(s, -1);
        a.emplace_back(e, 1);
    }
    unordered_map<int, int>ans;
    queue<int>order;
    while (q--)
    {
        cin >> s;
        a.emplace_back(s, 0);
        order.push(s);
    }
    sort(a.begin(), a.end());
    e = (int)a.size();
    int i(0);


    for (s = 0;s < e;++s)
    {
        if (a[s].second == -1) ++i;
        else if (a[s].second == 1) --i;
        else
        {
            ans[a[s].first] = i;
        }
    }
    while (!order.empty())
    {
        int cur = order.front();
        cout << ans[cur] << ' ';
        order.pop();
    }
    return 0;
}
