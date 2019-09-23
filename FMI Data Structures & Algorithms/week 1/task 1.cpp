#include <iostream>
#include <string>
#include <stack>
#include <iomanip>
/* logic that will work even with input data in the form "asd23s  kjd30n x1 &$3ds" instead of "23 30 1 3" */

size_t getDurationOfJourneyInMinutes(std::string line)
{
	//utility stack to store extracted numbers from line from back to front
	std::stack<size_t> numUtil;
	//my idea is to extract numbers from string using the idea from Reverse Polish Notation
	size_t length = line.length();
	size_t count(0);
	for (size_t i = 0; i < length; i++)
	{
		if (line[i] >= '0'&&line[i] <= '9')
		{
			if (count > 0)
			{
				int number = numUtil.top() * 10 + (line[i] - '0');
				numUtil.pop();
				numUtil.push(number);
			}
			else
			{
				numUtil.push(line[i] - '0');
				count++;
			}
		}
		else count = 0;		
	}
	std::stack<size_t>num;
	while (!numUtil.empty())
	{
		num.push(numUtil.top());
		numUtil.pop();
	} // now in min stack we have extracted all numbers from the input line 

	size_t hoursStart, minStart, hoursFin, minFin;
	hoursStart = num.top(); num.pop();
	minStart = num.top(); num.pop();
	hoursFin = num.top(); num.pop();
	minFin = num.top(); num.pop();

	size_t minutes1 = hoursStart * 60 + minStart;
	size_t minutes2 = hoursFin * 60 + minFin;
	size_t check;
	
	if (minutes1 <= minutes2) check = 0;	
	else check = 24 * 60;	
	
	size_t diff = check + minutes2 - minutes1;
	return diff;
}

int main()
{
	size_t durations[3];
	size_t indx(0);
	for (size_t i = 0; i < 3; i++)
	{
		std::string line;
		std::getline(std::cin, line);
		durations[indx++] = getDurationOfJourneyInMinutes(line);
	}
	//for (size_t i = 0; i < 3; i++) std::cout << durations[i] << ' '; 
	size_t minTrip = 24 * 60;
	size_t maxTrip = 0;

	for (size_t i = 0; i < 3; i++)
	{
		if (durations[i] > maxTrip) maxTrip = durations[i];
		if (durations[i] < minTrip) minTrip = durations[i];
	}
	std::cout << minTrip / 60 << ':' << std::setfill('0') << std::setw(2) << minTrip % 60 << '\n';
	std::cout << maxTrip / 60 << ':' << std::setfill('0') << std::setw(2) << maxTrip % 60 << '\n';
	return 0;
}
