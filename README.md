Benchmark Tests
=========
## Benchmarking custom implementations of native Java collections and sorting algorithms

### Data structures
#### HashMap 
* https://github.com/ksean/HashMap
 
### Sorting algorithms
#### Quicksort, insertion sort, selection sort, bubble sort
* https://github.com/ksean/SortingAlgorithm

#### Historical data
##### Test setup
* 10000 Integer elements
* Sorting pre-sorted list
* Sorting inversely-sorted list
* Sorting random list
* 3 warmup iterations & 10 test iterations

##### Test data
| Benchmark | Mode | Samples | Score | Score error | Units |
| --------- | ---- | ------- | ----- | ----------- | ----- |
| bubblesortPreSortedList | avgt | 10 | 40938.822 | 4442.172 | ns/op |
| bubblesortRandomList | avgt | 10 | 341628812.125 | 9211385.659 | ns/op |
| bubblesortUnSortedList | avgt | 10 | 256376491.680 | 13190590.818 | ns/op |
| insertionsortPreSortedList | avgt | 10 | 67984278.095 | 2263469.655 | ns/op |
| insertionsortRandomList | avgt | 10 | 51454323.802 | 4148655.683 | ns/op |
| insertionsortUnSortedList | avgt | 10 | 5742208.416 | 161123.210 |  ns/op |
| quicksortPreSortedList | avgt | 10 | 449231.937 | 13241.017 | ns/op |
| quicksortRandomList | avgt | 10 | 651365.579 | 43291.620 | ns/op |
| quicksortUnSortedList | avgt | 10 | 670628.299 | 23628.087 | ns/op |
| selectionsortPreSortedList | avgt | 10 | 87359237.985 | 5466168.805 | ns/op |
| selectionsortRandomList | avgt | 10 | 110126304.203 | 10914825.013 | ns/op |
| selectionsortUnSortedList | avgt | 10 | 95788402.353 | 7214438.492 | ns/op |