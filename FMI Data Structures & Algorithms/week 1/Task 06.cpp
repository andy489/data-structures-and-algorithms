#include <iostream>
#include <string>

void reduceWord(std::string& word)
{
	int length = (int)word.size();
	bool flag = false;
	do
	{
		flag = false;
		for (int i = 0; i < length - 1; i++)
		{
			if (word[i] == word[i + 1])
			{
				word.erase(word.begin() + i);
				word.erase(word.begin() + i);
				length -= 2; i--;
				flag = true;
			}
		}
	} while (flag);
}

int main()
{
	std::string word; std::cin >> word;
	reduceWord(word);
	(word.size() == 0) ? std::cout << "Empty String\n" : std::cout << word << '\n';

	return 0;
}
