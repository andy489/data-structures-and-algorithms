## Task 2 – Distance
Write a program to calculate the (Euclidean) distance between two points p1 {x1, y1} and p2 {x2, y2}. You should write a class to represent such points and a method in it which calculates the distance from the point to another point.
#### Examples
Input|Output
-|-
3 4<br>6 8|5.000
3 4<br>5 4|2.000
8 -2<br>-1 5|11.402

#### Solution
```cpp
#include <iostream>
#include <cmath>
using namespace std;

class Point
{
	double x, y;
public:
	Point(double x = 0, double y = 0) :x(x), y(y) {}
	double distance(const Point& p)
	{
		return sqrt(pow(x - p.x, 2) + pow(y - p.y, 2));
	}
};

int main()
{
	double x1, y1, x2, y2;
	cin >> x1 >> y1;
	Point P1(x1, y1);
	cin >> x2 >> y2;
	Point P2(x2, y2);

	cout.precision(3);
	cout<< fixed;
	cout << P1.distance(P2);

	return 0;
}

```
