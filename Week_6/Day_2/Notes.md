QUESTION OF THE DAY

Why is a queue fundamentally different from a stack even though both can support O(1) insertion and removal?

Don't answer:

"One is FIFO and one is LIFO."

That's true but incomplete.

Explain why the ordering constraint changes which element is accessible.

-> A stack and a queue can have identical time complexity for insertion/removal, but their ordering constraints define different access rules.

Stack

A stack imposes the constraint:

The most recently inserted element must be the next element removed.

Imagine:

push A
push B
push C

The structure is:

C ← accessible
B
A

You cannot remove A without first removing C and B.

So the ordering constraint determines the accessible element: the newest element is exposed.

Queue

A queue imposes the opposite constraint:

The earliest inserted element must be the next element removed.

A → B → C
↑
accessible

Even though C was inserted most recently, you cannot remove C until A and B have left.

So the ordering constraint determines the accessible element: the oldest element is exposed.

Why does this matter if both can be O(1)?

Because O(1) only tells us how fast we can perform the permitted operation.

It doesn't tell us which element we're permitted to access.

For example:

Stack:
A → B → C
↑
remove

Queue:
A → B → C
↑
remove

Both can remove an element in O(1), but they expose different elements.
