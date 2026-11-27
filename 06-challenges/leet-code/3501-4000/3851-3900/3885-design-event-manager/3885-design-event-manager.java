// https://leetcode.com/problems/design-event-manager/

class EventManager {
    // max-heap by priority, then min eventId
    // store [-priority, eventId] -> use PQ with comparator
    private PriorityQueue<int[]> pq;
    private Map<Integer, Integer> priorities;
    private Set<Integer> active;

    public EventManager(int[][] events) {
        pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        priorities = new HashMap<>();
        active = new HashSet<>();
        for (int[] e : events) {
            pq.offer(new int[]{e[1], e[0]});
            priorities.put(e[0], e[1]);
            active.add(e[0]);
        }
    }

    public void updatePriority(int eventId, int newPriority) {
        priorities.put(eventId, newPriority);
        pq.offer(new int[]{newPriority, eventId});
    }

    public int pollHighest() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int pri = top[0], id = top[1];
            if (active.contains(id) && priorities.get(id) == pri) {
                active.remove(id);
                priorities.remove(id);
                return id;
            }
        }
        return -1;
    }
}
