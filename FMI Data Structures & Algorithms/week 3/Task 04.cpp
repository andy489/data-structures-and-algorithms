#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>

struct Building
{
	int height = 0;
	int price = 0;
};

bool CompareHeight(Building& lhs, Building& rhs)
{
	return (lhs.height < rhs.height); // || (lhs.height == rhs.height && lhs.price < rhs.price));
}

bool ComparePrice(Building& lhs, Building& rhs)
{
	return (lhs.price < rhs.price); // || (lhs.price == rhs.price && lhs.height < rhs.height));
}

int Price(Building* buildings, int arrSize, int height)
{
	int price(0);
	for (int i = 0; i < arrSize; i++)
	{
		price += abs(buildings[i].height - height) * buildings[i].price;
	}
	return price;
}

bool BuildingEqual(const Building& a, const Building& b)
{
	return (a.height == b.height && a.price == b.price);
}

int Min(int a, int b)
{
	return a < b ? a : b;
}

int MinPriceTernaryNaive(Building* buildings, int size, int left, int right) 
{
	if (right - left < 3)
	{
		int currentMin = Price(buildings, size, left);
		for (int i = left + 1; i < right + 1; i++) 
		{
			currentMin = Min(currentMin, Price(buildings, size, i));
		}
		return currentMin;
	}
	else if (left < right)
	{
		int leftThird = left + (right - left) / 3;
		int rightThird = right - (right - left) / 3;

		int leftPrice = Price(buildings, size, leftThird);
		int rightPrice = Price(buildings, size, rightThird);

		if (leftPrice < rightPrice)
		{
			return MinPriceTernaryNaive(buildings, size, left, rightThird);
		}
		else if (leftPrice > rightPrice)
		{
			return MinPriceTernaryNaive(buildings, size, leftThird, right);
		}
		else
		{
			return Min(Min(MinPriceTernaryNaive(buildings, size, left, leftThird), MinPriceTernaryNaive(buildings, size, leftThird, rightThird)),
				MinPriceTernaryNaive(buildings, size, rightThird, right));
		}
	}
	return -1;
}

int MinPriceTernary(Building* buildings, int size, Building* unique, int uniqueSize, int left, int right)
{
	if (right - left < 3)
	{
		int currentMin = Price(buildings, size, buildings[left].height);
		for (int i = left + 1; i < right + 1; i++)
		{
			currentMin = Min(currentMin, Price(buildings, size, buildings[i].height));
		}
		return currentMin;
	}
	else if (left < right)
	{
		int leftThird = left + (right - left) / 3;
		int rightThird = right - (right - left) / 3;

		int leftPrice = Price(buildings, size, buildings[leftThird].height);
		int rightPrice = Price(buildings, size, buildings[rightThird].height);

		if (leftPrice < rightPrice)
		{
			return MinPriceTernary(buildings, size, unique, uniqueSize, left, rightThird);
		}
		else if (leftPrice > rightPrice)
		{
			return MinPriceTernary(buildings, size, unique, uniqueSize, leftThird, right);
		}
		else
		{ 
			return Min(Min(MinPriceTernary(buildings, size, unique, uniqueSize, left, leftThird), MinPriceTernary(buildings, size, unique, uniqueSize, leftThird, rightThird)),
				MinPriceTernary(buildings, size, unique, uniqueSize, rightThird, right));
		}
	}
	return -1;
}

int main()
{
	int N; std::cin >> N;
	Building* buildings = new Building[N];
	for (int i = 0; i < N; i++)
	{
		std::cin >> buildings[i].height;
	}
	for (int i = 0; i < N; i++)
	{
		std::cin >> buildings[i].price;
	}
	std::sort(buildings, buildings + N, CompareHeight);
	if (N > 1)
	{
		std::cout << MinPriceTernaryNaive(buildings, N, buildings[0].height, buildings[N - 1].height);
	}
}

