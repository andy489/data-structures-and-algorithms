/* logic that will work even with input data in the form "asd23s  kjd30n x1 &$3ds" instead of "23 30 1 3" .
The following logic literally extracts all numbers from a given text, covering their lengths and delimiters.
For example if we have a text like "Example1, number 12 asd489asd. 1st and 2nd. 00asd" The stack will be filled with:
1, 12, 489, 1, 2 and 0. Stack operations are performed for a constant time. */

#include <iostream>
#include <stack>
#include <iomanip>

using namespace std;

int getDurationOfJourneyInMinutes(const string& line) {
    //utility stack to store extracted numbers from line from back to front
    stack<int> numUtil; // utility stack with numbers
    //my idea is to extract numbers from string using the idea from Reverse Polish Notation
    size_t length = line.length();
    int count(0), i(0);
    for (; i < length; ++i) {
        if (line[i] >= '0' && line[i] <= '9') {
            if (count > 0) {
                int number = numUtil.top() * 10 + (line[i] - '0');
                numUtil.pop();
                numUtil.push(number);
            } else {
                numUtil.push(line[i] - '0');
                ++count;
            }
        } else count = 0;
    }
    stack<int> num;
    while (!numUtil.empty()) {
        num.push(numUtil.top());
        numUtil.pop();
    } // now in min stack we have extracted all numbers from the input line

    size_t hoursStart, minStart, hoursFin, minFin;
    hoursStart = num.top();
    num.pop();
    minStart = num.top();
    num.pop();
    hoursFin = num.top();
    num.pop();
    minFin = num.top();
    num.pop();

    int minutes1 = hoursStart * 60 + minStart;
    int minutes2 = hoursFin * 60 + minFin;
    int check;

    if (minutes1 <= minutes2) check = 0;
    else check = 24 * 60;

    int diff = check + minutes2 - minutes1;
    return diff;
}

int main() {
    int durations[3], index(0), i(0);
    for (; i < 3; ++i) {
        string line;
        getline(cin, line);
        durations[index++] = getDurationOfJourneyInMinutes(line);
    }
    int minTrip = 24 * 60, maxTrip = 0;

    for  (i = 0; i < 3; ++i) {
        if (durations[i] > maxTrip) maxTrip = durations[i];
        if (durations[i] < minTrip) minTrip = durations[i];
    }
    cout << minTrip / 60 << ':' << setfill('0') << setw(2) << minTrip % 60 << '\n';
    cout << maxTrip / 60 << ':' << setfill('0') << setw(2) << maxTrip % 60 << '\n';
    return 0;
}
