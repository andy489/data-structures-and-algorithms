#include <iostream>

int n, m; 
int* res, * aliceScores, * pos;
int getPlace(int x)
{
	int l = 0, r = n - 1;
	while (l < r)
	{
		if (res[(l + r) / 2] <= x)
		{
			r = (l + r) / 2;
		}
		else
		{
			l = (l + r) / 2 + 1;
		}
	}
	if (res[r] <= x)
	{
		return pos[r];
	}
	else
	{
		return pos[r] + 1;
	}
}

int main()
{
	res = new int[200000];	aliceScores = new int[200000];	pos = new int[200000];
	std::cin >> n;
	for (int i = 0; i < n; ++i) std::cin >> res[i];
	int currentPosition = 1;
	pos[0] = 1;
	for (int i = 1; i < n; ++i)
	{
		if (res[i] == res[i - 1])
		{
			pos[i] = currentPosition;
		}
		else
		{
			pos[i] = ++currentPosition;
		}
	}
	// for (int i = 0; i < n; i++) std::cout << pos[i] << ' ';
	std::cin >> m;
	for (int i = 0;i < m;++i)
	{
		std::cin >> aliceScores[i];
		std::cout << getPlace(aliceScores[i]) << std::endl;
	}
	delete[] res, delete[] aliceScores, delete[] pos;
}
