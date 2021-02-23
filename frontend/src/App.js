import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Intitialization from './Intitialization';
import './App.css';
import Visualization from './Visualization';
import axios from 'axios';

const App = () => {
  const [containers, setContainer] = useState([]);
  const [cuboids, setCuboid] = useState([]);
  const [cuboidsInRow, setCuboidsInRow] = useState(5);
  const [rowsInLayer, setRowsInLayer] = useState(5);

  const addCuboid = (cuboid) => {
    axios
      .post('http://localhost:8080/addCuboid', cuboid)
      .then((res) => {
        console.log(res.data);
        getCuboids();
      })
      .catch((e) => console.log(e));
  };

  const addContainer = (container) => {
    axios
      .post('http://localhost:8080/addContainer', container)
      .then((res) => {
        console.log(res.data);
        getContainers();
      })
      .catch((e) => console.log(e));
  };

  const clearCuboids = () => {
    axios
      .delete('http://localhost:8080/clearCuboids')
      .then((res) => {
        console.log(res.data);
        getCuboids();
      })
      .catch((err) => console.log(err));
  };

  const clearContainers = () => {
    axios
      .delete('http://localhost:8080/clearContainers')
      .then((res) => {
        console.log(res.data);
        getContainers();
      })
      .catch((err) => console.log(err));
  };

  const getContainers = () => {
    axios
      .get('http://localhost:8080/getContainers')
      .then((res) => {
        setContainer([]);
        res.data.map((container) => setContainer([...containers, container]));
      })
      .catch((err) => console.log(err));
  };

  const getCuboids = () => {
    axios
      .get('http://localhost:8080/getCuboids')
      .then((res) => {
        setCuboid([]);
        res.data.map((cuboid) => setCuboid([...cuboids, cuboid]));
      })
      .catch((err) => console.log(err));
  };

  useEffect(() => {
    getCuboids();
    getContainers();
  }, []);

  return (
    <Router>
      <div>
        <Route
          path='/initialization'
          render={(props) => (
            <Intitialization
              {...props}
              containers={containers}
              addContainer={addContainer}
              clearContainers={clearContainers}
              cuboids={cuboids}
              addCuboid={addCuboid}
              clearCuboids={clearCuboids}
              cuboidsInRow={cuboidsInRow}
              setCuboidsInRow={setCuboidsInRow}
              rowsInLayer={rowsInLayer}
              setRowsInLayer={setRowsInLayer}
            />
          )}
        />
        <Route path='/visualization' component={Visualization} />
      </div>
    </Router>
  );
};
export default App;
