              INTERVAL PROBLEM
                     │
                     ↓
               Can sorting help?
                     │
                     ↓
          Sort by the relevant boundary
                     │
          ┌──────────┼──────────┐
          ↓          ↓          ↓
       overlap    scheduling   insertion
          │          │          │
       compare    earliest     exploit
       endpoints  finishing    sorted order
          │          │          │
          ↓          ↓          ↓
        merge      greedy      scan

Problem
↓
What structure does the input have?
↓
What information do I need?
↓
Can I eliminate work?
↓
Can sorting expose useful structure?
↓
Choose the pattern
↓
Define the invariant
↓
Code
↓
Prove complexity
