# Testing

The algorithm is tested with unit and manual tests. 

## Running unit tests

You can run the unit tests by running the following command in backend directory

```
./gradlew test
```

After running the tests, you can find a test report from *./build/reports/tests/test/index.html*. 

## Manual testing

Numerical and visual result of different manual test cases.

### Case I

**Cuboids**

| Name    | Length | Width | Height | Weight  | Demand | Total Weight | Volume  |
|---------|--------|-------|--------|---------|--------|--------------|---------|
| Matches | 40     | 20    | 10     | 10      | 1000   | 10000         | 8000000 |
|         |        |       |        |         |        | 10000         | 8000000 |

**Containers**

| Name                  | Length | Width | Height | Max weight | Volume  |
|-----------------------|--------|-------|--------|------------|---------|
| Container for Matches | 400    | 200   | 100    | 10000      | 8000000 |

![ezgif-6-5079e470c4b8](https://user-images.githubusercontent.com/70749953/110858247-83b6e580-82c2-11eb-9271-63dff01f6dd0.gif)

Result:
1 X Container for Matches  
Volume utilization: 100%  
Weight utilization: 100%  

### Case II

| Name    | Length | Width | Height | Weight | Demand  | Total Weight  | Volume   |
|---------|--------|-------|--------|--------|---------|---------------|----------|
| Matches | 40     | 20    | 10     | 10     | 10000   | 100000        | 80000000 |
|         |        |       |        |        |         | 100000        | 80000000 |

**Containers**

| Name                  | Length | Width | Height | Max weight | Volume  |
|-----------------------|--------|-------|--------|------------|---------|
| Container for Matches | 400    | 200   | 100    | 10000      | 8000000 |

![ezgif-6-6595d8005f95](https://user-images.githubusercontent.com/70749953/110859626-608d3580-82c4-11eb-88c3-42743cf4e562.gif)

Result:  
10 X Container for Matches  
Volume utilization: 100%  
Weight utilization: 100%  

### Case III

| Name      | Length | Width | Height | Weight | Demand | Total Weight | Volume  |
|-----------|--------|-------|--------|--------|--------|--------------|---------|
| Tomatoes  | 24     | 23    | 35     | 2      | 15     | 30           | 289800  |
| Cucumbers | 30     | 10    | 30     | 2      | 15     | 26           | 117000  |
| Lettuce   | 100    | 100   | 100    | 50     | 3      | 150          | 3000000 |
|           |        |       |        |        |        | 210          | 3406800 |

**Containers**

| Name        | Length | Width | Height | Max weight | Volume    |
|-------------|--------|-------|--------|------------|-----------|
| Container A | 500    | 500   | 500    | 1000       | 125000000 |

![ezgif-6-65636963642d](https://user-images.githubusercontent.com/70749953/110860653-b9110280-82c5-11eb-94b2-26cf2ddac923.gif)


Result:  
1 X Container A  
Volume utilization: 2.74%  
Weight utilization: 21.0%  

### Case IIII

The smallest possible container to fit all is choosen.

| Name      | Length | Width | Height | Weight | Demand | Total Weight | Volume   |
|-----------|--------|-------|--------|--------|--------|--------------|----------|
| Cucumbers | 25     | 25    | 25     | 1      | 1000   | 1000         | 15625000 |
|           |        |       |        |        |        | 1000         | 15625000 |

**Containers**

| Name                | Length | Width | Height | Max weight | Volume     |
|---------------------|--------|-------|--------|------------|------------|
| Container too small | 25     | 25    | 25     | 1000       | 15625      |
| Container too big   | 1000   | 1000  | 1000   | 1000       | 1000000000 |
| Container good size | 250    | 250   | 250    | 1000       | 15625000   |

![ezgif-6-9f4a318f5615](https://user-images.githubusercontent.com/70749953/110869396-09429180-82d3-11eb-846c-92de39074c03.gif)

Result:  
1 X Container good size  
Volume utilization: 100%  
Weight utilization: 100%  





