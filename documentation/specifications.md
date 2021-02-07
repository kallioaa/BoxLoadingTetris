# Specifications

The BoxTetris program cargo people to pack boxes (cuboids) into as few containers as possible. 

## Algorithms and datastructures in use

The (x,y,z) coordinates and dimensions of the boxes are going to be stored in two dimensional lists. Sorting algorithms are going to be implemented for ordering the boxes by their surface areas and volumes.

## User input

User can add boxes and containers with different height and width. User can also select the weight of boxes and the max weight for containers.

## Target time and space complexities

The problem is considered NP-hard. Thus, BoxTetris is using an greedy algorithm to solve the problem. My solution closely resembles the implementaition of Saraiva et al., 2015.

## References

Saraiva, R. D., Nepomuceno, N., & Pinheiro, P. R. (2015). A layer-building algorithm for the three-dimensional multiple bin packing problem: a case study in an automotive company. IFAC-PapersOnLine, 48(3), 490-495.

## Practical information

My field of study: Computer Science\
Language: English\
Programming language: Java
