// github.com/andy489

#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <sstream>
using namespace std;

struct Cell {
	int x, y, level;
	bool visited, accessible;
	Cell* prev = nullptr;
	Cell(bool visited = 0, bool accessible = 0, int level = -1, int x = 0, int y = 0) :
		visited(visited), accessible(accessible), level(level), x(x), y(y) {};
};

struct Maze {
	vector<int> row{ 0,1,0,-1 }, col{ -1,0,1,0 };
	int w, h;
	vector<vector<Cell>> maze;
	Maze(int w, int h) :w(w), h(h) {
		maze = vector<vector<Cell>>(h);
		for (int i = 0; i < w; i++) {
			maze[i] = vector<Cell>(h);
		}
	}

	void readInput() {
		int i, j;
		for (i = 0; i < h; ++i) {
			for (j = 0; j < w; ++j) {
				cin >> maze[i][j].accessible;
				maze[i][j].x = i;
				maze[i][j].y = j;
			}
		}
	}

	bool valid(int x, int y) {
		return x >= 0 && y >= 0 && x < h && y < w
			&& maze[x][y].accessible == 0 && maze[x][y].visited == 0;
	}

	void computePaths(int startX, int startY) {
		queue<Cell*>Q;
		maze[startX][startY].visited = 1;
		maze[startX][startY].level = 0;
		Cell* dummy = &maze[startX][startY];

		Cell* currCell = nullptr;

		Q.push(dummy);
		int X, Y;
		while (!Q.empty()) {
			currCell = Q.front();
			Q.pop();
			size_t SIZE = row.size();
			for (size_t i = 0; i < SIZE; ++i) {
				X = currCell->x + row[i];
				Y = currCell->y + col[i];
				if (valid(X, Y)) {
					maze[X][Y].level = currCell->level + 1;
					maze[X][Y].visited = 1;
					maze[X][Y].prev = currCell;
					Q.push(&maze[X][Y]);
				}
			}
		}
	}
	int getLevel(int x, int y) {
		return maze[x][y].level;
	}

	ostringstream getPath(int x, int y) {
		stack<Cell*> S;
		Cell* end = &maze[x][y];
		while (end != nullptr) {
			S.push(end);
			end = end->prev;
		}
		ostringstream ostr;
		if (S.empty()) {
			ostr << "no path\n";
			return ostr;
		}		
		ostr << "path:\n";
		while (!S.empty()) {
			ostr << "[" << S.top()->x << "," << S.top()->y << "]\n";
			S.pop();
		}
		ostr << "-----\n";
		return ostr;
	}

	void displayMazeLevels() {
		int i, j;
		for (i = 0; i < h; ++i) {
			for (j = 0; j < w; ++j) {
				cout << maze[i][j].level << "  ";
			}
			cout << '\n';
		}
	}
};


int main() {
	int M, N, K, i, startX, startY, endX, endY;
	cin >> M >> N >> K >> startX >> startY;
	Maze maze(M, N);
	maze.readInput();
	maze.computePaths(startX, startY);

	cout << '\n'; maze.displayMazeLevels();

	queue<int>results;
	queue<ostringstream>paths;

	for (i = 0; i < K; ++i) {
		cin >> endX >> endY;
		if (endX >= 0 && endY >= 0 && endX < M && endY < N && maze.maze[endX][endY].level!=-1) {
			results.push(maze.getLevel(endX, endY));
			paths.push(maze.getPath(endX,endY));
		}
		else {
			results.push(-1);		
			paths.push(ostringstream("no path\n-----\n"));
		}		
	}
	while (!results.empty()) {
		cout << "distance "<<results.front() << '\n';
		results.pop();
		cout<<paths.front().str();
		paths.pop();
	}	
	return 0;
}

/*
5 5 8 3 3
0 0 0 0 0
0 0 0 0 0
1 1 0 0 0
0 1 0 0 0
1 1 0 0 0
0 0
3 0
3 3
4 4
-2 2
5 4
4 0
4 0
*/
