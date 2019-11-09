## Exercises on Associative Containers, Classes and Objects

## Problem 1 – What are the Odds
Write a program that reads a line of words (sequences of lowercase English letters separated by single spaces) and prints two lines – the first containing all words appearing an odd number of times, sorted alphabetically, and the second containing all words appearing an even number of times, sorted alphabetically. 
#### Examples
Input|Output
-|-
java cpp csharp php php java c java cpp|	c csharp java<br>
cpp php

#### Solution

```cpp
#include <iostream>
#include <map>
#include <sstream>
using namespace std;

enum indexes
{
	ODD_ELEMENTS,
	EVEN_ELEMENTS,

	INDEXES_COUNT
};

int main()
{
	string line;
	getline(cin, line);
	istringstream istr(line);

	map <string, int> wordsCounter;

	while (istr >> line)
	{
		wordsCounter[line]++;
	}

	ostringstream elements[INDEXES_COUNT];

	for (const auto& el : wordsCounter)
	{
		elements[el.second & 1] << el.first << ' ';
		//if (el.second & 1) // odd
		//{
		//	elements[ODD_ELEMENTS] << el.first << ' ';
		//}
		//else //if ((el.second & 1) == 0)
		//{
		//	elements[EVEN_ELEMENTS] << el.first << ' ';
		//}
	}
	cout << elements[ODD_ELEMENTS].str() << '\n' << elements[EVEN_ELEMENTS].str() << '\n';
	return 0;
}
```
## Problem 2 – In Range
You are given a line of integer numbers, followed by another line containing exactly two numbers – the start (inclusive) and end (exclusive) of a range (start will always be less than end). Write a program that prints all numbers from the first line that fall into the range [start, end), in increasing order, without duplicates.

Input|Output
-|-
1 42 13 1 13 10 9 7 4 105<br>7 12|7 9 10
1 42 13 1 13 10 9 4 105<br>7 13|9 10

#### Solution

```cpp
#include <iostream>
#include <sstream>
#include <set>
using namespace std;

int main()
{
	string line;
	getline(cin, line);

	istringstream istr(line);
	set<int> numbers;
	
	int num;
	while (istr>>num)
	{
		numbers.insert(num);
	}

	getline(cin, line);
	int start, end;
	istringstream interval(line);
	interval >> start;
	interval >> end;
	   
	for (const auto& num : numbers)
	{
		if (num>=start && num<end)
		{
			cout << num << ' ';
		}
	}

	return 0;
}
```
## Problem 3 - Matches

You are given two rows of integer numbers. Print a single line containing all the numbers that appear both in the first and the second row (without repetitions), sorted in increasing order. If there are no numbers that appear in both rows, print **no matches**.
#### Examples

Input|Output
-|-
1 42 13 1 13 10 9 7 4 105<br>7 7 19 1 106 42 -9 1 1 1 1 1 1|1 7 42	
1<br>2|no matches
42<br>42 42|42

```cpp
#include <iostream>
#include <sstream>
#include <set>
using namespace std;

int main()
{
	string firstLine, secondLine;
	getline(cin, firstLine);
	getline(cin, secondLine);
	istringstream firstIstr(firstLine);
	istringstream secondIstr(secondLine);

	set<int> firstSet, secondSet;

	int num;

	while (firstIstr >> num)
	{
		firstSet.insert(num);
	}

	while (secondIstr >> num)
	{
		secondSet.insert(num);
	}

	set<int> thirdSet;

	set<int>::iterator it;
	if (firstSet.size() < secondSet.size())
	{
		for (it = firstSet.begin();it != firstSet.end();++it)
		{
			if (secondSet.count(*it))
			{
				thirdSet.insert(*it);
			}
		}
	}
	else
	{
		for (it = secondSet.begin();it != secondSet.end();++it)
		{
			if (firstSet.count(*it))
			{
				thirdSet.insert(*it);
			}
		}
	}

	if (thirdSet.size()==0)
	{
		cout << "no matches\n";
		return 0;
	}
	for (it = thirdSet.begin();it != thirdSet.end();++it)
	{
		cout << *it << ' ';
	}
	return 0;
}
```

## Problem 5 - Matching Locations
Write a program that reads **names** of places and their geographical **coordinates** in the format **name,latitude,longitude** (where latitude and longitude are floating-point numbers). No two locations will have the same name. Some locations may have the same **coordinates**.

After all locations are entered, a single line containing the '.' (dot) character will be entered.

After that, queries will be entered – the queries will either contain a **name** of a location, or **latitude** and **longitude** coordinates (entered as two floating point numbers separated by a single space). Print all locations that match the query in the same format that they were entered.
#### Examples
Input|Output
-|-
Sofia, 42.70,23.33<br>Tokyo, 40.6976701,-74.2598732<br>FMI,42.70,23.33<br>.<br>Sofia<br>40.6976701 -74.2598732<br>42.70 23.33|Sofia, 42.70,23.<br>Tokyo, 40.6976701,-74.2598732<br>Sofia, 42.70,23.33<br>FMI,42.70,23.33

```cpp
#include <iostream>
#include <vector>
#include <string>
#include <sstream>

/*
Sofia,42.70,23.33
Tokyo,40.6976701,-74.2598732
FMI,42.70,23.33
.
Sofia
40.6976701 -74.2598732
42.70 23.33
*/

struct Point
{
	std::string latitude;
	std::string longitude;
};

class Location
{
public:
	void printInfo()
	{
		std::cout << name << ','
			<< point.latitude << ','
			<< point.longitude << std::endl;
	}

	bool isAtSamePoint(const Point& point)
	{
		return (this->point.latitude == point.latitude) &&
			(this->point.longitude == point.longitude);
	}

	std::string name;
	Point       point;
};

class Atlas
{
public:

	void parseLocationData(const std::string& input)
	{
		std::istringstream istr(input);

		Location currLocation;

		getline(istr, currLocation.name, ',');
		getline(istr, currLocation.point.latitude, ',');
		getline(istr, currLocation.point.longitude, ',');

		_locations.push_back(currLocation);
	}

	void printAllLocationsData()
	{
		for (Location& location : _locations)
		{
			location.printInfo();
		}
	}

	void executeQuery(const std::string& query)
	{
		for (Location& location : _locations)
		{
			if (location.name == query)
			{
				location.printInfo();
				break;
			}
		}
	}

	void executeQuery(const Point& point)
	{
		for (Location& location : _locations)
		{
			if (location.isAtSamePoint(point))
			{
				location.printInfo();
			}
		}
	}

private:
	std::vector<Location> _locations;
};

int main()
{
	Atlas atlas;

	std::string input;

	while (true)
	{
		getline(std::cin, input);

		if ("." == input)
		{
			break;
		}

		atlas.parseLocationData(input);
	}

	while (true)
	{
		getline(std::cin, input);

		if (input.empty())
		{
			break;
		}

		std::istringstream istr(input);
		std::string latitude;
		std::string longitude;
		istr >> latitude;

		if (istr >> longitude) //we have coordinate query
		{
			Point point;
			point.latitude = latitude;
			point.longitude = longitude;

			atlas.executeQuery(point);
		}
		else //name query
		{
			atlas.executeQuery(latitude);
		}
	}

	//    atlas.printAllLocationsData();

	return 0;
}

```
