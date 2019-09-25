#include <iostream>

int main()
{
	size_t Q; std::cin >> Q;
	for (size_t i = 0; i < Q; i++)
	{
		size_t n, countSoftwareOrder(0);  std::cin >> n;
		size_t *soldiers = new size_t[n];
		for (size_t i = 0; i < n; i++) std::cin >> soldiers[i];

		for (size_t i = 0; i < n - 1; i++)
		{
			for (size_t j = i + 1; j < n; j++)
			{
				if (soldiers[i] > soldiers[j])
				{
					countSoftwareOrder++;
				}
			}
		}
		std::cout << countSoftwareOrder << '\n';
		delete[] soldiers;
	}
	return 0;
}
