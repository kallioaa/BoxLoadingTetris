import React, { useState } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const CuboidForm = () => {
  const huutista = () => {
    console.log('testi');
  };

  return (
    <Form onSubmit={huutista}>
      <Form.Group>
        <Form.Control type='text' placeholder='Name' />
        <br />
        <Form.Control type='text' placeholder='Length' />
        <br />
        <Form.Control type='text' placeholder='Width' />
        <br />
        <Form.Control type='text' placeholder='Height' />
        <br />
        <Form.Control type='text' placeholder='Weight' />
        <br />
        <Form.Control type='text' placeholder='Demand' />
        <br />
        <Button className='float-right' type='submit'>
          Add Cuboid
        </Button>
      </Form.Group>
    </Form>
  );
};

export default CuboidForm;
