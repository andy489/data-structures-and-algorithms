#include <iostream>
#include <sstream>
#include <vector>
#include <algorithm>

struct Equation
{
	std::string equation;
	int result = 0;
	Equation(std::string equation = "") :equation(equation)
	{
		int op1, op2;
		char oper;
		std::istringstream istr(equation);
		istr >> op1;
		istr >> oper;
		istr >> op2;
		switch (oper)
		{
		case '+': result = op1 + op2; break;
		case '-': result = op1 - op2; break;
		case '*': result = op1 * op2; break;
		case '/': result = op1 / op2; break;
		case '%': result = op1 % op2; break;
		default: break;
		}
	}
	bool operator<(const Equation& other) const
	{
		return this->result > other.result; // descending stable
	}
};

void fillEquations(std::vector<Equation>& equations, int N)
{
	int i;
	std::string line;
	for (i = 0; i < N; i++)
	{
		std::getline(std::cin, line);
		equations.push_back(Equation(line));
	}
}

void displayEquations(const std::vector<Equation>& equations)
{
	for (const auto& eq : equations)
	{
		std::cout << eq.equation << '\n';
	}
}

int main()
{
	int N;
	std::cin >> N;
	std::cin.ignore();

	std::vector<Equation> equations;
	equations.reserve(N);

	fillEquations(equations, N);

	sort(equations.begin(), equations.end());

	displayEquations(equations);

	return 0;
}
