import React, { Component } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const ContainerForm = (props) => {
  return (
    <Form>
      <Form.Group>
        <Form.Control type='text' placeholder='Name' />
        <br />
        <Form.Control type='text' placeholder='Length' />
        <br />
        <Form.Control type='text' placeholder='Width' />
        <br />
        <Form.Control type='text' placeholder='Height' />
        <br />
        <Form.Control type='text' placeholder='Max Weight' />
        <br />
        <Button className='float-right' type='submit'>
          Add Container
        </Button>
      </Form.Group>
    </Form>
  );
};

export default ContainerForm;
