#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

bool isValid(int x, int y, int n, int m, vector<vector<int>>& grid)
{
	return x < n && y < m && x >= 0 && y >= 0 && grid[x][y]==1;
}

int bfs(int x, int y, vector<vector<int>>& grid, int n, int m)
{
	int k; int cnt(0);
	vector<int> a = { -1,-1,-1, 0, 0, 1, 1, 1 }, b{ -1, 0, 1,-1, 1,-1, 0, 1 };
	queue<pair<int, int>>Q;
	Q.push({ x,y });

	while (!Q.empty())
	{
		cnt++;
		auto coord = Q.front();
		Q.pop();
		grid[coord.first][coord.second] = 0;

		for (k = 0; k < 8; ++k)
		{
			if (isValid(coord.first + a[k], coord.second + b[k], n, m, grid))
			{
				Q.push({ coord.first + a[k], coord.second + b[k] });
				grid[coord.first + a[k]][coord.second + b[k]] = 0;
			}
		}
	}
	return cnt;
}

int main()
{
	int n, m, i, j, area(0);
	cin>> n >> m;
	vector<vector<int>> grid(n);
	for (i = 0; i < n; ++i)
	{
		grid[i].resize(m);
	}
	for (i = 0; i < n; ++i)
	{
		for (j = 0; j < m; ++j)
		{
			cin >> grid[i][j];
		}
	}

	for (i = 0; i < n; ++i)
	{
		for (j = 0; j < m; ++j)
		{
			if (grid[i][j] != 0)
			{
				area = max(area, bfs(i, j, grid, n, m));
			}
		}
	}
	cout << area << '\n';
	return 0;
}
