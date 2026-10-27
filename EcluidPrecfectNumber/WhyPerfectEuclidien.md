# Euclid Perfect Numbers — Future Notes

## 1. Euclid's Formula

A perfect number can be generated using:

    N = 2^(p-1) × (2^p - 1)

If:

    2^p - 1

is prime, then `N` is a perfect number.

`2^p - 1` is called a **Mersenne number**.

If it is prime, it is called a **Mersenne prime**.

Example:

    p = 2

    2^2 - 1 = 3       ← prime

    2^(2-1) × 3
    = 2 × 3
    = 6               ← perfect number


---

# 2. Why Start p From 2?

Don't start from `p = 1`.

For:

    p = 1

    2^1 - 1 = 1

But `1` is NOT prime.

So the first useful value is:

    p = 2


---

# 3. IMPORTANT: `<<` Does NOT Mean Multiplication by 2

This is a major bit-operation gotcha.

    1L << (p - 1)

means:

    2^(p-1)

NOT:

    2 * (p-1)

Example:

    p = 5

    1L << (5-1)
    = 1 << 4
    = 16

While:

    2 * (5-1)
    = 8

Completely different.


## Why?

Left shifting by one position doubles the number:

    1 << 0 = 1
    1 << 1 = 2
    1 << 2 = 4
    1 << 3 = 8
    1 << 4 = 16

Therefore:

    1 << k = 2^k

More generally:

    x << k ≈ x × 2^k

(for values where the shift doesn't cause overflow)


---

# 4. `1L << p` In Your Code

You wrote:

    long Mersenne = (1L << p) - 1;

This represents:

    2^p - 1

Example:

    p = 5

    1L << 5
    = 32

    32 - 1
    = 31

So:

    Mersenne = 2^p - 1


And:

    (1L << (p-1))

represents:

    2^(p-1)


Therefore your formula:

    (1L << (p-1)) * ((1L << p) - 1)

is:

    2^(p-1) × (2^p - 1)


---

# 5. Java `long` — The 63-Bit Trap

A Java `long` is:

    64 bits

But it is **signed**.

So:

    1 bit  → sign
    63 bits → magnitude/range

Maximum positive value:

    Long.MAX_VALUE = 2^63 - 1


IMPORTANT:

Don't think:

    "long can store numbers up to 63"

Think:

    "long's maximum positive number is 2^63 - 1"

63 is the NUMBER OF USABLE POSITIVE BITS,
not the maximum value.


---

# 6. Why p <= 31?

The Mersenne number alone is:

    2^p - 1

But our actual perfect number is:

    2^(p-1) × (2^p - 1)

The ENTIRE result must fit inside `long`.

Approximately:

    2^(p-1) × 2^p
    = 2^(2p-1)

A positive long can go up to roughly:

    2^63

So we need approximately:

    2p - 1 < 63

which gives:

    p <= 31

Therefore:

    for (int p = 2; p <= 31; p++)

is a safe practical bound for generating the perfect number
inside a signed Java `long`.


---

# 7. IMPORTANT Correction to My Earlier Thinking

Do NOT reason like this:

    2^p - 1 <= 63

That is WRONG.

Why?

Because `63` is not the maximum value of `long`.

The correct comparison is against:

    2^63 - 1


For the Mersenne number alone:

    2^p - 1 <= 2^63 - 1

would give:

    p <= 63

BUT that isn't enough because the final perfect number also contains:

    2^(p-1)

So we need to consider the WHOLE expression.


---

# 8. Why Check Only Up To √n When Testing Prime?

Your original code had:

    for(long i = 2; i <= n*n; i++)

This is wrong.

For primality, use:

    for(long i = 2; i * i <= n; i++)

or a safe equivalent:

    for(long i = 2; i <= n / i; i++)


## Why √n?

Factors come in pairs.

Example:

    36

    1 × 36
    2 × 18
    3 × 12
    4 × 9
    6 × 6

After √36 = 6, all factor pairs are just
duplicates in reverse order.

Therefore:

    If n has a factor,
    at least one factor must be <= √n.


So for primality:

    Check divisors only up to √n.


---

# 9. Prime Check Complexity

Normal brute force:

    2 ... n

would be:

    O(n)

Using √n:

    2 ... √n

gives:

    O(√n)


For your code:

    static boolean isPrime(long n) {
        if (n < 2) return false;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }


---

# 10. Why Overall isPerfect() Is O(1)

Your loop is:

    for (int p = 2; p <= 31; p++)

That's a FIXED maximum number of iterations.

It does not grow with `n`.

Even though `isPrime()` has a loop, `p` itself is bounded:

    p <= 31

Therefore the largest Mersenne number tested is also bounded.

So with respect to the input `n`:

    Time  = O(1)
    Space = O(1)


IMPORTANT:

This is because you deliberately bounded `p`.

If you wrote a generalized algorithm where `p` could grow with the input,
the complexity analysis would be different.


---

# 11. Bit Shift Gotchas

## `<<`

    1L << k

means:

    2^k

NOT:

    2k

and NOT:

    2 * k


## Parentheses matter

Write:

    1L << (p - 1)

rather than relying on precedence.

You mean:

    1L << [p - 1]

which represents:

    2^(p-1)


---

# 12. Why `1L` Instead of `1`?

Java integer literals:

    1     → int
    1L    → long

Since you're working with `long` values and potentially large shifts,
using:

    1L << p

makes the operation happen with a `long`.

This is especially important when dealing with shifts near the
integer width boundary.


---

# 13. Overflow Gotcha

This is VERY important.

Java integer arithmetic does NOT automatically throw an error
when an integer overflows.

It wraps around.

For example, a value that goes beyond `Long.MAX_VALUE`
can become negative or otherwise incorrect.

So when working with:

    2^(p-1) × (2^p - 1)

always ask:

    "Can this result fit in my data type?"


---

# 14. Mental Checklist When Seeing This Problem

When you see:

    "Check whether n is a perfect number"

and Euclid's theorem is being used:

### Step 1
Remember:

    Perfect = 2^(p-1) × (2^p - 1)

### Step 2
Try values of:

    p = 2, 3, 4, ...

### Step 3
Check whether:

    2^p - 1

is prime.

### Step 4
If prime, generate:

    2^(p-1) × (2^p - 1)

### Step 5
Compare it with `n`.

Because perfect numbers generated this way increase rapidly,
once:

    perfect > n

you can stop.

### Step 6
Remember Java `long` limits:

    Long.MAX_VALUE = 2^63 - 1

### Step 7
Watch for overflow.


---

# 15. Most Important Things To Remember

If I forget everything else, remember these:

1. `1L << k` means `2^k`.

2. `1L << (p-1)` means `2^(p-1)`,
   NOT `2 * (p-1)`.

3. `63` is the number of usable positive bits in a signed
   Java `long`; it is NOT its maximum value.

4. `Long.MAX_VALUE = 2^63 - 1`.

5. When calculating the safe `p` limit, consider the
   WHOLE perfect-number expression, not just `2^p - 1`.

6. For primality, check divisors only up to `√n`.

7. `i <= n*n` is a bad primality bound and can overflow.

8. Your `p = 2 ... 31` loop is bounded, so the algorithm is
   O(1) with respect to `n`.

9. Bit shifting is fundamentally about moving binary bits;
   the mathematical shortcut is:

       x << k = x × 2^k

10. Whenever you see powers of 2 in Java, think:
    **Can I represent this naturally using bit shifts?**