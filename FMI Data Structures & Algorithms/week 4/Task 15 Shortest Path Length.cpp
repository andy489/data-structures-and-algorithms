#include <iostream>
#include <vector>
#include <queue>
#include <utility>
#include <stack>
using namespace std;

int arr1[] = { 0,1,0,-1 };
int arr2[] = { -1,0,1,0 };
int n;

bool isValid(int i, int j, vector<vector<int>>& maze, vector<vector<int>>& used)
{
	if (i < 0 || j < 0 || i >= n || j >= n)
	{
		return false;
	}
	if (maze[i][j] == 1)
	{
		return false;
	}
	if (used[i][j] == 1)
	{
		return false;
	}
	return true;
}

void printPath(int startI, int startJ, int endI, int endJ,
	vector<vector<int>>& used, vector<vector<pair<int, int>>>& parent)
{
	if (used[endI][endJ] == 0)
	{
		cout << "no path\n";
		return;
	}
	pair<int, int> node = { endI,endJ };
	stack<pair<int, int>>S;
	while (node != pair<int, int>{-1, -1})
	{
		S.push(node);
		node = parent[node.first][node.second];
	}
	cout << "Path length is " << S.size() << '\n';
	while (!S.empty())
	{
		cout << "[" << S.top().first << ", " << S.top().second << "]\n";
		S.pop();
	}
}

void bfs(int startI, int startJ, int endI, int endJ,
	vector<vector<int>>& maze, vector<vector<int>>& used, vector<vector<pair<int, int>>>& parent)
{
	pair<int, int> point;
	queue<pair<int, int>> q;
	q.push({ startI,startJ });

	used[startI][startJ] = 1;
	parent[startI][startJ] = { -1,-1 };
	int x, y;
	while (!q.empty())
	{
		point = q.front();
		q.pop();

		for (int i = 0; i < 4; i++)
		{
			x = point.first + arr1[i];
			y = point.second + arr2[i];
			if (isValid(x, y, maze, used))
			{
				q.push({ x,y });
				used[x][y] = 1;
				parent[x][y] = { point.first,point.second };
				if (x == endI && y == endJ)
				{
					return;
				}
			}
		}
	}
}

int main()
{
	cin >> n;

	vector<vector<int>> maze(n);
	vector<vector<int>>used(n);
	vector<vector<pair<int, int>>> parent(n);

	for (int i = 0; i < n; i++)
	{
		maze[i] = vector<int>(n);
		used[i] = vector<int>(n, 0);
		parent[i] = vector<pair<int, int>>(n);
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> maze[i][j];
		}
	}

	int startI, startJ, endI, endJ;
	cin >> startI >> startJ >> endI >> endJ;
	cout << '\n';
	bfs(startI, startJ, endI, endJ, maze, used, parent);
	printPath(startI, startJ, endI, endJ, used, parent);

	return 0;
}

/*
5
0 0 0 0 0
0 1 1 1 1
0 0 0 1 1
1 1 0 0 0
1 1 1 0 1
0 4
4 3

3
0 0 0
0 1 1
0 0 0
0 2
2 2

6
1 1 0 1 1 1
0 0 0 0 0 0
1 1 1 0 0 0
1 1 1 1 0 0
0 0 1 0 0 0
0 0 0 0 1 1
0 2
4 1

4
0 1 0 0
0 0 1 0
0 0 0 1
1 0 0 0
0 0
1 3

*/
