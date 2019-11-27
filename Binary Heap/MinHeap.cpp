#include <iostream>
#include <vector>
using namespace std;

class MinHeap {
	vector<int>arr;

	int parentIndx(int i) {
		return (i - 1) / 2;
	}

	int leftChildIndx(int i) {
		return 2 * i + 1;
	}

	int rightChildIndx(int i) {
		return 2 * i + 2;
	}

	bool hasLeftChild(int i) {
		return leftChildIndx(i) < (int)arr.size();
	}

	bool hasRightChild(int i) {
		return rightChildIndx(i) < (int)arr.size();
	}

	void siftUp(int i) {
		if (i == 0) return;
		if (arr[i] < arr[parentIndx(i)]) { // > 
			swap(arr[parentIndx(i)], arr[i]);
			siftUp(parentIndx(i));
		}
	}

	void siftDown(int i) {
		if (!hasLeftChild(i)) return;
		int minChildIndx = leftChildIndx(i);
		if (hasRightChild(i) && arr[rightChildIndx(i)] < arr[leftChildIndx(i)]) { // >
			minChildIndx = rightChildIndx(i);
		}
		if (arr[i] > arr[minChildIndx]) { // <
			swap(arr[i], arr[minChildIndx]);
			siftDown(minChildIndx);
		}
	}

public:

	MinHeap() {
		arr.reserve(100);
	}

	//Floyd algorithm for building a Heap from array in linear time
	MinHeap(vector<int>& input)
	{
		int SIZE((int)input.size()), i;
		for (i = 0; i < SIZE; ++i) {
			this->arr.emplace_back(input[i]);
		}
		for (int i = SIZE / 2 - 1; i >= 0;--i) {
			siftDown(i);
		}
	}

	void push(int val) {
		arr.emplace_back(val);
		siftUp(arr.size() - 1);
	}

	void pop() {
		int SIZE = arr.size();
		if (SIZE == 0) return;
		swap(arr[0], arr[SIZE - 1]);
		arr.pop_back();
		siftDown(0);
	}

	int peek() {
		if (arr.size() == 0) return -1;
		return arr[0];
	}
};

int main()
{
	vector<int> arr{ 100,80,85,90,75,95,110,105,115,70,65,120,60 };
	MinHeap heap(arr);

	cout << heap.peek() << '\n';
	heap.pop();
	cout << heap.peek() << '\n';
	heap.pop();
	cout << heap.peek() << '\n';
	heap.pop();

	return 0;
}
