## Task 1 – Hex Colors 
Colors in computers are often represented in the RGB format, with an 8-bit (0-255) number per each of the R (red), the G (green) and the B (blue) color channels. An example of an RGB color would be the triplet **255, 0, 0**, which is the color red (red channel has the highest value, the other channels are “dark” as they have 0s as values) and **128, 128, 0** is the **olive** color.<br>
A common way of writing this format (e.g. in CSS) is to use the hexadecimal triplet notation, or Hex Code – we write a “#” in front of a string of 6 alphanumeric characters (letters and/or numbers), each 2 of which represent a hexadecimal number from **0** to **255**, with **00** being equal to **0** and **FF** being equal to **255**. For the above examples, red would be written as **#ff0000**, and **olive** would be written as **#808000**<br>
Write a program which, given two colors written in the Hex Code format (with a “#” in front of exactly 6 hexadecimal digits), computes the “average” between the colors – by calculating the average of each channel separately – and prints the resulting color in the same Hex Code format to the console. For computing the average of the channels of two colors, just sum the numbers of the channels and divide them by 2 (integer division, i.e. round down to the nearest integer, i.e. take the floor value).<br>
That is, if the first color has the components **red1, green1, blue1**, <br>
and the second color has the components **red2, green2, blue2**, <br>
then the “average” of those two colors is calculated as <br>
**(red1 + red2) / 2, (green1 + green2) / 2, (blue1 + blue2) / 2**. <br>
For our 2 example colors **#ff0000** and **#808000** above, the average would be **#bf4000** <br>
(because **ff = 255, 80 = 128, (255 + 128) / 2 = 383 / 2 = 191**, which is **bf** in hexadecimal, for the red channel, and **00 = 0, 80 = 128, (128 + 0) / 2 = 64**, which is **40** in hexadecimal, for the green channel)<br>
*Side note: If you’re interested, that’s not exactly how color “averaging” is done in real systems – the correct approach would be raising each channel’s value to the power of 2 before doing the average and then taking the square root of the result, but we don’t want to do that in this task for the sake of simplicity, if you want to learn more, see this video:* [video](https://youtu.be/LKnqECcg6Gw)
#### Input
Two Hex Code color values on the same line, separated by a single space. Any letters in the input will be lowercase
#### Output
A single Hex Code color value representing the “average” of the two colors. Any letters in the output must be lowercase.
#### Restrictions
The total running time of your program should be no more than **0.1s**<br>
The total memory allowed for use by your program is **16MB**

Example Input|Expected Output
-|-
#ff0000 #808000|	#bf4000
#2b00b5 #0ff1ce|	#1d78c1

#### Solution

```cpp
#include<iostream> 
#include<string> 
#include <iomanip>
#include <cmath>

int hexadecimalToDecimal(std::string hex)
{
	int len(2), base(1),dec(0);

	for (int i = len - 1; i >= 0; i--)
	{
		if (hex[i] >= '0' && hex[i] <= '9')
		{
			dec += (hex[i] - 48) * base;
			base = base * 16;
		}
		else if (hex[i] >= 'a' && hex[i] <= 'f')
		{
			dec += (hex[i] - 87) * base;
			base = base * 16;
		}
	}
	return dec;
}

int main()
{
	std::string color1, color2; std::cin >> color1 >> color2;
	std::cout << '#';
	for (size_t i = 1; i <= 5; i += 2)
	{
		std::string col1("xx"); col1[0] = color1[i]; col1[1] = color1[i + 1];
		std::string col2("xx"); col2[0] = color2[i]; col2[1] = color2[i + 1];

		int result = (int)floor((hexadecimalToDecimal(col1) + hexadecimalToDecimal(col2)) / 2);
		std::cout << std::setfill('0') << std::setw(2);
		std::cout << std::hex << result;
	}	
	return 0;
}
```

## Task 2 – Similarity

We will consider two words – **W1** and **W2** – “similar” if:<br>
- they have the same length
- they start with the same letter
- a minimum percentage – P – of their letters match (a letter in **W1** matches a letter in **W2** if the two letters are the same symbol and are at the same position in both words).<br>
For example, if **W1 = “kittens”** and **W2 = “kidding”**, the matching letters would be **k, i,** and **n**. That gives us **3** matching letters out of **7** letters, which is about **42.8%** of the letters. If **P = 40**, then we would say the words match. If **P = 43**, we would say the words don’t match.

A word is any uninterrupted sequence of lowercase English letters (**a-z**). So, punctuation or spaces surround a word from both “sides” (unless the word is at the start and/or end of the text).

Write a program, which reads a line of lowercase text **T** (letters and punctuation, but no numbers), a lowercase word W (letters only) and an integer number **P** and prints out how many words similar to **W** there are in the text.
#### Input
The first line will contain the text **T**, containing lowercase English letters (a-z) and punctuation (**.,;!?** and space).<br>
The second line of input will contain a single word **W**, containing only lowercase English letters (**a-z**), followed by a single space and the integer **P**.
#### Output
A single line containing an integer number – the number of words similar to **W** in the text **T**.
#### Restrictions
The text **T** will be no longer than **500** symbols and no shorter than **1** symbol. The word **W** will be no longer than **30** symbols and no shorter than **1** symbol. **P** will be between **1** and **100**, inclusive.<br>
The total running time of your program should be no more than **0.1s** <br>
The total memory allowed for use by your program is **16MB** <br>


Example Input|Expected Output
-|-
kittens,kidding.<br>kittenz 40|2
abcd<br>dcba 1|0
aaaa aabb abbb baaa<br>aaaa 50|2
aaaa<br>aa 1|0

#### Solution

```cpp
#include <iostream>
#include <string.h>
#include <string>

bool match(const std::string& word1, const std::string& word2, int percent)
{
	if (word1.length() != word2.length() || word1[0] != word2[0]) return false;

	int count = 0;

	for (size_t i = 0; i < word1.length(); i++)
		if (word1[i] == word2[i])
			count++;

	float percent_match = 100.0f * count / word1.length();

	return percent_match >= percent;
}

int parse(const std::string& text, const std::string& word, int percent)
{
	int count = 0;

	std::string delimiters(".,;!? ");
	char* next_token = nullptr;
	char* token = strtok_s(const_cast<char*>(text.c_str()), delimiters.c_str(), &next_token);

	while (token != nullptr)
	{
		if (match(token, word, percent)) count++;

		token = strtok_s(nullptr, delimiters.c_str(), &next_token);
	}
	return count;
}

int main()
{
	std::string text; getline(std::cin, text);
	std::string word;
	int P;
	std::cin >> word >> P;

	std::cout << parse(text, word, P) << std::endl;

	return 0;
}
```
## Task 3 – Machine
You are tasked with implementing software for a computational machine, which does basic operations with integer numbers. The machine has memory in the form of a sequence of numbers. When it does an operation, it takes (removes) numbers from the end of the sequence, calculates the result using those numbers and puts it back at the end of the sequence. There are also some operations which only add at the end or only remove from the end of the sequence. Here’s a list:
- Inserting a number. Syntax: an integer number, (can be positive, negative or **0**). Inserts a number at the end of the sequence (i.e. appends to the end of the sequence).
- Summing last two numbers. Syntax: **sum**. Removes the last two numbers in the sequence, calculates their sum and adds it to the end of the sequence.
- Subtracting last two numbers. Syntax: **subtract**. Removes the last element from the sequence and calls it **a**. Removes the next last element (again) and calls it **b**. Subtracts the two, i.e. **a - b** and adds the result to the end of the sequence. 
E.g. if the sequence is **(1, 4, 7)**, then **subtract** will remove **7** and **4**, calculate **7 - 4** and add it to the sequence – the resulting sequence will be **(1, 3)**
- Concatenation of last two numbers. Syntax: **concat**. Concatenates the last two elements in the sequence (as if they were strings), in the order they were added to it, evaluates the result to an integer and adds it to the end of the sequence.
E.g. if the sequence is **(1, 4, 7)**, then **concat** will remove **7** and **4**, concatenate **4** and **7**, resulting in **47**, and add it to the sequence – the resulting sequence will be **(1, 47)**
- Discarding the last number. Syntax: **discard**. Removes the last element from the sequence.
- Ending the computations. Syntax: **end**. Stops the machine (ends the program)<br>
Write a program which does the operations described above and prints out the final sequence of numbers, from first to last (i.e. in the order in which they were added).
#### Input
Two or more lines, each indicating an operation to be done with the machine (note that a line containing a single integer is the “Inserting a number” operation). The final line will not contain numbers and will only contain the string **"end"**
#### Output
One or more lines, each containing a single integer, representing the numbers in the final sequence.
#### Restrictions
There will be no more than **50** lines of operations in the input. The concat operation will never be done when the last element in the sequence is negative. All operations will be valid – i.e. the input data is such that there will always be enough numbers in the sequence for an operation to be executed correctly. The input will be such that there will be at least 1 number in the final sequence<br>
The total running time of your program should be no more than **0.1s** <br>
The total memory allowed for use by your program is **16MB** <br>

Example Input|Expected Output
-|-
1<br>4<br>sum<br>end|5
1<br>4<br>subtract<br>7<br>end|3<br>7
3<br>10<br>1<br>-1<br>sum<br>concat<br>sum<br>end|103

#### Solution

```cpp
#include <iostream>
#include <stack>
#include <string>
#include <cmath>

bool isInteger(const std::string& s)
{
	if (s.empty() ||
		((!isdigit(s[0]))
			&& (s[0] != '-')
			&& (s[0] != '+'))) return false;

	char* p;
	strtol(s.c_str(), &p, 10);
	return (*p == 0);
}

size_t digits(int num)
{
	if (num == 0) return 1;
	else return (size_t)log10(num) + 1;
}

int main()
{
	std::stack<int> CALC;
	std::string command;

	do
	{
		std::cin >> command;
		if (isInteger(command))
		{
			CALC.push(stoi(command));
		}
		else if (command == "sum")
		{
			int sum(0);
			sum += CALC.top();CALC.pop();
			sum += CALC.top();CALC.pop();
			CALC.push(sum);
		}
		else if (command == "sum")
		{
			int sum(0);
			sum += CALC.top();CALC.pop();
			sum += CALC.top();CALC.pop();
			CALC.push(sum);
		}
		else if (command == "subtract")
		{
			int a = CALC.top();CALC.pop();
			int b = CALC.top();CALC.pop();
			CALC.push(a - b);
		}
		else if (command == "concat")
		{
			int a = CALC.top();CALC.pop();
			int b = CALC.top();CALC.pop();
			int digitsOfa = digits(a);
			int expand = b * pow(10, digits(a));
			CALC.push(expand + a);
		}
		else if (command == "discard")
		{
			CALC.pop();
		}
	} while (command != "end");

	std::stack<int>RESULT;
	while (!CALC.empty())
	{
		RESULT.push(CALC.top());
		CALC.pop();
	}
	while (!RESULT.empty())
	{
		std::cout << RESULT.top() << '\n';
		RESULT.pop();
	}
	return 0;
}
```
