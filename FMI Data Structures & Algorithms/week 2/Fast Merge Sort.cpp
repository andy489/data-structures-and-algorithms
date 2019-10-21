#include <iostream>
using std::swap;
using std::unique_ptr;

void merge(int* arr, int l, int mid, int r) 
{
	unique_ptr<int[]> l_arr(new int[mid - l + 1]);
	unique_ptr<int[]> r_arr(new int[r - mid]);

	memcpy(l_arr.get(), arr + l, sizeof(int) * (mid - l + 1));
	memcpy(r_arr.get(), arr + mid + 1, sizeof(int) * (r - mid));

	int l_ind = 0;
	int r_ind = 0;

	for (int i = l; i <= r; i++) 
	{
		if (r_ind == r - mid || (l_ind != mid - l + 1 && l_arr[l_ind] < r_arr[r_ind])) 
		{
			arr[i] = l_arr[l_ind++];
		}
		else 
		{
			arr[i] = r_arr[r_ind++];
		}
	}
}

void mergeSort(int* arr, int l, int r) 
{
	if (l == r) 
	{
		return;
	}

	int mid = (l + r) / 2;

	mergeSort(arr, l, mid);
	mergeSort(arr, mid + 1, r);
	merge(arr, l, mid, r);
}

int main()
{
	int N;std::cin >> N;
	int* arr = new int[N];
	for (size_t i = 0; i < N; i++)
	{
		std::cin >> arr[i];
	}
	mergeSort(arr,0,N-1);
	for (size_t i = 0; i < N; i++)
	{
		std::cout << arr[i]<<' ';
	}
	return 0;
}
