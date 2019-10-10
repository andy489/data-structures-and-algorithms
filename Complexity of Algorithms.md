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
 long calcCount(int[,] matrix)
        {
            long count = 0;
            for (int row = 0; row < matrix.GetLength(0); row++)
            {
                if (matrix[row, 0] % 2 == 0)
                {
                    for (int col = 0; col < matrix.GetLength(1); col++)
                    {
                        if (matrix[row, col] > 0)
                        {
                            count++;
                        }
                    }
                }
            }
            return count;
        }
```
- Runs in linear time in best case and in quadratic time in worst case. <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n)"> at best, <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n.m)"> - at worst.
- The number of elementary steps on average case is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{\frac{n.m}{2}}">

#### Example 11
```cs
long calcSum(int[,] matrix, int row)
{
    long sum = 0;
    for (int col = 0; col < matrix.GetLength(0); col++)
    {
        sum += matrix[row.col];
    }
    if (row+1<matrix.GetLength(1))
    {
        sum += calcSum(matrix, row + 1);
    }
    return sum;
}
```
- Runs in quadratic time <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(max(n,m)^2)">
- The number of elementary steps is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{(n-1).n+\frac{(m-1).m}{2}}">

#### Example 12
```cs
int[] Union(int[] firstArr, int[] secondArr)
{
    List<int> union = new List<int>();
    union.AddRange(firstArray);
    foreach (int item in secondArray)
    	if(!union.Contains(item))
		union.Add(item);
    return union.ToArray();
}
```
- Runs in quadratic time <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(m.n)">
- The number of elementary steps is <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sim{m.n}">

#### Example 13
```cs
while (n>2)
{
   n=sqrt(n);
}
```
- Runs in logarithmic time 
- The number of elementary steps is <img src="https://latex.codecogs.com/svg.latex?\Large&space;log(log(n))">
