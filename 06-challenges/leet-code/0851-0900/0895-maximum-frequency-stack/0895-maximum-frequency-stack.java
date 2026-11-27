// https://leetcode.com/problems/maximum-frequency-stack/

// Solution: Frequency + Group Stacks — O(1) push/pop
class FreqStack {
    private Map<Integer, Integer> freq = new HashMap<>();
    private Map<Integer, Deque<Integer>> group = new HashMap<>();
    private int maxFreq = 0;

    public void push(int val) {
        int f = freq.merge(val, 1, Integer::sum);
        maxFreq = Math.max(maxFreq, f);
        group.computeIfAbsent(f, k -> new ArrayDeque<>()).push(val);
    }

    public int pop() {
        int val = group.get(maxFreq).pop();
        if (group.get(maxFreq).isEmpty()) { maxFreq--; }
        freq.merge(val, -1, Integer::sum);
        return val;
    }
}
