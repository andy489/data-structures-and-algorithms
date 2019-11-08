// Function that removes all min elements in a queue
#include <iostream>
#include <queue>
#include <climits>
#include <ctime>

using namespace std;

void displayQueue(queue<int> q) // makes a copy
{
	while (!q.empty())
	{
		cout << q.front() << ' ';
		q.pop();
	}
	cout << '\n';
}

void removeMinElementsFromQueue(queue<int>& q) // works with original
{
	int min(INT_MAX), count(0), currEl;

	size_t SIZE = q.size();
	if (SIZE == 0) return;
	// 5 3 1 4 2 5 6 2 5 5 7 3 5 1
	while (SIZE)
	{
		currEl = q.front();
		q.pop();
		if (min > currEl)
		{
			if (min != INT_MAX)
			{
				while (count)
				{
					q.push(min);
					count--;
				}
			}
			min = currEl;
			count++;
		}
		else if (min == currEl)
		{
			count++;
		}
		else
		{
			q.push(currEl);
		}
		SIZE--;
	}
}

int main()
{
	queue<int> q;

	srand((size_t)time(0));

	size_t n = 10 + rand() % 15;

	for (size_t i = 0; i < n; i++)
	{
		q.push(1 + rand() % 10);
	}
	
	displayQueue(q);

	removeMinElementsFromQueue(q);
	displayQueue(q);

	removeMinElementsFromQueue(q);
	displayQueue(q);

	removeMinElementsFromQueue(q);
	displayQueue(q);
	//etc.
	return 0;
}
