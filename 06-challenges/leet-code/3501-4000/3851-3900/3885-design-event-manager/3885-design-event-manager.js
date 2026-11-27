// https://leetcode.com/problems/design-event-manager/

class EventManager {
    constructor(events) {
        this.heap = [];
        this.priorities = new Map();
        this.active = new Set();
        for (const [eventId, priority] of events) {
            this._push(priority, eventId);
            this.priorities.set(eventId, priority);
            this.active.add(eventId);
        }
    }

    _push(priority, eventId) {
        const heap = this.heap;
        heap.push([priority, eventId]);
        let i = heap.length - 1;
        while (i > 0) {
            const p = (i - 1) >> 1;
            if (this._cmp(heap[p], heap[i]) > 0) {
                [heap[p], heap[i]] = [heap[i], heap[p]];
                i = p;
            } else { break; }
        }
    }

    _pop() {
        const heap = this.heap;
        const top = heap[0];
        const last = heap.pop();
        if (heap.length > 0) {
            heap[0] = last;
            let i = 0;
            while (true) {
                let s = i, l = 2*i+1, r = 2*i+2;
                if (l < heap.length && this._cmp(heap[l], heap[s]) < 0) { s = l; }
                if (r < heap.length && this._cmp(heap[r], heap[s]) < 0) { s = r; }
                if (s !== i) { [heap[s], heap[i]] = [heap[i], heap[s]]; i = s; }
                else { break; }
            }
        }
        return top;
    }

    // compare: higher priority first, then smaller eventId
    _cmp(a, b) {
        if (a[0] !== b[0]) { return b[0] - a[0]; }
        return a[1] - b[1];
    }

    updatePriority(eventId, newPriority) {
        this.priorities.set(eventId, newPriority);
        this._push(newPriority, eventId);
    }

    pollHighest() {
        while (this.heap.length > 0) {
            const [pri, id] = this._pop();
            if (this.active.has(id) && this.priorities.get(id) === pri) {
                this.active.delete(id);
                this.priorities.delete(id);
                return id;
            }
        }
        return -1;
    }
}
