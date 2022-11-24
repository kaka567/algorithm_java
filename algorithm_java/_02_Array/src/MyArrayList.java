import java.util.Arrays;

/**
 * 动态数组
 * */
public class MyArrayList<E> extends CommonParent<E> {
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capacity];
    }
    public MyArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        removeCapacity();
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        // 基本思路：先将要添加位置后面的元素依次往后移，然后再插入要添加的元素
        // 1、判断是否越界
        rangeCheckForAdd(index);
        // 2、确保容量
        ensureCapacity(size + 1);
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        // 基本思路：将要添加位置后面的元素依次往前移，然后将最后一位置为null
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i< size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        elements[size] = null;
        removeCapacity();
        return old;
    }

    @Override
    public int indexOf(E element) {
        // 将null和其他类型分开
        if (element == null) {
            // 找到第一个为null的元素
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements.equals(elements[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 扩容
     * */
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= minCapacity) return;
        // 扩容1.5倍
        int newCapacity = oldCapacity + oldCapacity >> 1;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    /**
     * 缩容
     * */
    private void removeCapacity() {
        int oldCapacity = elements.length;
        if (oldCapacity <= DEFAULT_CAPACITY) return;
        if (size < oldCapacity * 0.5) {
            int newCapacity = (oldCapacity >> 1) > DEFAULT_CAPACITY ? (oldCapacity >> 1) : DEFAULT_CAPACITY;
            E[] newElements = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
