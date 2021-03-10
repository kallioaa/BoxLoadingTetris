# Implementation 

In this section, I will introduce you to my implementation implmementation of the algorithm by .... I will start by introducing you to the different classes I used. Then I will move on to explain the main algorithms and how we arrive to the final result.

## Entities
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

**More information**

The algorithm generates n x 2 x 9 different packing patterns where n is the amount of containers, when there are still cuboids to pack. Consider the following situation:

1. We have ten cuboids outside of a container.
2. We try to fit all in on container but is not possible due to lack of space or weight limit. In this process we generate n x 2 x 9 patterns.
3. There are still 5 cuboid remaining.
4. We fit the remaining 5 to a container and generate n x 2 x 9 patterns.

Now, lets look where the constants 2 x 9 come from.

If we want to undertand where does the constant 2 come from, we have to first understand free space. In short, it is the space left in a container. When there is no cuboids in a container, we have one free space same size as the container. When we add new layers, new free space(s) are created around(on top) of the layer. We choose the freespace we are going to insert the next layer in two different ways. Thus, the constant 2 comes from using two different ways to sort the freespaces we choode the next from.

Constant 9 on the other hand comes from sorting the layers in different ways. We use nine different ways to sort layers affecting the order we insert them in to a container.

 






** To improve ** 

We could implement different datastructures and or sorting algorithms to store and sort the values. 




