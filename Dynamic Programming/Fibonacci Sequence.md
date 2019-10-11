## Fibonacci Sequence
- *The Fibonacci sequence* holds the following unsigned integers:
  - 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
  - The *first two* numbers are *0* and *1*
  - Each subsequent number is the sum of the previous two numbers
- Recursive mathematical formula:
  - <img src="https://latex.codecogs.com/svg.latex?\Large&space;f_0=0,{\;}f_1=1">
  - <img src="https://latex.codecogs.com/svg.latex?\Large&space;f_n=f_{n-1}+f_{n-2}">
  
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
	delete[] numbers;
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
<img src="https://latex.codecogs.com/svg.latex?\Large&space;\blacksquare"> **Smart approach*
```cpp
#define MAX 100
#include <iostream> 

// Create an array for memoization 
unsigned long long f[MAX] = { 0 };

// Returns n'th fuibonacci number using table f[] 
unsigned long long fib(unsigned long long n) //O(log n) arithmatic operations 
{
	// Base cases 
	if (n == 0) return 0;
	if (n == 1 || n == 2) return (f[n] = 1);

	// If fib(n) is already computed 
	if (f[n]) return f[n];

	size_t k = (n & 1) ? (n + 1) / 2 : n / 2;

	// Applyting above formula [Note value n&1 is 1 if n is odd, else 0] .
	f[n] = (n & 1) ? (fib(k) * fib(k) + fib(k - 1) * fib(k - 1))
		: (2 * fib(k - 1) + fib(k)) * fib(k);

	return f[n];
}

int main()
{
	size_t n; std::cin >> n;
	std::cout << fib(n) << '\n';
	return 0;
}
```
*Smart approach*: we used that the *Karatsuba's* method for finding <img src="https://latex.codecogs.com/svg.latex?\Large&space;k-th"> power of an object with complexity <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(log(n))"> works for matrices (**matrix multiplication is associative**).<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;\bigg(\begin{matrix}1&1\\1&0\end{matrix}\bigg)=\bigg(\begin{matrix}f_2&f_1\\f_1&f_0\end{matrix}\bigg)">. We can show usign *induction* that <img src="https://latex.codecogs.com/svg.latex?\Large&space;f_n=\bigg(\begin{matrix}1&1\\1&0\end{matrix}\bigg)^{(n-1)}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;f_3=\bigg(\begin{matrix}1&1\\1&0\end{matrix}\bigg)^{(2)}=\bigg(\begin{matrix}1&1\\1&0\end{matrix}\bigg)\bigg(\begin{matrix}1&1\\1&0\end{matrix}\bigg)=\bigg(\begin{matrix}1+1&1+0\\1+0&1+0\end{matrix}\bigg)=\bigg(\begin{matrix}2&1\\1&1\end{matrix}\bigg)=\bigg(\begin{matrix}f_3&f_2\\f_2&f_1\end{matrix}\bigg)">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;f_4=\bigg(\begin{matrix}1&1\\1&0\end{matrix}\bigg)^{(3)}=\bigg(\begin{matrix}1&1\\1&0\end{matrix}\bigg)^{(2)}\bigg(\begin{matrix}1&1\\1&0\end{matrix}\bigg)=\bigg(\begin{matrix}2&1\\1&1\end{matrix}\bigg)\bigg(\begin{matrix}1&1\\1&0\end{matrix}\bigg)=\bigg(\begin{matrix}2+1&2+0\\1+1&1+0\end{matrix}\bigg)=\bigg(\begin{matrix}3&2\\2&1\end{matrix}\bigg)=\bigg(\begin{matrix}f_4&f_3\\f_3&f_2\end{matrix}\bigg)">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;f_{n+1}=\bigg(\begin{matrix}f_{n+1}&f_n\\f_n&f_{n-1}\end{matrix}\bigg)\bigg(\begin{matrix}1&1\\1&0\end{matrix}\bigg)=\bigg(\begin{matrix}f_{n+1}+f_n&f_{n+1}\\f_n+f_{n-1}&f_n\end{matrix}\bigg)=\bigg(\begin{matrix}f_{n+2}&f_{n+1}\\f_{n+1}&f_n\end{matrix}\bigg)">

#### Compare Fibonacci solutions
- Recursive Fibonacci (divide-and-conquer, no memorization)
  - Complexity : <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{O(\varphi^n)}\sim{O(1.6^n)}"> - *exponential*
- *Top-down* dynamic programming (recursive with memorization)
  - Complexity : <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{O(n)}"> - *linear*
- *Bottom-up* dynamic programming (iterative)
  - Complexity : <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{O(n)}"> - *linear*
- *Smart approach*
  - Complexity : <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{O(log(n))}"> - *logarithmic*
  
#### If we want to find the <img src="https://latex.codecogs.com/svg.latex?\Large&space;36^{th}"> Fibonacci number:
- Recursive solution takes <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{48{\:}315{\:}633}"> steps
- Dynamic programming solution takes <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{36}"> steps
