## Task 1 - Pipes
The company "Water You Waiting For" provides hot water to houses in a village through a series of underground pipes, each house having its own pipe for hot water. But the pipes corrode over periods of years and need to be replaced. Since the company wants to save money, it only does checkups of the pipes once a year, always on the same date (April 1st). Pipes are replaced only during checkups.

But the company wants to save even more money by skipping checkups when they are not necessary. Since the pipes corrode at a constant speed, it is enough to have 2 measurements of a pipe’s strength and calculate how much time remains before it needs to be replaced. This needs to be rounded-down to years, since the repair can only happen during a checkup – so if a pipe is going to break after 2 years and 11 months, the company needs to replace it after 2 years, because otherwise the pipe will be broken and leak water for 1 month until the 3rd year checkup.

Write a program which, given two arrays of consecutive strength measurements (measured when the pipes were installed and the year after that) of all the pipes, calculates the lifetimes the pipes (i.e. how many years after it was installed it needs to be replaced).
#### Input
The first line of the standard input will contain a single positive integer number **N** – the number of pipes. The second line of the standard input will contain an array of **N** positive integer numbers, separated by single spaces, representing the measurements of each pipe, made during this year’s checkup – let’s call them **checkup**. 
The second line of the standard input is analogous to the first but contains the measurements from last year – when the pipes were installed – let’s call it **installation**.
So, the strength of pipe **i** last year was **installation[i]** and this year it is **checkup[i]**.
#### Output
A single line, containing integers separated by single spaces, representing the years remaining until the corresponding pipe described in the input arrays must be replaced (counting from **installation**). If we call this array lifetimes, then pipe i has to be replaced **lifetimes[i]** years after **installation[i]** was measured.
#### Restrictions
**0 < installation[i] <= 1000000000;  0 <= checkup[i] < installation[i];**<br>
N will be a positive number less than or equal to **500**.<br>
The total running time of your program should be no more than **0.1s**<br>
The total memory allowed for use by your program is **5MB**<br>
#### Example Input/Output
Example Input|Expected Output|Explanation
-|-|-
3<br>3 2 2<br>5 4 3|2 2 3|Pipe 0 has suffered 5 – 3 = 2 damage – next year it will have 3 – 2 = 1 strength remaining and needs to be replaced, otherwise it will fail ~1.5 years from now (so it has a lifetime of 2 years counting from installation). Pipe 1 will break exactly 1 year from now, which means 2 years since it was installed.
5<br>1 1 1 1 11<br>2 3 4 5 12|2 1 1 1 12|Pipe 0 and Pipe 4 get 1 damage per year (i.e. their lifetimes in years are equal to their initial strength), but the others lose more than half their strength per year – they need to be replaced each year

#### Solution
```cpp
#include <iostream>

int* inputArray(const size_t N)
{
	int* arr = new int[N];
	for (size_t i = 0; i < N; i++)
	{
		std::cin >> arr[i];
	}
	return arr;
}

void printArray(int* arr, size_t N)
{
	for (size_t i = 0; i < N; i++)
	{
		std::cout << arr[i] << ' ';
	}
}

int main()
{
	size_t N;
	std::cin >> N;

	int* instalation = inputArray(N);
	int* checkup = inputArray(N);

	int* sufferedTime = new int[N];
	for (size_t i = 0; i < N; i++)
	{
		sufferedTime[i] = checkup[i] - instalation[i];
	}

	for (size_t i = 0; i < N; i++)
	{
		std::cout << checkup[i] / sufferedTime[i]<<' ';
	}

	delete[] instalation;
	delete[] checkup;
	delete[] sufferedTime;
	return 0;
}
```

## Task 2 - Modulated Sum
You are given several integer arrays with equal length, as well as an integer modulo. Calculate a weighted sum array, equal in length to those arrays, by summing the arrays together (each element is summed with the elements of the other arrays at that index) and modulating them by the given value – i.e. each value in the result should be the remainder of the sum of the matching elements in the input arrays, divided by the modulo.

That is, if the input arrays are **arr1, arr2, …, arrN**, and the modulo is **mod**, then then for the **result** array:<br>
**result[i] = (arr1[i] + arr2[i] + … + arrN[i]) % mod**
#### Input
The first line of the input contains two integers – **N** and **M**.<br>
Each of the following **N** lines contains **M** integer numbers – the elements of the input arrays.<br>
The next lines each contain a single integer number – modulo (**mod**).<br>
#### Output
A single line, containing M integer numbers, separated by single spaces – the modulated sum array.
#### Restrictions
**0 < N < 100;**<br>
**0 < M < 100;**<br>
Elements in the input arrays are integer numbers between **-100** and **100** (inclusive).<br>
Modulo is a number between **10** and **100** (inclusive).<br>
The total running time of your program should be no more than **0.1s**<br>
The total memory allowed for use by your program is **5MB**<br>
#### Example Input/Output
Example Input|	Expected Output
-|-
3 4<br>1 2 3 4<br>1 2 3 4<br>5 6 7 8<br>10|7 0 3 6
4 2<br>-1 0<br>2 12<br>7 -42<br>13 13<br>2|1 1

#### Solution
```cpp
#include <iostream>

int myAbs(int a)
{
	return a > 0 ? a : -a;
}

int** inputArrays(const size_t N,const size_t M)
{
	int** arrays = new int*[N];
	for (size_t i = 0; i < N; i++)
	{
		arrays[i] = new int[M];
	}
	for (size_t i = 0; i < N; i++)
	{
		for (size_t j = 0; j < M; j++)
		{
			std::cin >> arrays[i][j];
		}
	}
	return arrays;
}

void releaseArrays(const size_t N, int** arrays)
{
	for (size_t i = 0; i < N; i++)
	{
		delete[] arrays[i];
	}
	delete[] arrays;
}

int main()
{
	size_t N, M;
	std::cin >> N >> M;	
	int** arrays = inputArrays(N, M);

	int mod;
	std::cin >> mod;

	int* result = new int[M]();
	
	for (size_t i = 0; i < M; i++)
	{
		for (size_t j = 0; j < N; j++)
		{
			result[i] += arrays[j][i];
		}
	}

	for (size_t i = 0; i < M; i++)
	{
		std::cout << myAbs(result[i]) % mod<<' ';
	}

	delete[] result;
	releaseArrays(N,arrays);
	return 0;
}
```

## Task 3 – Bus 
Captain Grant needs your help. He’s currently on leave, but needs to get back to his ship soon. To do that, he needs to catch a bus to the train station, and from there take a train to the naval base. But captain Grant hates waiting – he has a certain train he has to catch, but can pick from several busses, and he wants to pick a bus which arrives as close to the train departure as possible.

The transport company, which operates the busses to the station and the trains at the station, has a list of bus arrival times at the station, as well as information on the train departure time. Of course, since the company works with the military, the arrival times and the train departure time are in military time format – **4**-digit numbers, the first two digits represent the hours (**00** to **23**), the next two digits represent the minutes (**00** to **59**). For example, two o’clock in the morning is **0200**, twenty minutes past four in the afternoon is **1620**, two minutes to midnight (the time, not the Iron Maiden song) is **2358**, etc.

Write a program which, given a list of bus arrival times and a train departure time, in military time format, finds the minimum amount of time – in minutes – between a bus arrival and the train departure (i.e. the time Grant would have to wait if he picks the “best” bus) and prints the position of the bus in the bus arrival times list. 

Note that **0** waits is possible, but negative wait times aren’t possible.

#### Input
The first line of the standard input will contain the number **N** – the number of bus arrival times.<br>
The first line of the standard input will contain a sequence of bus arrival times, in military time format, separated by single spaces.<br>
The second line of the standard input will contain the train departure time, in military time format.
#### Output
A single line containing a single non-negative integer – the number/position of the bus in the input sequence of bus arrival times, for which the wait time is minimal.
#### Restrictions
**N** will be at least **1** and at most **20**.
The input data will be such that there will always be a valid (non-negative) minimum wait time. There will always be a bus that arrives before the train leaves.
The total running time of your program should be no more than **0.1s**<br>
The total memory allowed for use by your program is **5MB**<br>
Example Input/Output
Example Input|Expected Output|Explanation
-|-|-
4<br>2013 0130 0004 0012<br>2122|1|The best bus is the one arriving at 2013 (20:13) – i.e. the 1st bus in the list (NOTE: the answer is the position of the bus in the input, not in their chronological order)
3<br>1205 1241 1708<br>1241|2|The train leaves at 1241 and the 2nd bus arrives then (0 minutes wait, so it is the best option)

#### Solution
```cpp
#include <iostream>
#include <string>

int myAbs(int a)
{
	return a > 0 ? a : -a;
}

std::string* inputTimes(const size_t N)
{
	std::string* times = new std::string[N];
	for (size_t i = 0; i < N; i++)
	{
		std::cin >> times[i];
	}

	return times;
}

int convertTime(std::string time)
{
	int sec = 10 * (time[0]-'0') * 60 +
		(time[1]-'0') * 60 +
		(time[2] - '0') * 10 +
		(time[3] - '0');
	return sec;
}

int main()
{
	size_t N;
	std::cin >> N;
	std::string* times = inputTimes(N);

	std::string trainLeaves;
	std::cin >> trainLeaves;
	int leave = convertTime(trainLeaves);

	int* minutes = new int[N];
	for (size_t i = 0; i < N; i++)
	{
		minutes[i] = convertTime(times[i]);
	}
	
	int  minDiff = 24*60;
	int indx(0);

	for (size_t i = 0; i < N; i++)
	{
		int diff = myAbs(minutes[i] - leave);
		if (diff < minDiff)
		{
			indx = i;
			minDiff = diff;
		}
	}

	std::cout << indx + 1;

	delete[] times;
	delete[] minutes;
	return 0;
}
```
## Task 4 - Roxettes
You are a fictional astronaut on the fictional planet Rox. There are a lot of rocks on the planet Rox, and there are a lot of microorganisms on those rocks. Since those microorganisms are the native life form on Rox, let’s call them Roxettes!<br>
There’s an interesting thing about Roxettes – they live in groups, each group is isolated from the others. Roxettes have DNA (like Earth organisms do) and they multiply by dividing into two organisms with the same DNA. Each group has one unique Roxette – the leader, which never multiplies – and multiple other duplicate Roxettes. <br>
That means the **DNA of the leader is unique among the group**, and for **each other DNA in the group there are 2, 4, 6, 8, etc. organisms with the same DNA** (it is also possible that the unique DNA is the only DNA in the group). That is, for each group you have **1 unique DNA**, and all **other DNAs are encountered an even number of times** ("even" means divisible by 2).<br>
You have a device which scans a group of Roxettes and gives you a large sequence of characters, representing all the Roxettes in the group. The DNA of each Roxette in the sequence is a hexadecimal number represented by exactly 5 characters (**00001** to **fffff**) from the scan of the device.<br>
Unfortunately, the sequence of characters representing the DNAs is very, very large, and NASA’s budget has been bit low lately, so the device has very little memory (you can’t hope to have enough memory to keep info on all the DNAs in the group when working with larger groups).<br>
Write a program which can find the unique DNA in a group of Roxettes, where each DNA except the unique one is encountered an even number of times, using as little memory as possible.<br>
#### Input
A single line containing sequence of hexadecimal characters **(0-9, a-f)**, of which each **5** consecutive characters represent the DNA of a single Roxette. So characters 0, 1, 2, 3 and 4 represent the DNA of the first Roxette, characters 5, 6, 7, 8, 9 represent the DNA of the second Roxette and so on. <br>
There are no spaces or other delimiters and the sequence ends with **'.'** (dot), i.e. **char(46)**.
#### Output
A single line containing exactly **5** hexadecimal characters, representing the unique Roxette DNA.<br>
#### Restrictions
The total number of DNAs in the input will be less than or equal to **4194240** (so that gives us a maximum of **4194240*5 = 20971200** symbols in the input, plus one **'\0'** and end of line symbols **'\r'** and **'\n'**, for a total of a maximum of **20971203** symbols in the input). DNAs will be hexadecimal numbers from **1** to **1048575** (**00001** to **fffff**).<br>
The total running time of your program should be no more than **2.5s**<br>
HINT: place **cin.sync_with_stdio(false)** and **cout.sync_with_stdio(false)** before you read/write input/output data if you want to make **cin** and **cout** faster.<br>
The total memory allowed for use by your program is **2MB**, however keep in mind that (as of the time writing this) an empty C++ program running on Judge will consume about **1.77MB**, without any variables in the program. Overall, you should try to keep memory used for variables, arrays, etc., to less than **100KB** to be sure you will fit into the memory constraint.<br>
In 50% of the test cases, the total number of DNAs will be less than or equal to **5000** and their numerical values will be between **1** and **10000** (**00001** to **02710** in hexadecimal).<br>
#### Example Input/Output
Example Input|Expected Output
-|-
abab1bca98abab1.|bca98
44444111112222244444222224444444444.|11111
01aefabcdeabcde01aef01aefb00b501aef.|b00b5
#### Solution

```cpp
#define DNA_LENGTH 6
#define DOT 46
#include <iostream>
int main()
{
	char ch, result[DNA_LENGTH]{ 0 };
	size_t currIndx(0);
	while ((ch = getchar()) != DOT)
	{
		result[currIndx++] ^= ch;
		if (currIndex == DNA_LENGTH - 1) currIndx = 0;
	}
	std::cout << result;
	return 0;
}
```
## Task 5 - Divisible by 45
Your task is to write a program which finds all the numbers, which are divisible by 45, inside a specified range. 
#### Input 
Exactly **2** lines, each containing a single integer number – with an arbitrary length, but no more than **100** digits.<br>   
The first line contains the start of the range (inclusive) **S** <br> 
The second line contains the end of the range (exclusive) **E** <br> 
#### Output 
One or more lines, with a single integer number each, representing the numbers divisible by 45 in the given range, in ascending order (i.e. start from the smallest number divisible by 45 in the range and print each of them on a separate line). 
#### Restrictions 
The range will be such that total numbers divisible by 45 will be no more than **100**<br> 
The number of digits in the numbers specifying the range will NOT exceed **100** <br> 
**0 < S < E - 1**<br>  
The total running time of your program should be no more than **0.1s**<br> 
The total memory allowed for use by your program is **5MB** <br> 
#### Example Input/Output
Example Input|Expected Output
---|---
1<br>100|45<br>90 
1<br>90|45
45000000000000000000000000000000000000013<br>45000000000000000000000000000000000000100|45000000000000000000000000000000000000045<br>45000000000000000000000000000000000000090 

## Solution
- BigInt.h

```cpp
#pragma once
#include <iostream>
#include<string>
#include<sstream>
#include<cmath>
#include <algorithm>

class BigInt
{
protected:
	std::string digits;
public:
	BigInt() : digits("0") {}

	BigInt(std::string digits) : digits(trimLeadingZeroes(digits)) {}

	BigInt(int number) : digits(intToString(number)) {}

	std::string getDigits() const
	{
		return this->digits;
	}

	BigInt& operator+=(const BigInt & other) 
	{
		*this = *this + other;
		return *this;
	}

	BigInt operator+(const BigInt & other) const 
	{
		int maxTotalDigits = 1 + std::max(this->digits.size(), other.digits.size());

		std::string thisDigits = getPaddedWithZeroes(this->digits, maxTotalDigits);
		std::string otherDigits = getPaddedWithZeroes(other.digits, maxTotalDigits);

		std::string resultDigits(maxTotalDigits, '0');

		int carry = 0;
		for (int i = resultDigits.size() - 1; i >= 0; i--) 
		{
			int thisDigit = thisDigits[i] - '0';
			int otherDigit = otherDigits[i] - '0';

			int sum = thisDigit + otherDigit + carry;
			carry = sum / 10;
			int sumDigit = sum - carry * 10;

			resultDigits[i] = sumDigit + '0';
		}

		return BigInt(resultDigits);
	}

	friend std::ostream& operator<<(std::ostream& stream, const BigInt &number);

	bool operator<(const BigInt& other) const 
	{
		std::string thisStr = this->digits;
		std::string otherStr = other.digits;

		if (thisStr.size() < otherStr.size()) 
		{
			thisStr = getPaddedWithZeroes(thisStr, otherStr.size());
		}
		else if (thisStr.size() > otherStr.size()) 
		{
			otherStr = getPaddedWithZeroes(otherStr, thisStr.size());
		}

		return thisStr < otherStr;
	}

private:
	static std::string trimLeadingZeroes(std::string number) 
	{
		std::string resultDigitsTrimmed;
		for (size_t i = 0; i < number.size(); i++) 
		{
			if (number[i] != '0') {
				resultDigitsTrimmed = number.substr(i);
				break;
			}
		}

		return resultDigitsTrimmed.empty() ? "0" : resultDigitsTrimmed;
	}


	static std::string intToString(int number) 
	{
		std::ostringstream str;
		str << number;
		return str.str();
	}

	static std::string getPaddedWithZeroes(std::string s, size_t widthNeeded) 
	{
		if (s.size() < widthNeeded) 
		{
			return std::string(widthNeeded - s.size(), '0') + s;
		}
		else 
		{
			return s;
		}
	}
};

inline std::ostream& operator<<(std::ostream& stream, const BigInt &number) 
{
	stream << number.digits;
	return stream;
}
```
- BigInt.cpp

```cpp
#include "BigInt.h"

size_t findSumOfDigitsUtil(std::string number)
{	/* utility function to find sum of digits*/
	size_t len = number.length();
	size_t sum(0);
	for (size_t i = 0; i < len; i++)
	{
		sum += number[i] - '0';
	}
	return sum;
}

bool isMultipleOf9(int num)
{   /* function that checks whether a given number is multiply of 9 */
	if (num == 0 || num == 9) return true; // base
	if (num < 9)    return false;
	// if the number is greater than 9
	return isMultipleOf9((int)(num >> 3) - (int)(num & 7)); //recur
}

bool isMultipleOf5(std::string num)
{
	size_t len = num.length();
	size_t lastDigit = num[len - 1];
	if (lastDigit == '0' || lastDigit == '5')
	{
		return true;
	}
	return false;
}

int main()
{
	std::string S, E;
	std::cin >> S >> E;

	BigInt A(S); BigInt B(E);
	
	/*size_t sumDigits1 = findSumOfDigitsUtil(A.getDigits());
	size_t sumDigits2 = findSumOfDigitsUtil(B.getDigits());

	std::cout << sumDigits1 << '\n';
	std::cout << sumDigits2 << '\n';;

	isMultipleOf9(sumDigits1) ? std::cout << "yes\n" : std::cout << "no\n";
	isMultipleOf9(sumDigits2) ? std::cout << "yes\n" : std::cout << "no\n";*/

	
	for (BigInt i(S); i < B; i += 1)
	{
		if (isMultipleOf9(findSumOfDigitsUtil(i.getDigits()))&& isMultipleOf5(i.getDigits()))
		{
			std::cout << i << '\n';
		}
	}
	
	return 0;
}
```

## Task 6 – Near Cities
You are given information about towns. Each town has a name and a position represented by a point in 2 dimensional Euclidean space (i.e. the “normal” 2D space you are used to). 

Write a program, which, given the names and coordinates of a set of towns, finds the two closest towns (the two towns with the smallest distance between them). 
#### Input 
On the first line of the standard input, there will be the number of towns – **N**<br> 
On each of the next lines, there will be the **name**, the **first coordinate** and the **second coordinate** of a town (i.e. **name x y**), separated by single spaces.<br>
#### Output 
Write a single line containing the names of the two closest towns, separated by a single "**-**" sign. The names should be printed in order of appearance in the input. Also, if there are multiple pairs of towns with the same distance between each other, print the one that appears first in the input. For example, if the input has the towns **Sofia, Burgas, Pernik**, entered in that order, and if the distances between all of them are the same (i.e. they form an equilateral triangle), then the output should be **Sofia-Burgas** (NOT Burgas-Sofia, NOT Sofia-Pernik). 
#### Restrictions 
**1 < N < 100**, The name of each town will be a sequence of English letters (**a-z, A-Z**), no 2 towns will have the same name or same coordinates. <br>
Coordinates will be input as integer numbers (but calculations should be done in floating-point). <br>
The total running time of your program should be no more than **0.1s** <br>
The total memory allowed for use by your program is **5MB** <br>
#### Example Input/Output
Example Input|Expected Output 
---|---
3<br> Sofia 0 0<br>Burgas 350 0 <br>Pernik 0 -5|Sofia-Pernik 
3<br>A -1 -1<br>B -4 -1<br>C -3 -2|B-C 
4<br>A 1 1<br>B 2 1<br>C 2 2<br>D 1 2|A-B 
 
## Solution
```cpp
#include <iostream>
#include <cmath>
#include <string>
#include <vector>

struct Town
{
	std::string town;
	int x, y;
};

float getDistance(const Town& A, const Town& B)
{
	float distance = (float)sqrt((pow(A.x - B.x, 2) + pow(A.y - B.y, 2)));
	return distance;
}

void releaseVectorOfPointers(std::vector<Town*> &vec)
{
	size_t SIZE = vec.size();
	for (size_t i = 0; i < SIZE; i++)
	{
		delete vec[i];
	}
	vec.clear();
}

std::vector<Town*> readInput(size_t N)
{
	std::vector<Town*> cities;

	for (size_t i = 0; i < N; i++)
	{
		Town* city = new Town();
		std::cin >> city->town;
		std::cin >> city->x >> city->y;
		cities.push_back(city);
	}
	return cities;
}

void printMinDistance(const std::vector<Town*>& cities)
{
	Town *A = nullptr; Town *B = nullptr;
	float minDistance = FLT_MAX;
	size_t N = cities.size();
	for (size_t i = 0; i < N; i++)
	{
		for (size_t j = i + 1; j < N; j++)
		{
			float distance = getDistance(*cities[i], *cities[j]);
			if (distance < minDistance)
			{
				minDistance = distance;
				A = cities[i];
				B = cities[j];
			}
		}
	}
	std::cout << A->town << '-' << B->town << '\n';
}

int main()
{
	size_t N;
	std::cin >> N;
	std::vector<Town*> cities = readInput(N);
	printMinDistance(cities);	
	releaseVectorOfPointers(cities);
	return 0;
}
```
## Task 7 – Transmission
You are part of a SETI (*that thing that’s supposed to find aliens but never does*) team and you have just detected messages from a distant star system. The signal has been verified to indeed come from a star system, not from an Earth-orbiting satellite or any other sort of interference, and your team is certain the source is artificial. Your team wants to analyze the message, and for that they need to first identify the most-commonly encountered signals in the message. <br>
The message has been converted to a sequence of English words (containing characters **a-z** and digits **0-9**), separated by spaces. The message ends with a dot, preceded by a space **(" .")**. <br>
Your task is to write a program, which answers queries about the message in the form **occurrenceCount index** by finding all words which appear an **occurenceCount** number of times in the transmission, and printing out the word at position index in the lexicographical order of the (unique) words. If there are no words with that **occurenceCount**, print the dot character **(".")**. <br>
For example, if we have the message string:<br> 
**"chug a mug of mead and another mug mead chug another mug of mead warrior ."**<br> 
(*What? Nobody said the aliens can’t be from Skyrim…*) <br>
and type in **3 0**, the program should output **mead** – the words **mead** and **mug** each appear **3** times in the message, and ordered lexicographically they form the array **{"mead", "mug"}**, in which the element at the **0** index is the word **mead**.<br> 
If we instead type in **2 1**, the program should output **chug** – the words that appear **2** times in the message are chug and another. If we sort them lexicographically we get **{"another", "chug"}**, and index **1** in that array is **chug**.<br> 
If we instead type in **4 0**, the program should output **.** (a single dot character) – there is no word that appears **4** times in the text. <br>
Write a program which reads in a message in the above-mentioned format, and queries in the above-mentioned format, and prints out the results for those queries. <br>
#### Input 
The first line of the input will contain the message – a string containing English characters **a-z**, digits **0-9**, spaces, and ending with a space and a dot **(" .")**. Words in that string are considered sequences of characters and/or digits separated by spaces. <br>
The next line will contain a single integer **N** – the number of queries. <br>
Each of the following lines will contain two positive integer numbers, separated by a single space – the **occurrenceCount** and **index** values of the query. <br>
#### Output 
**N** lines, each containing a single word, representing the answers to the queries in the same order the queries were given. 
#### Restrictions 
**0 < N < 500;**<br>
The total number of words will be at most **1000**. Of those, no more than **50** will be unique. Each word will be at most **20** symbols. <br>
The total running time of your program should be no more than **0.05s** <br>
The total memory allowed for use by your program is **5MB** <br>
#### Example Input/Output
Example Input|Expected Output 
---|---
chug a mug of mead and another mug mead chug another mug of mead warrior .<br>2 <br>3 0 <br>2 1 <br>|mead <br>chug 
 
 #### Solution
 ```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

int containWord(std::string word, std::vector<std::pair<std::string, size_t>> words)
{
	size_t SIZE = words.size();
	for (size_t i = 0; i < SIZE; i++)
	{
		if (word == words[i].first)
		{
			return i;
		}
	}
	return -1;
}

void print(std::vector<std::pair<std::string, size_t>> words)
{
	size_t SIZE = words.size();
	for (size_t i = 0; i < SIZE; i++)
	{
		std::cout << words[i].first << ' ' << words[i].second << '\n';
	}
	std::cout << '\n';
}

//chug a mug of mead and another mug mead chug another mug of mead warrior . 
std::vector<std::pair<std::string, size_t>> getWords(const std::string& sentence)
{
	std::vector <std::pair<std::string, size_t>> words;
	size_t senLen = sentence.length();

	std::string word("");

	for (size_t i = 0; i < senLen; i++)
	{
		char currChar = sentence[i];
		if (currChar != ' ')
		{
			word += sentence[i];
		}
		else
		{
			if (sentence[i+1]=='.')
			{
				break;
			}
			if (word.length() != 0)
			{
				int pos = containWord(word, words);
				if (pos == -1)
				{
					std::pair<std::string, size_t> pair;
					pair.first = word; pair.second = 1;
					words.push_back(pair);
				}
				else
				{
					words[pos].second++;
				}
			}
			word = "";
		}
	}
	return words;
}

std::string searchForWordWithOccurancesAndIndex(size_t countOccurances, size_t index, 
const std::vector<std::pair<std::string, size_t>>& words)
{
	size_t SIZE = words.size();
	size_t count(0);
	for (size_t i = 0; i < SIZE; i++)
	{
		if (words[i].second == countOccurances)
		{
			if (count < index)
			{
				count++;
			}
			else
			{
				return words[i].first;
			}
		}
		else
		{
			count = 0;
		}
	}
	return ".";
}

int main()
{
	std::string sentence;
	std::getline(std::cin, sentence);

	std::vector<std::pair<std::string, size_t>> words = getWords(sentence);
	//print(words);

	sort(words.begin(), words.end());
	//print(words);

	size_t N;
	std::cin >> N;
	for (size_t i = 0; i < N; i++)
	{
		size_t countOccurances, index;
		std::cin >> countOccurances >> index;
		std::cout << searchForWordWithOccurancesAndIndex(countOccurances, index, words) << '\n';
	}

	return 0;
}
 ```
