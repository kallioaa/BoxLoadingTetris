import React from 'react';
import { Canvas } from 'react-three-fiber';
import { OrbitControls } from '@react-three/drei';
import Cuboid from './Cuboid';
import Container from './Container';

const PatternVisualization = (props) => {
  const containerDimensions = [600, 600, 400];

  return (
    <div>
      <style global jsx>{`
        html,
        body,
        body > div:first-child,
        div#__next,
        div#__next > div {
          height: 100%;
          backfroung: #f3ff;
        }
      `}</style>
      <Canvas colorManagement camera={{ position: [100, 100, 100], fov: 60, far: 2000 }}>
        <ambientLight intensity={0.3} />
        <directionalLight
          position={[0, 10, 0]}
          intensity={1.5}
          shadow-mapSize-width={1024}
          shadow-mapSize-width={1024}
          shadow-camera-far={50}
          shadow-camera-left={-10}
          shadow-camera-right={10}
          shadow-camera-top={10}
          shadow-camera-bottom={-10}
        />
        <pointLight position={[-10, 0, -20]} intensity={0.5} />
        <pointLight position={[0, -10, 0]} intensity={1.5} />
        <Container args={containerDimensions} />
        <Cuboid />
        <OrbitControls />
      </Canvas>
    </div>
  );
};

export default PatternVisualization;
