import React, { useRef } from 'react';
import './Visualization.css';
import { Canvas, useFrame } from 'react-three-fiber';
import { OrbitControls } from '@react-three/drei';

const Box = ({ coordinates, args, color }) => {
  return (
    <mesh position={coordinates}>
      <boxBufferGeometry attach='geometry' args={args} />
      <meshStandardMaterial attach='material' color={color} />
    </mesh>
  );
};

const Visualization = (props) => {
  return (
    <Canvas colorManagement camera={{ position: [-5, 2, 10], fov: 60 }}>
      <ambientLight intensity={0.3} />
      <pointLight position={[-10, 0, -20]} intensity={0.5} />
      <pointLight position={[0, -10, 0]} intensity={1.5} />
      <Box coordinates={[0, 0, 0]} args={[5, 5, 5]} color={'blue'} />
      <Box coordinates={[5, 0, 0]} args={[5, 5, 5]} color={'red'} />
      <Box coordinates={[5, 0, 5]} args={[5, 5, 5]} color={'red'} />
      <Box coordinates={[0, 0, 0]} args={[5, 5, 5]} color={'blue'} />
      <Box coordinates={[10, 10, 0]} args={[5, 5, 5]} color={'red'} />
      <Box coordinates={[10, 0, 5]} args={[5, 5, 5]} color={'red'} />
      <Box coordinates={[10, 10, 0]} args={[5, 5, 5]} color={'blue'} />
      <Box coordinates={[20, 0, 0]} args={[5, 5, 5]} color={'red'} />
      <Box coordinates={[29, 0, 5]} args={[5, 5, 5]} color={'red'} />
      <Box coordinates={[30, 10, 0]} args={[5, 5, 5]} color={'blue'} />
      <Box coordinates={[3, 0, 0]} args={[5, 5, 5]} color={'red'} />
      <Box coordinates={[4, 0, 5]} args={[5, 5, 5]} color={'red'} />
      <OrbitControls />
    </Canvas>
  );
};

export default Visualization;
