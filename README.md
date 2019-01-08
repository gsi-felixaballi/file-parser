# Logs Parser App (*Test Exercise*)
### Introduction:

**Abstract**

We have a public leak file that we need to process to be able to ingest that information into our
system. To solve this problem, you need to develop a program that will ingest a text file and return
output as specified bellow, and write that output to STDOUT.
The input file represents a list of places and people at different times. There are two distinct
formats mixed in the same file.

**Disclaimer**

Names and ID's are completely randomly generated with an online tool. Any possible
match it's just a coincidence.


**Format details**
1. Each line starts with F or D.
2. If F, this is a "format" line and two formats can be provided (1 or 2).
3. If D, this is a "data" line whose format is defined by the closest above format line.
4. If "F1" is specified, you can expect these fields separated with a comma:
a. D defining a data line
b. Name and surname
c. City
d. ID formatted as "12345678Z"
5. If "F2" is specified, you can expect these fields separated with space-semicolon-space:
a. D defining a data line
b. Name and surname
c. City
d. ID formatted as "12345678-Z"
Commands to support
1. java -jar application.jar {FILE} CITY {CITY_NAME} → Will print the list of names and ID's
belonging to people that have been in that city
2. java -jar application.jar {FILE} ID {ID_VALUE} (ID format example for input: 12345678Z) →
Will print the list of cities that this person has been to.


### Use Cases:
**Resource:**  *"./classes/data.txt"*

**Program input:**
```bash
java -jar file-parser-app-1.0-SNAPSHOT.jar "./classes/data.txt" "ID" "25384390A"
java -jar file-parser-app-1.0-SNAPSHOT.jar "./classes/data.txt" "ID" "25384390-A"
```

**Output:**

```bash
    [{id: 25384390A, name: Mitchell Newton, city: SAN FRANCISCO}]
    [{id: 25384390-A, name: Mitchell Newton, city: LAS VEGAS}]
```


**Program input:**
```bash
java -jar file-parser-app-1.0-SNAPSHOT.jar "./classes/data.txt" "CITY" "BARCELONA"
```

**Output:**
```bash
[
    {id: 93654902Y, name: Erica Burns, city: BARCELONA}, 
    {id: 44340637H, name: Renee Anderson, city: BARCELONA}, 
    {id: 04217040J, name: Lowell Miles, city: BARCELONA}, 
    {id: 69429384C, name: Russell Pope, city: BARCELONA}, 
    {id: 54808168L, name: Shelley Payne, city: BARCELONA}, 
    {id: 10863096N, name: Johnathan Cooper, city: BARCELONA}, 
    {id: 58204706D, name: Peter Daniel, city: BARCELONA}, 
    {id: 84604786E, name: Ruben Daniels, city: BARCELONA}, 
    {id: 23803975X, name: Emilio Warner, city: BARCELONA}
]
```

