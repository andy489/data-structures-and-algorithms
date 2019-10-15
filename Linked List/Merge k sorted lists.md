Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

**Example:**

**Input:**
[
  1->4->5,
  1->3->4,
  2->6
]<br>
**Output:** 1->1->2->3->4->4->5->6

```cpp
#include <iostream>
#include <sstream>
#include <vector>
#include <list>

void parse(std::string& text)
{
	std::string delimiters(",->");
	char* next_token = nullptr;
	char* token = strtok_s(const_cast<char*>(text.c_str()), delimiters.c_str(), &next_token);

	std::string parsed("");

	while (token != nullptr)
	{
		parsed.append(token); parsed.append(" ");
		token = strtok_s(nullptr, delimiters.c_str(), &next_token);
	}
	text = parsed;
}

int main()
{
	std::vector<std::list<int>> lists;

	std::string text;
	getline(std::cin, text);

	while (text != "]")
	{
		if (text == "[")
		{
			getline(std::cin, text);
			continue;
		}

		std::list<int> A;

		parse(text); std::istringstream istr(text);
		int element;
		istr >> element;
		while (istr)
		{
			A.push_back(element);
			istr >> element;
		}
		lists.push_back(A);
		getline(std::cin, text);
	}

	std::list<int> RESULT;

	int min; int minIndex;

	size_t SIZE = lists.size();

	while (lists.size())
	{
		min = lists[0].front();
		minIndex = 0;
		for (size_t i = 0; i < SIZE; i++)
		{

			if (lists[i].front() < min)
			{
				min = lists[i].front();
				minIndex = i;
			}
		}
		RESULT.push_back(min);
		lists[minIndex].pop_front();
		if (lists[minIndex].empty())
		{
			lists.erase(lists.begin() + minIndex);
			SIZE = lists.size();
		}
	}

	for (auto& node : RESULT)
	{
		std::cout << node;
		if (&node != &RESULT.back())
		{
			std::cout << "->";
		}
	}

	return 0;
}
```
