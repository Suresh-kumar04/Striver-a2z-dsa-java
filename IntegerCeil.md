# Ceiling Division in Java

Used in Koko Eating Bananas: hours for one pile = `ceil(pile / speed)`.

## The problem: int division floors

```java
7 / 2        // 3, not 3.5, because Java drops the fraction
```

Ceiling needs the *rounded-up* result (`4` for `7 / 2`), so plain `/` on ints is not enough.

---

## Method 1: Your method (`Math.ceil` with `double`)

```java
totalH += Math.ceil((double) n / mid);
// or, closest to your original loop:
for (double n : piles) {
    totalH += Math.ceil(n / mid);
}
```

**How it works**

1. `(double) n` converts to a double *before* dividing, so `7 / 2` becomes `3.5`.
2. `Math.ceil(3.5)` returns `4.0`.
3. `totalH += 4.0` works even though `totalH` is a `long`: compound assignment (`+=`) casts the result back automatically.

**Common mistakes**

| Code | Result for n=7, mid=2 | Why |
|---|---|---|
| `Math.ceil(n / mid)` | `3.0` (wrong) | `n / mid` is int division, so it floors *before* `ceil` runs |
| `Math.ceil((double) n / mid)` | `4.0` (correct) | cast happens first |
| `Math.ceil((double) (n / mid))` | `3.0` (wrong) | cast is applied *after* the int division |

**`float` vs `double`**

- `float` has 24 bits of precision, so it cannot represent every `int` above about 16.7 million exactly. With piles up to 10^9, it can round wrongly at the boundary.
- `double` has 53 bits, so it holds every `int` exactly. Safe here.

**Downsides:** floating-point is slower, and you have to reason about precision.

---

## Method 2: Integer ceil (no floating point)

```java
int result = (a + b - 1) / b;    // ceil(a / b) for positive a, b
```

Example: `a = 7, b = 2` gives `(7 + 2 - 1) / 2 = 8 / 2 = 4`.

### Why it works

Write `a = q * b + r`, where `0 <= r < b` (`q` is the quotient, `r` the remainder).

- **If `r == 0`** (divides evenly): the answer should be `q`.
  `a + b - 1 = q*b + (b - 1)`, and `(b - 1) < b`, so integer division gives `q`. Correct.
- **If `r > 0`** (not even): the answer should be `q + 1`.
  `a + b - 1 = q*b + (r + b - 1)`. Since `1 <= r <= b - 1`, we have `b <= r + b - 1 <= 2b - 2`, so it adds exactly one more `b`, giving `q + 1`. Correct.

Intuition: adding `b - 1` is "just enough to push any leftover into one extra full group, but not enough to push an exact fit into an extra group."

### Alternative form

```java
int result = (a - 1) / b + 1;    // requires a >= 1
```

Same result, and it cannot overflow from the addition. Prefer it if `a + b` could exceed `Integer.MAX_VALUE` (about 2.147 billion).

---

## Side by side

| | `Math.ceil((double) a / b)` | `(a + b - 1) / b` |
|---|---|---|
| Uses floating point | Yes | No |
| Precision concerns | Yes (`float` breaks, `double` is fine here) | None |
| Speed | Slower | Faster |
| Readability | Very obvious | Needs the trick above |
| Overflow risk | None for ints | `a + b - 1` can overflow for huge values |
| Works for negatives | Yes | No (assumes positive) |

## In the Koko solution

```java
long hours = 0;
for (int p : piles) {
    hours += (p + mid - 1) / mid;   // integer ceil(p / mid)
    if (hours > h) break;           // already too slow, stop early
}
```

Here `p <= 10^9` and `mid <= 10^9`, so `p + mid - 1 < 2^31 - 1` and it fits in an `int`. Keep `hours` as `long` because the *sum* across piles can be far larger.