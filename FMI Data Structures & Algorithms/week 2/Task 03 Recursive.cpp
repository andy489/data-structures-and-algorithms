/* My Recursive Solution (true masterpiece). Idea: look up for the cheapest toy in the array (recursively: which one is cheaper - 
the first or the cheaper in all other toys except the first one?) and move it in front of the array.
After that recursively repeat the same operation for the remaining array (without the first element) */
#include <iostream>

size_t getIndexOfMinPrice(size_t *toys, size_t start, size_t end)
{	// recursive function to get the index of the smallest element in RANGE from array
	if (start == end) return start; // base case (exit case)
	else
	{	// dive in
		return (toys[getIndexOfMinPrice(toys, start + 1/*incremanting lower bound of range*/, end)]
			< toys[start]) ? getIndexOfMinPrice(toys, start + 1, end) : start; // recursive call
	}
}

void swap(size_t &lego, size_t& doll)
{
	size_t temp = lego;
	lego = doll;
	doll = temp;
}

int main()
{
	size_t N; int K; std::cin >> N >> K;
	size_t *toys = new size_t[N];
	for (size_t i = 0; i < N; i++)std::cin >> toys[i];

	size_t countToys(0);

	while (true)
	{
		size_t cheaperToyIndex = getIndexOfMinPrice(toys, countToys, N - 1);
		K -= toys[cheaperToyIndex]; // spending money
		if (K >= 0) // while still having money -> buy toys
		{
			if (countToys == (int)N - 1) // if bought all the toys
			{
				countToys++;
				break;
			}// move the cheapest toy to the FRONT of the CURRENT array
			swap(toys[cheaperToyIndex], toys[countToys]); 
			countToys++;
		}
		else break;
	}
	std::cout << countToys;
	return 0;
}

