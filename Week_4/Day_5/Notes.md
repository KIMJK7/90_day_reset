### 1. Why does assigning the smallest sufficient cookie make sense?

Because a larger cookie has **more potential value** for another child who might need it.

Suppose a child needs `3`, and you have cookies `3, 5`.

If you give them `5`, you've satisfied the child, but you've wasted a cookie that could satisfy a child needing `5`.

If you give them `3`, you satisfy the same child while preserving `5`.

So the greedy choice is safe because:

> **Using the smallest sufficient resource never makes the current assignment worse, and preserves larger resources for future assignments.**

This is essentially a **resource-preservation argument**.

---

### 2. Why does collecting every positive stock increase produce maximum profit?

Suppose prices go:

```text
1 → 3 → 5
```

You could buy at `1` and sell at `5`:

```text
+4
```

Or think of it as:

```text
(3 - 1) + (5 - 3) = 2 + 2 = 4
```

So every positive increase can be collected without losing anything.

If tomorrow's price is higher than today's:

```text
today → tomorrow
  1   →   3
```

you can profit from that increase.

If tomorrow is lower:

```text
3 → 1
```

there is no reason to hold the stock through that decrease.

The crucial property here is:

> **Profit is additive across consecutive increases.**

That's why taking every positive difference is globally optimal.

---

### 3. In Jump Game, why do we track `farthest` instead of all possible paths?

Because we don't care **which path** got us somewhere. We only care about the **furthest reachable boundary**.

Imagine:

```text
        1
       ↗
start
       ↘
        3
```

If one path can reach index `4` and another can reach index `6`, knowing both complete paths is unnecessary.

The only information relevant to future decisions is:

```text
farthest = 6
```

Everything at or before `6` is potentially reachable.

So we're compressing many possible paths into one useful state:

> **The furthest position reachable so far contains all the information we need to determine whether the end is reachable.**

That's why we can avoid exponential path exploration.

---

### 4. Why is "choose the position with the largest `nums[i]`" not necessarily correct for Jump Game II?

Because `nums[i]` alone doesn't tell you how far you'll actually get.

The relevant quantity is:

```text
i + nums[i]
```

But even that needs context: you only choose among positions that are reachable within the current jump range.

For example:

```text
index:    0  1  2  3
nums:     2  1  3  1
```

From index `0`, you can reach indices `1` and `2`.

You don't simply say:

> "Which position has the largest jump value?"

You ask:

> **"Among all positions I can reach with this jump, which one extends my next reachable range the furthest?"**

That's:

```text
max(i + nums[i])
```

The greedy decision is therefore about **maximum future reach**, not merely maximum local value.

---

### 5. Difference between "This choice looks good" and "I can prove this choice is safe."

This is probably the **most important distinction**.

"This choice looks good" means:

> I tested some examples and it seems to work.

That's not a greedy proof.

"I can prove this choice is safe" means:

> I can show that making this choice cannot prevent an optimal solution from existing.

For example, in interval scheduling:

> Choose the interval that finishes earliest.

Why is that safe?

Suppose an optimal solution starts with some interval `X`.

If another available interval `Y` finishes earlier than `X`, replace `X` with `Y`.

Because `Y` finishes no later than `X`, every interval that could come after `X` can still come after `Y`.

Therefore the replacement doesn't reduce the number of intervals we can eventually select.

**That's a proof of safety.**

A good greedy question is:

> **"If the optimal solution made a different choice, can I replace its choice with my greedy choice without making the solution worse?"**

If yes, you're getting toward a real greedy proof.

---

### 6. Why does greedy work for some coin systems but fail for `[1,3,4]`?

Suppose you need to make:

```text
6
```

With coins:

```text
[1, 3, 4]
```

Greedy says:

```text
take 4
remaining 2

take 1
remaining 1

take 1

→ 4 + 1 + 1 = 3 coins
```

But the optimal solution is:

```text
3 + 3 = 6

→ 2 coins
```

The problem is that taking the **largest immediate coin** (`4`) doesn't preserve an optimal solution.

The choice:

```text
take 4
```

looks best locally, but it creates a bad remainder.

For systems like standard US coins:

```text
[1, 5, 10, 25]
```

greedy happens to work because the denomination structure has special mathematical properties.

But **greedy coin change is not universally valid**.

That's an important lesson:

> **A greedy strategy isn't justified merely because the objective seems to reward taking the largest/smallest thing first. You need a property that guarantees the local choice can be part of an optimal solution.**

---

### 7. Why was ending time the correct ordering in interval scheduling?

Because the objective is:

> **Maximize the number of non-overlapping intervals.**

Finishing early leaves the largest possible amount of time available for everything that comes afterward.

Suppose:

```text
A: |--------|   ends at 10
B: |---|         ends at 5
```

If both are currently available, choosing `B` leaves more room for future intervals.

More formally:

Suppose an optimal solution chooses interval `A` first, ending at `10`.

Our greedy choice `B` ends at `5`.

Since:

```text
end(B) <= end(A)
```

every interval that could follow `A` can also follow `B`.

Therefore replacing `A` with `B` cannot hurt the optimal solution.

That's the **exchange argument**.

And this is why ending time—not starting time, not duration, not interval length—is the correct ordering.

---

# 🎯 How do you know when a greedy choice is actually safe?

Don't ask:

> "Does this choice look like the best choice right now?"

Ask:

> **"Can I prove that there exists an optimal solution that makes this choice?"**

That's the core.

A useful mental checklist is:

### 1. Identify the local greedy choice

For example:

```text
Cookies → smallest sufficient cookie
Intervals → earliest ending interval
Jump Game II → furthest reachable boundary
Stock → every positive increase
```

### 2. Ask what future options the choice preserves

Does the choice leave at least as much flexibility as the alternatives?

### 3. Try an exchange argument

Imagine an optimal solution that **didn't** make your greedy choice.

Can you replace its choice with yours **without making the solution worse**?

If yes, that's strong evidence that your greedy choice is safe.

### 4. Look for a counterexample

This is equally important.

Try to break your greedy rule.

That's exactly what happens with coin change:

```text
[1,3,4], target = 6
```

Greedy fails.

So the deeper lesson from these problems isn't:

> **"Greedy means choose what looks best."**

It's:

> **Greedy means make a locally optimal choice for which you can establish that some globally optimal solution can be transformed to include that choice without losing optimality.**

That's the distinction between **guessing a greedy algorithm** and **actually proving one**.
