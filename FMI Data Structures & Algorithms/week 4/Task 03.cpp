#include <iostream>

struct Snowman
{
	unsigned short value = 0;
	size_t total = 0;
	Snowman* previuos = nullptr;
};

int main()
{
	size_t N; std::cin >> N;
	Snowman* arr = new Snowman[N + 1]; //the first one is the zero snowman

	size_t dupTarget(0);
	unsigned short add(0);

	for (size_t i = 1; i < N + 1; i++)
	{
		std::cin >> dupTarget >> add;
		if (add == 0)
		{
			if (arr[dupTarget].previuos)
			{
				arr[i] = *arr[dupTarget].previuos;
			}
		}
		else
		{
			arr[i].value = add;
			arr[i].total = arr[dupTarget].total + add;
			arr[i].previuos = &arr[dupTarget];
		}
	}

	size_t sum(0);

	for (size_t i = 0; i < N + 1; i++)
	{
		sum += arr[i].total;
	}
	std::cout << sum;

	return 0;
}

