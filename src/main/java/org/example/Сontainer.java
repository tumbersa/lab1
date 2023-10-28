package org.example;

import java.util.Arrays;
class Container<T> {
    /**
     @param INIT_SIZE размер изначального массива
     */
    private final int INIT_SIZE = 1;
    /**
     Массив array  на базе которого построен контейнер
     */
    private Object[] array = new Object[INIT_SIZE];
    /**
     @param lastIndex - инедкс последнего элемента
     */
    private int lastIndex = 0;

    /**
     Добавляется новый элемент в список.
     @param element - объект типа T который необходимо добавить в контейнер
     */
    public void add(T element) {
        if(lastIndex == array.length-1)
            resize(array.length + 1);
        array[lastIndex++] = element;
    }

    /**
     Возвращается элемент списка по индексу.
     @param index - индекс элемента который надо вернуть
     */
    public T get(int index) {
        return (T) array[index];
    }

    /**
     Удаляет элемент списка по индексу. Все элементы справа от удаляемого
     смещаются один раз в начало.
     @param index - индекс элемента который надо удалить
     */
    public void removeIndex(int index) {
        if (index >= lastIndex) {
            return;
        } else {
            for (int i = index; i < lastIndex; i++)
                array[i] = array[i + 1];
            array[lastIndex] = null;
            lastIndex--;
            resize(array.length - 1);
        }
    }
    /**
     Удаляет элемент равный полученному значению. Все элементы справа от удаляемого
     смещаются один раз в начало.
     @param deleteValue - значение которое надо удалить из контейнера
     */
    public void removeValue(T deleteValue){
        int index=lastIndex;
        for (int i=0;i<lastIndex;i++ ) {
            if (array[i] == deleteValue) {
                index=i;
                break;
            }
        }
        if (index != lastIndex) {
            for (int i = index; i < lastIndex; i++)
                array[i] = array[i + 1];
            array[lastIndex] = null;
            lastIndex--;
            resize(array.length - 1);
        }
    }

    /**
     * Метод который преобразует контейнер в строку
     * @return строку из нашего контейнера без элементов null
     */
    @Override
    public String toString() {
        Object[] arrayToOut = new Object[lastIndex];
        System.arraycopy(array, 0, arrayToOut, 0, lastIndex);
        return Arrays.toString(arrayToOut);
    }

    /**
     * Возвращает количество элементов в списке
     */
    public int size() {
        return lastIndex;
    }

    /**
     * Вспомогательный метод для масштабирования.
     * @param newLength - параметр указывающий новый размер массива
     * */
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, lastIndex);
        array = newArray;
    }
}
