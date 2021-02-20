import React, { Component } from 'react';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';

class Containers extends Component {
  render() {
    return (
      <React.Fragment>
        <div>
          <h2 className='text-center'> Containers </h2>
          <Table striped bordered hover>
            <thead>
              <tr>
                <th> ID </th>
                <th> Name </th>
                <th> Dimensions </th>
                <th> Max Weight </th>
              </tr>
            </thead>
          </Table>
        </div>
        <div>
          <Button variant='outline-primary' size='lg' block>
            Add Container
          </Button>
        </div>
      </React.Fragment>
    );
  }
}

export default Containers;
