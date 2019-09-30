## Fibonacci Sequence
- *The Fibonacci sequence* holds the following unsigned integers:
  - 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
  - The *first two* numbers are *0* and *1*
  - Each subsequent number is the sum of the previous two numbers
- Recursive mathematical formula:
  - <img src="https://latex.codecogs.com/svg.latex?\Large&space;F_0=0,{\;}F_1=1">
  - <img src="https://latex.codecogs.com/svg.latex?\Large&space;F_n=F_{n-1}+F_{n-2}">
  
### Memorization
- DP -> sub-problems *overlap*
- In order to *avoid solving* problems *multiple times*. memorize
  - *Memorization* -> *save/cache* sub-problem solution *for late use*
- Typically using an *array, matrix* or *hash table*

#### Top Down vs Bottom Up
- *Top down* approach
  - Solve *recursively* by *breaking down* the problem further and further
- *Bottom up* approach
  - Solve *iteratively* by solving smaller problems and *constructing the whole solution from the bottom up*
  
<img src="https://latex.codecogs.com/svg.latex?\Large&space;\blacksquare"> **Recursive approach (*without optimization*) showing the overlapping problem**
```cpp
#include <iostream>
static long overlap(0);
unsigned long long Fib(unsigned short n)
{
	count++;
	if (n == 1) return 0;
	else if (n == 2) return 1;
	else return Fib(n - 1) + Fib(n - 2);
}
int main()
{
	unsigned short n; std::cin >> n;
	std::cout <<"Recur: "<< count << "\nFib: " << Fib(n) << '\n';
	return 0;
}
```
<img src="https://latex.codecogs.com/svg.latex?\Large&space;\blacksquare"> **Recursive approach with optimization**
```cpp
#include <iostream>
static long count(0);
static unsigned long long* numbers;
unsigned long long Fib(unsigned short n)
{
	if (numbers[n]!=0) return numbers[n];
	count++;
	if (n == 1) return 0;
	else if (n == 2) return 1;
	unsigned long long result = Fib(n - 1) + Fib(n - 2);
	numbers[n] = result;
	return result;
}
int main()
{
	unsigned short n; std::cin >> n;
	numbers = new unsigned long long[n+1]();
	std::cout <<"Recur: "<< count << "\nFib: " << Fib(n) << '\n';
	return 0;
}
```
<img src="https://latex.codecogs.com/svg.latex?\Large&space;\blacksquare"> **Iterative approach (*do while cycle*)**

```cpp
#include <iostream>
int main()
{
	unsigned long long fir(0), sec(1); unsigned short n; std::cin >> n;
	if (n == 1) { std::cout << 0; return 0; }
	do
	{
		n--;
		unsigned long long fib_n = fir + sec;
		fir = sec;
		sec = fib_n;
	} while (n > 2);
	std::cout << sec << '\n';
	return 0;
}
```
#### Compare Fibonacci solutions
- Recursive Fibonacci (divide-and-conquer, no memorization)
  - Complexity : <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{O(1.6^n)}"> - *exponential*
- *Top-down* dynamic programming (recursive with memorization)
  - Complexity : <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{O(n)}"> - *linear*
- *Bottom-up* dynamic programming (iterative)
  - Complexity : <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{O(n)}"> - *linear*
#### If we want to find the <img src="https://latex.codecogs.com/svg.latex?\Large&space;36^{th}"> Fibonacci number:
- Recursive solution takes <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{48{\:}315{\:}633}"> steps
- Dynamic programming solution takes <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{36}"> steps
