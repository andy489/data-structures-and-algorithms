// https://leetcode.com/problems/design-an-ordered-stream/

// Solution: Array with Pointer — O(n) total time, O(n) space
class OrderedStream {
    private String[] data;
    private int ptr;

    public OrderedStream(int n) {
        data = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        data[idKey] = value;
        List<String> result = new ArrayList<>();
        while (ptr < data.length && data[ptr] != null) {
            result.add(data[ptr++]);
        }
        return result;
    }
}
