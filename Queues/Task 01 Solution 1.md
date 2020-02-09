#include <iostream>
#include <queue>
using namespace std;

int main()
{
    priority_queue<int,vector<int>,greater<int>>p;
    int n, m, c, a(0);
    cin >> n >> m;
    while (n--) {
        cin >> c;
        p.push(c);
    }
    while (!p.empty() && p.top() < m) {
        int o = p.top();
        p.pop();
        if(p.empty()){
            cout<<-1;
            return 0;
        }
        o += (2 * p.top());
        p.pop();
        p.push(o);
        ++a;
    }
    cout << a;
    return 0;
}
