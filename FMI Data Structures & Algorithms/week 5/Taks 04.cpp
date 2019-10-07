#include <iostream>
#include <queue>

int main() 
{
	long long N;
	std::cin >> N;

	std::queue<long long> Q;
	for (char i = 1; i <= 9; i++) 
	{
		Q.push(i);
	}

	long long next;
	int lastDigit;
	while (Q.front() <= N) 
	{
		next = Q.front();
		std::cout << next << ' ';
		Q.pop();
		lastDigit = next % 10;
		if (lastDigit < 2) 
		{
			Q.push(next * 10 + lastDigit + 2);
		}
		else if (lastDigit > 7) 
		{
			Q.push(next * 10 + lastDigit - 2);
		}
		else 
		{
			Q.push(next * 10 + lastDigit - 2);
			Q.push(next * 10 + lastDigit + 2);
		}
	}
	return 0;
}
