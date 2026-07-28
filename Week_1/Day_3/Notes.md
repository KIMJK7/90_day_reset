# Java Interview Notes

## 1. What is Control Flow?

**Answer:**

Control flow refers to the order in which a program's statements are
executed. By default, Java executes code sequentially from top to
bottom. However, using control flow statements like `if`, `switch`,
loops (`for`, `while`, `do-while`), and `break`/`continue`, we can make
decisions, repeat blocks of code, or skip certain sections based on
conditions.

---

## 2. Difference between `if` and `switch`

**Answer:**

The `if` statement is more flexible because it can evaluate any boolean
expression, including complex conditions using operators like `&&`,
`||`, `<`, `>`, and `==`. It is used when the decision depends on
conditions or ranges of values.

A `switch` statement is used when we want to choose between multiple
fixed constant values, such as menu options, days of the week, or
months. It is generally more readable and cleaner than a long chain of
`if-else` statements, but it is less flexible because it only works with
specific constant values.

### Examples

- **Use `if` for:**
  - Age \> 18
  - Salary \>= 50000 && experience \> 2
- **Use `switch` for:**
  - Month number
  - Menu choice
  - Grade letter

---

## 3. Difference between `for` and `while`

**Answer:**

A `for` loop is generally used when the number of iterations is known
beforehand. It combines initialization, condition checking, and
increment/decrement in one place, making it ideal for counting loops.

A `while` loop is used when the number of iterations is not known in
advance. The loop continues executing as long as the specified condition
remains true.

### Examples

- **`for` loop:** Print numbers from 1 to 10.
- **`while` loop:** Keep asking the user for input until they enter
  the correct password.

---

## 4. Explain the Lifecycle of a Loop

**Answer:**

The lifecycle of a loop consists of four main steps:

1.  **Initialization** -- The loop variable is initialized (for example,
    `int i = 0`).
2.  **Condition Check** -- The condition is evaluated. If it is `true`,
    the loop executes; otherwise, it terminates.
3.  **Execution** -- The statements inside the loop body are executed.
4.  **Update** -- The loop variable is updated (incremented or
    decremented), and the condition is checked again.

This process repeats until the condition becomes false, after which the
program continues with the statements following the loop.

---

## 5. What is Variable Scope?

**Answer:**

Variable scope refers to where a variable can be accessed and how long
it exists in a program.

There are three common scopes in Java:

- **Local Scope** -- A variable declared inside a method can only be
  accessed within that method.
- **Block Scope** -- A variable declared inside a block (such as an
  `if`, `for`, or `while` block) can only be accessed within that
  block.
- **Class (Instance/Static) Scope** -- Variables declared inside a
  class but outside methods are accessible according to their access
  modifiers and belong to the object or the class.

The scope of a variable determines its visibility and lifetime.

---

## 6. Why does a Variable Declared Inside a Loop Not Exist Outside the Loop?

**Answer:**

A variable declared inside a loop has **block scope**, meaning it only
exists within the loop's block (`{ }`). It is created when execution
reaches its declaration and is no longer accessible once execution
leaves that block. Therefore, it cannot be used outside the loop because
it is out of scope.

---

# Quick Interview Tips

- **Control Flow:** Order in which program statements execute.
- **`if`:** Used for complex boolean expressions and ranges.
- **`switch`:** Used for fixed constant values.
- **`for`:** Known number of iterations.
- **`while`:** Unknown number of iterations.
- **Loop Lifecycle:** Initialization → Condition → Execution → Update.
- **Variable Scope:** Local, Block, and Class scope.
- **Loop Variables:** Exist only within the loop because of block
  scope.
