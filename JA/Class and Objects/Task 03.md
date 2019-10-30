## Task 3 – Sales
Write a class **Sale** holding the following data: **town, product, price, quantity**. Read a **list of sales** and calculate and print the **total sales by town** as shown in the output. Order the towns **alphabetically** in the output.
#### Examples
Input|Output|Comments
-|-|-
5<br>Sofia beer 1.20 160<br>Varna chocolate 2.35 86<br>Sofia coffee 0.40 853<br>Varna apple 0.86 75.44<br>Plovdiv beer 1.10 88|Plovdiv -> 96.80<br>Sofia -> 533.20<br>Varna -> 266.98|Plovdiv -> 1.10 * 88 = 96.80<br>Sofia -> 1.20 * 160 + 0.40 * 853 = 533.20<br>Varna -> 2.35 * 86 + 0.86 * 75.44 = 266.98

```cpp
#include <iostream>
#include <sstream>
#include <map>
using namespace std;
//no need for class, but
/*class Sale
{
public:
	string town, prod;
	double price, qu;
	Sale(string town, string prod, double price, double qu) :
		town(town), prod(prod), price(price), qu(qu) {}
};*/
int main()
{
	int n;
	cin >> n;
	map<string, double> sales;
	string town, prod;
	double price, qu;
	for (int i = 0; i < n; i++)
	{
		cin >> town >> prod;
		cin >> price >> qu;
		sales[town] += price * qu;
	}
	cout.precision(2);
	cout << fixed;
	for (const auto& s : sales)
		cout << s.first << " -> " << s.second << '\n';;

	return 0;
}

```
