// github.com/andy489

// https://www.hackerrank.com/contests/practice-2-sda/challenges/schedule-sda

#include <iostream>
#include <vector>

using namespace std;

struct Event {
    int start, end;

    Event() : start(0), end(0) {};

    Event(int start, int end) : start(start), end(end) {};
};

int partition(vector<Event> &events, int start, int end) {
    int midIndex = start + (end - start) / 2;
    swap(events[midIndex], events[end]);

    int pivot = events[end].end;
    int pIndex = start;

    for (int i = start; i < end; i++) {
        if (events[i].end <= pivot) {
            swap(events[i], events[pIndex]);
            pIndex++;
        }
    }
    swap(events[pIndex], events[end]);
    return pIndex;
}

void quickSort(std::vector<Event> &events, int start, int end) {
    if (start >= end) return;
    int pivot = partition(events, start, end);
    quickSort(events, start, pivot - 1);
    quickSort(events, pivot + 1, end);
}

size_t maxEvents(vector<Event> &events) {
    int count(1);
    int r1 = events[0].end;

    int SIZE = (int) events.size();
    for (int i = 1; i < SIZE; ++i) {
        int l1 = events[i].start, r2 = events[i].end;

        if (l1 >= r1)
            ++count, r1 = r2;
    }
    return count;
}

int main() {
    int N, i(0), s, e;
    cin >> N;

    if (N == 0)
        return cout << 0, 0;

    vector<Event> events;
    events.reserve(N);

    for (; i < N; ++i) {
        cin >> s >> e;
        events.push_back(Event(s, s + e));
    }
    quickSort(events, 0, N - 1);
    return cout << maxEvents(events), 0;
}
