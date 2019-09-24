/* The idea is to create a char histogram for any of the two given words and after that to print the minimum usage of
any char in both of the words (if that minimum is greater than 0) in lexicographical order. Time and memory complexity is
O(m+n), where m and n are the lenghts of the given words. */

#include <iostream>
#include <string>

int getMin(int a, int b)
{
	return a > b ? b : a;
}

int* lowLetterHistogram(std::string word)
{
	int* his = new int[26]();
	size_t length = word.length();
	for (size_t i = 0; i < length; i++)
	{
		his[word[i] - 97]++;
	}
	return his;
}

int main()
{
	std::string firstWord;	std::cin >> firstWord;
	int* firstHis = lowLetterHistogram(firstWord);

	std::string secWord;	std::cin >> secWord;
	int* secHis = lowLetterHistogram(secWord);
	int curr;
	for (size_t i = 0; i < 26; i++)
	{
		curr = getMin(firstHis[i], secHis[i]);
		if (curr>0)
		{
			for (size_t j = 0; j < curr; j++)
			{
				std::cout << char(i + 97);
			}
		}
	}	
	delete[] firstHis; delete[] secHis;
}
