#include <iostream>
#include <cmath>
#include <vector>
using namespace std;

void updateValueUtil(vector<int>& st, int s, int e, int indx, int diff, int i) {
	if (indx < s || indx > e) {
		return;
	}
	st[i] += diff;
	if (s != e) {
		int mid = s + (e - s) / 2;
		updateValueUtil(st, s, mid, indx, diff, 2 * i + 1);
		updateValueUtil(st, mid + 1, e, indx, diff, 2 * i + 2);
	}
}

void updateValue(vector<int>& arr, vector<int>& st, int n, int indx, int new_val) {

	if (indx < 0 || indx > n - 1) {
		cout << "Invalid Input ";
		return;
	}

	int diff = new_val - arr[indx];
	arr[indx] = new_val;

	updateValueUtil(st, 0, n - 1, indx, diff, 0);
}

int getSumUtil(vector<int>& st, int s, int e, int qs, int qe, int i) {
	if (qs <= s && qe >= e) {
		return st[i];
	}
	if (qs > e || qe < s) {
		return 0;
	}
	int mid = s + (e - s) / 2;
	return getSumUtil(st, s, mid, qs, qe, 2 * i + 1) +
		getSumUtil(st, mid + 1, e, qs, qe, 2 * i + 2);
}

int getSum(vector<int>& st, int n, int qs, int qe) {

	if (qs<0 || qe>n - 1 || qs > qe) {
		cout << "Invalid Input ";
		return -1;
	}
	return getSumUtil(st, 0, n - 1, qs, qe, 0);
}

int constructSTUtil(vector<int>& arr, int s, int e, vector<int>& st, int i) {
	if (s == e) {
		st[i] = arr[s];
		return arr[s];
	}
	int mid = s + (e - s) / 2;
	st[i] = constructSTUtil(arr, s, mid, st, 2 * i + 1) +
		constructSTUtil(arr, mid + 1, e, st, 2 * i + 2);
	return st[i];
}

vector<int> constructST(vector<int>& arr) {
	int n = (int)arr.size();
	int x = (int)ceil(log2(n));
	int max_size = 2 * (int)pow(2, x) - 1;

	vector<int>st(max_size);
	constructSTUtil(arr, 0, n - 1, st, 0);
	return st;
}

int main() {
	vector<int>arr{ 3,2,9,5,4,10 };
	vector<int>st = constructST(arr);
	int n = (int)arr.size();
	cout << getSum(st, n, 1, 4) << '\n';	
	updateValue(arr, st, n, 2, 1);
	cout << getSum(st, n, 1, 4) << '\n';	

	return 0;
}
