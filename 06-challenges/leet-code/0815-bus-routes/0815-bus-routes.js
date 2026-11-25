// https://leetcode.com/problems/bus-routes/

var numBusesToDestination = function(routes, source, target) {
    if (source === target) { return 0; }
    const stopToRoutes = new Map();
    for (let i = 0; i < routes.length; i++) {
        for (const stop of routes[i]) {
            if (!stopToRoutes.has(stop)) { stopToRoutes.set(stop, []); }
            stopToRoutes.get(stop).push(i);
        }
    }
    const visitedStops = new Set([source]);
    const visitedRoutes = new Set();
    let queue = [source];
    let buses = 0;
    while (queue.length) {
        buses++;
        const next = [];
        for (const stop of queue) {
            for (const route of (stopToRoutes.get(stop) || [])) {
                if (visitedRoutes.has(route)) { continue; }
                visitedRoutes.add(route);
                for (const nextStop of routes[route]) {
                    if (nextStop === target) { return buses; }
                    if (!visitedStops.has(nextStop)) {
                        visitedStops.add(nextStop);
                        next.push(nextStop);
                    }
                }
            }
        }
        queue = next;
    }
    return -1;
};
