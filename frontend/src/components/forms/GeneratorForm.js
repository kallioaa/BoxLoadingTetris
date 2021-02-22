import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const GeneratorForm = (props) => {
  const [newCuboidsInRow, setNewCuboidsInRow] = useState('');
  const [newRowsInLayer, setNewRowsInLayer] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();
    props.setCuboidsInRow(parseInt(newCuboidsInRow));
    props.setRowsInLayer(parseInt(newRowsInLayer));
    props.handleClose();
  };

  return (
    <Form onSubmit={handleSubmit}>
      <Form.Group>
        <Form.Label> Cuboids in a row</Form.Label>
        <Form.Control type='number' className='form-control' name='CuboidsInRow' placeholder={props.cuboidsInRow.toString()} required onChange={(event) => setNewCuboidsInRow(event.target.value)} />
        <Form.Text> Specific settings for the layer building algorithm.</Form.Text>
        <br />
        <Form.Label> Rows in layer</Form.Label>
        <Form.Control type='number' className='form-control' name='rowsInLayer' placeholder={props.rowsInLayer.toString()} required onChange={(event) => setNewRowsInLayer(event.target.value)} />
        <Form.Text> Specific settings for the layer building algorithm.</Form.Text>
        <br />
        <Button className='float-right' type='submit'>
          Close settings
        </Button>
      </Form.Group>
    </Form>
  );
};

export default GeneratorForm;
