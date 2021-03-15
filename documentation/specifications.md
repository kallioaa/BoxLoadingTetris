# Specifications

The BoxTetris program cargo people to pack boxes (cuboids) into containers maximising voilume utilization. 

## Algorithms and datastructures in use

A list structure is implmented to store information. This information is then sorted with quick sort algorithm.

## User input

**Cuboid**
* Name
* Length
* Width
* Height
* Weight
* Demand

**Container**
* Name
* Length
* Width
* Height
* Max weight

## Target time and space complexities

The problem is considered NP-hard. Thus, BoxTetris is using an greedy algorithm to solve the problem. My solution closely resembles the implementaition of Saraiva et al., 2015.

## References

Saraiva, R. D., Nepomuceno, N., & Pinheiro, P. R. (2015). A layer-building algorithm for the three-dimensional multiple bin packing problem: a case study in an automotive company. IFAC-PapersOnLine, 48(3), 490-495.

## Practical information

My field of study: Computer Science\
Language: English\
Programming language: Java
