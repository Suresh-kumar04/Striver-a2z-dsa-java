# Search in a Rotated Sorted Array — Notes

## 1. The problem

Given an ascending sorted array that has been rotated, search for `k` and return its index. Return `-1` if it is not present.

Example:

```text
Original: [1, 2, 3, 4, 5, 6, 7, 8]
Rotated:  [5, 6, 7, 8, 1, 2, 3, 4]
```

This algorithm assumes the input came from **an ascending sorted array rotated by some number of positions**. It does **not** assume the array can be arbitrarily shuffled or reversed.

## 2. The key observation

At every binary-search step, split the current search range into two halves:

- Left half: `s ... mid`
- Right half: `mid ... e`

**At least one half is sorted in ascending order.** Sometimes both halves are sorted.

Why? A rotated ascending array has at most one *drop* (a place where the next value is smaller than the previous value), such as `8 → 1`. That single drop cannot be inside both halves at once.

### Case A: The left half is sorted

Example:

```text
[5, 6, 7, 8 | 1, 2, 3, 4]
 s        mid             e
```

The left half `[5, 6, 7, 8]` is sorted.

We detect this with:

```java
if (nums[s] <= nums[mid])
```

Because the values from `s` through `mid` are in ascending order, the first value is less than or equal to the middle value.

If `k` is inside the left half's value range, search left:

```java
if (nums[s] <= k && k < nums[mid]) {
    e = mid - 1;
} else {
    s = mid + 1;
}
```

The upper check is `k < nums[mid]` because equality with `nums[mid]` was already handled at the top of the loop:

```java
if (nums[mid] == k) return mid;
```

### Case B: The left half is not sorted

If `nums[s] <= nums[mid]` is false, then `nums[s] > nums[mid]`. The rotation drop must be in the left half, so the **right half is sorted**.

Example:

```text
[6, 7, 8, 1 | 2, 3, 4, 5]
 s        mid             e
```

The left half contains the drop `8 → 1`; the right half `[2, 3, 4, 5]` is sorted.

Now check whether `k` is inside the right half's value range:

```java
if (nums[mid] < k && k <= nums[e]) {
    s = mid + 1;
} else {
    e = mid - 1;
}
```

Again, `nums[mid] == k` was already handled, so the range check uses `nums[mid] < k`.

## 3. Complete Java solution

```java
class Solution {
    public int search(int[] nums, int k) {
        int s = 0, e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == k) return mid;

            if (nums[s] <= nums[mid]) {
                // Left half is sorted.
                if (nums[s] <= k && k < nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                // Left half is not sorted, so right half is sorted.
                if (nums[mid] < k && k <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }

        return -1;
    }
}
```

**Complexity:** `O(log n)` time and `O(1)` extra space, assuming distinct values as in the standard version of this problem.

## 4. Can both halves be sorted?

**Yes.** For example, with:

```text
[5, 6, 7, 8 | 1, 2, 3, 4]
```

both halves are individually sorted. The algorithm checks the left half first and uses it if the target falls within its range; otherwise it searches the right half.

The correct guarantee is **at least one half is sorted**, not “exactly one half is sorted.”

## 5. What if the whole array is reversed?

A reversed array such as:

```text
[8, 7, 6, 5, 4, 3, 2, 1]
```

is descending throughout. It is **not** an ascending sorted array rotated by some number of positions.

In this example, both halves can be unsorted in ascending order. Therefore, the above algorithm's guarantee no longer applies. A fully descending array needs a binary search that uses descending-order comparisons instead.

## 6. Does rotating an array many times reverse it?

No. Rotation moves elements around in a cycle; it does not reverse their relative order.

For an array of length `n`, rotating right by `k` positions is equivalent to rotating by `k % n` positions.

For example, rotating `[1, 2, 3, 4]` right by one position:

```text
0 rotations: [1, 2, 3, 4]
1 rotation:  [4, 1, 2, 3]
2 rotations: [3, 4, 1, 2]
3 rotations: [2, 3, 4, 1]
4 rotations: [1, 2, 3, 4]
```

After `n` one-position rotations, the array returns to its original order. Reversal is a different operation.

## 7. A useful mental checklist

At each loop iteration:

1. Compute `mid`.
2. If `nums[mid] == k`, return `mid`.
3. If `nums[s] <= nums[mid]`, the left half is sorted:
   - If `k` is between `nums[s]` and `nums[mid]`, keep the left half.
   - Otherwise, keep the right half.
4. Otherwise, the right half is sorted:
   - If `k` is between `nums[mid]` and `nums[e]`, keep the right half.
   - Otherwise, keep the left half.
5. If the search range becomes empty (`s > e`), return `-1`.

**Remember:** Identify a sorted half first; then use its value range to decide whether the target can be there. Don't apply this logic to arbitrary unsorted or fully reversed arrays.
