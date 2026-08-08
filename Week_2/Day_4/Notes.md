Thinking Exercises

Without coding:

Why shouldn't fields always be public?

    Fields should not always be public because it allows any part of the program to modify an object's state without following its business rules. This can violate the object's invariants and leave it in an invalid state. By keeping fields private and exposing controlled methods, the object can validate changes and ensure it remains consistent throughout its lifetime.

    Example:

    class Student {
    private int age;

        public void setAge(int age) {
            if (age >= 0) {
                this.age = age;
            }
        }

    }

    Without encapsulation:

    Student s = new Student();
    s.age = -20; // Invalid state

    user can just do as follows
    Stud s = new Stud();
    s.age = -20;

    but as we know age should always be a positive number, to prevent such modifications to take place we make the fields private and only let them be accessed via public methods hiding the inner logic.

Why are getters usually safer than public fields?

    Getters are safer than public fields because they provide controlled read access instead of unrestricted access. A getter can return a computed value, a copy of the data, a formatted version, or decide not to expose certain information at all. Public fields expose the internal representation directly, making future changes more difficult.

    For example:

    public String getFullName() {
    return firstName + " " + lastName;
    }

    The caller doesn't need to know that the name is stored in two separate fields.

    Also:

    getId() ✔️ makes sense.
    getPasswordHash() ❌ usually doesn't.

Should every field have a setter? Why?

    No. A setter should only exist if modifying the field is a valid operation. Some fields, such as IDs, account numbers, or dates of birth, represent an object's identity or immutable information and should never change after the object is created. Providing a setter for such fields would violate the object's design and could lead to inconsistent data.

Why is validation better inside the object than outside?

    Validation should be inside the object because the object is responsible for maintaining its own invariants. If validation is left to external code, every caller must remember to perform the same checks, increasing the risk of mistakes and duplicated logic. By keeping validation inside the object, every modification follows the same rules, ensuring the object always remains in a valid state.

What happens if multiple parts of a program can freely modify an object's state?

    If multiple parts of a program can freely modify an object's state, the object may become inconsistent because different parts of the program can make conflicting or invalid changes. It also becomes difficult to determine where a bug originated, since any piece of code could have modified the object. Encapsulation avoids this by ensuring that all state changes pass through controlled methods that enforce the object's business rules.

    For example:

    inventory.quantity = -50;
    inventory.quantity = 1000;
    inventory.quantity = -1;

    Who changed it?

    Why was it changed?

    Was the change valid?

    It's difficult to answer because there is no single place controlling modifications.

    With encapsulation:

    inventory.addStock(50);
    inventory.removeStock(10);

    Every update goes through well-defined methods that can validate the operation, log changes, or enforce business rules.

End-of-Day Self-Test

Without notes, explain:

What is encapsulation?

    Encapsulation is an object-oriented programming (OOP) principle that hides an object's internal state and provides controlled access through a well-defined public interface. Its primary purpose is to protect the object's invariants and prevent it from entering an invalid state.

Why does encapsulation exist?

    Encapsulation exists to ensure that an object always remains in a valid state. Instead of allowing external code to modify fields directly, the class exposes controlled methods that validate every change before updating the object's state. This protects object integrity, enforces business rules, improves maintainability, and reduces coupling.

Difference between private and public.

    private members are accessible only within the same class and are typically used to hide implementation details and protect an object's state. public members are accessible from anywhere and are used to expose the class's public interface to other parts of the program.

Why are getters and setters useful?

    Getters and setters provide controlled access to private fields. Getters allow safe read access, while setters can validate input before modifying an object's state. They help enforce encapsulation, maintain object integrity, and expose only the operations that make sense.
