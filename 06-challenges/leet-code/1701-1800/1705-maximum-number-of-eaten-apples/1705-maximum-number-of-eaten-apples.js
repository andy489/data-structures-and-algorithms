// https://leetcode.com/problems/maximum-number-of-eaten-apples/

var eatenApples = function(apples, days) {
    // Min-heap: [expiryDay, count]
    const heap = new MinPriorityQueue({ priority: x => x[0] });
    const n = apples.length;
    let eaten = 0;
    let i = 0;
    while (i < n || heap.size() > 0) {
        if (i < n && apples[i] > 0) {
            heap.enqueue([i + days[i], apples[i]]);
        }
        while (heap.size() > 0 && heap.front().element[0] <= i) {
            heap.dequeue();
        }
        if (heap.size() > 0) {
            const top = heap.front().element;
            top[1]--;
            if (top[1] === 0) {
                heap.dequeue();
            }
            eaten++;
        }
        i++;
    }
    return eaten;
};
