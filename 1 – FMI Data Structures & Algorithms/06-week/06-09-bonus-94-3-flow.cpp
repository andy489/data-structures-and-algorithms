// https://www.hackerrank.com/contests/practice-6-sda/challenges/94/problem

#include <cstdio>
#include <climits>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

struct Stop {
    int position;
    int time;

    explicit Stop(int position = 0, int time = 0) : position(position), time(time) {}
};

pair<size_t, size_t> find_student_range(const vector<int> &students, int position, int time) {
    auto left = position - time;
    auto right = position + time;

    auto left_it = lower_bound(students.begin(), students.end(), left);
    auto right_it = upper_bound(students.begin(), students.end(), right);

    return make_pair(left_it - students.begin(), right_it - students.begin());
}

template<class Left_object, class Right_object>
class BipGraph {
#define NIL 0
#define INF INT_MAX
public:
    BipGraph(const vector<Left_object> &left_nodes, const vector<Right_object> &right_nodes)
            : m_left_objs(left_nodes), m_right_objs(right_nodes) {
        m_left_size = m_left_objs.size();
        m_right_size = m_right_objs.size();
    }

    bool check_augmenting_path() {
        queue<int> q;

        // First layer of vertices (set distance as 0)
        for (int u = 0; u <= m_left_size; ++u) {
            // If this is a free vertex, add it to queue
            if (m_pair_u[u] == NIL) {
                // u is not matched
                m_dist[u] = 0;
                q.push(u);
            }

                // Else set distance as infinite so that this vertex
                // is considered next time
            else m_dist[u] = INF;
        }

        // Initialize distance to NIL as infinite
        m_dist[NIL] = INF;

        // q is going to contain vertices of left side only.
        while (!q.empty()) {
            // Dequeue a vertex
            int u = q.front();
            q.pop();

            // If this node is not NIL and can provide a shorter path to NIL
            if (m_dist[u] < m_dist[NIL]) {
                // Get all adjacent vertices of the dequeued vertex u
                auto adj = find_student_range(m_right_objs, m_left_objs[u - 1].position,
                                              m_left_objs[u - 1].time);
                
                for (auto i = adj.first; i != adj.second; ++i) {
                    int v = i + 1;

                    // If pair of v is not considered so far
                    // (v, pairV[V]) is not yet explored edge.
                    if (m_dist[m_pair_v[v]] == INF) {
                        // Consider the pair and add it to queue
                        m_dist[m_pair_v[v]] = m_dist[u] + 1;
                        q.push(m_pair_v[v]);
                    }
                }
            }
        }

        // If we could come back to NIL using alternating path of distinct
        // vertices then there is an augmenting path
        return (m_dist[NIL] != INF);
    }

    bool add_augmenting_path(int start_vertex) {
        if (start_vertex != NIL) {
            auto adj = find_student_range(m_right_objs, m_left_objs[start_vertex - 1].position,
                                          m_left_objs[start_vertex - 1].time);
            
            for (auto i = adj.first; i != adj.second; ++i) {
                // Adjacent to u
                int v = i + 1;

                // Follow the distances set by BFS
                if (m_dist[m_pair_v[v]] == m_dist[start_vertex] + 1) {
                    // If dfs for pair of v also returns
                    // true
                    if (add_augmenting_path(m_pair_v[v]) == true) {
                        m_pair_v[v] = start_vertex;
                        m_pair_u[start_vertex] = v;
                        return true;
                    }
                }
            }

            // If there is no augmenting path beginning with u.
            m_dist[start_vertex] = INF;
            return false;
        }

        return true;
    }

    int get_maximum_matching_size() {
        m_pair_u.clear();
        m_pair_u.resize(m_left_size + 1);

        m_pair_v.clear();
        m_pair_v.resize(m_right_size + 1);

        // dist[u] stores distance of left side vertices
        // dist[u] is one more than dist[u'] if u is next
        // to u' in augmenting path
        m_dist.clear();
        m_dist.resize(m_left_size + 1);

        // Initialize NIL as pair of all vertices
        for (int u = 0; u <= m_left_size; ++u) {
            m_pair_u[u] = NIL;
        }
        for (int v = 0; v <= m_right_size; ++v) {
            m_pair_v[v] = NIL;
        }

        // Initialize result
        int result = 0;

        // Keep updating the result while there is an
        // augmenting path.
        while (check_augmenting_path()) {
            // Find a free vertex
            for (int u = 1; u <= m_left_size; ++u)

                // If current vertex is free and there is
                // an augmenting path from current vertex
                if (m_pair_u[u] == NIL && add_augmenting_path(u)) {
                    result++;
                }
        }

        return result;
    }

private:
    int m_left_size, m_right_size;
    
    const vector<Left_object> &m_left_objs;
    const vector<Right_object> &m_right_objs;

    vector<int> m_pair_u, m_pair_v, m_dist;

#undef INF
#undef NIL
};

int main() {
    int n, m;
    scanf("%d %d", &n, &m);

    vector<int> students(n);

    for (auto &student : students) {
        scanf("%d", &student);
    }

    sort(students.begin(), students.end());

    vector<Stop> stops(m);
    for (auto &stop : stops) {
        scanf("%d %d", &stop.position, &stop.time);
    }

    BipGraph<Stop, int> graph(stops, students);

    printf("%d", graph.get_maximum_matching_size());

    return 0;
}
