// Find the first occurrence of x in sorted array with n elements.

#include <iostream>
#include <algorithm>
using namespace std;

int leftMostOccurrence(int* arr, int n, int x)
{
    int left = 0, right = n-1, result = -1;
    while(left <= right)
    {
        int mid = (left + right)/2;
        if(x == arr[mid])
        {
            result = mid;
            right = mid - 1;
        }
        else if(x < arr[mid])
        {
            right = mid - 1;
        }
        else
        {
            left = mid + 1;
        }
    }
    return result;
}

int main()
{
    int n;
    int arr[1000];
    scanf("%d", &n);
    for(int i=0;i<n;++i)
    {
        scanf("%d", &arr[i]);
    }
    int x;
    cin>>x;
    sort(arr, arr+n);
    cout<<leftMostOccurrence(arr, n, x)<<endl;
}

