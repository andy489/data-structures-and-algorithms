#include <iostream>
#include <string>

std::string PalPerm(std::string s)
{
	int* histogram = new int[26](); // constant memory for ascii[a...z] all elements set to 0

	size_t len = s.length();

	for (size_t i = 0; i < len; i++) histogram[s[i] - 'a']++; // fill histogram for the given word

	if (len & 1) // odd
	{
		bool flag = false;
		for (size_t i = 0; i < 26; i++)
		{
			if (histogram[i] & 1)
			{
				if (flag)
				{
					return "NO";
				}
				flag = true;
			}
		}
	}
	else
	{
		for (size_t i = 0; i < 26; i++)
		{
			if (histogram[i] & 1)
			{
				return "NO";
			}
		}
	}
	return "YES";
	delete[] histogram;
}
int main()
{
	std::string word;std::cin >> word;

	std::string result = PalPerm(word);

	std::cout << result << "\n";

	return 0;
}
