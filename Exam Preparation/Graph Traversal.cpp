//https://leetcode.com/problems/keys-and-rooms/
class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) 
    {
        size_t n=rooms.size();
        vector<bool>visited(n);
        stack<int>s;
        s.push(0);
        visited[0]=true;
        while(!s.empty())
        {
            int cur=s.top();
            s.pop();
            for(const auto& child:rooms[cur])
            {
                if(!visited[child])
                {
                    s.push(child);
                    visited[child]=true;
                }
            }
        }
        for(const auto& x:visited) if(!x) return false;
        return true;
    }
};
