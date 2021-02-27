import React from 'react';

const Container = ({ args }) => {
  return (
    <mesh position={[0, 0, 0]}>
      <boxBufferGeometry attach='geometry' args={args} />
      <meshStandardMaterial attach='material' color='white' wireframe opacity={0.87} />
    </mesh>
  );
};

export default Container;
