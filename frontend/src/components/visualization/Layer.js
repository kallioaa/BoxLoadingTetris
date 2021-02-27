import React, { useState } from 'react';
import LayerInformation from './LayerInformation';

const Layer = ({ coordinates, args, color, layerInformation }) => {
  return (
    <React.Fragment>
      <mesh onClick={() => console.log(layerInformation)} position={coordinates}>
        <boxBufferGeometry attach='geometry' args={args} />
        <meshStandardMaterial attach='material' color={color} />
      </mesh>
    </React.Fragment>
  );
};

export default Layer;
