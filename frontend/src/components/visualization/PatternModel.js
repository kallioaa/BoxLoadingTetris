import React from 'react';
import { ListGroup } from 'react-bootstrap';

const PatternModel = (props) => {
  const pattern = props.pattern;
  const count = props.count;

  return (
    <ListGroup.Item action onClick={() => props.handleVisualization(pattern)}>
      {count}. {pattern.container.name}. Volume utilization: {pattern.volumeUtilization * 100} %. Weight utilization: {pattern.weightUtilization * 100} %
    </ListGroup.Item>
  );
};

export default PatternModel;
