// https://leetcode.com/problems/operations-on-tree/
class LockingTree {
    private int[] parent;
    private int[] lockedBy;
    private List<List<Integer>> children;

    public LockingTree(int[] parent) {
        this.parent = parent;
        int n = parent.length;
        lockedBy = new int[n];
        children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            children.get(parent[i]).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (lockedBy[num] != 0) {
            return false;
        }
        lockedBy[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (lockedBy[num] != user) {
            return false;
        }
        lockedBy[num] = 0;
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (lockedBy[num] != 0) {
            return false;
        }
        int cur = parent[num];
        while (cur != -1) {
            if (lockedBy[cur] != 0) {
                return false;
            }
            cur = parent[cur];
        }
        if (!hasLockedDescendant(num)) {
            return false;
        }
        unlockDescendants(num);
        lockedBy[num] = user;
        return true;
    }

    private boolean hasLockedDescendant(int node) {
        for (int child : children.get(node)) {
            if (lockedBy[child] != 0 || hasLockedDescendant(child)) {
                return true;
            }
        }
        return false;
    }

    private void unlockDescendants(int node) {
        for (int child : children.get(node)) {
            lockedBy[child] = 0;
            unlockDescendants(child);
        }
    }
}
