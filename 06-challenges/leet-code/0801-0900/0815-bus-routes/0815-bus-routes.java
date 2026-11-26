// https://leetcode.com/problems/bus-routes/

// Solution: BFS on Routes — O(Σ|route|) time, O(Σ|route|) space
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, x -> new ArrayList<>()).add(i);
            }
        }
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visitedStops.add(source);
        int buses = 0;
        while (!queue.isEmpty()) {
            buses++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int stop = queue.poll();
                for (int route : stopToRoutes.getOrDefault(stop, new ArrayList<>())) {
                    if (visitedRoutes.contains(route)) {
                        continue;
                    }
                    visitedRoutes.add(route);
                    for (int nextStop : routes[route]) {
                        if (nextStop == target) {
                            return buses;
                        }
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
