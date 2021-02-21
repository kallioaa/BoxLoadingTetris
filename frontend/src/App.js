import React, { useState } from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
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
    <div className='App'>
      <Intitialization addCuboid={addCuboid} cuboids={cuboids} addContainer={addContainer} containers={containers} />
    </div>
  );
};

export default App;
