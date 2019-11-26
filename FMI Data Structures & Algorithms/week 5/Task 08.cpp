#include <iostream>
#include <queue>
#include <list>
#include <climits>
using namespace std;

struct MyQueue
{
    list <int> Q, Min, Max;
    int size = 0;

    void push(int num)
    {
        size++;
        Q.push_back(num);
        while (!Min.empty() && Min.back() > num)
        {
            Min.pop_back();
        }
        Min.push_back(num);
        while (!Max.empty() && Max.back() < num)
        {
            Max.pop_back();
        }
        Max.push_back(num);
    }

    void pop()
    {
        size--;
        if (Min.front() == Q.front())
        {
            Min.pop_front();
        }

        if (Max.front() == Q.front())
        {
            Max.pop_front();
        }
        Q.pop_front();
    }

    int min()
    {
        if (size == 0)
        {
            return INT_MAX;
        }
        return Min.front();
    }

    int max()
    {
        if (size == 0)
        {
            return INT_MIN;
        }
        return Max.front();
    }
};

int main()
{
    /*MyQueue queue;
    cout << "8 1 4 7 2 3\n";
    queue.push(8);
    cout << "min " << queue.min() << '\n';
    cout << "MAX " << queue.max() << '\n';
    queue.push(1);
    cout << "min " << queue.min() << '\n';
    cout << "MAX " << queue.max() << '\n';
    queue.push(4);
    cout << "min " << queue.min() << '\n';
    cout << "MAX " << queue.max() << '\n';
    queue.push(7);
    cout << "min " << queue.min() << '\n';
    cout << "MAX " << queue.max() << '\n';
    queue.push(2);
    cout << "min " << queue.min() << '\n';
    cout << "MAX " << queue.max() << '\n';
    queue.push(3);
    cout << "min " << queue.min() << '\n';
    cout << "MAX " << queue.max() << '\n';
    cout << '\n';
    queue.pop();
    cout << "min " << queue.min() << '\n';
    cout << "MAX " << queue.max() << '\n';
    queue.pop();
    cout << "min " << queue.min() << '\n';
    cout << "MAX " << queue.max() << '\n';
    queue.pop();
    cout << "min " << queue.min() << '\n';
    cout << "MAX " << queue.max() << '\n';
    queue.pop();
    cout << "min " << queue.min() << '\n';
    cout << "MAX " << queue.max() << '\n';
    queue.pop();
    cout << "min " << queue.min() << '\n';
    cout << "MAX " << queue.max() << '\n';
    queue.pop();
    cout << "min " << queue.min() << '\n';
    cout << "MAX " << queue.max() << '\n';*/
    
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, K, el;
    cin >> N >> K;
   
    queue<int> Queue;
    MyQueue helpQueue;

    for (int i = 0; i < N; i++)
    {
        cin >> el;
        Queue.push(el);
    }

    long long totalCount(N);

    while (!Queue.empty())
    {
        helpQueue.push(Queue.front());
        Queue.pop();
        
        while (helpQueue.max() - helpQueue.min() > K)
        {
            helpQueue.pop();
        }
        if (helpQueue.max() - helpQueue.min() <= K && helpQueue.size>1)
        {
            totalCount += helpQueue.size - 1;
        }
    }
    
    cout << totalCount;
    return 0;
}
