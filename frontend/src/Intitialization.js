import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import ContainerList from './components/ContainerList';
import CuboidList from './components/CuboidList';
import AddCuboid from './components/AddCuboid';
import AddContainer from './components/AddContainer';
import Button from 'react-bootstrap/Button';

const Intitialization = (props) => {
  const [addCuboid, setAddCuboid] = useState(false);
  const [addContainer, setAddContainer] = useState(false);

  const handleCloseAddContainer = () => {
    setAddContainer(false);
  };

  const handleCloseAddCuboid = () => {
    setAddCuboid(false);
  };

  return (
    <div className='mx-auto'>
      <div className='container'>
        <div className='row'>
          <div className='col'>
            <CuboidList cuboids={props.cuboids} />
            <Button variant='outline-primary' size='lg' onClick={() => setAddCuboid(true)} block>
              Add Cuboid
            </Button>
            <br />
            {props.cuboids.length !== 0 ? (
              <Button variant='outline-danger' onClick={props.clearCuboids} block>
                Clear Cuboids
              </Button>
            ) : null}
          </div>
          <div className='col'>
            <ContainerList containers={props.containers} />
            <Button variant='outline-primary' size='lg' onClick={() => setAddContainer(true)} block>
              Add Container
            </Button>
            <br />
            {props.containers.length !== 0 ? (
              <Button variant='outline-danger' onClick={props.clearContainers} block>
                Clear Containers
              </Button>
            ) : null}
          </div>
          <div>{addCuboid ? <AddCuboid handleClose={handleCloseAddCuboid} addCuboid={props.addCuboid} /> : null}</div>
          <div>{addContainer ? <AddContainer handleClose={handleCloseAddContainer} addContainer={props.addContainer} /> : null}</div>
        </div>
      </div>
    </div>
  );
};

export default Intitialization;
