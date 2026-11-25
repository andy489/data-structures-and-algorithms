# https://leetcode.com/problems/bus-routes/

from collections import defaultdict, deque

class Solution:
    def numBusesToDestination(self, routes: list[list[int]], source: int, target: int) -> int:
        if source == target:
            return 0
        stop_to_routes = defaultdict(list)
        for i, route in enumerate(routes):
            for stop in route:
                stop_to_routes[stop].append(i)
        visited_stops = {source}
        visited_routes = set()
        queue = deque([source])
        buses = 0
        while queue:
            buses += 1
            for _ in range(len(queue)):
                stop = queue.popleft()
                for route in stop_to_routes[stop]:
                    if route in visited_routes:
                        continue
                    visited_routes.add(route)
                    for next_stop in routes[route]:
                        if next_stop == target:
                            return buses
                        if next_stop not in visited_stops:
                            visited_stops.add(next_stop)
                            queue.append(next_stop)
        return -1
