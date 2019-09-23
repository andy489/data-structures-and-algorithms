/* We well use greedy algorithm. First we will sort the products prices by descending order 
and will discount every k-th product. In that way we will avoid paying most expensive products. */

#include <iostream>

size_t *inputData(size_t n)
{
	size_t *products = new size_t[n];
	for (size_t i = 0; i < n; i++) std::cin >> products[i];
	return products;
}

void bubbleSortDescending(size_t* arr, size_t arrLen)
{
	while (true)
	{
		bool swapped = false;
		for (size_t index = 0; index < arrLen - 1; index++)
		{
			if (arr[index] < arr[index + 1])
			{
				std::swap(arr[index], arr[index + 1]);
				swapped = true;
			}
		}
		if (!swapped) break;
	}
}

size_t minPrice(size_t* products, size_t n, size_t k)
{
	size_t minPrice(0);
	for (size_t i = 0; i < n; i++)
	{
		if ((i + 1) % k != 0) minPrice += products[i];
	}
	return minPrice;
}

int main()
{
	size_t n, k;
	std::cin >> n >> k;

	size_t* products = inputData(n);
	bubbleSortDescending(products, n);
	std::cout << minPrice(products, n, k);

	delete[] products;
	return 0;
}


/* //Or shortly:
#include <iostream>
#include <vector>
#include <algorithm>

int main()
{
	size_t n, k; std::cin >> n >> k;
	std::vector<size_t> products(n);
	for (size_t i = 0; i < n; i++) std::cin >> products[i];	
	sort(products.begin(), products.end(), std::greater<size_t>());
	size_t minBill(0);
	size_t SIZE = products.size();
	for (size_t i = 0; i < SIZE; i++) if ((i + 1) % k != 0) minBill += products[i];	
	std::cout << minBill;
	return 0;
}*/

