#include <iostream>
#include <string>
#include <vector>

void encode(const std::string& password,std::vector<size_t> &repetitions,std::vector<char>& symbols)
{
	size_t SIZE = password.size();
	repetitions.reserve(SIZE); // stock up to avoid frequent resize
	symbols.reserve(SIZE); // stock up
	for (size_t i = 0; i < SIZE; i++)
	{
		size_t currCount(0);
		char curr = password[i];
		for (size_t j = i; j < SIZE; j++)
		{
			if (curr == password[j])
			{
				currCount++;
				if (j==SIZE-1)
				{
					repetitions.push_back( currCount);
					symbols.push_back(curr);
					return; //reached end
				}
			}
			else
			{
				repetitions.push_back(currCount);
				symbols.push_back(curr);
				i += currCount - 1; // update index
				break;
			}
		}
	}	
}

int main()
{
	std::string password; std::cin >> password;

	std::vector<size_t> repetitions; 
	std::vector<char> symbols;
	encode(password,repetitions,symbols);
	
	size_t SIZE = symbols.size();
	for (size_t i = 0; i < SIZE; i++)
	{
		std::cout << repetitions[i];
		std::cout << symbols[i];
	}

	return 0;
}
