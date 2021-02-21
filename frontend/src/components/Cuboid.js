import React from 'react';

const Cuboid = (cuboid) => {
  return (
    <tr>
      <td>{cuboid.name}</td>
      <td>{cuboid.length}</td>
      <td>{cuboid.width}</td>
      <td>{cuboid.height}</td>
      <td>{cuboid.weight}</td>
      <td>{cuboid.demand}</td>
    </tr>
  );
};

export default Cuboid;
