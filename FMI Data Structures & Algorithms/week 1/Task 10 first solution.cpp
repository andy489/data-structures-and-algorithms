#include <iostream>
#include <vector>

int min(int a, int b)
{
	return a > b ? b : a;
}

int main()
{
	int N;std::cin >> N;
	std::vector<int> walls(N);

	for (int i = 0; i < N; i++)
	{
		std::cin >> walls[i];
	}

	int maxWater(0);

	for (int i = 0; i < N; i++)
	{
		int currWall = walls[i];
		for (int j = i+1; j < N; j++)
		{
			if ((j - i) * min(walls[i], walls[j]) > maxWater)
			{
				maxWater = (j - i) * min(walls[i], walls[j]);
			}
		}
	}
	std::cout << maxWater;

	return 0;
}
