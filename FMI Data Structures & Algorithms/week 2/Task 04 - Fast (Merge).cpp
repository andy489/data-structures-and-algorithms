/* Counting inversions using merge sort */
#include <iostream>

size_t mergeSort(size_t *arr, size_t *temp, int left, int right);
size_t merge(size_t arr[], size_t temp[], int left, int mid, int right);

/* sorts the array and returns count of inversions */
size_t mergeSort(size_t* arr, size_t array_size)
{
	size_t* temp = new size_t[array_size];
	size_t inversions= mergeSort(arr, temp, 0, array_size - 1);
	delete[] temp;
	return inversions;
}

size_t mergeSort(size_t *arr, size_t *temp, int left, int right)
{
	int mid, invCount(0);
	if (right > left) 
	{
		mid = (right + left) / 2;
		/* Inversion count will be sum of inversions in left-part, 
		right-part and number of inversions in merging */
		invCount = mergeSort(arr, temp, left, mid);
		invCount += mergeSort(arr, temp, mid + 1, right);

		// merging the two parts
		invCount += merge(arr, temp, left, mid + 1, right);
	}
	return invCount;
}

// Merges two sorted arrays and returning inversion count in the arrays
size_t merge(size_t *arr, size_t *temp, int left, int mid, int right)
{
	int i, j, k;
	size_t invCount(0);

	i = left; // i is index for left subarray
	j = mid; // j is index for right subarray
	k = left; // k is index for resultant merged subarray
	while ((i <= mid - 1) && (j <= right)) 
	{
		if (arr[i] <= arr[j]) temp[k++] = arr[i++];		
		else 
		{
			temp[k++] = arr[j++];
			invCount = invCount + (mid - i);
		}
	}

	// copy remaining elements
	while (i <= mid - 1) temp[k++] = arr[i++];
	while (j <= right) temp[k++] = arr[j++];
	// copy back the merged elements to original array
	for (i = left; i <= right; i++) arr[i] = temp[i];
	return invCount;
}

int main()
{
	size_t Q; std::cin >> Q;
	for (size_t i = 0; i < Q; i++)
	{
		size_t n; std::cin >> n;
		size_t *soldiers = new size_t[n];
		for (size_t i = 0; i < n; i++) std::cin >> soldiers[i];
		std::cout << mergeSort(soldiers, n) << '\n';
		delete[] soldiers;
	}	
	return 0;
}
