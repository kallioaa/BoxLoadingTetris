import React from 'react';

const Container = (container) => {
  return (
    <tr>
      <td>{container.name}</td>
      <td>{container.length}</td>
      <td>{container.width}</td>
      <td>{container.height}</td>
      <td>{container.maxWeight}</td>
    </tr>
  );
};

export default Container;
