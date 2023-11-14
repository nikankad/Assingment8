# Program 8 - AVL Tree for Sale Records

## Introduction

This Java program demonstrates the usage of an AVL tree to store and search `SaleRecord` objects. The program reads data
from two CSV files, constructs `SaleRecord` objects, and inserts them into the AVL tree. Subsequently, it performs
searches based on data from another CSV file and prints the corresponding records found.

## Usage

Make sure to run the program with two command-line arguments specifying the paths to the CSV files. The first argument
should be the path to the file containing sale records (`filePath`), and the second argument should be the path to the
file used for testing (`testFile`).

```bash
java program8 path/to/sale_records.csv path/to/test_file.csv
```

## CSV File Assumptions

The program assumes the CSV files follow a specific format. For the sale records file (`filePath`), the columns should
be in the order of the constructor for `SaleRecord` objects. The test file (`testFile`) should contain data for
searching, and the order of columns should match the assumed structure.

## Program Structure

1. Initialize an AVL tree (`AVL tree = new AVL();`).
2. Create an `ArrayList` to store lines from the test file (`ArrayList<String> searchLines = new ArrayList<>();`).
3. Read entries from the test file and add them to the `searchLines` ArrayList.
4. Read entries from the sale records file, construct `SaleRecord` objects, and insert them into the AVL tree.
5. Perform searches based on data from the test file, print the results to a new CSV file ("output.csv").

## Author

- Nikan Kadkhodazadeh

## Version

- 1.0

