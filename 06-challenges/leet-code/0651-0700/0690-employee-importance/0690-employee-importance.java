// https://leetcode.com/problems/employee-importance/

// Solution: BFS — O(n) time, O(n) space
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> idMap = new HashMap<>();
        for (Employee e : employees) {
            idMap.put(e.id, e);
        }
        int total = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            Employee e = idMap.get(queue.poll());
            total += e.importance;
            for (int subId : e.subordinates) {
                queue.offer(subId);
            }
        }
        return total;
    }
}
