// https://leetcode.com/problems/minimum-number-of-refueling-stops/

var minRefuelStops = function(target, startFuel, stations) {
    const all = [...stations, [target, 0]];
    const maxHeap = new MaxPriorityQueue({priority: x => x});
    let fuel = startFuel, stops = 0, prev = 0;
    for (const [pos, cap] of all) {
        fuel -= pos - prev;
        while (fuel < 0 && maxHeap.size()) {
            fuel += maxHeap.dequeue().element;
            stops++;
        }
        if (fuel < 0) return -1;
        if (cap > 0) maxHeap.enqueue(cap);
        prev = pos;
    }
    return stops;
};
