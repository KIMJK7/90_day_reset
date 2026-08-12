# Week 2 — Day 7

## 🧠 WEEKLY MASTERY GATE

No new theory today.

You have spent six days learning and applying:

- Objects & references
- Heap/stack mental model
- Constructors
- Object initialization
- `this`
- Constructor chaining
- Static vs instance members
- Encapsulation
- Access modifiers
- Getters/setters
- Object identity
- `==` vs `.equals()`
- Aliasing
- Separation of responsibilities
- Designing classes

Today we test whether you can **reason without being guided through the answer**.

### Rules for today

**No notes. No Google. No AI. Don't run the code before answering.**

You can check your answers afterward.

I want you to write your reasoning, not just the final answer.

---

# Part 1 — Object Creation & Initialization

### Question 1

What is printed?

```java
class Student {

    String name = "Unknown";

    {
        name = "Block";
    }

    Student() {
        name = "Constructor";
    }
}

public class Main {

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.name);
    }
}
```

Explain the **complete initialization order**.

Student s; initializes a reference variable on stack which currently points to null
new Student(); allocates the memory sapce to the new student object on heap with object field having default initialization String name = null;
it first goes to the field initializer and name = "Unknown" value of object field name gets chnaged to Unknown in heap memory
then it looks at the initialization block it executes the code insode of the block so now the value of object field name in heap becomes "Block";
Student(); constructor is executed object field name value in heap gets changed to Constructor
s.name is now "Constructor" so System.out.println(s.name); will print "Constructor";

---

### Question 2

What is printed?

```java
class Student {

    String name;

    Student(String name) {
        this.name = name;
    }

    void changeName(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(this.name);
    }
}

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student("Aman");
        Student s2 = new Student("Jasleen");

        s1.changeName("Rahul");

        s1.display();
        s2.display();
    }
}
```

Explain **which `name` changes and why**.

stack heap

## s1 -------------> Student Object

name = "Aman"

## s2 --------------> Student Object

name = "Jasleen"

s1.changeName("Rahul");

stack heap

## s1 -------------> Student Object

name = "Rahul"

## s2 --------------> Student Object

name = "Jasleen"

s1.display();// Rahul
s2.display();//Jasleen

s1 objects name changes cause when we do s1.changeName("Rahul");
the method void changeName(String name) {
this.name = name;
}
this logic is used this.name points to the object field name and name is the parameter
so its saying change the value in object field and that value should be the parameter name.
this is the cureent objects reference and in s1.changeName("Rahul"); this = s1 object.

---

# Part 2 — References & Aliasing

### Question 3

Without running it:

```java
class Student {

    String name;

    Student(String name) {
        this.name = name;
    }
}

public class Main {

    public static void main(String[] args) {

        Student a = new Student("A");
        Student b = a;
        Student c = new Student("A");

        b.name = "B";

        System.out.println(a.name);
        System.out.println(b.name);
        System.out.println(c.name);

        System.out.println(a == b);
        System.out.println(a == c);
    }
}
```

Answer:

1. How many Student objects exist? // 2
2. How many references exist?//3
3. Which references point to the same object?// a and b pointot same object
4. Final output.

   System.out.println(a.name);// B
   System.out.println(b.name);//B
   System.out.println(c.name);//A

   System.out.println(a == b);// True
   System.out.println(a == c);// False

5. Why?

   a and b refernce point to same object we initialize object with A initialally but later with b.name = "B"; as a and b point to same object a.name = "B" c was intialized with "A"
   a==b is true cause both references point tothe same memory adder space but a==c is false cause tehy both point to different object on differnt memory addr block

---

# Part 3 — Static vs Instance

### Question 4

Trace this:

```java
class Student {

    static int count = 0;

    String name;

    Student(String name) {
        this.name = name;
        count++;
    }
}

public class Main {

    public static void main(String[] args) {

        Student a = new Student("A");
        Student b = new Student("B");

        a.count++;

        System.out.println(Student.count);
        System.out.println(a.count);
        System.out.println(b.count);
    }
}
```

Answer:

- How many Student objects?//2
- How many `count` variables?//1
- What is `count` after each constructor?//2
- What does `a.count++` actually modify?// count = 3 it modifies the sataic count variable
- Final output.

  System.out.println(Student.count);//3
  System.out.println(a.count);//3
  System.out.println(b.count);//3

---

# Part 4 — Find the Bug

### Question 5

What's wrong with this class?

```java
class BankAccount {

    public double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}
```

Give **at least three problems**.

Then explain how encapsulation would improve the design.

Don't just say:

> "Make balance private."

Explain **what problem that solves**.

1. balance should not be public as we dont want any method or just any user to have access to modify its data we dont want that any one could just do b1.banace = -10000;
   to avoid this we would keep balance private so only methods inside the class can access and modify the value.
2. in public BankAccount() we are not checking if there is balance already present we are just replacing the value of balance object field t should rather be first balance should be > 0 as it should be postitive and second it should be added to teh current balance rather than replacing the existing balance
3. for widraw as well first we need to check if sufficent balance is available cause balance cannot be negative value fo beofre balance -= amount; we need to check the condition is amount <= balance; else say insufficent balance

---

# Part 5 — Constructor Chaining

### Question 6

Trace the output:

```java
class Employee {

    String name;
    double salary;

    Employee() {
        this("Unknown");
        System.out.println("A");
    }

    Employee(String name) {
        this(name, 0);
        System.out.println("B");
    }

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        System.out.println("C");
    }
}

public class Main {

    public static void main(String[] args) {
        Employee e = new Employee();
    }
}
```

What is printed?

And explain **why that order occurs**.

> Output :
> C
> . B
> . A

now why is this,
Note: before anything else the memory allocation and initializations take place so we have
stack heap

## e -------------> Employee Object

                        name = null
                        Salary = 0

in this case when we call new Employee();
it first goes to the no argument constructor
which has this("Unknown");
this() - calls constructor of the object class

this envokes single arguemnt string constructor
which has this(name, 0);
this calls dowble argument constructor with string and double parameter
and all this is creating a stack one on top of other and before one pops the below ones cannot execute
so Employee(String name, double salary) constructor gets evoked and its body is executed
this.name = name; this.salary = salary;
then it prints "C" and ones execution of body id over it is poped from the stack then excution of previous single argument consttrcutor starts its body is exected after this() and "B" is printed and similary with no argument constrcutor and "A" is printed

---

# Part 6 — Design Problem

You're designing:

```java
class BankAccount
```

It needs:

```text
accountNumber
accountHolder
balance
```

Requirements:

- Account number cannot change after creation.
- Account holder can change.
- Balance cannot be directly modified.
- Depositing a negative amount must be rejected.
- Withdrawal cannot exceed balance.
- The account should expose its current balance.
- Every account should have a unique account number.

### Question 7

For each field, decide:

| Field         | `private`? | `final`? | Setter? |
| ------------- | ---------- | -------- | ------- |
| accountNumber | yes        | yes      | No      |
| accountHolder | Yes        | No       | Yes     |
| balance       | yes        | No       | yes     |

Then explain **why**.
AccountNumber should be unique and it shouldnot change once created and no one should be able to access it directly or modify it so it will be private and final and no setter casue its value should not change
accountHolder should be private casue no one should be able to access it directly or modify it cause we dont want anyone to just do a1.accountHolder = null; as value of holder can change so it is not final and it shoul dhave a setter casue we might change the name later
balance is private casue we donot wnat just anyone doing a1.balance=-1000; and a setter cause it will hide all the logic and invarients as balnce cannot be negative and people can chaneg their balance but with rules.

Also answer:

> Which class should be responsible for ensuring account numbers are unique?

Employee class itself should be reponsible to add the loic for accountNumber to be unique in its constructor itself.

---

# Part 7 — Architecture

You have:

```java
class Student {

    private String name;
    private int marks;
}
```

and:

```java
class StudentManager {

    private Student[] students;
}
```

### Question 8

Where should each operation belong?

| Operation                     | Student | StudentManager | Main |
| ----------------------------- | ------- | -------------- | ---- |
| Validate marks                | Yes     | No             | No   |
| Change student's marks        | Yes     | No             | No   |
| Search by roll number         | No      | Yes            | No   |
| Calculate class average       | No      | Yes            | No   |
| Display menu                  | No      | No             | yes  |
| Add student to collection     | No      | yes            | No   |
| Display one student's details | No      | yes            | No   |

Then explain your reasoning.

---

# Part 8 — The "AI Would Usually Solve This" Question

This one is deliberately different.

### Question 9

You see this:

```java
Student a = new Student("Jasleen");
Student b = new Student("Jasleen");
```

A junior developer says:

> "These are equal because they contain exactly the same data."

Do you agree?

Explain the difference between:

```java
a == b
```

and:

```java
a.equals(b)
```

Then answer:

> **What would you need to implement if you wanted two Student objects with the same roll number to be considered logically equal?**

Don't write the implementation yet. Explain the concept.

== checks for equality a==b will be false as they point to two different objects on diff memory addr on heap
a.equals(b) will also be false cause we first need to override equals() in the class so it will compare the object fields that all i know as of now but it can be true after overriding.

not sure how to ovveride equals() as it is a build in function given to us by class

---

# Part 9 — Final Design Challenge

### Question 10

Consider this:

```java
class Student {

    private String name;
    private int marks;

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
```

The developer says:

> "I've used encapsulation because `marks` is private."

Is that statement completely correct?

**Challenge it.**

Explain whether this class actually protects the invariant:

```text
0 ≤ marks ≤ 100
```

and what would need to change.

it has the basic idea but encapasulation is hidng the logic so that user can just utilize the function without also implementing the logic by making marks and name private w emade sure that no one can directly access them so they cant do s1.marks = -50; but what is stopping them right now from doing s1.setmarks(-50);
becasue it doesnot stop them from entring any number this breaks the invarient that marks should be between 0 and 100

public void setMarks(int marks) {
if(marks<0 ||marks >100){
System.out.println("Invalid Marks");
return;
}
this.marks = marks;
}

---
