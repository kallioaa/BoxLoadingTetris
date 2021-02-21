import React from 'react';
import Modal from 'react-bootstrap/Modal';
import ContainerForm from './forms/ContainerForm';

const ContainerModalForm = (props) => {
  return (
    <React.Fragment>
      <Modal show={true} onHide={props.handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Add Container</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <ContainerForm addContainer={props.addContainer} handleClose={props.handleClose} />
        </Modal.Body>
      </Modal>
    </React.Fragment>
  );
};

export default ContainerModalForm;
