import React from 'react';
import Table from 'react-bootstrap/Table';

const CuboidList = () => {
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
    </React.Fragment>
  );
};
export default CuboidList;
