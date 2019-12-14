/*L <- Empty list that will contain the sorted elements
S <- Set of all nodes with no incoming edge
while S is non - empty do
remove a node n from S
add n to tail of L
for each node m with an edge e from n to m do
remove edge e from the graph
if m has no other incoming edges then
insert m into S
if graph has edges then
return error(graph has at least one cycle)
else
return L(a topologically sorted order)*/

class Solution {
	int i, curr;
public:
	vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
		vector<list<int>> going(numCourses), coming(numCourses);
		vector<int> topSort;

		for (const auto& x : prerequisites) {
			coming[x[0]].push_back(x[1]);
			going[x[1]].push_back(x[0]);
		}

		list<int> noIncomingEdgeNodes;

		for (i = 0;i < numCourses;++i) {
			if (coming[i].size() == 0) { //no incoming edge		
				noIncomingEdgeNodes.push_back(i);
			}
		}

		while (!noIncomingEdgeNodes.empty()) {

			curr = noIncomingEdgeNodes.front();
			noIncomingEdgeNodes.pop_front();

			topSort.push_back(curr);

			for (auto x : going[curr]) {
				coming[x].pop_back();

				if (coming[x].size() == 0) {
					noIncomingEdgeNodes.push_back(x);
				}
			}
		}
		for (const auto& x : coming) {
			if (x.size()) {
				vector<int> empty;
				return empty;
			}
		}
		return topSort;
	}
};
