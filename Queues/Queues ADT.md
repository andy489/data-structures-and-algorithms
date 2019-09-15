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

The signatures of the fundamental operations for queue of integers for example - Enqueue and Dequeue can be something like this:
```cpp
void Enqueue(int x);
int Dequeue();
```

All the operations written here must take constant time ot in other words, their time complexity should be big of 1 (O(1)).

Logically a queue can be shown as a figure or container open from two sides. So, an element can be inserted or Enqueued from one side and an element can be removed or dequeued from other side. We show a stack as a container open from one side. So, an insertion or what we call push in context of stack and removal or pop, both must happen from the same side. In queue, insertion and removal should happen from different sides. 

One obvious question can be - what are the real scenarios where we can use Queue? What are the use cases of Queue data structre? Queue is more often used in a scenario where there is a shared resource that's supposed to serve some request, but the resource can handle only one request at a time. It can serve only one request at a time. In such a scenario it makes most sense to Queue up the requests. The request that comes first, gets served first. Let's say we have a printer shared in a network. Any machine in the network can send a print request to this printer. Printer can serve only one request at a time, it can print only one document at a time. So, if a request comes when its busy, it can't be like - I'm busy, request later. That will be really rude of the printer :smile:. What really happens is that the program that really manages the printer, puts the print request in a queue. As long as there is something in the queue, printer keeps picking up a request from the front of the queue and serves it. Processor on your computer is also a shared resource. A lot of running programs or processes need time of the processor and the processor can attend to only one process at a time. Processor is the guy who has to execute all the instructions, who has to perform all the arithmetic and logical operations. So, the porcesses are put in a queue. Queue in general can be used to simulate wait in a number of scenarios.

Applications:
- 1) Printer queue
- 2) Process scheduling
- 3) Simulating wait


