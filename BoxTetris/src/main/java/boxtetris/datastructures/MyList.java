package boxtetris.datastructures;

public class MyList<E> {
    private static final Integer DEFAULT_SIZE = 10;
    private Integer currentIndex;
    private Object[] array;

    public MyList() {
        this.currentIndex = -1;
        this.array = new Object[DEFAULT_SIZE];
    }

    /**
     * @return boolean
     */
    public boolean isEmpty() {
        return this.currentIndex == -1;
    }

    /**
     * @param e
     */
    public void add(E e) {
        currentIndex++;
        ensureCapacity(currentIndex);
        array[currentIndex] = e;
    }

    /**
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
     * @param index
     * @return E
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
     * @param index
     * @return E
     */
    @SuppressWarnings("unchecked")
    public E get(Integer index) {
        rangeCheck(index);
        return (E) array[index];
    }

    /**
     * @return Integer
     */
    public Integer size() {
        return currentIndex + 1;
    }

    public void clear() {
        this.array = new Object[DEFAULT_SIZE];
        this.currentIndex = -1;
    }

    /**
     * @param index
     */
    private void rangeCheck(int index) {
        if (index < 0 || index > currentIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }

    /**
     * @param index
     */
    private void removeFromArray(int index) {
        for (int i = index; i < currentIndex; i++) {
            array[i] = array[i + 1];
        }
    }

    /**
     * @param minSize
     */
    private void ensureCapacity(Integer minSize) {
        if (array.length <= minSize) {
            Object[] arrayNew = copyArray();
            array = arrayNew;
        }
    }

    /**
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
    public boolean addAll(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add((E) arr[i]);
        }
        return true;
    }
}
