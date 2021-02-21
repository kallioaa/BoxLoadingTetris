import React, { useState } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const CuboidForm = (props) => {
  const [state, setState] = useState({
    name: '',
    length: '',
    width: '',
    height: '',
    weight: '',
    demand: '',
  });

  const handleChange = (event) => {
    const { name, value } = event.target;
    setState({ ...state, [name]: value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    props.addCuboid(state);
    props.handleClose();
  };

  return (
    <Form onSubmit={handleSubmit}>
      <Form.Group>
        <Form.Control type='text' name='name' placeholder='Name' onChange={handleChange} />
        <br />
        <Form.Control type='text' name='length' placeholder='Length' onChange={handleChange} />
        <br />
        <Form.Control type='text' name='width' placeholder='Width' onChange={handleChange} />
        <br />
        <Form.Control type='text' name='height' placeholder='Height' onChange={handleChange} />
        <br />
        <Form.Control type='text' name='weight' placeholder='Weight' onChange={handleChange} />
        <br />
        <Form.Control type='text' name='demand' placeholder='Demand' onChange={handleChange} />
        <br />
        <Button className='float-right' type='submit'>
          Add Cuboid
        </Button>
      </Form.Group>
    </Form>
  );
};

export default CuboidForm;
