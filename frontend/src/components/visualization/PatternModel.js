import React from 'react';
import { ListGroup } from 'react-bootstrap';

const PatternModel = (props) => {
  const pattern = props.pattern;
  const count = props.count;

  return (
    <ListGroup.Item action onClick={() => props.handleVisualization(pattern)}>
      {count}. {pattern.container.name}. Volume utilization: {Math.round((pattern.volumeUtilization * 100 + Number.EPSILON) * 100) / 100} %. Weight utilization:
      {Math.round((pattern.volumeUtilization * 100 + Number.EPSILON) * 100) / 100} %
    </ListGroup.Item>
  );
};
export default PatternModel;
