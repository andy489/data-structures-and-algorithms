/* Ще сортираме скъпоценните камъни по най-добро съотношение цена/тегло 
и ще приложим greedy алгоритъм*/
#include <iostream>
#include <vector>
#include <algorithm>

struct Stone // скъпоценен камък
{
	double price; // цена
	double weight; // тегло
	double density; // съотношение между цена и тегло
	Stone(double price, double weight); // конструктор с два параметъра
	friend std::ostream& operator<<(std::ostream& os, const Stone* item); // оператор <<
};

struct byDensity // оператор () - възходящ ред по съотношение цена/тегло
{
	bool operator()(Stone *a, Stone *b) const
	{
		return a->density > b->density;
	}
};

std::vector<Stone*> inputData(size_t items)
{
	std::vector<Stone*>allStones(items);

	for (size_t i = 0; i < items; i++)
	{
		double price, weight; std::cin >> price >> weight;
		Stone* newItem = new Stone(price, weight);
		allStones[i] = newItem;
	}
	return allStones;
}

void releaseVectorOfPointers(std::vector<Stone*> &allStones)
{
	size_t SIZE = allStones.size();
	for (size_t i = 0; i < SIZE; i++)
	{
		delete allStones[i];
	}
	allStones.clear();
}

void printStones(std::vector<Stone*> allStones, size_t items)
{
	for (size_t i = 0; i < items; i++)
	{
		std::cout << allStones[i];
	}
}

double getMin(double a, double b)
{
	return a > b ? b : a;
}

int main()
{
	size_t N, K; std::cin >> N >> K; // N>=K

	std::vector<Stone*>allStones = inputData(N);
	// sort descending starting from the most expensive per unit weight
	sort(allStones.begin(), allStones.end(), byDensity());
	// printStones(allStones, items);
	size_t indx(0); double totalPrice(0);
	while (indx < K) // K<=N по условие!
	{
		totalPrice += allStones[indx]->price;
		indx++;
	}
	std::cout << totalPrice;
	return 0;
}

std::ostream & operator<<(std::ostream & os, const Stone* item)
{
	os << item->price << " -> " << item->weight << " quality/density " << item->density << '\n';
	return os;
}

Stone::Stone(double price, double weight)
{
	this->price = price;
	this->weight = weight;
	this->density = price / weight;
}
