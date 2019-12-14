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

#include <iostream>
#include <vector>
#include <list>
using namespace std;

int main()
{
	int n, edges, i, start, end, curr;
	cin >> n >> edges;
	vector<vector<int>> prerequisites;
	for (i = 0; i < edges; ++i)
	{
		cin >> end >> start;
		prerequisites.push_back({ end,start });
	}

	vector<list<int>> going(n);
	vector<list<int>> coming(n);

	for (const auto& x : prerequisites)
	{
		coming[x[0]].push_back(x[1]);
		going[x[1]].push_back(x[0]);
	}

	list<int> topSort, noIncomingEdgeNodes;

	for (i = 0;i < n;++i)
	{
		if (coming[i].size() == 0) //no incoming edge
		{
			noIncomingEdgeNodes.push_back(i);
		}
	}

	while (!noIncomingEdgeNodes.empty())
	{
		curr = noIncomingEdgeNodes.front();
		noIncomingEdgeNodes.pop_front();

		topSort.push_back(curr);

		for (auto x : going[curr])
		{
			coming[x].pop_back();

			if (coming[x].size() == 0)
			{
				noIncomingEdgeNodes.push_back(x);
			}
		}
	}

	for (const auto& x : coming)
	{
		if (x.size())
		{
			cout << -1;// at least one cycle
			return 0;
		}
	}
	for (const auto& x : topSort)
	{
		cout << x << ' ';
	}

	return 0;
}
