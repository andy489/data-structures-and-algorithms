#include <bits/stdc++.h>
using namespace std;

#define x first
#define y second

vector<pair<int, int>> points;

int dist(pair<int, int> p1, pair<int, int> p2) {
    return (p1.x - p2.x) * (p1.x - p2.x) + 
           (p1.y - p2.y) * (p1.y - p2.y);
}

int orientation(pair<int, int> p1, pair<int, int> p2, pair<int, int> p3) {
    return (p2.y - p1.y) * (p3.x - p2.x) -
           (p2.x - p1.x) * (p3.y - p2.y);
}

bool compare(pair<int, int> p1, pair<int, int> p2) {
    int ori = orientation(points[0], p1, p2);

    if (ori == 0) {
        return dist(points[0], p1) <= dist(points[0], p2);
    }

    return ori < 0;
}

pair<int, int> top2(stack<pair<int, int>> s) {
    pair<int, int> temp = s.top();
    s.pop();

    pair<int, int> res = s.top();
    s.push(temp);

    return res;
}

void arrange_points() {
    int minPoint = 0;

    for (int i = 0; i < points.size(); i++) {
        if ((points[minPoint].y == points[i].y 
            && points[minPoint].x > points[i].x) 
            || points[minPoint].y > points[i].y) {
            minPoint = i;
        }
    }

    swap(points[0], points[minPoint]);

    sort(points.begin() + 1, points.end(), compare);

    int viable_points = 1;
    for (int i = 1; i < points.size(); i++) {
        while (i < points.size() - 1 && orientation(points[0], points[i], points[i + 1]) == 0) {
            i++;
        }
        points[viable_points++] = points[i];
    }
    
    while (points.size() > viable_points) {
        points.pop_back();
    }
}

void graham_scan() {
    arrange_points();

    if (points.size() < 3) {
        return;
    }

    stack<pair<int, int>> convex_hull; 
    convex_hull.push(points[0]);
    convex_hull.push(points[1]);
    convex_hull.push(points[2]);

    for (int i = 3; i < points.size(); i++) {
        while (orientation(top2(convex_hull), convex_hull.top(), points[i]) >= 0) {
            convex_hull.pop();
        }
        convex_hull.push(points[i]);
    }

    while (convex_hull.empty() == false) {
        cout << "(" << convex_hull.top().x << ", " << convex_hull.top().y << ")\n";
        convex_hull.pop();
    }
}

void input() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        points.push_back({x, y});
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    input();
    graham_scan();

    return 0;
}
