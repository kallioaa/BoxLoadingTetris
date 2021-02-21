import React, { Component } from 'react';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import AddCuboid from './AddCuboid';

class CuboidList extends Component {
  constructor(props) {
    super(props);
    this.state = { showAddCuboid: false };
  }

  handleAddCuboidClick = () => {
    this.setState({ showAddCuboid: true });
  };

  handleCloseAddCuboid = () => {
    this.setState({ showAddCuboid: false });
  };

  render() {
    return (
      <React.Fragment>
        <div>
          <h2 className='text-center'> Cuboids </h2>
          <Table striped bordered hover>
            <thead>
              <tr>
                <th> Name </th>
                <th> Length </th>
                <th> Width </th>
                <th> Height </th>
                <th> Weight </th>
                <th> Demand </th>
              </tr>
            </thead>
            <tbody></tbody>
          </Table>
        </div>
        <div>
          <Button variant='outline-primary' size='lg' onClick={this.handleAddCuboidClick} block>
            Add Cuboid
          </Button>
        </div>
        <div>{this.state.showAddCuboid ? <AddCuboid handleClose={this.handleCloseAddCuboid} /> : null}</div>
      </React.Fragment>
    );
  }
}
export default CuboidList;
