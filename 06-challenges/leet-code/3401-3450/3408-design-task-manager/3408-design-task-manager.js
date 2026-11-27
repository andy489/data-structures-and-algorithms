// https://leetcode.com/problems/design-task-manager/
class TaskManager {
    constructor(tasks) {
        // Use a Map for O(log n) operations via sorted structure
        // taskId -> [userId, priority]
        this.taskMap = new Map();
        // We'll use a sorted set represented as array + binary search for small constraints
        // For efficiency, store as sorted array of [priority, taskId]
        this.sortedTasks = [];
        for (const [userId, taskId, priority] of tasks) {
            this._insert(priority, taskId);
            this.taskMap.set(taskId, [userId, priority]);
        }
    }

    _insert(priority, taskId) {
        // Insert maintaining sorted order: highest priority first, then highest taskId
        let lo = 0, hi = this.sortedTasks.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            const [mp, mt] = this.sortedTasks[mid];
            if (mp > priority || (mp === priority && mt > taskId)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        this.sortedTasks.splice(lo, 0, [priority, taskId]);
    }

    _remove(priority, taskId) {
        let lo = 0, hi = this.sortedTasks.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            const [mp, mt] = this.sortedTasks[mid];
            if (mp > priority || (mp === priority && mt > taskId)) {
                lo = mid + 1;
            } else if (mp === priority && mt === taskId) {
                this.sortedTasks.splice(mid, 1);
                return;
            } else {
                hi = mid;
            }
        }
    }

    add(userId, taskId, priority) {
        this._insert(priority, taskId);
        this.taskMap.set(taskId, [userId, priority]);
    }

    edit(taskId, newPriority) {
        const [userId, oldPriority] = this.taskMap.get(taskId);
        this._remove(oldPriority, taskId);
        this._insert(newPriority, taskId);
        this.taskMap.set(taskId, [userId, newPriority]);
    }

    rmv(taskId) {
        const [userId, priority] = this.taskMap.get(taskId);
        this._remove(priority, taskId);
        this.taskMap.delete(taskId);
    }

    execTop() {
        if (this.sortedTasks.length === 0) {
            return -1;
        }
        const [priority, taskId] = this.sortedTasks.shift();
        const [userId] = this.taskMap.get(taskId);
        this.taskMap.delete(taskId);
        return userId;
    }
}
