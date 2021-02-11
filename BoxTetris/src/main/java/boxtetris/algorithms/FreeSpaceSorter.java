package boxtetris.algorithms;

import boxtetris.datastructures.MyList;
import boxtetris.entities.FreeSpace;

public interface FreeSpaceSorter {

    MyList<FreeSpace> sortFreeSpaces(MyList<FreeSpace> freeSpaces);
}
