/* If (twice the length of the most common string character does not 
exceed the length of the entire string + 1 and the string has at least two 
different characters) OR (string is only one character) the answer is YES. 
In all other cases, the answer is NO */
#include <iostream>
#include <string>

size_t *charHistogram(std::string word)
{
	size_t *his = new size_t[26]();
	size_t SIZE = word.length();
	for (size_t i = 0; i < SIZE; i++) his[word[i] - 97]++;
	return his;
}

int main()
{
	std::string word; std::cin >> word;
	size_t *his = charHistogram(word);
	size_t maxCount(0), countOfDiffChars(0);
	for (size_t i = 0; i < 26; i++)
	{
		if (his[i] > 0) countOfDiffChars++;
		if (his[i] > maxCount) maxCount = his[i];
	}
	((2 * maxCount <= word.length() + 1 && countOfDiffChars > 1) || word.length() == 1) ?
		std::cout << "Yes\n" : std::cout << "No\n";
	return 0;
}
