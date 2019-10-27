#include <iostream>
#include <vector>

struct Event
{
    int start, end;
    Event() :start(0), end(0) {};
    Event(int start, int end) :start(start), end(end) {};
};

size_t partition(std::vector<Event>& events, size_t start, size_t end)
{
    size_t midIndex = start + (end - start) / 2;
    std::swap(events[midIndex], events[end]);

    int pivot = events[end].end;
    size_t pIndex = start;

    for (size_t i = start; i < end; i++)
    {
        if (events[i].end <= pivot)
        {
            std::swap(events[i], events[pIndex]);
            pIndex++;
        }
    }
    std::swap(events[pIndex], events[end]);
    return pIndex;
}

void quickSort(std::vector<Event>& events, int start, int end)
{
    if (start >= end) return;
    size_t pivot = partition(events, start, end);
    quickSort(events, start, pivot - 1);
    quickSort(events, pivot + 1, end);
}

size_t maxEvents(std::vector<Event>& events)
{
    size_t count(1);
    int r1 = events[0].end;

    int SIZE = (int)events.size();
    for (int i = 1; i < SIZE; ++i)
    {
        int l1 = events[i].start;
        int r2 = events[i].end;

        if (l1 >= r1)
        {
            count++;
            r1 = r2;
        }
    }
    return count;
}

int main()
{
    int N;std::cin >> N;

    if (N==0)
    {
        std::cout << 0;
        return 0;
    }

    std::vector<Event>events; events.reserve(N);

    int start, end;
    int i; for (i = 0; i < N; ++i)
    {
        std::cin >> start >> end;
        events.push_back(Event(start, start + end));
    }

    quickSort(events, 0, N - 1);

    //for (int i = 0; i < N; i++)    std::cout << events[i].start << '-' << events[i].end<<'\n';

    std::cout<<maxEvents(events);

    return 0;
}
