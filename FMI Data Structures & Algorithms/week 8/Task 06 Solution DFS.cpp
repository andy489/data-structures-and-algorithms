/*L <- Empty list that will contain the sorted nodes
while exists nodes without a permanent mark do
select an unmarked node n
visit(n)

function visit(node n)
if n has a permanent mark then return
if n has a temporary mark then stop(not a DAG)
mark n with a temporary mark
for each node m with an edge from n to m do
visit(m)
remove temporary mark from n
mark n with a permanent mark
add n to head of L*/

class Solution {
	int i, n;
	bool cycle = false;

	void dfs(int s,
		vector<bool>& perm_mark,
		vector<bool>& temp_mark,
		vector<list<int>>& going,
		list<int>& topSort, bool& flag) {
		if (flag) return;
		if (perm_mark[s]) return;
		if (temp_mark[s]) goto notDAG;
		temp_mark[s] = true;
		for (const auto& x : going[s]) {
			dfs(x, perm_mark, temp_mark, going, topSort, flag);
		}
		temp_mark[s] = false;
		perm_mark[s] = true;
		topSort.push_front(s);
		if (1 == 2) {
		notDAG: flag = true;
		}
	}
public:
	vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
		n = numCourses;
		vector<list<int>> going(n);

		for (const auto& x : prerequisites) {
			going[x[1]].push_back(x[0]);
		}

		list<int> topSort;
		vector<bool> temp_mark(n), perm_mark(n);

		vector<int>ans;

		for (i = 0; i < n; ++i) {
			if (!perm_mark[i]) {
				dfs(i, perm_mark, temp_mark, going, topSort, cycle);
			}
		}
		if (cycle) return ans;
		for (const auto& x : topSort) {
			ans.push_back(x);
		}
		return ans;

	}
};
