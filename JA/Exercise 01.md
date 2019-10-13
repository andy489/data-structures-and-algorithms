## Task 1 - Reverse words
Write a program that reads lines of space separated words from the standard input (until “end” word is met), reverse the order of all given words and outputs the result to the standard output (**words should be space-delimited**). 
#### Examples

Input|Output
-|-
Hello there<br>How are you<br>end|you are How there Hello
end|“” (empty)
I did not quite<br>understand that<br>end|that understand quite not did I

#### Solution

```cpp
#include <iostream>
#include <stack>
#include <string>

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
```
## Task 2 - Numeral System
Write a program that reads the digits of a base-10 numeral system – exactly 10 unique non-space characters on a single line, representing the symbols used for the digits 0-9 (inclusively) – then reads two numbers represented in that numeral system, then prints their sum in that numeral system.

#### Examples

Input|Output|Explanation
-|-|-
abcdefghij<br>cba<br>ja|daa|a=0, b=1, …, j=9<br>cba = 210<br>ja = 90<br>90 + 210 = 300 = daa
0123456789<br>42<br>512|554|Numeral system matches normal<br>base-10 (0=0, 1=1, …, 9=9)
qwertyuiop<br>popiu<br>tutiy|wtytyw|q=0, w=1, …, p=9<br>popiu = 98976<br>tutiy = 46475<br>98976 + 46475 = 145451 = wtytyw

#### Solution 1 - Naive approach

```cpp
#include <iostream>
#include <stack>

int readNum(std::string chars, std::string number)
{
	std::stack<int> NUM;

	int numLen = (int)number.size();

	for (int i = 0; i < numLen; i++)
	{
		char curr = number[i];
		for (int j = 0; j < 10; j++)
		{
			if (curr == chars[j])
			{
				if (!NUM.empty())
				{
					int num = NUM.top() * 10 + j;
					NUM.pop();
					NUM.push(num);
				}
				else
				{
					NUM.push(j);
				}
			}
		}
	}
	return NUM.top();
}

int main()
{
	std::string chars, fir, sec; std::cin >> chars >> fir >> sec;

	int num = readNum(chars, fir) + readNum(chars, sec);

	std::stack<int> S;

	int digit;
	while (num != 0)
	{
		digit = num % 10 ;
		S.push(digit);
		num /= 10;
	}

	while (!S.empty())
	{
		digit = S.top();
		std::cout << chars[digit];
		S.pop();
	}

	return 0;
}
```

#### Solution 2 - Smart approach

```cpp
#include <iostream>
#include <vector>
#include <string>

void readInput(std::vector<int>& digits, std::string& input, 
			std::string& fir, std::string& sec)
{
	std::cin >> input >> fir >> sec;

	size_t SIZE = input.size();
	for (size_t i = 0; i < SIZE; i++)
	{
		digits[input[i]] = i;
	}
}

int getNum(const std::vector<int>& digits, std::string& num)
{
	int result(0);

	size_t SIZE = num.size();
	for (size_t i = 0; i < SIZE; i++)
	{
		result = result * 10 + digits[num[i]];
	}
	return result;
}

std::string encode(const int result, const std::string& digitsStr)
{
	std::string number = std::to_string(result);

	size_t SIZE = number.size();
	for (size_t i = 0; i < SIZE; i++)
	{
		number[i] = digitsStr[number[i] - '0'];
	}
	return number;
}

int main()
{
	std::vector<int> digits(255);
	std::string digitsStr, fir, sec;
	readInput(digits, digitsStr, fir, sec);

	int first = getNum(digits, fir);
	int second = getNum(digits, sec);

	const int result = first + second;

	std::cout << encode(result, digitsStr);

	return 0;
}
```

## Task 3 - Minesweeper

You are given a **N** by **M** matrix (**N** and **M** are two integers entered on the console), in which the cells contain single characters – either a **.** (dot), or a **!** (exclamation mark) – representing "empty" or "mined" positions.

Write a program that prints a **N** by **M** matrix, where each cell contains a number, representing how many adjacent cells, **including itself**, are "mined".

Each cell in a matrix has at most 8 adjacent cells – the cells directly above, below, to the left, to the right, as those diagonally – to the left and above, to the right and above, to the right and below and to the left and below.
#### Examples
Input|Output		
-|-							
4 5<br>.....<br>...!.<br>.....<br>.....|00111<br>00111<br>00111<br>00000
5 8<br>........<br>...!....<br>....!...<br>........<br>...!....|00111000<br>00122100<br>00122100<br>00122100<br>00111000
3 3<br>!!!<br>!.!<br>!!!|353<br>585<br>353

#### Solution 1 - First way
```cpp
#include <iostream>
#include <vector>

char** input(int R, int C);
void release(int R, char** battlefield);
int** generateMinesweeper(char** battlefield, int R, int C);
template <typename T>
void display(T** arr, int R, int C);
bool isInRange(int x, int y, int R, int C);

int main()
{
	int R, C;std::cin >> R >> C;
	char** battlefield = input(R, C);
	int** mines = generateMinesweeper(battlefield, R, C);

	display(mines, R, C);

	delete[] battlefield; delete[] mines;
	return 0;
}

char** input(int R, int C)
{
	char** battlefield = new char* [R];
	for (int i = 0; i < R; i++)
	{
		battlefield[i] = new char[C];
	}
	for (int i = 0; i < R; i++)
	{
		for (int j = 0; j < C; j++)
		{
			std::cin >> battlefield[i][j];
		}
	}
	return battlefield;
}

void release(int R, char** battlefield)
{
	for (int i = 0; i < R; i++)
	{
		delete[] battlefield[i];
	}
	delete[] battlefield;
}

int** generateMinesweeper(char** battlefield, int R, int C)
{
	int** mines = new int* [R];
	for (int i = 0; i < R; i++)
	{
		mines[i] = new int[C]();
	}

	int a[] = { -1,-1,-1, 0, 0, 0, 1, 1, 1 };
	int b[] = { -1, 0, 1,-1, 0, 1,-1, 0, 1 };
	const int SIZE = sizeof(a) / sizeof(a[0]);

	for (int i = 0; i < R; i++)
	{
		for (int j = 0; j < C; j++)
		{
			if (battlefield[i][j] == '!')
			{
				for (int k = 0; k < SIZE; k++)
				{
					if (isInRange(i + a[k], j + b[k], R, C))
					{
						mines[i + a[k]][j + b[k]]++;
					}
				}
			}
		}
	}
	return mines;
}

template <typename T>
void display(T** arr, int R, int C)
{
	for (int i = 0; i < R; i++)
	{
		for (int j = 0; j < C; j++)
		{
			std::cout << arr[i][j];
		}
		std::cout << '\n';
	}
}

bool isInRange(int x, int y, int R, int C)
{
	if (x >= 0 && y >= 0 && x < R && y < C) return true;
	else return false;
}
```
#### Solution 2 - Second way
```cpp
#include <iostream>
#include <vector>
#include <queue>

struct Point
{
	int x, y;
	Point(int x, int y) :x(x), y(y) {};
};

std::vector<std::vector<char>> readInput()
{
	std::vector<std::vector<char>> matrix;
	int rows(0), cols(0);
	std::cin >> rows >> cols;

	matrix.resize(rows);
	for (int i = 0; i < rows; i++)
	{
		matrix[i].resize(cols);
		for (int j = 0; j < cols; j++)
		{
			std::cin >> matrix[i][j];
		}
	}
	return matrix;
}

std::queue<Point> findAllMines(const std::vector<std::vector<char>>& matrix)
{
	std::queue<Point> Q;

	const int ROWS = (int)matrix.size();
	for (int i = 0; i < ROWS; i++)
	{
		const int COLS = (int)matrix[i].size();
		for (int j = 0; j < COLS; j++)
		{
			if (matrix[i][j] == '!') // mine found!
			{
				Point M(i, j);
				Q.push(M);
			}
		}
	}

	return Q;
}

bool isInRange(const Point& p, const std::vector<std::vector<int>>& matrix)
{

	if (p.x >= 0 && p.x < (int)matrix.size() && p.y >= 0 && 
					p.y < (int)matrix[p.x].size())
	{
		return true;
	}
	return false;
}

void detonateSignleMine(Point& p, std::vector<std::vector<int>>& matrix)
{
	int a[] = { -1,-1,-1, 0, 0, 0, 1, 1, 1 };
	int b[] = { -1, 0, 1,-1, 0, 1,-1 ,0, 1 };
	int SIZE = sizeof(a) / sizeof(a[0]);
	for (size_t k = 0; k < SIZE; k++)
	{
		Point q(p.x + a[k], p.y + b[k]);
		if (isInRange(q, matrix))
		{
			matrix[q.x][q.y]++;
		}
	}
}

void detonateMines(std::queue<Point>& mines, 
		std::vector<std::vector<int>>& output)
{
	while (!mines.empty())
	{
		Point p(mines.front());
		mines.pop();
		detonateSignleMine(p, output);
	}
}

void display(const std::vector<std::vector<int>> output)
{
	for (auto& i : output)
	{
		for (const int j : i)
		{
			std::cout << j;
		}
		std::cout << '\n';
	}
}

int main()
{
	std::vector<std::vector<char>> matrix = readInput();

	std::vector<std::vector<int>> output(matrix.size(), 
			std::vector<int>(matrix[0].size(), 0));

	std::queue<Point> mines = findAllMines(matrix);

	detonateMines(mines, output);

	display(output);

	return 0;
}
```

## Task 4 – Rust
You are given a 10x10 matrix representing a metal square, which has begun to rust. There are 3 types of symbols in the matrix – a **.** (dot) means a healthy part of the metal, a **#** indicates a rust-resistant part, and a **!** indicates a part that has begun to rust.

There may be **0, 1 or more** parts that has begun to rust.

The rust spreads from a rusty cell to healthy cells by "infecting" adjacent cells directly above, to the right, below and to the left of itself **(no diagonals)**, at the same time. The rust cannot infect cells that are indicated as rust-resistant. Let’s define the time it takes for all cells adjacent to a rusty cell to get infected as 1 unit.

After reading the matrix, read a single integer – the elapsed time in units (as defined above) – and print a matrix representing how the metal square will look after the rust has been acting on it for that amount of time.

#### Examples

Input|Output
-|-
..........<br>....!.....<br>..........<br>..........<br>..........<br>..........<br>..........<br>..........<br>..........<br>..........<br>4|.!!!!!!!..<br>!!!!!!!!!.<br>.!!!!!!!..<br>..!!!!!...<br>...!!!....<br>....!.....<br>..........<br>..........<br>..........<br>..........
..........<br>....!.....<br>...###....<br>..........<br>..........<br>..........<br>..........<br>..........<br>..........<br>..........<br>5|!!!!!!!!!.<br>!!!!!!!!!!<br>!!!###!!!.<br>.!!!.!!!..<br>..!...!...<br>..........<br>..........<br>..........<br>..........<br>..........
!........!<br>..........<br>..........<br>..........<br>..........<br>..........<br>..........<br>..........<br>..........<br>!........!<br>5|!!!!!!!!!!<br>!!!!!!!!!!<br>!!!!..!!!!<br>!!!....!!!<br>!!......!!<br>!!......!!<br>!!!....!!!<br>!!!!..!!!!<br>!!!!!!!!!!<br>!!!!!!!!!!<br>

#### Solution

```cpp
#include <iostream>
#include <string>
#include <queue>

struct Point
{
	int x, y;
	Point(int x, int y) :x(x), y(y) {};
};

bool isNumber(const std::string& s)
{
	std::string::const_iterator it = s.begin();
	while (it != s.end() && std::isdigit(*it)) ++it;
	return !s.empty() && it == s.end();
}

std::vector<std::string> readInput(int& rust)
{
	std::vector<std::string> matrix; matrix.reserve(10);
	rust;
	std::string line; getline(std::cin, line);

	while (!isNumber(line))
	{
		matrix.push_back(line);
		getline(std::cin, line);
	}
	rust = std::stoi(line);
	return matrix;
}

std::queue<Point> findAllMines(const std::vector<std::string>& matrix)
{
	std::queue<Point> Q;

	const int ROWS = (int)matrix.size();
	for (int i = 0; i < ROWS; i++)
	{
		const int COLS = (int)matrix[i].size();
		for (int j = 0; j < COLS; j++)
		{
			if (matrix[i][j] == '!') // rust found!
			{
				Point M(i, j);
				Q.push(M);
			}
		}
	}

	return Q;
}

bool isInRange(const Point& p, const std::vector<std::string>& matrix)
{
	if (p.x >= 0 && p.x < (int)matrix.size() && p.y >= 0 &&
				p.y < (int)matrix[p.x].size()
		&& matrix[p.x][p.y] != '#' && matrix[p.x][p.y] != '!')
	{
		return true;
	}
	return false;
}

void detonateSignleMine(Point& p, std::vector<std::string>& matrix)
{
	int a[] = { -1, 0, 0, 1,0 };
	int b[] = { 0,-1, 1, 0,0 };
	int SIZE = sizeof(a) / sizeof(a[0]);
	for (size_t k = 0; k < SIZE; k++)
	{
		Point q(p.x + a[k], p.y + b[k]);
		if (isInRange(q, matrix))
		{
			matrix[q.x][q.y] = '!';
		}
	}
}

void detonateMines(std::queue<Point>& mines, std::vector<std::string>& output)
{
	while (!mines.empty())
	{
		Point p(mines.front());
		mines.pop();
		detonateSignleMine(p, output);
	}
}

void display(const std::vector<std::string> output)
{
	for (auto& i : output)
	{
		for (auto j : i)
		{
			std::cout << j;
		}
		std::cout << '\n';
	}
}

std::vector<std::string> clone(const std::vector<std::string>& matrix)
{
	size_t SIZE = matrix.size();
	std::vector<std::string> cloneMatrix(SIZE);
	for (size_t i = 0; i < SIZE; i++)
	{
		cloneMatrix[i] = std::string(matrix[i].size(),'.');
	}
	for (size_t i = 0; i < SIZE; i++)
	{
		for (size_t j = 0; j < cloneMatrix[i].size(); j++)
		{
			cloneMatrix[i][j] = matrix[i][j];
		}
	}
	return cloneMatrix;
}

int main()
{
	int rust;

	std::vector<std::string> matrix = readInput(rust);

	std::vector<std::string> output = clone(matrix);

	std::queue<Point> mines;

	mines = findAllMines(matrix);

	detonateMines(mines, output);

	for (size_t i = 0; i < rust - 1; i++)
	{
		mines = findAllMines(output);
		detonateMines(mines, output);
	}

	display(output);

	return 0;
}
```
