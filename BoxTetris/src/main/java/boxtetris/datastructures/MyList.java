package boxtetris.datastructures;

public class MyList<E> {
    private static final Integer DEFAULT_SIZE = 10;
    private Integer currentIndex;
    private Object[] array;

    public MyList() {
        this.currentIndex = 0;
        this.array = new Object[DEFAULT_SIZE];
    }

    public boolean add(E e) {
        array[currentIndex] = e;
        currentIndex++;
        ensureCapacity(currentIndex);
        return true;
    }

    public E remove(Integer index) {
        rangeCheck(index);
        E oldItem = (E) array[index];
        removeFromArray(index);
        return oldItem;

    }

    public E get(Integer index) {
        rangeCheck(index);
        return (E) array[index];
    }

    private void rangeCheck(int index) {
        if (index<0 || index >= currentIndex) {
            throw new IndexOutOfBoundsException("Index " + index + "is out of bounds");
        }
    }

    private void removeFromArray(int index) {
        for (int i=index; i < currentIndex - 1; i++) {
            array[i] = array[i+1];
        }
    }


    private void ensureCapacity(Integer minSize) {
        if (array.length <= minSize) {
            Object[] arrayNew = copyArray();
            array = arrayNew;        
        }
    }

    private Object[] copyArray() {
        Object[] arrayNew = new Object[array.length * 2];
        for (int i=0; i<array.length; i++) {
            arrayNew[i] = array[i];
        }
        return arrayNew;
    }
}
