# Search in Rotated Sorted Array: Problem 1 vs Problem 2

## The two problems

| | Problem 1 | Problem 2 |
|---|---|---|
| Array values | **Distinct** | **Duplicates allowed** |
| Return type | `int` (index, or `-1`) | `boolean` |
| Time (average) | O(log n) | O(log n) |
| Time (worst) | **O(log n)** | **O(n)** |
| Space | O(1) | O(1) |

The only real difference is duplicates. That one change breaks a key assumption and forces one extra step.

---

## Core idea (both problems)

At every step, **at least one half is sorted**. Find the sorted half, check whether `k` lies in its range, then keep that half or discard it.

Why: a rotated array has at most one "drop" (a big value followed by a small one, like `7 -> 0`). The drop can sit in only one half, so the other half is sorted.

---

## Problem 1: distinct values

```java
class Solution {
    public int search(int[] nums, int k) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == k) return mid;

            if (nums[s] <= nums[mid]) {               // left half sorted
                if (nums[s] <= k && k < nums[mid]) e = mid - 1;
                else s = mid + 1;
            } else {                                  // left not sorted -> right sorted
                if (nums[mid] < k && k <= nums[e]) s = mid + 1;
                else e = mid - 1;
            }
        }
        return -1;
    }
}
```

With distinct values, `nums[s] <= nums[mid]` **proves** the left half is sorted. So every iteration halves the range: **O(log n) always**.

---

## Problem 2: duplicates (the edge case)

```java
class Solution {
    public boolean search(int[] nums, int k) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == k) return true;

            // EDGE CASE: can't tell which half is sorted, so shrink
            if (nums[s] == nums[mid] && nums[mid] == nums[e]) {
                s++;
                e--;
                continue;
            }

            if (nums[s] <= nums[mid]) {               // left half sorted
                if (nums[s] <= k && k < nums[mid]) e = mid - 1;
                else s = mid + 1;
            } else {                                  // left not sorted -> right sorted
                if (nums[mid] < k && k <= nums[e]) s = mid + 1;
                else e = mid - 1;
            }
        }
        return false;
    }
}
```

### Why duplicates break the check

With duplicates, `nums[s] == nums[mid]` no longer proves the left half is sorted.

Example: `nums = [1, 0, 1, 1, 1]`, `k = 0`

- `s = 0, e = 4, mid = 2`, and `nums[s] = nums[mid] = nums[e] = 1`
- The check `nums[s] <= nums[mid]` says "left is sorted", but the left half `[1, 0, 1]` is **not** sorted. The drop is inside it.
- The code would conclude `0` is not in `[1, 1)` and set `s = mid + 1`, **throwing away the `0`**. Wrong answer.

### Why only the all-three-equal case is ambiguous

If `nums[s] == nums[mid]` but `nums[e]` is different, the left half really is sorted. A drop inside `[s..mid]` would force `nums[s] >= nums[e] >= nums[mid]`. Since `nums[s] == nums[mid]`, that makes all three equal, which contradicts `nums[e]` being different.

So the only truly ambiguous case is `nums[s] == nums[mid] == nums[e]`.

### Why `s++` and `e--` is safe

`nums[mid] != k` was already checked, and `nums[s]` and `nums[e]` equal `nums[mid]`. So neither endpoint can be `k`, and dropping both loses nothing.

---

## Time complexity

### Problem 1: O(log n)

Every iteration halves the range (`n -> n/2 -> n/4 -> ...`). It takes log n steps to reach 1.

### Problem 2: O(log n) average, O(n) worst

- **Average:** the three values are usually not all equal, so the normal halving branches run: O(log n).
- **Worst:** when the all-equal case keeps firing, the range shrinks by **2** per iteration (`n -> n-2 -> n-4 -> ...`). That takes **n/2** steps, which is **O(n)** because constants are dropped.

**Worst-case input:** `nums = [1,1,1,1,1,1,1,1]`, `k = 2`. Every iteration hits the shrink branch, so the range goes 8 -> 6 -> 4 -> 2 -> 0, and it returns `false` after n/2 iterations.

### Halving vs subtracting

| n | halving steps (log n) | shrink-by-2 steps (n/2) |
|---|---|---|
| 16 | 4 | 8 |
| 1,000 | ~10 | 500 |
| 1,000,000 | ~20 | 500,000 |

Dividing by 2 and subtracting 2 look similar but grow very differently.

### Can O(n) be beaten?

No. In an input like `[1,1,1,1,0,1,1]`, nothing tells you which side the `0` is on. No comparison-based method can do better than O(n) in the worst case.

---

## Quick summary

- **Problem 1:** distinct values, `nums[s] <= nums[mid]` proves the left is sorted, O(log n) always.
- **Problem 2:** duplicates, `s == mid == e` hides which half is sorted, so shrink with `s++; e--`. O(log n) average, O(n) worst.
- Everything else (range checks, `<=` on the sorted-half test, half-open `mid` side) is identical.
