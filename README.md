Assignment 2 – Algorithmic Analysis and Peer Code Review

Student Information
- Student: Abdikarim Nurmukhammed SE-2430 
- Partner: Dauren Akhmetov  
- Algorithm Implemented: Shell Sort  
- Partner Algorithm Analyzed: Heap Sort  

---

Project Overview
This project is part of *Assignment 2: Algorithmic Analysis and Peer Code Review*.  
It focuses on implementing sorting algorithms, analyzing their complexity, and reviewing a partner’s code for efficiency and optimization.

My task was to implement Shell Sort and analyze my partner’s Heap Sort implementation.

---

Implementation
The source code includes:
- `ShellSort.java` – Implementation of Shell Sort with multiple gap sequences.  
- `PerformanceTracker.java` – Tracks comparisons, swaps, and array accesses.  
- `BenchmarkRunner.java` – CLI-based performance tester for different input sizes.  

---

Performance Metrics
The algorithm tracks:
- Number of comparisons  
- Number of swaps  
- Number of array accesses  
- Execution time (ms)

---

Git Branches
Recommended branch strategy:
main
feature/algorithm
feature/metrics
feature/testing
feature/cli
feature/optimization
---

Theoretical Complexity (Shell Sort)
- Best Case: Ω(n log n)  
- Average Case: Θ(n^(3/2))  
- Worst Case: O(n²)  
- Space Complexity: O(1)

---

Conclusion
Shell Sort is efficient for small and medium-sized datasets, while Heap Sort maintains more stable performance for larger inputs.  
This project demonstrates practical algorithm analysis, peer review, and empirical validation.
