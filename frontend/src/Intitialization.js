import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import ContainerList from './components/ContainerList';
import CuboidList from './components/CuboidList';

class Intitialization extends Component {
  render() {
    return (
      <div className='mt-5'>
        <div className='container'>
          <div className='row'>
            <div className='col'>
              <CuboidList />
            </div>
            <div className='col'>
              <ContainerList />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Intitialization;
