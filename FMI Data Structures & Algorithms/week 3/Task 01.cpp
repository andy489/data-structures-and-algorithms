#include <iostream>

size_t getMinDaysRecursive(size_t sections)
{
	if (sections < 1) return 0;
	return getMinDaysRecursive(sections / 2) + 1;
}

size_t getMinDays(size_t sections)
{
	size_t result(0);
	while (sections > 0)
	{
		result++;
		sections /= 2;
	}
	return result;
}

void printResult(size_t *result, size_t n)
{
	for (size_t i = 0; i < n; i++) std::cout << result[i] << '\n';
}

int main()
{
	size_t T, N; std::cin >> T;
	size_t *result = new size_t[T];
	for (size_t i = 0; i < T; i++)
	{
		std::cin >> N;
		result[i] = getMinDaysRecursive(N); //result[i] = getMinDays(N);
	}
	printResult(result, T);
	return 0;
}
