## Merge Trains
At a certain train station, trains arrive on two tracks – Track A and Track B – and are merged onto a single track. Each railcar has a number, and in each train the railcars are ordered by number – the front railcar has the lowest number, the back railcar has the highest number. 
Given the railcar numbers on Track A and Track B, given from the back car to the front car, output the order in which railcars from Track A and Track B should be merged into the single track, then output the new train configuration, starting from the last railcar, and finishing at the first railcar. Railcars are moved starting from the front to the back (i.e. you can only move the front car of a train). Each time you move a railcar from the parallel tracks A and B to the merge track, it pushes forward any railcars that are already there.
The first line of the console will contain the numbers of the railcars on Track A, from the last railcar to the first railcar.
The second line of the console will contain the numbers of the railcars on Track B, from the last railcar to the first railcar.
If a railcar from Track A should be moved to the single track, print A. Otherwise, print B. 
On a separate line print the final configuration of the train (numbers separated by spaces, representing the railcar numbers from the last railcar to the first).
The “input” railcars will always be correctly ordered (i.e. will be a line of descending positive integer numbers). The input will be such that the result will never have any railcars with the same numbers.
Examples
Input	Output	Explanation
11 4 2 1
5 3	AABABA
11 5 4 3 2 1	We first move from A, railcar 1, and the result becomes:
1
We again move from A, railcar 2, which pushes railcar 1 more to the right:
2 1
Now we need B (the rightmost of A is 4, the rightmost of B is 3), which again pushes the railcars in the merge:
3 2 1
We now again need A:
4 3 2 1
Back to B, that's the last railcar there:
5 4 3 2 1
Finally we move the last from A and get the result:
11 5 4 3 2 1

- the sequence was AABABA
2
1	BA
2 1	Only two railcars, line B has the smaller railcar, so move that first, then move from A





#### Solution

```cpp
#include <iostream>
#include <string>
#include <sstream>
#include <queue>
#include <stack>

struct RailCar
{
	int num;
	char ch;
	RailCar(int num, char ch) :num(num), ch(ch) {};
};

struct cmpNum
{
	bool operator()(RailCar const& carLeft, RailCar const& carRight)
	{
		return carLeft.num > carRight.num;
	}
};

int main()
{
	using namespace std;
	priority_queue<RailCar, vector<RailCar>, cmpNum> Q; stack<int> S;

	for (size_t i = 65; i <= 66; i++) // 65 & 66 ASCII кодовете на 'A' и 'B'
	{		
			string trains; getline(cin, trains); istringstream istr(trains);
			string num;
			getline(istr, num, ' ');
			while (istr)
			{
				RailCar car(stoi(num),i); // конструктур с два параметъра, i е ASCII кода на желаната буква
				Q.push(car);
				getline(istr, num, ' ');
			}		
	}	
	while (!Q.empty()) // вадим от приоритетната опашка (дърво) номерата на вагоните
	{
		std::cout << Q.top().ch;
		S.push(Q.top().num); // слагаме буквите на вагоните във стек, защото ще ни трябват в обратен ред
		Q.pop();
	}
	cout << '\n';
	while (!S.empty()) // вадим буквите от стека и знаем, че ще са в искания ред
	{
		std::cout << S.top() << ' ';
		S.pop();
	}
	return 0;
}
```
