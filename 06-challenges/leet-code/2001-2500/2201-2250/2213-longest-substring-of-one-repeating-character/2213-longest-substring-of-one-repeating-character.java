// https://leetcode.com/problems/longest-substring-of-one-repeating-character/
class Solution {
    int[] maxLen, prefLen, sufLen;
    char[] prefChar, sufChar;
    char[] arr;
    int n;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        n = s.length();
        arr = s.toCharArray();
        maxLen = new int[4 * n];
        prefLen = new int[4 * n];
        sufLen = new int[4 * n];
        prefChar = new char[4 * n];
        sufChar = new char[4 * n];
        build(1, 0, n - 1);
        int k = queryIndices.length;
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            arr[queryIndices[i]] = queryCharacters.charAt(i);
            update(1, 0, n - 1, queryIndices[i]);
            result[i] = maxLen[1];
        }
        return result;
    }

    private void setLeaf(int node, int pos) {
        maxLen[node] = prefLen[node] = sufLen[node] = 1;
        prefChar[node] = sufChar[node] = arr[pos];
    }

    private void buildMerge(int node, int left, int mid, int right) {
        prefChar[node] = prefChar[2 * node];
        sufChar[node] = sufChar[2 * node + 1];
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        prefLen[node] = prefLen[2 * node];
        if (prefLen[2 * node] == leftSize && prefChar[2 * node] == prefChar[2 * node + 1]) {
            prefLen[node] = leftSize + prefLen[2 * node + 1];
        }
        sufLen[node] = sufLen[2 * node + 1];
        if (sufLen[2 * node + 1] == rightSize && sufChar[2 * node + 1] == sufChar[2 * node]) {
            sufLen[node] = rightSize + sufLen[2 * node];
        }
        maxLen[node] = Math.max(maxLen[2 * node], maxLen[2 * node + 1]);
        if (sufChar[2 * node] == prefChar[2 * node + 1]) {
            maxLen[node] = Math.max(maxLen[node], sufLen[2 * node] + prefLen[2 * node + 1]);
        }
    }

    private void build(int node, int left, int right) {
        if (left == right) {
            setLeaf(node, left);
            return;
        }
        int mid = (left + right) / 2;
        build(2 * node, left, mid);
        build(2 * node + 1, mid + 1, right);
        buildMerge(node, left, mid, right);
    }

    private void update(int node, int left, int right, int pos) {
        if (left == right) {
            setLeaf(node, pos);
            return;
        }
        int mid = (left + right) / 2;
        if (pos <= mid) {
            update(2 * node, left, mid, pos);
        } else {
            update(2 * node + 1, mid + 1, right, pos);
        }
        buildMerge(node, left, mid, right);
    }
}
