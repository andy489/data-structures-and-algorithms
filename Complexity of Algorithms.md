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


````cs
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
