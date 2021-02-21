import React, { Component } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

class ContainerForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      length: '',
      width: '',
      height: '',
      maxWeight: '',
    };
  }

  handleChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
    console.log(event.target.value);
    console.log(event.target.name);
  };

  handleSubmit = (event) => {
    event.preventDefault();
    console.log(this.state);
  };

  render() {
    return (
      <Form onSubmit={this.handleSubmit}>
        <Form.Group>
          <Form.Control type='text' name='name' placeholder='Name' value={this.state.name} onChange={this.handleChange} />
          <br />
          <Form.Control type='text' name='length' placeholder='Length' value={this.state.length} onChange={this.handleChange} />
          <br />
          <Form.Control type='text' name='width' placeholder='Width' value={this.state.width} onChange={this.handleChange} />
          <br />
          <Form.Control type='text' name='height' placeholder='Height' value={this.state.height} onChange={this.handleChange} />
          <br />
          <Form.Control type='text' name='maxWeight' placeholder='Max Weight' value={this.state.maxWeight} onChange={this.handleChange} />
          <br />
          <Button className='float-right' type='submit'>
            Add Container
          </Button>
        </Form.Group>
      </Form>
    );
  }
}

export default ContainerForm;
