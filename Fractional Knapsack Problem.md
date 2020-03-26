## Fractional Knapsack Problem
A modification of the famous knapsack problem is the so-called [continuous (or fractional) knapsack problem](https://en.wikipedia.org/wiki/Continuous_knapsack_problem). 

We have **N** items, each with a certain **weight** and **price**. The knapsack has a **maximum capacity**, so we need to choose what to take in order to **maximize the value (price)** of the items in it. 

Unlike the classical version of the problem where an object should either be taken in its entirety or not at all, in this version **we can take a fraction of each item**. For example, such items may be liquids or powders; unlike solid objects which (presumably) we cannot split, we’ll assume that all items under consideration can be divided in any proportion. Therefore, the weight can be thought as the maximum quantity Q of an item we are allowed to take – we can take any amount in the range [0 … Q]. Note that in this version of the problem the knapsack will always be filled completely (if the total quantity of items is greater than its capacity).

Items will be given on separate lines in format **price -> weight**. Round all numbers to two digits after the decimal separator.

#### Examples
Input|Output
-|-
Capacity: 16<br>Items: 3<br>25 -> 10<br>12 -> 8<br>16 -> 8|Take 100% of item with price 25.00 and weight 10.00<br>Take 75.00% of item with price 16.00 and weight 8.00<br>Total price: 37.00
Capacity: 13<br>Items: 2<br>13 -> 7<br>15 -> 7|Take 100% of item with price 15.00 and weight 7.00<br>Take 85.71% of item with price 13.00 and weight 7.00<br>Total price: 26.14
Capacity: 22<br>Items: 4<br>50 -> 25<br>34 -> 25<br>41 -> 25<br>3 -> 25|Take 88.00% of item with price 50.00 and weight 25.00<br>Total price: 44.00
Capacity: 134<br>Items: 9<br>12 -> 14<br>45 -> 54<br>98 -> 78<br>21 -> 51<br>64 -> 11<br>90 -> 117<br>33 -> 17<br>64 -> 23<br>7 -> 3|Take 100% of item with price 64.00 and weight 11.00<br>Take 100% of item with price 64.00 and weight 23.00<br>Take 100% of item with price 7.00 and weight 3.00<br>Take 100% of item with price 33.00 and weight 17.00<br>Take 100% of item with price 98.00 and weight 78.00<br>Take 14.29% of item with price 12.00 and weight 14.00<br>Total price: 267.71
Capacity: 10<br>Items: 1<br>25 -> 5|Take 100% of item with price 25 and weight 5<br>Total price: 25.00

*Hints: Use a greedy algorithm: take the best item (max price / weight) as much as possible, then the next best item, etc.*

#### Solution

```cpp
#include <iostream>
#include <vector>
#include <algorithm>

struct Item {
	double price;
	double weight;
	double density;
	Item(double price, double weight); // constructor with parameters
	friend std::ostream& operator<<(std::ostream& os, const Item* item); // operator <<
};

struct byDensity {
	bool operator()(Item *a, Item *b) const {
		return a->density > b->density;
	}
};

std::vector<Item*> inputData(size_t items) {
	std::vector<Item*>allItems(items);

	for (size_t i = 0; i < items; i++) {
		double price, weight; std::cin >> price >> weight;
		Item* newItem = new Item(price, weight);
		allItems[i] = newItem;
	}
	return allItems;
}

void releaseVectorOfPointers(std::vector<Item*> &allItems) {
	size_t SIZE = allItems.size();
	for (size_t i = 0; i < SIZE; i++) {
		delete allItems[i];
	}
	allItems.clear();
}

void printItems(std::vector<Item*> allItems, size_t items) {
	for (size_t i = 0; i < items; i++) {
		std::cout << allItems[i];
	}
}

double getMin(double a, double b) {
	return a > b ? b : a;
}

int main() {
	std::cout << "Capacity: ";
	double capacity; std::cin >> capacity;
	std::cout << "Items: ";
	size_t items; std::cin >> items;

	std::vector<Item*>allItems = inputData(items);
	// sort descending starting from the most expensive
	sort(allItems.begin(), allItems.end(), byDensity());
	// printItems(allItems, items);
	size_t indx(0); double totalPrice(0.0);
	while (capacity > 0 && indx < items) {
		double currItemWeight = allItems[indx]->weight;
		double currItemPrice = allItems[indx]->price;
		double takenQuantity = getMin(capacity, currItemWeight);

		double percentageQuantity = takenQuantity / currItemWeight;

		totalPrice += percentageQuantity * currItemPrice;

		capacity -= takenQuantity;

		indx++;

		std::cout.setf(std::ios::fixed);
		std::cout.precision(2);
		std::cout << "Take " << percentageQuantity * 100 << "% of item with price " << currItemPrice << " and weight "
			<< currItemWeight<<'\n';
	}
	std::cout.setf(std::ios::fixed);
	std::cout.precision(2);
	std::cout << "Total price: " << totalPrice;
	releaseVectorOfPointers(allItems);
	return 0;
}

std::ostream & operator<<(std::ostream & os, const Item* item) {
	os << item->price << " -> " << item->weight << " quality/density " << item->density << '\n';
	return os;
}

Item::Item(double price, double weight) {
	this->price = price;
	this->weight = weight;
	this->density = price / weight;
}

```
