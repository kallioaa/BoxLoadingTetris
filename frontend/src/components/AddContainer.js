import React, { Component } from 'react';
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import ContainerForm from './forms/ContainerForm';

class ContainerModalForm extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <React.Fragment>
        <Modal show={true} onHide={this.props.handleClose}>
          <Modal.Header closeButton>
            <Modal.Title>Add Container</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <ContainerForm />
          </Modal.Body>
        </Modal>
      </React.Fragment>
    );
  }
}

export default ContainerModalForm;
