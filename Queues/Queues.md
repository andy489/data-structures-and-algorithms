## Introduction to Queues

### Queue as abstract data type

Queue is a structure in which whatever goes in first, comes out first. In short we call Queue a FIFO structure (*First In First Out*). In queue an insertion must happen from one end that we call rear or tail of the queue and any removal must happen from the other end that we can call front or head of the queue. 

A queue is a list or collection with the restriction or the constraint that insertion can be and must be performed at one end that we call the rear of queue or the tail of queue and deletion can be performed at other end that we can call the front of queue or head of queue. 

### Operations

- Enqueue(x) or Push(x)

*Enqueue operation should insert an element at tail or rear end of queue.*

- Dequeue() or Pop()

*Dequeue operation should remove an element from front or head of the queue. And Dequque typically also returns this element that it removes from the head.*

- front() or Peek()

*This operation should just return the element at front and should not delete anything.*

- IsEmpty()

*Operation to check whether queue is empty or not.*

- IsFull()

*Checks if the queue is full only if it has limited size.*

The signatures of Enqueue and Dequeue for a queue of integers can be something like this:
```cpp
void Enqueue(int x);
int Dequeue();
```

All the operations written here must take constant time ot in other words, their time complexity should be big of 1 (O(1)).
