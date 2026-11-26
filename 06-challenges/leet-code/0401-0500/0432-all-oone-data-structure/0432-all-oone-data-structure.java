// https://leetcode.com/problems/all-oone-data-structure/

// Solution: Doubly Linked List of Buckets + HashMap — O(1) time, O(n) space
class AllOne {
    private static class Bucket {
        int count;
        Set<String> keys;
        Bucket prev, next;

        Bucket(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private final Map<String, Bucket> keyToBucket;
    private final Bucket head;  // sentinel min
    private final Bucket tail;  // sentinel max

    public AllOne() {
        keyToBucket = new HashMap<>();
        head = new Bucket(0);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    private void insertBucketAfter(Bucket prev, Bucket bucket) {
        bucket.prev = prev;
        bucket.next = prev.next;
        prev.next.prev = bucket;
        prev.next = bucket;
    }

    private void removeBucket(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
    }

    public void inc(String key) {
        if (keyToBucket.containsKey(key)) {
            Bucket curr = keyToBucket.get(key);
            Bucket next = curr.next;
            if (next.count != curr.count + 1) {
                Bucket newBucket = new Bucket(curr.count + 1);
                insertBucketAfter(curr, newBucket);
                next = newBucket;
            }
            next.keys.add(key);
            keyToBucket.put(key, next);
            curr.keys.remove(key);
            if (curr.keys.isEmpty()) {
                removeBucket(curr);
            }
        } else {
            Bucket first = head.next;
            if (first.count != 1) {
                Bucket newBucket = new Bucket(1);
                insertBucketAfter(head, newBucket);
                first = newBucket;
            }
            first.keys.add(key);
            keyToBucket.put(key, first);
        }
    }

    public void dec(String key) {
        Bucket curr = keyToBucket.get(key);
        if (curr.count == 1) {
            keyToBucket.remove(key);
        } else {
            Bucket prev = curr.prev;
            if (prev.count != curr.count - 1) {
                Bucket newBucket = new Bucket(curr.count - 1);
                insertBucketAfter(prev, newBucket);
                prev = newBucket;
            }
            prev.keys.add(key);
            keyToBucket.put(key, prev);
        }
        curr.keys.remove(key);
        if (curr.keys.isEmpty()) {
            removeBucket(curr);
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
}
