#include <iostream>

size_t countInversions(size_t *arr, size_t n)
{
	size_t inversions(0);
	for (size_t i = 0; i < n - 1; i++)
	{
		for (size_t j = i + 1; j < n; j++)
		{
			if (arr[i] > arr[j])
			{
				inversions++;
			}
		}
	}
	return inversions;
}

int main()
{
	size_t Q; std::cin >> Q;
	for (size_t i = 0; i < Q; i++)
	{
		size_t n;  std::cin >> n;
		size_t *soldiers = new size_t[n];
		for (size_t i = 0; i < n; i++) std::cin >> soldiers[i];		
		std::cout << countInversions(soldiers, n) << '\n';
		delete[] soldiers;
	}
	return 0;
}
