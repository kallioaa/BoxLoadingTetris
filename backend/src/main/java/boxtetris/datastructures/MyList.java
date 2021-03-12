package boxtetris.datastructures;

/**
 * Implmentation of a list datastructure
 */
public class MyList<E> {
    private static final Integer DEFAULT_SIZE = 10;
    private Integer currentIndex;
    private Object[] array;

    public MyList() {
        this.currentIndex = -1;
        this.array = new Object[DEFAULT_SIZE];
    }

    /**
     * Return true if the list is empty false otherwise.
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        return this.currentIndex == -1;
    }

    /**
     * Adds a item to the list
     * 
     * @param e
     */
    public void add(E e) {
        currentIndex++;
        ensureCapacity(currentIndex);
        array[currentIndex] = e;
    }

    /**
     * Returns the list as an array.
     * 
     * @return Object[]
     */
    public Object[] toArray() {
        Object[] arrayReturned = new Object[currentIndex + 1];
        for (int i = 0; i < currentIndex + 1; i++) {
            arrayReturned[i] = array[i];
        }
        return arrayReturned;
    }

    /**
     * Removes the item from a index
     * 
     * @param index from where the object is removed
     * @return E the item which was removed
     */
    @SuppressWarnings("unchecked")
    public E remove(Integer index) {
        rangeCheck(index);
        E oldItem = (E) array[index];
        removeFromArray(index);
        currentIndex--;
        return oldItem;
    }

    /**
     * Returns the object from index
     * 
     * @param index index of the object we want
     * @return E
     */
    @SuppressWarnings("unchecked")
    public E get(Integer index) {
        rangeCheck(index);
        return (E) array[index];
    }

    /**
     * Amount of objects in the list
     * 
     * @return Integer size of the list
     */
    public Integer size() {
        return currentIndex + 1;
    }

    /**
     * Clears all object from the list
     */
    public void clear() {
        this.array = new Object[DEFAULT_SIZE];
        this.currentIndex = -1;
    }

    /**
     * Returns the last object from the list
     * 
     * @return E last object
     */
    @SuppressWarnings("unchecked")
    public E getLast() {
        if (currentIndex > -1) {
            return (E) array[currentIndex];
        }
        return null;
    }

    /**
     * Checks if a value is in the correct range
     * 
     * @param index to be checked
     */
    private void rangeCheck(int index) {
        if (index < 0 || index > currentIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }

    /**
     * Removes a object from the array
     * 
     * @param index of the object to be removed
     */
    private void removeFromArray(int index) {
        for (int i = index; i < currentIndex; i++) {
            array[i] = array[i + 1];
        }
    }

    /**
     * Creates new space if the list becomes too msall
     * 
     * @param minSize
     */
    private void ensureCapacity(Integer minSize) {
        if (array.length <= minSize) {
            Object[] arrayNew = copyArray();
            array = arrayNew;
        }
    }

    /**
     * Returns a copy of an array
     * 
     * @return Object[]
     */
    private Object[] copyArray() {
        Object[] arrayNew = new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            arrayNew[i] = array[i];
        }
        return arrayNew;
    }

    /**
     * @param arr
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    public boolean addAll(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add((E) arr[i]);
        }
        return true;
    }
}
