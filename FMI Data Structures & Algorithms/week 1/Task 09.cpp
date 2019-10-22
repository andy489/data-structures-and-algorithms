#include <iostream>
#include <vector>

int main()
{
	int M, N;std::cin >> M >> N;
	std::vector<long long> results(N);
	long long sum(0);
	for (size_t i = 0; i < N; i++)
	{
		std::cin >> results[i];
		sum += results[i];
	}
	sum >= (long long)N * M ? std::cout << "yes\n" : std::cout << "no\n";
	return 0;
}
