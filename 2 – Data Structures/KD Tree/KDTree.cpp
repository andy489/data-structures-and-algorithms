#include <iostream>
#include <vector>
#include <cmath>
#include <iomanip>

using namespace std;

static const int SIZE = 2e6 + 5;

int n, k;
vector<vector<int>> points;

struct point_comparator {
    int dimension;

    explicit point_comparator(int dimension = 0) : dimension(dimension) {}

    bool operator()(const vector<int> &point1, const vector<int> &point2) const {
        return point1[dimension] < point2[dimension];
    }
};

long long distance_squared(vector<int> &point1, vector<int> &point2) {
    long long dist = 0;

    for (int i = 0; i < k; ++i) {
        dist += (point1[i] - point2[i]) * (point1[i] - point2[i]);
    }

    return dist;
}

struct kd_node {
    vector<int> point;

    int axis{};

    kd_node *left{};
    kd_node *right{};
};

kd_node *root;

int mem_cnt;
kd_node memory_holder[SIZE];


kd_node *build(int from, int to, int axis) {
    if (from == to) {
        return nullptr;
    }

    int mid = (from + to) / 2;

    nth_element(points.begin() + from,
                points.begin() + mid,
                points.begin() + to,
                point_comparator(axis));

    kd_node *node = &memory_holder[mem_cnt++];

    node->axis = axis;
    node->point = points[mid];

    node->left = build(from, mid, (axis + 1) % k);
    node->right = build(mid + 1, to, (axis + 1) % k);

    return node;
}

long long nearest_neighbour(kd_node *node, vector<int> &point) {
    if (node == nullptr) {
        return LLONG_MAX;
    }

    long long result = distance_squared(node->point, point);

    if (node->point[node->axis] <= point[node->axis]) {
        result = min(result, nearest_neighbour(node->right, point));

        if (node->left && point[node->axis] - sqrt(result) <= node->point[node->axis]) {
            result = min(result, nearest_neighbour(node->left, point));
        }
    } else {
        result = min(result, nearest_neighbour(node->left, point));

        if (node->right && point[node->axis] - sqrt(result) >= node->point[node->axis]) {
            result = min(result, nearest_neighbour(node->right, point));
        }
    }

    return result;
}

void input() {
    cin >> n >> k;

    for (int i = 0; i < n; ++i) {
        vector<int> point;

        for (int j = 0; j < k; ++j) {
            int coordinate;
            cin >> coordinate;

            point.push_back(coordinate);
        }

        points.push_back(point);
    }
}

void solve() {
    root = build(0, n, 0);

    int q;
    cin >> q;

    cout << fixed << setprecision(2);

    for (int i = 0; i < q; ++i) {
        vector<int> point;

        for (int j = 0; j < k; ++j) {
            int coordinate;
            cin >> coordinate;

            point.push_back(coordinate);
        }

        cout << sqrt(nearest_neighbour(root, point)) << endl;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    input();
    solve();

    return 0;
}
