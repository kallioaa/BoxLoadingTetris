import React, { useState } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Intitialization from './Intitialization';

const App = () => {
  const [containers, setContainer] = useState([]);
  const [cuboids, setCuboid] = useState([]);

  const addContainer = (container) => {
    setContainer([...containers, container]);
  };

  const addCuboid = (cuboid) => {
    setCuboid([...cuboids, cuboid]);
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
