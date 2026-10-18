# Hospital Record System

A command-line patient records manager in Java. It lets you create, search, sort, save and load patient files, and every field is validated as it's entered.

## Features

- **Create patients** with a health card number, full name (including middle names), date of birth, gender, phone number, address, email, vaccination status and a list of recent contacts
- **Input validation** on every field, for example:
  - Health card: 10 digits + a 2-letter version code (`1234567890AB`)
  - Date of birth: `MM/DD/YYYY`
  - Phone number: 10 digits
  - Province: 2-letter code checked against the real provinces and territories
  - Postal code: Canadian format (`A1A 1A1`)
  - Email: basic format check
- **Duplicate detection**: if a health card number already exists, you can either start over or replace the old record
- **Search** by health card number (binary search) or by full name. If more than one patient has the same name, it asks for the health card number instead.
- **Sort**, **print one** or **print all** records
- **Save and load** the patient list to and from a text file

## Menu

```
1  Create a new patient
2  Print a patient's information
3  Print all patient records
4  Save current patient list
5  Load patient list
6  Sort patient list
7  Find a patient
```

## Tech

Java · OOP (`Patient`, `Address` and `RecentContact` classes) · `Comparable` with `Collections.sort` / `binarySearch` · regex validation · custom exceptions · file I/O

## Running it

Open the project in Eclipse or IntelliJ and run `HospitalSystem`. Patient data is saved to and loaded from a `*`-delimited text file (see `src/main/data.text` for sample records).

## Author

Kaleena Kanagarajan · December 2025
