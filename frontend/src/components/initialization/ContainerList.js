import React from 'react';
import Table from 'react-bootstrap/Table';
import ContainerModel from './ContainerModel';

const ContainerList = (props) => {
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
          <tbody>{props.containers.map(ContainerModel)}</tbody>
        </Table>
      </div>
    </React.Fragment>
  );
};

export default ContainerList;
