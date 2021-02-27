import React from 'react';
import { Canvas } from 'react-three-fiber';
import { OrbitControls } from '@react-three/drei';
import Layer from './Layer';
import Container from './Container';
import './PatternVisualization.scss';

const PatternVisualization = (props) => {
  const container = props.pattern.container;
  const containerDimensions = [container.length, container.height, container.width];

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

    console.log(layer);
    const argsArray = [layer.length, layer.height, layer.width];
    const coordinatesArray = [layer.length / 2 - container.length / 2 + coordinates.x, layer.height / 2 - container.height / 2 + coordinates.z, layer.width / 2 - container.width / 2 + coordinates.y];

    return <Layer args={argsArray} coordinates={coordinatesArray} layerInformation={layerInformation} color='blue'></Layer>;
  };

  return (
    <Canvas className='Canvas' colorManagement camera={{ position: [container.length + 10, container.height + 10, container.width + 10], fov: 60, far: 2000 }}>
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
