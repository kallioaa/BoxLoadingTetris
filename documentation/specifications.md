# Specifications

The BoxTetris program cargo people to pack boxes (cuboids) into as few containers as possible. Dimensions of the containers are planned to be fixed. Number of boxes and their height and width can be altered.

## Algorithms and datastructures in use

The (x,y,z) coordinates and dimensions of the boxes are going to be stored in two dimensional lists. Sorting algorithms are going to be implemented for ordering the boxes by their surface areas and volumes.

## User input

User can add boxes with different height and width. The size of a container where the boxes are packed is fixed.

## Target time and space complexities

The problem is considered NP-hard[1]. Thus, BoxTetris is using an greedy algorithm to solve the problem. 

## References

[1]
Wenqi Huang, Kun He,
A new heuristic algorithm for cuboids packing with no orientation constraints,
Computers & Operations Research,
Volume 36, Issue 2,
2009,
Pages 425-432,
ISSN 0305-0548,
https://doi.org/10.1016/j.cor.2007.09.008.
(http://www.sciencedirect.com/science/article/pii/S0305054807001785)

## Practical information

My field of study: Computer Science
Language: English
Programming language: Java
