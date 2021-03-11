import React, { useState } from 'react';
import { Canvas } from 'react-three-fiber';
import { OrbitControls } from '@react-three/drei';
import Layer from './Layer';
import Container from './Container';
import './PatternVisualization.scss';

const PatternVisualization = (props) => {
  var color = 'blue';
  const container = props.pattern.container;
  const scalar = 100 / Math.max(container.length, container.height, container.width);
  const containerDimensions = [container.length * scalar, container.height * scalar, container.width * scalar];

  const layersAndCoords = props.pattern.layers.map((e, i) => {
    return [e, props.pattern.coordinates[i]];
  });

  const addLayer = (layerAndCoord) => {
    const layer = layerAndCoord[0];
    const coordinates = layerAndCoord[1];

    const layerInformation = {
      cuboid: layer.cuboid,
      numberOfCuboid: layer.numberOfCuboid,
    };
    const argsArray = [layer.length * scalar, layer.height * scalar, layer.width * scalar];
    const coordinatesArray = [
      (layer.length / 2 - container.length / 2 + coordinates.x) * scalar,
      (layer.height / 2 - container.height / 2 + coordinates.z) * scalar,
      (layer.width / 2 - container.width / 2 + coordinates.y) * scalar,
    ];
    const layerVisual = <Layer args={argsArray} coordinates={coordinatesArray} layerInformation={layerInformation} color={color}></Layer>;
    color === 'red' ? (color = 'blue') : (color = 'red');
    return layerVisual;
  };

  return (
    <Canvas className='Canvas' colorManagement camera={{ position: [containerDimensions[0] + 10, containerDimensions[1] + 10, containerDimensions[2] + 10], fov: 60, far: 1000 }}>
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
      {layersAndCoords.map(addLayer)}
      <OrbitControls />
    </Canvas>
  );
};

export default PatternVisualization;
