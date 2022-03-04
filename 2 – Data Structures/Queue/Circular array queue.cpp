// Queue - Circular array implementation
#include <iostream>

const int MAX_SIZE = 101;

using namespace std;

class Queue {
private:
    int A[MAX_SIZE]{};
    int front;
    int rear;

public:
    // Constructor - set front and rear as -1.
    // We are assuming that for an empty Queue, both front and rear will be -1.

    Queue() {
        front = -1;
        rear = -1;
    }

    // To check whether Queue is empty or not
    [[nodiscard]] bool is_empty() const {
        return (front == -1 && rear == -1);
    }

    // To check whether Queue is full or not
    [[nodiscard]] bool is_full() const {
        return (rear + 1) % MAX_SIZE == front ? true : false;
    }

    // Inserts an element in queue at rear end
    void Enqueue(int x) {
        cout << "Enqueuing " << x << endl;

        if (is_full()) {
            cout << "Error: Queue is Full" << endl;

            return;
        }
        if (is_empty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % MAX_SIZE;
        }

        A[rear] = x;
    }

    // Removes an element in Queue from front end.
    void Dequeue() {
        cout << "Dequeuing" << endl;
        if (is_empty()) {
            cout << "Error: Queue is Empty" << endl;
            return;
        } else if (front == rear) {
            rear = front = -1;
        } else {
            front = (front + 1) % MAX_SIZE;
        }
    }

    // Returns element at front of queue.
    int front_el() {
        if (front == -1) {
            cout << "Error: cannot return front from empty queue" << endl;
            return -1;
        }

        return A[front];
    }

    /*
       Printing the elements in queue from front to rear.
       This function is only to test the code.
       This is not a standard function for Queue implementation.
    */
    void Print() {
        // finding number of elements in queue
        int count = (rear + MAX_SIZE - front) % MAX_SIZE + 1;

        cout << "Queue       : ";

        for (int i = 0; i < count; ++i) {
            int index = (front + i) % MAX_SIZE; // index of element while traversing circularly from front
            cout << A[index] << " ";
        }

        cout << endl << endl;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    Queue q; // creating an instance of Queue

    q.Enqueue(2);
    q.Print();

    q.Enqueue(4);
    q.Print();

    q.Enqueue(6);
    q.Print();

    q.Dequeue();
    q.Print();

    q.Enqueue(8);
    q.Print();
    
    return 0;
}
