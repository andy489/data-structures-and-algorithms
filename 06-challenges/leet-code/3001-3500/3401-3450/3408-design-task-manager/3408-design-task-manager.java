// https://leetcode.com/problems/design-task-manager/
class TaskManager {
    private TreeSet<int[]> taskSet;  // [priority, taskId]
    private HashMap<Integer, int[]> taskMap;  // taskId -> [userId, priority]

    public TaskManager(List<List<Integer>> tasks) {
        taskSet = new TreeSet<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        taskMap = new HashMap<>();
        for (List<Integer> task : tasks) {
            int userId = task.get(0), taskId = task.get(1), priority = task.get(2);
            taskSet.add(new int[]{priority, taskId});
            taskMap.put(taskId, new int[]{userId, priority});
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskSet.add(new int[]{priority, taskId});
        taskMap.put(taskId, new int[]{userId, priority});
    }

    public void edit(int taskId, int newPriority) {
        int[] info = taskMap.get(taskId);
        taskSet.remove(new int[]{info[1], taskId});
        taskSet.add(new int[]{newPriority, taskId});
        taskMap.put(taskId, new int[]{info[0], newPriority});
    }

    public void rmv(int taskId) {
        int[] info = taskMap.remove(taskId);
        taskSet.remove(new int[]{info[1], taskId});
    }

    public int execTop() {
        if (taskSet.isEmpty()) {
            return -1;
        }
        int[] top = taskSet.pollFirst();
        int taskId = top[1];
        int[] info = taskMap.remove(taskId);
        return info[0];
    }
}
