// github.com/andy489

// https://leetcode.com/problems/course-schedule-ii

/*
Kahn's (bfs) Algorithm:
L <- Empty list that will contain the sorted elements
S <- Set of all nodes with no incoming edge
while S is non - empty do
remove a node u from S
add u to tail of L
for each node v with an edge e from u to v do
remove edge e from the graph
if v has no other incoming edges then
insert v into S
if graph has edges then
return error(graph has at least one cycle)
else
return L (a topologically sorted order)
*/

class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        int n = numCourses, i, curr;
        vector<list<int>> going(n), coming(n);
        
        for (const auto &x : prerequisites) {
            coming[x[0]].push_back(x[1]); // incoming edges
            going[x[1]].push_back(x[0]); // outgoing edges
        }
        
        list<int> noIncomingEdgeNodes;
        vector<int> topSort;
        
        for (i = 0; i < n; ++i)
            if (!coming[i].size()) //no incoming edge
                noIncomingEdgeNodes.push_back(i);
        
        while (!noIncomingEdgeNodes.empty()) {
            curr = noIncomingEdgeNodes.front();
            noIncomingEdgeNodes.pop_front();

            topSort.push_back(curr);

            for (auto x : going[curr]) {
                coming[x].pop_back();
                if (!coming[x].size())
                    noIncomingEdgeNodes.push_back(x);
            }
        }
        
        for (const auto &x : coming)
            if (x.size())
                return vector<int>(); // at least one cycle
        
        for (const auto &x : topSort)
            cout << x << ' ';
        
        return topSort;
    }
};

/*
#include <iostream>
#include <vector>
#include <list>

using namespace std;

int main() {
    int n, edges, i, start, end, curr;

    cin >> n >> edges;

    vector<pair<int, int>> prerequisites;

    for (i = 0; i < edges; ++i) {
        cin >> end >> start;
        prerequisites.push_back({end, start});
    }

    vector<list<int>> going(n), coming(n);

    for (const auto &x : prerequisites) {
        coming[x.first].push_back(x.second);
        going[x.second].push_back(x.first);
    }

    list<int> topSort, noIncomingEdgeNodes;

    for (i = 0; i < n; ++i)
        if (!coming[i].size()) //no incoming edge
            noIncomingEdgeNodes.push_back(i);


    while (!noIncomingEdgeNodes.empty()) {
        curr = noIncomingEdgeNodes.front();
        noIncomingEdgeNodes.pop_front();

        topSort.push_back(curr);

        for (auto x : going[curr]) {
            coming[x].pop_back();
            if (!coming[x].size())
                noIncomingEdgeNodes.push_back(x);
        }
    }

    for (const auto &x : coming)
        if (x.size())
            return cout << -1, 0; // at least one cycle

    for (const auto &x : topSort)
        cout << x << ' ';

    return 0;
}
*/
