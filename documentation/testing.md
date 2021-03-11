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


Result:
10 Contianers with
Volume utilization: 100%  
Weight utilization: 100%  



