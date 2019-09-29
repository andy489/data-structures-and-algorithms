#### Example 1
```cs
int findMaxElement(int[] array)
{
	int max = array[0];
	for (int i = 0; i < array.Length; i++)
	{
		if (array[i]>max)
		{
			max = array[i];
		}
	}
	return max;
}
```
- Runs in <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n)"> where <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> is the size of the array
- The number of elementary steps is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{n}">

#### Example 2
```cs
int findInversions(int[] array)
{
	long inversions = 0;
	for (int i = 0; i < array.Length; i++)
	{
		for (int j = i+1; j < array.Length; j++)
		{
			if (array[i]>array[j])
			{
				inversions++;
			}
		}
	}
	return inversions;
}
```
- Runs in <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n^2)"> where <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> is the size of the array
- The number of elementary steps is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim\frac{n.(n+1)}{2}">

#### Example 3
```cs
decimal sum3(int n)
{
	decimal sum = 0;
	for (int  a = 0; a < n; a++)
	{
		for (int b = 0; b < n; b++)
		{
			for (int c = 0; c < n; c++)
			{
				sum += a * b*c;
			}
		}
	}
	return sum;
}
```
- Runs in cubic time <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n^3)">
- The number of elementary steps is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{n^3}">

#### Example 4
```cs
long sumMN(int n, int m)
{
	long sum = 0;
	for (int x = 0; x < n; x++)
	{
		for (int y = 0; y < m; y++)
		{
			sum += x * y;
		}
	}
	return sum;
}
```
- Runs in quadratic time <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n*m)">
- The number of elementary steps is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{n.m}">

#### Example 5
```cs
long sumMN(int n, int m)
{
	long sum = 0;
	for (int x = 0; x < n; x++)
	{
		for (int y = 0; y < m; y++)
		{
			if (x==y)
			{
				for (int i = 0; i < n; i++)
				{
					sum += i * x*y;
				}
			}
		}
	}
	return sum;
}
```
- Runs in quadratic time <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n*m)">
- The number of elementary steps is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{n.m+min(m,n}.n}">

#### Example 6
```cs
decimal calculation(int n)
{
	decimal result = 0;
	for (int i = 0; i < (1<<n); i++)
	{
		result += i;
	}
	return result;
}
```
- Runs in exponential time <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(2^n)">
- The number of elementary steps is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{2^n}">

#### Example 7
```cs
decimal factorial(int n)
{
	if (n == 0) return 1;	
	else return n * factorial(n - 1);
}
```
- Runs in linear time <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n)">
- The number of elementary steps is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{n}">

#### Example 8
```cs
decimal fibonacci(int n)
{
	if (n == 0) return 1;
	else if (n == 1) return 1;
	else return fibonacci(n - 1) + fibonacci(n - 2);
}
```
- Runs in exponential time <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(2^n)">
- The number of elementary steps is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{f_{n+1}}">, where <img src="https://latex.codecogs.com/svg.latex?\Large&space;f_{k}"> is the <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">-th Fibonacci's number

#### Example 9
```cs
long compute(int arr[], int n)
{
	long count = 0; 
	for (int i = 0; i < n; i++)
	{
		int start = 0, end = n-1;
		while (start < end)
		{
			if (arr[start] < arr[end]) start++; count++;			
			else end--;			
		}
	}
	return count;
}
```
- Runs in quadratic time <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n^2)">
- The number of elementary steps is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{n(n-1)}">

#### Example 10
```cs
long compute(int arr[], int n)
{
	long count = 0; 
	for (int i = 0; i < n; i++)
	{
		int start = 0, end = n-1;
		while (start < end)
		{
			if (arr[start] < arr[end]) start++; count++;			
			else end--;			
		}
	}
	return count;
}
```
- Runs in quadratic time <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n^2)">
- The number of elementary steps is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{n(n-1)}">
