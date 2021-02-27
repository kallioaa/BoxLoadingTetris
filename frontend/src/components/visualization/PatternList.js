import React from 'react';
import { ListGroup, Row, Col, Container } from 'react-bootstrap';
import PatternModel from './PatternModel';

const PatternList = (props) => {
  var count = 1;

  const patternMapper = (pattern) => {
    var patternProps = { count: count, pattern: pattern, handleVisualization: props.handleVisualization };
    count++;
    return PatternModel(patternProps);
  };

  return (
    <Container>
      <Row>
        <Col>
          <ListGroup>{props.patterns.map((pattern) => patternMapper(pattern))}</ListGroup>
        </Col>
      </Row>
    </Container>
  );
};

export default PatternList;
