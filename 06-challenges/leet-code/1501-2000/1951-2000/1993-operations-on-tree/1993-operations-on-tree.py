# https://leetcode.com/problems/operations-on-tree/
class LockingTree:
    def __init__(self, parent: list[int]):
        n = len(parent)
        self.parent = parent
        self.locked_by = [0] * n
        self.children = [[] for _ in range(n)]
        for i in range(1, n):
            self.children[parent[i]].append(i)

    def lock(self, num: int, user: int) -> bool:
        if self.locked_by[num] != 0:
            return False
        self.locked_by[num] = user
        return True

    def unlock(self, num: int, user: int) -> bool:
        if self.locked_by[num] != user:
            return False
        self.locked_by[num] = 0
        return True

    def upgrade(self, num: int, user: int) -> bool:
        if self.locked_by[num] != 0:
            return False
        cur = self.parent[num]
        while cur != -1:
            if self.locked_by[cur] != 0:
                return False
            cur = self.parent[cur]
        if not self._has_locked_descendant(num):
            return False
        self._unlock_descendants(num)
        self.locked_by[num] = user
        return True

    def _has_locked_descendant(self, node: int) -> bool:
        for child in self.children[node]:
            if self.locked_by[child] != 0 or self._has_locked_descendant(child):
                return True
        return False

    def _unlock_descendants(self, node: int) -> None:
        for child in self.children[node]:
            self.locked_by[child] = 0
            self._unlock_descendants(child)
