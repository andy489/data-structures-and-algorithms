class Solution {
public:
    int minRefuelStops(int target, int startFuel, vector<vector<int>>& stations) {
        priority_queue<int> pq;
        int coord = 0;
        int passed = 0;
        int counter = 0;
        stations.push_back({target, 0});
        int size = (int)stations.size();
       
        while (passed < size && startFuel < target)
        {  
            while (!pq.empty() && stations[passed][0] > startFuel)
            {
                startFuel += pq.top();
                pq.pop();
                counter++;
            }
           
            if (stations[passed][0] > startFuel)
                return -1;
           
            pq.push(stations[passed][1]);
            coord = stations[passed][0];
            passed++;
        }
       
        return counter;
    }
};
