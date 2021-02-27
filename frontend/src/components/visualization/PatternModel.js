import React from 'react';
import { ListGroup } from 'react-bootstrap';

const PatternModel = (props) => {
  const pattern = props.pattern;
  const count = props.count;
  console.log(props.handleVisualization);
  return (
    <ListGroup.Item action onClick={props.handleVisualization}>
      {count}. {pattern.container.name}. Volume utilization: {pattern.volumeUtilization}. Weight utilization: {pattern.weightUtilization}
    </ListGroup.Item>
  );
};

export default PatternModel;
