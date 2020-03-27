## Task 1 The Signal and the Noise
Write a program which reads a sequence of non-negative integer numbers (in the decimal numeral system), separated by spaces, and finds the maximum number. The numbers in the input may have “noise” – symbols before, after, or between the digits of the number, which are not decimal digits (you need to ignore these when reading the numbers). All symbols in the input will be either letters, digits, punctuation, or signs from the standard ASCII table (no control symbols like newlines or tabs, delete, etc.)
#### Examples

Example input|Expected output|Explanation
-|-|-
5a3 1f a0aaaa f1fg3|53|The numbers are 53 1 0 13, of which 53 is the max
1 2 3|3|The numbers are 1 2 3, of which 3 is the max
1.][.3 5--aA3:)5 2asd=@14|535|The numbers are 13 535 214, of which 535 is the max

## Solution Task 1
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

## Task 2 – The Noise and the Signal
Your task here is to find the longest noise in a number (numbers will always be positive integers). There are several noises with equal length, print the one that is the first lexicographically. If there are no noises, print “no noise”. All symbols in the input will be either letters, digits, punctuation, or signs from of the standard ASCII table (no control symbols like newlines or tabs, delete, etc.)
#### Examples

Expected input|Expected output|Explanation
-|-|-
5bbbb3 1f a0aaa f1fg3|aaaa|The noises are bbbb f aaaa ffg, aaaa and bbbb are equal length, but aaaa is before bbbb lexicographically
1 2 3|no noise	
1.][.3 5-aA3:)5 2asd=@14|–aA:)|The noises are .][. –aA:) asd=@, of which –aA:) and asd=@ are of equal max length (5), but in the ASCII table, the – sign ("hyphen-minus") is before the letter a, so –aA:) is the first lexicographically

## Solution Task 2
```cpp
#include <iostream>
#include <string>
#include <stack>

bool lenlexcmp(std::string& l, std::string& r)
{
	size_t len_l = l.size();
	size_t len_r = r.size();
	if (len_l > len_r) return true;
	else if (len_l < len_r) return false;
	else
	{
		for (size_t i = 0; i < len_r; i++)
		{
			if (l[i] < r[i])
			{
				return true;
			}
			else if (l[i] > r[i])
			{
				return false;
			}
		}
	}
	return len_l > len_r ? true : false;
}

std::string longest(std::string& line) // 1.][.3 5-aA3:)5 2asd=@14
{
	// помощен стек, в който ще си съхраняваме извадените "думи"
	std::stack<std::string> words;

	size_t length = line.length();
	bool flag = false;
	for (size_t i = 0; i < length; i++) // O(n)
	{
		char curr = line[i];
		if ((curr < '0' || curr > '9') && curr != ' ')
		{
			if (flag)
			{
				std::string currWord = words.top() + curr;
				words.pop(); // O(1)
				words.push(currWord); // O(1)
			}
			else
			{
				std::string newWord("");
				newWord += curr;
				words.push(newWord); // O(1)
				flag = true;
			}
		}
		else if (curr == ' ')
		{
			flag = false;
		}

	} // в помощния стек сме извадили всички "думи", но в обратен ред, което в случая не е значимо
	if (words.empty())
	{
		return "2019";
	}
	std::string result(words.top());
	words.pop();
	while (!words.empty()) // докато има "думи" в стека -> изкарваме и търсим най-голямата
	{
		std::string curr = words.top();
		if (lenlexcmp(curr, result))
		{
			result = curr;
		}
		words.pop();
	}
	return result;
}

int main()
{
	std::string sentence; getline(std::cin, sentence);
	std::string result = longest(sentence);
	result == "2019" ? std::cout << "no noise\n" : std::cout << result << "\n";
	return 0;
}
```
