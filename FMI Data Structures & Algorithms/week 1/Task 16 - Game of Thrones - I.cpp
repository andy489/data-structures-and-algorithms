#include <iostream>

/*
Problem statement: https://www.hackerrank.com/challenges/game-of-thrones/problem?h_r=internal-search
*/

int letterUsage[26];

/*
Solution
For this problem we need to make the observation
that if the count of occurrences for every letter in the
word is an even number the word can obviously be rearranged
so that it is a palindrome with even length. If there is only
one letter with odd count of occurrences in the word it could
also be rearranged so that it is a palindrome with odd length,
but if there are more than one letters with odd count of
occurrences then the string cannot be rearranged to a palindrome.

This observation reduces the problem to the following: find the
number of letters with odd count of occurrences in the word.

Luckily the word can contain only lower letter words, so we
can have an array with length 26 that contains the count of
occurrences of every letter in the word where the occurrences of
'a' are at index 0, the occurrences of 'b' are at index 1 and
so on.

Time complexity - O(n)
Space complexity - O(n), where n is the length of the string we
input.
*/
int main()
{

	std::ios::sync_with_stdio(false);

	std::string str;
	std::cin >> str;
	for (int i = 0; i < str.length(); ++i)
	{
		letterUsage[str[i] - 'a']++;
	}

	int oddCountLetters = 0;
	for (int i = 0; i < 26; ++i)
	{
		if (letterUsage[i] % 2 == 1)
		{
			oddCountLetters++;
		}
	}

	if (oddCountLetters <= 1)
	{
		std::cout << "YES" << std::endl;
	}
	else
	{
		std::cout << "NO" << std::endl;
	}
}
