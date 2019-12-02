class KthLargest {
private:
    priority_queue<int ,vector<int>, greater<int>> minHeap;
    int k;
public:
    KthLargest(int k, vector<int>& nums) : k(k) {
        int size(nums.size()),i;
       
        for (i = 0; i < size; i++)
        {
            if (pq.size() < k)
                minHeap.push(nums[i]);
            else
            {
                if (nums[i] > pq.top())
                {
                    minHeap.pop();
                    minHeap.push(nums[i]);
                }
            }
        }
    }
   
    int add(int val) {
        if (minHeap.size() < k)
            minHeap.push(val);
        else
        {
            if (val > pq.top())
            {
                minHeap.pop();
                minHeap.push(val);
            }
        }
        return minHeap.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */
