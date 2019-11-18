#include <iostream>
#include <sstream>
#include <set>
#include <vector>

void editInterview(std::vector<std::string>& editedInterview, int N)
{
	std::set<std::string> SET;
	std::string line, word;
	for (int i = 0; i < N; i++)
	{
		std::getline(std::cin, line);

		std::istringstream istr(line);

		while (istr >> word)
		{
			if (word == ".")
			{
				SET.clear();
				editedInterview.push_back(".");
			}
			else
			{
				if (!SET.count(word))
				{
					editedInterview.push_back(word);
				}
				SET.insert(word);
			}
		}
	}
}

void displayEditetInterview(const std::vector<std::string>& editetInterview)
{
	for (const auto& word : editetInterview)
	{
		std::cout << word << ' ';
	}
}

int main()
{
	int N;
	std::cin >> N;
	std::cin.ignore();

	std::vector<std::string> editedInterview;
	editInterview(editedInterview, N);
	displayEditetInterview(editedInterview);

	return 0;
}
