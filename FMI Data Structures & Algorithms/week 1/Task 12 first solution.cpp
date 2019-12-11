#include <iostream> 
#include <vector>

struct Sector // Creating a structure Sector to determine all darts shots 
{
	unsigned short value;
	bool multiplierX2;
	// constructor with two arguments, one of which is default
	Sector(int value, bool multiplierX2 = false) :value(value), multiplierX2(multiplierX2) {};
};

std::vector<Sector> fillSectors(unsigned short N)
{
	std::vector<Sector> shots;
	shots.reserve(100); //we reserve at least 100 positions to avoid frequent resize
	Sector a(0); shots.push_back(a);

	for (size_t i = 1; i <= 60; i++)
	{
		Sector a(i);
		if (i <= 20)
		{
			shots.push_back(a);
			if (i % 2 == 0)
			{
				Sector a(i, 1); shots.push_back(a);
			}
			if (i % 3 == 0) shots.push_back(a);
		}
		else if (i <= 40)
		{
			if (i % 2 == 0)
			{
				Sector a(i, 1); shots.push_back(a);
			}
			if (i % 3 == 0)	shots.push_back(a);			
		}
		else if (i % 3 == 0) shots.push_back(a);		
	}
	Sector x(25), y(50, 1); // outer center & bullseye
	shots.push_back(x); shots.push_back(y);
	return shots;
}

int countWays(const std::vector<Sector>& shots, unsigned short N)
{
	size_t count(0);

	size_t SIZE = shots.size();
	for (size_t i = 0; i < SIZE; i++)
	{
		if (shots[i].value == N && shots[i].multiplierX2)
		{
			count++;
		}
		for (size_t j = 0; j < SIZE; j++)
		{
			if (shots[i].value + shots[j].value == N && shots[j].multiplierX2)
			{
				count++;
			}
			for (size_t k = 1; k < SIZE; k++)
			{
				if (shots[i].value + shots[j].value + shots[k].value == N && shots[k].multiplierX2)
				{
					count++;
				}
			}
		}
	}
	return count;
}

int main()
{
	unsigned short N; std::cin >> N;

	std::vector<Sector> shots = fillSectors(N); // vector of all possible darts shots

	std::cout << countWays(shots, N) << '\n';

	return 0;
}




SECOND APPROACH

#include <iostream>
#include <vector>

int main()
{
	int result;	std::cin >> result;
	std::vector<int> points; points.reserve(100);
	for (int i = 0; i <= 20; i++) points.push_back(i); // zero plus points from single sector	
	for (int i = 1; i <= 20; i++) points.push_back(3 * i); // points from tripple sector	
	points.push_back(25); // outer circle
	for (int i = 1; i <= 20; i++) points.push_back(2 * i); // points from double circle
	
	points.push_back(50); // inner circle (bullseye)
	//std::cout << points[42]; from here starts the double sector shots

	size_t counter (0);	size_t SIZE = points.size();

	for (size_t i = 0; i < SIZE; i++)
	{
		if (points[i] == result && i >= 42)	counter++;		
		for (size_t j = 0; j < SIZE; j++)
		{
			if (points[i] + points[j] == result && j >= 42)	counter++;
			for (size_t m = 0; m < SIZE; m++)
			{
				if (points[i] + points[j] + points[m]==result && m >= 42) counter++;				
			}
		}
	}

	std::cout << counter;

	return 0;
}
