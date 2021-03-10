# Implementation 

In this section, I will introduce you to my implementation of the algorithm by .... I will start by introducing you to the different classes I used. Then I will move on to explain the main algorithms and how we arrive at the final result.

## Entities
To understand the solution, the following entites are necessary.

### Cuboid
Cuboids represent items(boxes). A cuboid has a name, dimensions(length, width, height), weight, and demand. Cuboids can be rotated horizontally.

### Layer
A layer is formed of homogenous cuboids placed in rows (lengthwise), and these rows are placed next to each other (widthwise). 

### Container
A container has a name, dimensions(length, width, height), and a max weight.

### Pattern

A pattern is a packing solution. It has a container and a list of layers and their coordinates. 


## Main algorithms

### Layer building algorithm

Layer building is responsible for creating a list of layers that are used by the Pattern generation algorithm to arrive at the final result.

**Parameters**

* `list of cuboids`
  * MyList of cuboids we want to generate layers from
* `cuboidsInRow`
  * Max amount of cuboids in a row (lengthwise)
* `rowsInLayer`
  * Max amount of rows we set next to each other (widthwise)

By changing `cuboidsInRow` and `rowsInLayer`, we can experiment with runtime changes in different scenarios. The algorithm never generates a layer where the number of cuboids exceeds its demand.

**Return value**

* `list of layers`

**Complexities**

* Time Complexity: O()
* Space Complexity: O()

### Pattern generation algorithm

Pattern generation algorithm generates the pseudo-optimal packing patterns for the cuboids. The constraints can be found [here]()

**Parameters**

* `list of layers`
  * MyList of layers from which we build the pattern from
* `list of containers`
  * Containers we can use for packing
* `array of comparators for Dimensions`
  * These comparators change the order we select free spaces in

**Return value**

* `list of patterns`

**Complexities**

* Time Complexity: O()
* Space Complexity: O()

**More information**

The algorithm generates n x 2 x 9 different packing patterns where n is the number of containers when there are still cuboids to pack. Consider the following situation:

1. We have ten cuboids outside of a container.
2. We try to fit it all in one container, but it is not possible due to a lack of space or weight limit. In this process, we generate n x 2 x 9 patterns.
3. There are still five cuboids remaining.
4. We fit the remaining five into a container and generate n x 2 x 9 patterns.

Now, let's look at where the constants 2 x 9 come from.

If we want to understand where constant two comes from, we have first to understand free space. In short, it is the space left in a container. When there are no cuboids in a container, we have one free space the same size as the container. When we add new layers, new free space(s) are created around(on top) of the layer. We choose the free space we are going to insert the next layer in two different ways. Thus, the constant two comes from using two different ways to sort the free spaces we choose the next from.

Constant 9, on the other hand, comes from sorting the layers in different ways. We use nine different ways to sort layers affecting the order we insert them into a container.

We choose the best based on a volume utilization function after creating n x 2 x 9 different packing patterns. The volume utilization is calculated by dividing the volume of all layers in a container by the volume of the container. After we have found the pseudo-optimal pattern, we add it to the solution (list of patterns we return).


## To improve 

We could implement different data structures and or sorting algorithms to store and sort the values. 




