package movers.tetris.datastructures;

public class MyList<E> {
    private static final Integer DEFAULT_SIZE = 10;
    private Integer size;
    private Object[] array;

    public MyList() {
        this.size = 0;
        this.array = new Object[DEFAULT_SIZE];
    }

    public boolean add(E e) {
        ensureCapacity(size++);
        array[size++] = e;
        size++;
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
        if (index<0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + "is out of bounds");
        }
    }

    private void removeFromArray(int index) {
        for (int i=index; i < size - 1; i++) {
            array[i] = array[i+1];
        }
    }


    private void ensureCapacity(Integer minSize) {
        if (array.length < minSize) {
            Object[] arrayNew = new Object[array.length * 2];
            arrayNew = copyArray(array, arrayNew);
            array = arrayNew;        
        }
    }


    private Object[] copyArray(Object[] arrayOld, Object[] arrayNew) {
        for (int i=0; i<arrayOld.length; i++) {
            arrayNew[i] = arrayOld[i];
        }
        return arrayNew;
    }
}
