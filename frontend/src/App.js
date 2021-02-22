import React, { useState } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Intitialization from './Intitialization';
import axios from 'axios';

const App = () => {
  const [containers, setContainer] = useState([]);
  const [cuboids, setCuboid] = useState([]);

  const postCuboid = (cuboid) => {
    axios
      .post('http://localhost:8080/addCuboid', cuboid)
      .then((res) => {
        console.log(res);
        console.log(res.data);
      })
      .catch((e) => console.log(e));
  };

  const postContainer = (container) => {
    axios
      .post('http://localhost:8080/addContainer', container)
      .then((res) => {
        console.log(res);
        console.log(res.data);
      })
      .catch((e) => console.log(e));
  };

  const addContainer = (container) => {
    setContainer([...containers, container]);
    console.log(container);
    postContainer(container);
  };

  const addCuboid = (cuboid) => {
    setCuboid([...cuboids, cuboid]);
    postCuboid(cuboid);
  };

  return (
    <Router>
      <div>
        <Route path='/initialization' render={(props) => <Intitialization {...props} containers={containers} addContainer={addContainer} cuboids={cuboids} addCuboid={addCuboid} />} />
      </div>
    </Router>
  );
};

export default App;
