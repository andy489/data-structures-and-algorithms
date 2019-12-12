#include <iostream>
#include <vector>
#include <queue>
#include <sstream>

using namespace std;
typedef vector<int> vi;
typedef vector<vi> vvi;
#define TABLE_SIZE 101
#define DICE 6

void createEmptyTable(vvi& table)
{
	int i, j;
	for (i = 1; i < TABLE_SIZE; ++i)
	{
		for (j = 1; j <= DICE; ++j)
		{
			if (i + j < TABLE_SIZE)
			{
				table[i].push_back(i + j);
			}
		}
	}
}

void readLadders(vvi& table)
{
	int ladders, i, ls, le;
	cin >> ladders;
	for (i = 0; i < ladders; ++i)
	{
		cin >> ls >> le;
		table[ls].clear();
		
		for (int j = DICE; j >=1; --j)
		{
			if (ls - j > 0)
			{
				table[ls - j].push_back(le);
			}
		}
	}
}

void readSnakes(vvi& table)
{
	int snakes, i,j, head, tail;
	cin >> snakes;
	for (i = 0; i < snakes; i++)
	{
		cin >> head >> tail;
		table[head].clear();
		for (j = DICE; j >=1; --j)
		{
			if (head - j > 0)
			{
				table[head - j].push_back(tail);
			}

		}		
	}
}

struct Graph
{
	const vvi& adj;

	Graph(const vvi& adj) :adj(adj) {}

	int bfs(int start)
	{
		int level = 0;
		queue<int> Q;
		vector<bool> visited(TABLE_SIZE);
		Q.push(start);
		visited[start] = true;

		int SIZE = Q.size();

		while (!Q.empty())
		{
			while (SIZE--)
			{
				int curr = Q.front();
				Q.pop();

				for (size_t i = 0; i < adj[curr].size(); i++)
				{
					if (!visited[adj[curr][i]])
					{
						if (adj[curr][i] == TABLE_SIZE - 1)
						{
							return level + 1;
						}
						Q.push(adj[curr][i]);
						visited[adj[curr][i]] = true;
					}
				}
			}
			SIZE = Q.size();
			level++;
		}
		return -1;
	}
};

int main()
{
	int tests;
	cin >> tests;

	ostringstream ostr;

	for (int i = 0; i < tests; ++i)
	{
		vvi table(TABLE_SIZE);
		createEmptyTable(table);
		readLadders(table);
		readSnakes(table);

		Graph G(table);
		ostr << G.bfs(1) << '\n';
	}
	cout << ostr.str();
	return 0;
}
