## Fractional Knapsack Problem
A modification of the famous knapsack problem is the so-called [continuous (or fractional) knapsack problem](https://en.wikipedia.org/wiki/Continuous_knapsack_problem). 

We have **N** items, each with a certain **weight** and **price**. The knapsack has a **maximum capacity**, so we need to choose what to take in order to **maximize the value (price)** of the items in it. 

Unlike the classical version of the problem where an object should either be taken in its entirety or not at all, in this version **we can take a fraction of each item**. For example, such items may be liquids or powders; unlike solid objects which (presumably) we cannot split, we will assume that all items under consideration can be divided in any proportion. Therefore, the weight can be thought as the maximum quantity Q of an item we are allowed to take – we can take any amount in the range [0…Q]. Note that in this version of the problem the knapsack will always be filled completely (if the total quantity of items is greater than its capacity).

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
#include <sstream>

using namespace std;

struct Item {
    double price;
    double weight;
    double density;

    Item() = default;

    friend ostream &operator<<(ostream &os, const Item *item) {
        os << item->price << " -> " << item->weight << " quality/density " << item->density << '\n';
        return os;
    }
};

struct By_density {
    bool operator()(Item a, Item b) const {
        return a.density > b.density;
    }
};

void input_data(vector<Item> &all_items, int n) {
    all_items.resize(n);

    string line;
    cout << "Enter every item on a new line with"
         << "price and weight separated by arrows \" -> \": "
         << endl;

    cin.ignore();
    double cost, weight;
    for (int i = 0; i < n; ++i) {
        cout << "Item " << i + 1 << ": ";

        getline(cin, line);

        istringstream iss(line);

        iss >> cost;
        for (int i = 0; i < 4; ++i) {
            iss.ignore();
        }
        iss >> weight;

        Item *current_item = &all_items[i];

        current_item->weight = weight;
        current_item->price = cost;
        current_item->density = cost / weight;
    }
}

void print_items(const vector<Item> &all_items) {
    const int N = all_items.size();

    for (int i = 0; i < N; ++i) {
        cout << &all_items[i];
    }
}

double get_min(double a, double b) {
    return a > b ? b : a;
}

int main() {
    cout << "Capacity: ";
    double capacity;
    cin >> capacity;

    cout << "Items: ";
    int items;
    cin >> items;

    vector<Item> all_items;

    input_data(all_items, items);

    sort(all_items.begin(), all_items.end(), By_density());

    print_items(all_items);

    int index = 0;
    double total_price = 0.0;

    while (capacity > 0 && index < items) {
        double curr_item_weight = all_items[index].weight;
        double curr_item_cost = all_items[index].price;

        double taken_quantity = get_min(capacity, curr_item_weight);
        double percentage_quantity = taken_quantity / curr_item_weight;

        total_price += percentage_quantity * curr_item_cost;
        capacity -= taken_quantity;

        index++;

        cout.setf(ios::fixed);
        cout.precision(2);
        cout << "Take "
             << percentage_quantity * 100
             << "% of item with price "
             << curr_item_cost << " and weight "
             << curr_item_weight << endl;
    }

    cout.setf(ios::fixed);
    cout.precision(2);

    cout << "Total price: " << total_price;

    return 0;
}

```
