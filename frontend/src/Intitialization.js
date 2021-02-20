import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Containers from './components/Containers';
import Cuboids from './components/Cuboids';

class Intitialization extends Component {
  render() {
    return (
      <div className='mt-5'>
        <div class='container'>
          <div class='row'>
            <div class='col'>
              <Cuboids />
            </div>
            <div class='col'>
              <Containers />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Intitialization;
