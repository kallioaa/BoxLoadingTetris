# Instructions for tui

If you want to use a tui. First, locate to the build.gradle file in backend directory. Here, change mainClassName equals 'boxtetris.timer.TimeAlgo'. (Picture below)

<img width="304" alt="Screenshot 2021-03-15 at 10 22 00" src="https://user-images.githubusercontent.com/70749953/111123644-48ddd780-8578-11eb-9ac8-64a9943450bd.png">

Now, open file input.txt located in the backend directory. From here you can add cuboids and containers used in the solution, and change the parameters cuboidsInLayer and rowsInLayer. **Do not use spaces for the names!**. After you are done, save the file.

Now you are ready to run the algorithm. Run the following command from the backend directory

```
./gradlew run
```

The runtime of the algorithm should be displayd on your terminal window. Output.txt from the backend folder contains details of the packing patterns.

# Instructions for gui

If you want to use a gui. First, locate to the build.gradle file in backend directory. Here, change mainClassName equals 'boxtetris.restservice.RestServiceApplication'. (Picture below)

<img width="495" alt="Screenshot 2021-03-15 at 10 32 26" src="https://user-images.githubusercontent.com/70749953/111124955-bfc7a000-8579-11eb-9e46-9c19ec13c949.png">


## Intializing the backend

Locate to the backend directory and run the following command.

```
./gradlew run
```
You should see sprint initializing itself and starting to listen on port 8080.


## Intializing the frontend

Locate to the frontend folder and run the following command to download dependencies (Assuming you have node.js installed).

```
npm install 
```

Now you can start the application by running the command.

```
npm start
```

Locate to the /intialization site where you can start using the program.






