#include <iostream> 
#include <cmath>
int result = 0;

int checkRecursive(int N, int X, int start, int K)
{
	if (X == 0)	result++;

	int r = (int)floor(pow(N, 1.0 / K));

	for (int i = start + 1; i <= r; i++)
	{
		int a = X - (int)pow(i, K);
		if (a >= 0)	checkRecursive(N, X - (int)pow(i, K), i, K);
	}
	return result;
}

int check(int N, int K)
{
	return checkRecursive(N, N, 0, K);
}

int main()
{
	int N, K; std::cin >> N >> K;
	std::cout << (check(N, K));
	return 0;
}
