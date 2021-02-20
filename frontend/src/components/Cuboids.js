import React, { Component } from 'react';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';

class Cuboids extends Component {
  render() {
    return (
      <React.Fragment>
        <div>
          <h2 className='text-center'> Cuboids </h2>
          <Table striped bordered hover>
            <thead>
              <tr>
                <th> ID </th>
                <th> Name </th>
                <th> Dimensions </th>
                <th> Weight </th>
              </tr>
            </thead>
            <tbody></tbody>
          </Table>
        </div>
        <div>
          <Button variant='outline-primary' size='lg' block>
            Add Cuboid
          </Button>
        </div>
      </React.Fragment>
    );
  }
}

export default Cuboids;
