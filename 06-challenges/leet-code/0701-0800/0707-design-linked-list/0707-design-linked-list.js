// https://leetcode.com/problems/design-linked-list/

class MyLinkedList {
    constructor() {
        this.dummy = { val: 0, next: null };
        this.tail = this.dummy;
        this.size = 0;
    }

    get(index) {
        if (index < 0 || index >= this.size) return -1;
        let curr = this.dummy.next;
        for (let i = 0; i < index; i++) curr = curr.next;
        return curr.val;
    }

    addAtHead(val) {
        const node = { val, next: this.dummy.next };
        this.dummy.next = node;
        if (this.size === 0) this.tail = node;
        this.size++;
    }

    addAtTail(val) {
        this.tail.next = { val, next: null };
        this.tail = this.tail.next;
        this.size++;
    }

    addAtIndex(index, val) {
        if (index > this.size) return;
        if (index <= 0) { this.addAtHead(val); return; }
        if (index === this.size) { this.addAtTail(val); return; }
        let prev = this.dummy;
        for (let i = 0; i < index; i++) prev = prev.next;
        const node = { val, next: prev.next };
        prev.next = node;
        this.size++;
    }

    deleteAtIndex(index) {
        if (index < 0 || index >= this.size) return;
        let prev = this.dummy;
        for (let i = 0; i < index; i++) prev = prev.next;
        if (prev.next === this.tail) this.tail = prev;
        prev.next = prev.next.next;
        this.size--;
    }
}
