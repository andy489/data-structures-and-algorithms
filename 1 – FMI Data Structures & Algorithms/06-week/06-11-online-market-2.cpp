// https://www.hackerrank.com/contests/sda-test-5/challenges/2-61

#include <list>
#include <unordered_map>
#include <unordered_set>

using namespace std;

class Graph {
    unordered_map<int, list<int>> adj;
public:
    Graph() = default;

    void add_edge(int v, int w) {
        adj[v].push_back(w);
        adj[w].push_back(v);
    }

    void bfs(int s) {
        unordered_set<int> visited;

        list<int> q;
        visited.insert(s);
        q.push_back(s);

        list<int>::iterator i;

        int level = 0;
        int sum = 0;

        while (!q.empty()) {
            int sz = q.size();

            while (sz--) {
                s = q.front();
                q.pop_front();

                sum += level;

                for (i = adj[s].begin(); i != adj[s].end(); ++i) {
                    if (visited.find(*i) == visited.end()) {
                        visited.insert(*i);
                        q.push_back(*i);
                    }
                }
            }

            ++level;
        }

        printf("%d", sum);
    }
};

int main() {
    Graph g;
    int n;

    scanf("%d", &n);

    int a, b;
    for (int i = 0; i < n; ++i) {
        scanf("%d %d", &a, &b);
        g.add_edge(a, b);
    }

    g.bfs(0);

    return 0;
}
