## Egyptian Fractions
In mathematics, a fraction is the rational number <img src="https://latex.codecogs.com/svg.latex?\Large&space;\frac{p}{q}"> where <img src="https://latex.codecogs.com/svg.latex?\Large&space;p"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;q"> are integers. An Egyptian fraction is a sum of fractions, each with numerator <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> where all denominators are different, e.g. <img src="https://latex.codecogs.com/svg.latex?\Large&space;\frac{1}{2}+\frac{1}{3}+\frac{1}{16}"> is an Egyptian fraction, but <img src="https://latex.codecogs.com/svg.latex?\Large&space;\frac{1}{3}+\frac{1}{3}+\frac{1}{5}"> is not (repeated denominator <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">). 
Every positive fraction <img src="https://latex.codecogs.com/svg.latex?\Large&space;(q\neq{0},{\:}p<q)"> can be represented by an Egyptian fraction, for instance, <img src="https://latex.codecogs.com/svg.latex?\Large&space;\frac{43}{48}=\frac{1}{2}+\frac{1}{3}+\frac{1}{16}">. Given <img src="https://latex.codecogs.com/svg.latex?\Large&space;p"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;q">, write a program to represent the fraction <img src="https://latex.codecogs.com/svg.latex?\Large&space;\frac{p}{q}"> as an Egyptian fraction.
#### Examples
Input|Output
-|-
43/48|43/48 = 1/2 + 1/3 + 1/16
3/7|3/7 = 1/3 + 1/11 + 1/231
23/46|23/46 = 1/2
22/7|Error (fraction is equal to or greater than 1)
134/3151|134/3151 = 1/24 + 1/1164 + 1/2445176

**Note**: There may be more than one correct solution, e.g. 3/7 = 1/4 + 1/8 + 1/19 + 1/1064. If you follow the greedy algorithm logic, you should get the solutions given in the input/output examples.

*Hints
You can complete the expression by starting with the biggest fraction with numerator 1 which added to the expression keeps it smaller than or equal to the target fraction. The biggest fraction is the one with smallest denominator – 1/2. Increase the denominator until you’ve found a solution.


#### Solution
```cpp
#include <iostream>
#include <string>
#include <stack>
#include <vector>

void getRational(long &nom, long &denom)
{
	std::string s; std::cin >> s;
	size_t len = s.length();
	s += '\0';
	std::stack<long> S; S.push(0);

	for (size_t i = 0; i <= len; i++)
	{
		if (s[i] >= '0' && s[i] <= '9')
		{
			long num = S.top() * 10 + s[i] - '0'; S.pop();
			S.push(num);
		}
		else
		{
			if (i != len)
			{
				nom = S.top();
				S.pop(); S.push(0);
			}
			else
			{
				denom = S.top();
				S.pop();
			}
		}
	}
}

int main()
{
	long num, denom;
	getRational(num, denom);
	std::cout << num << '/' << denom << " = ";

	if (denom<num)
	{
		std::cout << "Error (fraction is equal to or greater tha 1)\n";
		return 0;
	}

	std::vector<long> res;

	size_t indxDenom(2); // 3/7 - 1/2
	while (num != 0)
	{
		long diff = num * indxDenom - denom; // 3*2 - 1*7 < 0 ?
		if (diff < 0)
		{
			indxDenom++;
			continue;
		}
		res.push_back(indxDenom);

		num = diff;
		denom = denom*indxDenom;
		indxDenom++;
	}
	size_t resLen = res.size();
	for (size_t i = 0; i < resLen-1; i++)
	{
		std::cout << "1/" << res[i] << " + ";
	}
	std::cout << "1/"<<res[resLen - 1];

	return 0;
}
```
