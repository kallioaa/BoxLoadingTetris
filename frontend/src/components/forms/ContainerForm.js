import React, { useState } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const ContainerForm = (props) => {
  const [state, setState] = useState({
    name: '',
    length: '',
    width: '',
    height: '',
    maxWeight: '',
  });

  const handleChange = (event) => {
    const { name, value } = event.target;
    setState({ ...state, [name]: value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    props.addContainer(state);
    props.handleClose();
  };

  return (
    <Form onSubmit={handleSubmit}>
      <Form.Group>
        <Form.Control type='text' name='name' placeholder='Name' value={state.name} onChange={handleChange} />
        <br />
        <Form.Control type='text' name='length' placeholder='Length' value={state.length} onChange={handleChange} />
        <br />
        <Form.Control type='text' name='width' placeholder='Width' value={state.width} onChange={handleChange} />
        <br />
        <Form.Control type='text' name='height' placeholder='Height' value={state.height} onChange={handleChange} />
        <br />
        <Form.Control type='text' name='maxWeight' placeholder='Max Weight' value={state.maxWeight} onChange={handleChange} />
        <br />
        <Button className='float-right' type='submit'>
          Add Container
        </Button>
      </Form.Group>
    </Form>
  );
};

export default ContainerForm;
