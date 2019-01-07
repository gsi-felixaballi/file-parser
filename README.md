# Logs Parser App (*Test Exercise*)
### Introduction:
Abstract
We have a public leak file that we need to process to be able to ingest that information into our
system. To solve this problem, you need to develop a program that will ingest a text file and return
output as specified bellow, and write that output to **STDOUT**.

The input file represents a *list of places and people at different times*. 
There are two distinct formats mixed in the same file. 

**Disclaimer**: names and ID's are completely randomly generated with an online tool. Any possible
match it's just a coincidence


### Scenarios:
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

