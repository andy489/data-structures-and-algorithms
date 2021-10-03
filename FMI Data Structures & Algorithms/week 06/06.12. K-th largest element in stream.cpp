// github.com/andy489

// https://leetcode.com/problems/kth-largest-element-in-a-stream/

class KthLargest {
    priority_queue<int, vector<int>, greater<int>> minHeap;
    int k;
public:
    KthLargest(int k, vector<int> &nums) : k(k) {
        int size(nums.size()), i(0);

        for (; i < size; ++i) {
            if (minHeap.size() < k)
                minHeap.push(nums[i]);
            else {
                if (nums[i] > minHeap.top()) {
                    minHeap.pop();
                    minHeap.push(nums[i]);
                }
            }
        }
    }

    int add(int val) {
        if (minHeap.size() < k)
            minHeap.push(val);
        else {
            if (val > minHeap.top()) {
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
