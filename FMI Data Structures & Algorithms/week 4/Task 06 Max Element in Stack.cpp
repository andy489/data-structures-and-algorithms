//Find maximum in a stack in O(1) time and O(1) extra space
#include <iostream>
#include <stack>
using namespace std;

struct MyStack
{
	stack<int> S;
	int maxEl;

	void getMax()
	{
		if (S.empty())
		{
			cout << "Stack is empty\n";
		}
		else
		{
			cout << "Max: "
				<< maxEl << '\n';
		}
	}

	void peek()
	{
		if (S.empty())
		{
			cout << "Stack is empty ";
			return;
		}
		int t = S.top();
		cout << "Top: ";
		(t > maxEl) ? cout << maxEl : cout << t;
	}

	void pop()
	{
		if (S.empty())
		{
			cout << "Stack is empty\n";
			return;
		}
		cout << "Top most Element Removed ";
		int t = S.top();
		S.pop();

		if (t > maxEl)
		{
			cout << maxEl << '\n';
			maxEl = 3 * maxEl - t; // 2 * max - top
		}
		else cout << t << '\n';
	}

	void push(int x)
	{
		if (S.empty())
		{
			maxEl = x;
			S.push(x);
			cout << "Number Inserted: " << x << '\n';
			return;
		}

		if (x > maxEl)
		{
			S.push(3 * x - maxEl); // 2 * el - max
			maxEl = x;
		}

		else
		{
			S.push(x);
		}
		cout << "Number Inserted: " << x << '\n';
	}
};

int main()
{
	MyStack s;
	s.push(3);
	s.push(7);
	s.getMax();
	s.push(5);
	s.push(8);
	s.getMax();
	s.pop();
	s.getMax();
	s.pop();
	s.peek();

	return 0;
}
