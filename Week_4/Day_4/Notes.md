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
