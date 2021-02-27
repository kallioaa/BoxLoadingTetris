import React from 'react';
import Modal from 'react-bootstrap/Modal';
import GeneratorForm from './forms/GeneratorForm';

const setUpGenerator = (props) => {
  return (
    <React.Fragment>
      <Modal show={true} onHide={props.handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Pattern generator settings</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <GeneratorForm
            cuboidsInRow={props.cuboidsInRow}
            setCuboidsInRow={props.setCuboidsInRow}
            rowsInLayer={props.rowsInLayer}
            setRowsInLayer={props.setRowsInLayer}
            handleClose={props.handleClose}
          />
        </Modal.Body>
      </Modal>
    </React.Fragment>
  );
};

export default setUpGenerator;
