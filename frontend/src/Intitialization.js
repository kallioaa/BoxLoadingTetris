import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import ContainerList from './components/ContainerList';
import CuboidList from './components/CuboidList';
import AddCuboid from './components/AddCuboid';
import AddContainer from './components/AddContainer';
import Button from 'react-bootstrap/Button';

class Intitialization extends Component {
  constructor(props) {
    super(props);
    this.state = { showAddCuboid: false, showAddContainer: false };
  }

  handleAddContainerClick = () => {
    this.setState({ showAddContainer: true });
  };

  handleCloseAddContainer = () => {
    this.setState({ showAddContainer: false });
  };

  handleAddCuboidClick = () => {
    this.setState({ showAddCuboid: true });
  };

  handleCloseAddCuboid = () => {
    this.setState({ showAddCuboid: false });
  };

  render() {
    return (
      <div className='mt-5'>
        <div className='container'>
          <div className='row'>
            <div className='col'>
              <CuboidList />
              <Button variant='outline-primary' size='lg' onClick={this.handleAddCuboidClick} block>
                Add Cuboid
              </Button>
            </div>
            <div className='col'>
              <ContainerList />
              <Button variant='outline-primary' size='lg' onClick={this.handleAddContainerClick} block>
                Add Container
              </Button>
            </div>
            <div>{this.state.showAddCuboid ? <AddCuboid handleClose={this.handleCloseAddCuboid} /> : null}</div>
            <div>{this.state.showAddContainer ? <AddContainer handleClose={this.handleCloseAddContainer} /> : null}</div>
          </div>
        </div>
      </div>
    );
  }
}

export default Intitialization;
