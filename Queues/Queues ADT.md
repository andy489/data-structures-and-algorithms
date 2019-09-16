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

There are two popular implementations of Queue. We can implement Queue using:
- Array based implementation (Circular Array)
- Linked List based implementation

In an array implementation we will have this question: What if array gets filled? We need to take care of this question by givin it a intelligible answer. We can either say queue is full, or we can create a new larger array and copy elements from previous filled array into new larger array. The time taken from the copy operation will be proportional to number of number of elements in filled array, or in other words we can say that the time complexity of this operation will be O(N). There is another problem with the array implementation. We can have a large enough array and the queue may not be using most of it. Memory is an important resource and we should always avoid blocking memory unnecessarily. It's not that some amount of unused memory will be a real problem in a modern-day machine. It's just that while designing solutions and algorithms, we should analyze and understand there implications. Let's now see how good we will be with a linked list implementation. If we are picking a head side for enqueue operation, a dequeue must always happen from tail. Obversely if we are picking tail for enqueue operation then dequeue must always happen from head. WHatever side we're picking for whatever operation we need to be taking care of one requirement and the requirement is that, these operations must take *constant* time, or in other words their time complexity must be O(1). As we know, the cost of insertion or removal from head side is O(1), but the cost of insertion removal from tail side is O(n). So here is the deal - in a normal implementation of linked list if we will insert at one side and remove from other side then one of there operations enqueue or dequeue, depending on how we are picking the side, will cost us O(n), but the requirement that we have is that both these operations must take constant time. So we definitely need to do something to make sure that both enqueue and dequeue operations take constant time. The problem with the O(n) complexity comes from the traversal in the linked list, because we need a pointer from head to tail and that's taking all the time. What we can do is we can avoid this whole traversal. We can have a pointer variable just like head that should always store the address of rear node. Let's call this variable tail or rear. Let's call the variable that's storing the address of head node front, and the variable that's storing the address of tail node - rear. Now, with this design both enqueue and dequeue will be with O(1) and we do not need to bother with the size of the queue. We are using some extra memory to store address of next node but apart from that there is no other major disadvantage.




