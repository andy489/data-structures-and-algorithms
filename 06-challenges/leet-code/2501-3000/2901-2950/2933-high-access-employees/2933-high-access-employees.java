// https://leetcode.com/problems/high-access-employees/

// Solution: Group and Sort — O(n log n) time, O(n) space
class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> timesByEmployee = new HashMap<>();
        for (List<String> entry : access_times) {
            String name = entry.get(0);
            String timeStr = entry.get(1);
            int minutes = Integer.parseInt(timeStr.substring(0, 2)) * 60
                        + Integer.parseInt(timeStr.substring(2));
            timesByEmployee.computeIfAbsent(name, k -> new ArrayList<>()).add(minutes);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : timesByEmployee.entrySet()) {
            List<Integer> times = entry.getValue();
            Collections.sort(times);
            for (int i = 0; i + 2 < times.size(); i++) {
                if (times.get(i + 2) - times.get(i) < 60) {
                    result.add(entry.getKey());
                    break;
                }
            }
        }
        return result;
    }
}
