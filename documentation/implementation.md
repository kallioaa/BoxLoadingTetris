# Implementation 

In this section, I will introduce you to my implementation implmementation of the algorithm by .... I will start by introducing you to the different classes I used. Then I will move on to explain the main algorithms and how we arrive to the final result.

## Different classes
The most important classes are.

### Cuboid
Cuboids represent items(boxes). A cuboid has a name, dimensions(length, width, height), weight, and demand. Cuboids can be rotated horizontally.

### Container
A Container has a name, dimensions(length, width, height), and a max weight.

### Layer
A layer is formed of homogenous cuboids placed in rows (lengthwise), and these rows are placed next to each other (widthwise). 

## Main algorithms

### Layer building algorithm

Parameters

* `list of cuboids`
* `cuboidsInRow`
* `rowsInLayer`

`cuboidsInRow` the sets the maximum amount of cuboids the algorithm places in one row (lengthwise), and `rowsInLayer` the amount of rows we set next to each other (widthwise). The algortihm does not generate layers where the number of cuboids exceeds its demand. The algorithm returns a list of cuboids.

**Time Complexity: O()**  
**Space Complexity: O()**  

### Pattern generation algorithm

Paremters

*`list of layers`
*`list of containers`
*`array of comptarators for dimensions`





