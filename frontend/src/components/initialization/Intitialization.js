import React, { useState } from 'react';
import ContainerList from './ContainerList';
import CuboidList from './CuboidList';
import AddCuboid from './AddCuboid';
import AddContainer from './AddContainer';
import Button from 'react-bootstrap/Button';
import SetUpGenerator from './SetUpGenerator';

const Intitialization = (props) => {
  const [addCuboid, setAddCuboid] = useState(false);
  const [addContainer, setAddContainer] = useState(false);
  const [showGenerator, showSetUpGenerator] = useState(false);

  const handleCloseAddContainer = () => {
    setAddContainer(false);
  };

  const handleCloseAddCuboid = () => {
    setAddCuboid(false);
  };

  const handleCloseSetUpGenerator = () => {
    showSetUpGenerator(false);
  };

  console.log(props.containers);

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
            <div>
              <br />
              <Button className='float-right' variant='btn btn-outline-secondary' onClick={() => showSetUpGenerator(true)}>
                Set up generator
              </Button>
              <br />
              <br />
              <br />
              {props.containers.length !== 0 && props.cuboids.length !== 0 ? (
                <Button className='float-right' variant='success' size='lg' onClick={props.generatePatterns} href='/visualization'>
                  Generate patterns!
                </Button>
              ) : null}
            </div>
          </div>
          <div>{addCuboid ? <AddCuboid handleClose={handleCloseAddCuboid} addCuboid={props.addCuboid} /> : null}</div>
          <div>{addContainer ? <AddContainer handleClose={handleCloseAddContainer} addContainer={props.addContainer} /> : null}</div>
          <div>
            {showGenerator ? (
              <SetUpGenerator
                handleClose={handleCloseSetUpGenerator}
                cuboidsInRow={props.cuboidsInRow}
                setCuboidsInRow={props.setCuboidsInRow}
                rowsInLayer={props.rowsInLayer}
                setRowsInLayer={props.setRowsInLayer}
              />
            ) : null}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Intitialization;
