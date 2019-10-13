Problem 1 – Reverse words
Write a program that reads lines of space separated words from the standard input (until “end” word is met), reverse the order of all given words and outputs the result to the standard output (words should be space-delimited). 
Examples
Input	Output
Hello there
How are you
end	you are How there Hello
end	“” (empty)
I did not quite
understand that
end	that understand quite not did I

#include <iostream>
#include <stack>
#include <sstream>

int main()
{
	std::string line; getline(std::cin, line);

	std::stack<std::string> REVERSER;
	
	while (line != "end")
	{
		std::istringstream istr(line);
		
		while (istr >> line)
		{
			REVERSER.push(line);
		}
		getline(std::cin, line);
	}

	while (!REVERSER.empty())
	{
		std::cout << REVERSER.top() << ' ';
		REVERSER.pop();
	}

	return 0;
}



