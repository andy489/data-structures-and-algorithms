#include <iostream>
#include <string>
#include <vector>
#define DIGITS 10

void fillCodedDigits(std::vector<std::vector<std::string>>& mayan, int N)
{
	std::string line;
	int i, j;
	for (i = 0; i < N; ++i)
	{
		int k(0);
		std::getline(std::cin, line);
		int SIZE = line.size();
		int digitSize = SIZE / DIGITS;

		std::string code;
		int digit = 0;
		for (j = 0; j < SIZE; j += digitSize)
		{
			code.append(line.begin() + j, line.begin() + j + digitSize);

			mayan[i][digit++] = code;
			code.clear();
		}
	}
}

void displayDecryptedNum(const std::string& T,
	std::vector<std::vector<std::string>>& mayan,
	int N)
{
	int TSIZE = (int)T.size();
	int currVecDecrypt(0);
	while (N--)
	{
		for (int i = 0; i < TSIZE; i++)
		{
			int p = T[i] - '0';
			std::cout << mayan[currVecDecrypt][p];
		}
		std::cout << '\n';
		currVecDecrypt++;
	}
}

int main()
{
	int N;
	std::cin >> N;
	std::cin.ignore();

	std::vector<std::vector<std::string>> mayan(N);
	for (size_t i = 0; i < N; i++)
	{
		mayan[i] = std::vector<std::string>(DIGITS);
	}

	fillCodedDigits(mayan, N);

	std::string T;
	std::getline(std::cin, T);

	displayDecryptedNum(T, mayan, N);

	return 0;
}
