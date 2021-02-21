import React from 'react';
import Modal from 'react-bootstrap/Modal';
import CuboidForm from './forms/CuboidForm';

const CuboidModalForm = (props) => {
  return (
    <React.Fragment>
      <Modal show={true} onHide={props.handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Add Cuboid</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <CuboidForm addCuboid={props.addCuboid} handleClose={props.handleClose} />
        </Modal.Body>
      </Modal>
    </React.Fragment>
  );
};

export default CuboidModalForm;
