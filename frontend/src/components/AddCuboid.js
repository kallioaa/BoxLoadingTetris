import React, { Component } from 'react';
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import CuboidForm from './forms/CuboidForm';

class CuboidModalForm extends Component {
  render() {
    return (
      <React.Fragment>
        <Modal show={true} onHide={this.props.handleClose}>
          <Modal.Header closeButton>
            <Modal.Title>Add Cuboid</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <CuboidForm />
          </Modal.Body>
        </Modal>
      </React.Fragment>
    );
  }
}

export default CuboidModalForm;
