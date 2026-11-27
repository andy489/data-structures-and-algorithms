// https://leetcode.com/problems/furthest-building-you-can-reach/

var furthestBuilding = function(heights, bricks, ladders) {
    const minHeap = new MinPriorityQueue();
    for (let i = 0; i < heights.length - 1; i++) {
        const d = heights[i + 1] - heights[i];
        if (d <= 0) {
            continue;
        }
        minHeap.enqueue(d);
        if (minHeap.size() > ladders) {
            bricks -= minHeap.dequeue().element;
        }
        if (bricks < 0) {
            return i;
        }
    }
    return heights.length - 1;
};
