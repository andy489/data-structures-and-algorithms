#include <iostream>
#include <queue>

int N, M, K; bool** maze; bool** visited;

// arrs to get row and col of 4 neighbours of a cell 
int rowNum[] = { -1, 0, 0, 1 };
int colNum[] = { 0, -1, 1, 0 };

struct Point
{
	int x;
	int y;
	Point(int x = 0, int y = 0);
};

struct queueNode
{
	Point p;
	int distance;
};

bool **inputLabyrinth()
{
	bool** maze = new bool*[N];
	for (int i = 0; i < N; i++)
	{
		maze[i] = new bool[M];
	}
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			std::cin >> maze[i][j];
		}
	}
	return maze;
}

void releaseLabyrinth()
{
	for (int i = 0; i < N; i++)
	{
		delete[] maze[i];
	}
	delete[] maze;
}

bool isValid(int row, int col)
{
	// return true if row and col are in range 
	return (row >= 0) && (row < N) && (col >= 0) && (col < M);
}

int minPath(Point src, Point dest) // BFS
{	// if src or dest are forbidden to step (they must both be 0)
	if (maze[src.x][src.y] || maze[dest.x][dest.y])	return -1;

	visited = new bool*[N];
	for (int i = 0; i < N; i++)
	{
		visited[i] = new bool[M]();
	}
	// we mark the src cell as visited
	visited[src.x][src.y] = true;

	std::queue<queueNode> q;

	queueNode s = { src,0 }; // distance of src cell is 0
	q.push(s); // enqueue src cell

	// Do a BFS starting from src cell
	while (!q.empty())
	{
		queueNode curr = q.front();
		Point p = curr.p;

		// exit condition (we have reached the dest cell)
		if (p.x == dest.x && p.y == dest.y) return curr.distance;

		// otherwise dequeue the front cell in the queue and enququq its adjacent cells
		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int row = p.x + rowNum[i];
			int col = p.y + colNum[i];
			//in range, stepable, not visited
			if (isValid(row, col) && !maze[row][col] && !visited[row][col])
			{
				// mark cell as visited and enqueue it
				visited[row][col] = true;
				queueNode adjecentCell = { {row,col},curr.distance + 1 };
				q.push(adjecentCell);
			}
		}
	}
	return -1; //if not reached
}

int main()
{
	std::cin >> N >> M >> K;
	maze = inputLabyrinth();

	for (int i = 0; i < K; i++)
	{
		int x, y; std::cin >> x >> y; // coordinates of dest
		Point src; // coordinates of source (constructor with default arguments)
		Point dest(x, y);

		int distance = minPath(src, dest);

		std::cout << "Shortest path is: " << distance << '\n';

		for (int i = 0; i < N; i++)
		{
			delete[] visited[i];
		}
		delete visited;
	}
	releaseLabyrinth();
	return 0;
}

Point::Point(int x, int y)
{
	this->x = x; this->y = y;
}
