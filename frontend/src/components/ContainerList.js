import React from 'react';
import Table from 'react-bootstrap/Table';

const ContainerList = () => {
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
    </React.Fragment>
  );
};

export default ContainerList;
