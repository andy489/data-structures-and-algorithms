// https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/

// Solution: Sort Times per Worker, Sliding Window — O(n log n) time, O(n) space
class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> timeMap = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            int mins = toMinutes(keyTime[i]);
            timeMap.computeIfAbsent(keyName[i], k -> new ArrayList<>()).add(mins);
        }
        List<String> alerted = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : timeMap.entrySet()) {
            List<Integer> times = entry.getValue();
            Collections.sort(times);
            for (int j = 2; j < times.size(); j++) {
                if (times.get(j) - times.get(j - 2) <= 60) {
                    alerted.add(entry.getKey());
                    break;
                }
            }
        }
        Collections.sort(alerted);
        return alerted;
    }

    private int toMinutes(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60
             + Integer.parseInt(time.substring(3));
    }
}
