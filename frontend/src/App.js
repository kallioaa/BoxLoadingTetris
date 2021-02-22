import React, { useState } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Intitialization from './Intitialization';
import axios from 'axios';
import { AccordionCollapse } from 'react-bootstrap';

const App = () => {
  const [containers, setContainer] = useState([]);
  const [cuboids, setCuboid] = useState([]);

  const addCuboid = (cuboid) => {
    axios
      .post('http://localhost:8080/addCuboid', cuboid)
      .then((res) => {
        console.log(res);
        console.log(res.data);
        setCuboid([...cuboids, cuboid]);
      })
      .catch((e) => console.log(e));
  };

  const addContainer = (container) => {
    axios
      .post('http://localhost:8080/addContainer', container)
      .then((res) => {
        console.log(res.data);
        setContainer([...containers, container]);
      })
      .catch((e) => console.log(e));
  };

  const clearCuboids = () => {
    console.log('huutista');
    axios
      .delete('http://localhost:8080/clearCuboids')
      .then((res) => {
        console.log(res.data);
        setCuboid([]);
      })
      .catch((err) => console.log(err));
  };

  const clearContainers = () => {
    console.log('huutista');
    axios
      .delete('http://localhost:8080/clearContainers')
      .then((res) => {
        console.log(res.data);
        setContainer([]);
      })
      .catch((err) => console.log(err));
  };

  return (
    <Router>
      <div>
        <Route
          path='/initialization'
          render={(props) => (
            <Intitialization {...props} containers={containers} addContainer={addContainer} clearContainers={clearContainers} cuboids={cuboids} addCuboid={addCuboid} clearCuboids={clearCuboids} />
          )}
        />
      </div>
    </Router>
  );
};

export default App;
