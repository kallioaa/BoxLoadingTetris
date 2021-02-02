package boxtetris.datastructures;

public class MyList<E> {
    private static final Integer DEFAULT_SIZE = 10;
    private Integer currentIndex;
    private Object[] array;

    public MyList() {
        this.currentIndex = -1;
        this.array = new Object[DEFAULT_SIZE];
    }

    public void add(E e) {
        currentIndex++;
        ensureCapacity(currentIndex);
        array[currentIndex] = e;
    }

    public E remove(Integer index) {
        rangeCheck(index);
        E oldItem = (E) array[index];
        removeFromArray(index);
        currentIndex--;
        return oldItem;
    }

    public E get(Integer index) {
        rangeCheck(index);
        return (E) array[index];
    }

    public Integer size() {
        return currentIndex + 1;
    }

    private void rangeCheck(int index) {
        if (index<0 || index > currentIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }

    private void removeFromArray(int index) {
        for (int i=index; i < currentIndex; i++) {
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
