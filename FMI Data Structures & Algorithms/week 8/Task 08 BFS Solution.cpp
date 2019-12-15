#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n;

vector<vector<char>> grid;
vector<vector<int>> shortestPaths;

vector<int>xd{ 0, 0,-1, 1 };
vector<int>yd{ 1,-1,0, 0 };

bool isValid(int x, int y, int prevX, int prevY)
{
	return x >= 0 && y >= 0
		&& x < n && y < n
		&& grid[x][y] == '.'
		&& (shortestPaths[x][y] == -1 ||
			shortestPaths[x][y] == shortestPaths[prevX][prevY] + 1);
}

void bfs(int sx, int sy, int ex, int ey)
{
	shortestPaths[sx][sy] = 0;

	queue<pair<int, int>> Q;
	Q.push({ sx,sy });

	while (!Q.empty())
	{
		pair<int, int>p = Q.front();
		Q.pop();

		for (size_t i = 0; i < 4; ++i)
		{
			int newX = p.first + xd[i];
			int newY = p.second + yd[i];

			while (isValid(newX, newY, p.first, p.second))
			{
				if (shortestPaths[newX][newY] != shortestPaths[p.first][p.second] + 1)
				{
					Q.push({ newX,newY });
				}
				shortestPaths[newX][newY] = shortestPaths[p.first][p.second] + 1;
				newX += xd[i];
				newY += yd[i];
			}
		}

	}
}

int main()
{
	int startX, endY, goalX, goalY, i, j;
	cin >> n;

	grid.assign(n, vector<char>(n));
	shortestPaths.assign(n, vector<int>(n, -1));

	for (i = 0; i < n; ++i)
	{
		for (j = 0; j < n; ++j)
		{
			cin >> grid[i][j];
		}
	}
	cin >> startX >> endY >> goalX >> goalY;

	bfs(startX, endY, goalX, goalY);

	cout << shortestPaths[goalX][goalY];

	return 0;
}
