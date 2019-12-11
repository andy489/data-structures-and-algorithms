#include <cmath>
#include <cstdio>
#include <climits>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
 
int n, m;
 
struct Stop
{
    int position;
    int time;
 
    Stop(int position = 0, int time = 0) : position(position), time(time) {}
};
 
using It = vector<int>::const_iterator;
 
pair<size_t, size_t> FindStudentRange(const vector<int>& students, int position, int time)
{
    auto left = position - time;
    auto right = position + time;
 
    auto leftIt = lower_bound(students.begin(), students.end(), left);
    auto rightIt = upper_bound(students.begin(), students.end(), right);
 
    return make_pair(leftIt - students.begin(), rightIt - students.begin());
}
 
template <class LeftObjectT, class RightObjectT>
class BipGraph
{
#define NIL 0
#define INF INT_MAX
public:
    BipGraph(const vector<LeftObjectT>& leftNodes, const vector<RightObjectT>& rightNodes)
        : m_leftObjs(leftNodes)
        , m_rightObjs(rightNodes)
    {
        m_leftSize = m_leftObjs.size();
        m_rightSize = m_rightObjs.size();
    }
 
    bool CheckAugmentingPath()
    {
        queue<int> Q;
 
        // First layer of vertices (set distance as 0)
        for (int u = 0; u <= m_leftSize; u++)
        {
            // If this is a free vertex, add it to queue
            if (m_pairU[u] == NIL)
            {
                // u is not matched
                m_dist[u] = 0;
                Q.push(u);
            }
 
            // Else set distance as infinite so that this vertex
            // is considered next time
            else m_dist[u] = INF;
        }
 
        // Initialize distance to NIL as infinite
        m_dist[NIL] = INF;
 
        // Q is going to contain vertices of left side only.  
        while (!Q.empty())
        {
            // Dequeue a vertex
            int u = Q.front();
            Q.pop();
 
            // If this node is not NIL and can provide a shorter path to NIL
            if (m_dist[u] < m_dist[NIL])
            {
                // Get all adjacent vertices of the dequeued vertex u
                auto adj = FindStudentRange(m_rightObjs, m_leftObjs[u - 1].position, m_leftObjs[u - 1].time);
                for (auto i = adj.first; i != adj.second; ++i)
                {
                    int v = i + 1;
 
                    // If pair of v is not considered so far
                    // (v, pairV[V]) is not yet explored edge.
                    if (m_dist[m_pairV[v]] == INF)
                    {
                        // Consider the pair and add it to queue
                        m_dist[m_pairV[v]] = m_dist[u] + 1;
                        Q.push(m_pairV[v]);
                    }
                }
            }
        }
 
        // If we could come back to NIL using alternating path of distinct
        // vertices then there is an augmenting path
        return (m_dist[NIL] != INF);
    }
 
    bool AddAugmentingPath(int startVertex)
    {
        if (startVertex != NIL)
        {
            auto adj = FindStudentRange(m_rightObjs, m_leftObjs[startVertex - 1].position, m_leftObjs[startVertex - 1].time);
            for (auto i = adj.first; i != adj.second; ++i)
            {
                // Adjacent to u
                int v = i + 1;
 
                // Follow the distances set by BFS
                if (m_dist[m_pairV[v]] == m_dist[startVertex] + 1)
                {
                    // If dfs for pair of v also returns
                    // true
                    if (AddAugmentingPath(m_pairV[v]) == true)
                    {
                        m_pairV[v] = startVertex;
                        m_pairU[startVertex] = v;
                        return true;
                    }
                }
            }
 
            // If there is no augmenting path beginning with u.
            m_dist[startVertex] = INF;
            return false;
        }
 
        return true;
    }
 
    int GetMaximumMatchingSize()
    {
        m_pairU.clear();
        m_pairU.resize(m_leftSize + 1);
 
        m_pairV.clear();
        m_pairV.resize(m_rightSize + 1);
 
        // dist[u] stores distance of left side vertices
        // dist[u] is one more than dist[u'] if u is next
        // to u'in augmenting path
        m_dist.clear();
        m_dist.resize(m_leftSize + 1);
 
        // Initialize NIL as pair of all vertices
        for (int u = 0; u <= m_leftSize; u++)
            m_pairU[u] = NIL;
        for (int v = 0; v <= m_rightSize; v++)
            m_pairV[v] = NIL;
 
        // Initialize result
        int result = 0;
 
        // Keep updating the result while there is an
        // augmenting path.
        while (CheckAugmentingPath())
        {
            // Find a free vertex
            for (int u = 1; u <= m_leftSize; u++)
 
                // If current vertex is free and there is
                // an augmenting path from current vertex
                if (m_pairU[u] == NIL && AddAugmentingPath(u))
                    result++;
        }
 
        return result;
    }
 
private:
    int m_leftSize, m_rightSize;
 
    const vector<LeftObjectT>& m_leftObjs;
    const vector<RightObjectT>& m_rightObjs;
 
    vector<int> m_pairU, m_pairV, m_dist;
 
#undef INF
#undef NIL
};
 
 
int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
 
    scanf("%d %d", &n, &m);
    vector<int> students(n);
    for (auto& student : students)
        scanf("%d", &student);
 
    sort(students.begin(), students.end());
 
    vector<Stop> stops(m);
    for (auto& stop : stops)
        scanf("%d %d", &stop.position, &stop.time);
 
    BipGraph<Stop, int> graph(stops, students);
 
    printf("%d", graph.GetMaximumMatchingSize());
 
    return 0;
}
