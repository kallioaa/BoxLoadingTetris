import React, { Component } from 'react';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import AddContainer from './AddContainer';

class ContainerList extends Component {
  constructor(props) {
    super(props);
    this.state = { showAddContainer: false };
  }

  handleAddContainerClick = () => {
    this.setState({ showAddContainer: true });
  };

  handleCloseAddContainer = () => {
    this.setState({ showAddContainer: false });
  };

  render() {
    return (
      <React.Fragment>
        <div>
          <h2 className='text-center'> Containers </h2>
          <Table striped bordered hover>
            <thead>
              <tr>
                <th> Name </th>
                <th> Length </th>
                <th> Width </th>
                <th> Height </th>
                <th> Max Weight </th>
              </tr>
            </thead>
          </Table>
        </div>
        <div>
          <Button variant='outline-primary' size='lg' onClick={this.handleAddContainerClick} block>
            Add Container
          </Button>
        </div>
        <div>{this.state.showAddContainer ? <AddContainer handleClose={this.handleCloseAddContainer} /> : null}</div>
      </React.Fragment>
    );
  }
}

export default ContainerList;
