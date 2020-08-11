// github.com/andy489

// https://leetcode.com/problems/minimum-number-of-refueling-stops/

class Solution {
public:
    int minRefuelStops(int target, int startFuel, vector<vector<int>>& stations) {
        priority_queue<int> pq;
        int passed = 0, counter = 0;
        stations.push_back({target, 0});
        int size = (int)stations.size();

        while (passed < size && startFuel < target){
            while (!pq.empty() && stations[passed][0] > startFuel){
                startFuel += pq.top();
                pq.pop();
                counter++;
            }

            if (stations[passed][0] > startFuel)
                return -1;

            pq.push(stations[passed][1]);
            passed++;
        }

        return counter;
    }
};
