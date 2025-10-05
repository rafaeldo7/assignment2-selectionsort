# Selection Sort - Assignment 2
# 🧩 Selection Sort Performance Analysis

## 📘 Project Overview
This project implements and evaluates the **Selection Sort** algorithm as part of the **Algorithm Performance Benchmarking Assignment**.  
It includes:
- A clean implementation of Selection Sort with **early termination optimization**.  
- **Performance tracking** for comparisons, swaps, and array accesses.  
- A **command-line benchmarking tool** for testing multiple input types and array sizes.  
- **JUnit 5 tests** for algorithm correctness.

---

## 🧠 Algorithm Description
**Selection Sort** repeatedly finds the smallest element from the unsorted portion of an array and moves it to its correct position.  
This implementation introduces an **early exit** optimization that terminates if the array becomes sorted before completing all passes.

### 🔹 Complexity
| Case | Time Complexity | Space Complexity |
|------|------------------|------------------|
| Best | Ω(n²)            | O(1) (in-place) |
| Average | Θ(n²)         | O(1)            |
| Worst | O(n²)           | O(1)            |

---

## 🧾 Features
✅ Tracks comparisons, swaps, and array accesses  
✅ Early termination when already sorted  
✅ Benchmarking across data distributions:
- Random
- Sorted
- Reversed  
✅ Generates **CSV output** for further analysis  
✅ Modular design (Algorithms / Metrics / CLI / Tests)  
✅ Documented with **Javadoc** and follows Java coding standards

---

## 🗂️ Project Structure

project-root/
│
├── src/
│ ├── algorithms/
│ │ └── SelectionSort.java
│ │
│ ├── metrics/
│ │ └── PerformanceTracker.java
│ │
│ ├── cli/
│ │ └── BenchmarkRunner.java
│ │
│ └── test/
│ └── algorithms/
│ └── SelectionSortTest.java
│
├── docs/
│ └── performance_data.csv # Generated automatically after running BenchmarkRunner
│
├── README.md
└── pom.xml (if using Maven)


---

## ⚙️ Setup & Run Instructions

### ▶️ Run via Command Line
Compile and run the benchmark:

```bash
javac -d out $(find src -name "*.java")
java -cp out cli.BenchmarkRunner

This will generate a file:

docs/performance_data.csv

containing performance results such as:

ArraySize,DataType,Time_ms,Comparisons,Swaps,ArrayAccesses
100,Random,1.242,4950,99,9900
...

🧪 Run Unit Tests (JUnit 5)

If using Maven, include the JUnit dependency in pom.xml and run:

mvn test

Example expected output:

[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

📊 Benchmark Example
Array Size	Data Type	Time (ms)	Comparisons	Swaps	Array Accesses
1000	Random	8.12	499,500	999	999,000
1000	Sorted	4.03	499,500	0	999,000
1000	Reversed	9.52	499,500	999	999,000
🧰 Dependencies

    Java 17+

    JUnit 5 (for tests)

    (Optional) Maven for build automation and dependency management

Example Maven dependency for JUnit:

<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.3</version>
    <scope>test</scope>
</dependency>

👨‍💻 Author

Rafael Shayekhov
SE-2425
