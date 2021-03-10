# Implementation 

In this section, I will introduce you to my implementation implmementation of the algorithm by .... I will start by introducing you to the different classes I used. Then I will move on to explain the main algorithms and how we arrive to the final result.

## Different classes
The most important classes are.

### Cuboid
Cuboids represent items(boxes). A cuboid has a name, dimensions(length, width, height), weight, and demand. Cuboids can be rotated horizontally.

### Layer
Layer is formed of homogenous cuboids placed in rows (lengthwise), and these rows are placed next to each other (widthwise). 

### Container
Container has a name, dimensions(length, width, height), and a max weight.

### Pattern

Pattern is a packing solution. It has a container and a list of layers and their coordinates. 


## Main algorithms

### Layer building algorithm

Layer building is resbonsible for creating a list of layers which are used by Pattern generation algorithm to arrive at the final result.

**Parameters**

* `list of cuboids`
  * MyList of cuboids we want to generate layers from
* `cuboidsInRow`
  * Max amoung of cuboids in a row (lengthwise)
* `rowsInLayer`
  * Max amount of rows we set next to each other (widthwise)

By changing `cuboidsInRow` and `rowsInLayer` we can experiment runtime changes on different scenarios. Algorithm never generates a layer where the number of cuboids exceed its demand.

**Return value**

* `list of layers`

**Complexities**

* Time Complexity: O()
* Space Complexity: O()

### Pattern generation algorithm

Pattern generation algorithm generates the pseudo-optimal packing patterns for the cuboids. 

**Parameters**

* `list of layers`
  * MyList of layers from which we build the pattern from
* `list of containers`
  * Conttainers we can use for packing
* `array of comparators for Dimensions`
  * These comprators change the order we select freespaces in


**Return value**

* `list of patterns`

**Complexities**

* Time Complexity: O()
* Space Complexity: O()







