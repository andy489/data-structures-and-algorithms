/* We search for the toy with lowest price and place it in front of the array of toys. We proceed iteratively proceed 
with the second toy with searching for toy with lowest price, among all left toys and stop when w exceed the budget*/
#include <iostream>

void swap(size_t& a, size_t& b)
{
	size_t tmp = a;
	a = b;
	b = tmp;
}

int main()
{
	size_t N, K; std::cin >> N >> K;
	size_t *toys = new size_t[N];
	for (size_t i = 0; i < N; i++) std::cin >> toys[i];

	size_t indx, i;
	size_t sum(0);

	for (i = 0; i < N; i++)
	{
		indx = i;
		for (size_t j = i + 1; j < N; j++)
		{
			if (toys[j] < toys[indx]) indx = j;
		}
		swap(toys[indx], toys[i]);
		sum += toys[i];
		if (sum > K)
		{
			std::cout << i;
			return 0;
		}
	}
	std::cout << i;
	return 0;
}
