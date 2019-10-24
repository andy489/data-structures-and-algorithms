## Pairs
![judge system for the task](https://www.hackerrank.com/challenges/pairs/problem?h_r=internal-search)

You will be given an array of integers and a target value. Determine the number of pairs of array elements that have a difference equal to a target value.

For example, given an array of <img src="https://latex.codecogs.com/svg.latex?\Large&space;[1,2,3,4]"> and a target value of 1, we have three values meeting the condition: <img src="https://latex.codecogs.com/svg.latex?\Large&space;2-1=1,3-2=1">, and <img src="https://latex.codecogs.com/svg.latex?\Large&space;4-3=1">.

#### Function Description

Complete the pairs function below. It must return an integer representing the number of element pairs having the required difference.

pairs has the following parameter(s):

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">: an integer, the target difference
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;arr">: an array of integers

Input Format

The first line contains two space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">, the size of <img src="https://latex.codecogs.com/svg.latex?\Large&space;arr"> and the target value.
The second line contains space-separated integers of the array.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{n}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0<k<10^9">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0<arr[i]<2^{31}-1">
- each integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;arr[i]"> will be unique

#### Output Format

An integer representing the number of pairs of integers whose difference is <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">.

Example input|Expected output|Explanation
-|-|-
5 2  <br>1 5 3 4 2 |3|There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1] .

#### Solution
```cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
typedef vector<int> vi;
#define sz(x) ((int)x.size())

int bS(vi& vec, int x)
{
	int SIZE = sz(vec);
	int ans = 1;
	int start = 0;
	int end = sz(vec) - 1;
	int mid;

	int firEnc = -1;

	while (start <= end)
	{
		mid = start + (end - start) / 2;
		if (vec[mid] == x)
		{
			firEnc = mid;
			end = mid - 1;
		}
		else if (vec[mid] > x) end = mid - 1;		
		else start = mid + 1;
		
	}
	if (firEnc == -1) return 0;	
	else
	{
		while (firEnc++ + 1 < SIZE && vec[firEnc] == vec[firEnc + 1]) ans++;			
		return ans;
	}
}

int main()
{
	int N, X, result(0);
	cin >> N >> X;
	vi vec(N);
	for (int i = 0; i < N; i++) cin >> vec[i];
	sort(vec.begin(), vec.end(), less<int>());
	int curr(vec[0]), prevResult(0);
	if (N == 0) cout << result;	
	else
	{
		result += bS(vec, vec[0] + X);
		prevResult = bS(vec, vec[0] + X);
		for (int i = 1; i < N; i++)
		{
			curr = vec[i];
			if (curr != vec[i - 1])
			{
				prevResult = bS(vec, vec[i] + X);
			}			
			result += prevResult;
		}
	}
	cout << result << '\n';

	return 0;
}
```
