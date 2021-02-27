import React from 'react';

const Cuboid = ({ coordinates, args, color }) => {
  return (
    <mesh position={coordinates}>
      <boxBufferGeometry attach='geometry' args={args} />
      <meshStandardMaterial attach='material' color={color} />
    </mesh>
  );
};

export default Cuboid;
