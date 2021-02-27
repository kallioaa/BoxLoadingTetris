import React, { useState } from 'react';
import PatternList from './PatternList';
import PatternVisualization from './PatternVisualization';

const Visualization = (props) => {
  const [visualizationActive, setVisualizationActive] = useState(false);
  const [visualization, setVisualization] = useState(<PatternVisualization pattern={props.patterns[1]} />);

  const handleVisualization = (pattern) => {
    setVisualization(<PatternVisualization pattern={pattern} />);
    setVisualizationActive(true);
  };

  return <React.Fragment>{visualizationActive ? visualization : <PatternList patterns={props.patterns} handleVisualization={handleVisualization} />}</React.Fragment>;
};

export default Visualization;
