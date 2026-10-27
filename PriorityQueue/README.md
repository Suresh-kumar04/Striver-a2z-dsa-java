# Min Priority Queue (Binary Heap)

## What it is
A **min-heap**: the smallest element is always at index `0`. Stored as an array, treated as a complete binary tree.

## Array ↔ tree indexing
For node at index `i`:
```
parent(i) = (i - 1) / 2
left(i)   = 2*i + 1
right(i)  = 2*i + 2
```

Example:
```
        0 (min)
       / \
      1   2
     / \
    3   4

Array: [0, 1, 2, 3, 4]
```

## Heap property (min-heap)
Every parent ≤ both children.

## Your implementation (`PriorityQueue.java`)

### `offer(x)` — insert
1. Append at end of array
2. **Up-heap (bubble up):** swap with parent while child < parent

### `poll()` — extract min
1. Save `arr[0]`
2. Move last element to root, remove last
3. **Down-heap (bubble down):** swap with smaller child while parent > child

### `peek()` — see min
Return `arr[0]` without removing.

## Why last element goes to root on `poll`
Removing index 0 leaves a hole. Moving the last leaf to root keeps the tree **complete** (no gaps in the array). Then down-heap restores the heap property.

## Niche points

1. **Complete binary tree** — array representation only works if the tree has no gaps.
2. **Up-heap stops at index 0** — root has no parent.
3. **Down-heap picks smaller child** — for min-heap, swap with the **minimum** of left/right.
4. **`compareTo < 0`** means current node is smaller → bubble up (min-heap).
5. **Max-heap** — flip comparisons (`>` instead of `<`).
6. **Duplicate values** — allowed; heap property still holds.
7. **Empty check** — always guard `peek()` / `poll()`.

## Complexity
| Operation | Time |
|-----------|------|
| offer | O(log n) |
| poll | O(log n) |
| peek | O(1) |

Height of heap ≈ log₂(n).

## Build heap from array
- Naive: n inserts → O(n log n)
- **Heapify bottom-up** → O(n) (Floyd's build-heap)

## When to use
- Dijkstra's algorithm
- Merge k sorted lists
- Top-k elements
- Huffman coding (you use Java's `PriorityQueue` there)

## Small cleanup notes in your code
- Constructor `PriorityQueue(T data)` ignores `data` — remove or use it.
- Prefer `IllegalStateException("pq is empty")` over generic `Exception`.
