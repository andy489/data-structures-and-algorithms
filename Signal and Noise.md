## The Signal and the Noise
Write a program which reads a sequence of non-negative integer numbers (in the decimal numeral system), separated by spaces, and finds the maximum number. The numbers in the input may have “noise” – symbols before, after, or between the digits of the number, which are not decimal digits (you need to ignore these when reading the numbers). All symbols in the input will be either letters, digits, punctuation, or signs from the standard ASCII table (no control symbols like newlines or tabs, delete, etc.)
#### Examples

Example input|Expected output|Explanation
-|-|-
5a3 1f a0aaaa f1fg3|53|The numbers are 53 1 0 13, of which 53 is the max
1 2 3|3|The numbers are 1 2 3, of which 3 is the max
1.][.3 5--aA3:)5 2asd=@14|535|The numbers are 13 535 214, of which 535 is the max

##Solution
```cpp
#include <iostream>
#include <string>
#include <stack>
//5a3 1f a0aaaa f1fg3
size_t largest(std::string& line)
{
	// помощен стек, в който ще си съхраняваме извадените числа
	std::stack<size_t> numbers;
	// идеята ми е да изваждаме числа от думата като в обратен полски запис или postfix запис
	size_t length = line.length();
	bool flag = false;
	for (size_t i = 0; i < length; i++) // O(n)
	{
		char curr = line[i];
		if (curr >= '0' && curr <= '9')
		{
			if (flag)
			{
				int number = numbers.top() * 10 + (line[i] - '0');
				numbers.pop(); // O(1)
				numbers.push(number); // O(1)
			}
			else
			{
				numbers.push(line[i] - '0'); // O(1)
				flag = true;
			}
		}
		else if (curr == ' ')
		{
			flag = false;
		}
	} // сега в помощния стек сме извадили всички числа, но в обратен ред, което в случая не е значимо
	size_t max(0);
	while (!numbers.empty()) // докато има числа в стека -> изкарваме и търсим най-голямото
	{
		if (numbers.top() > max) // O(1)
		{
			max = numbers.top(); // O(1)			
		}
		numbers.pop();
	}
	return max;
} // общо O(n) + нещо константно/изброимо, т.е. samo O(n) - което е линейно и е fine

int main()
{
	std::string sentence; getline(std::cin, sentence);
	std::cout << largest(sentence) << '\n';
	return 0;
}
```
