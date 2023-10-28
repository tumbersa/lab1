package org.example;

import java.util.Arrays;
public class Container<T> {
    /**
     @param INIT_SIZE размер изначального массива
     */
    private final int INIT_SIZE = 16;
    /**
     @param CUT_RATE число для проверки необходимого размера , т.е если массив будет размером 64 , а объектов в нем всего 15 ,
     то массив уменьшиться в 4 раза , ради экономии памяти
     */
    private final int CUT_RATE = 4;
    /**
     Массив array  на базе которого построен контейнер
     */
    private Object[] array = new Object[INIT_SIZE];
    /**
     @param pointer - испольняет роль инедкса последнего элемента
     */
    private int pointer = 0;

    /**
     Добавляет новый элемент в список. При достижении размера внутреннего
     массива происходит его увеличение в два раза.
     @param item - объект типа T который необходимо добавить в контейнер
     */
    public void add(T item) {
        if(pointer == array.length-1)
            resize(array.length*2); // увеличу в 2 раза, если достигли границ
        array[pointer++] = item;
    }

    /**
     Возвращает элемент списка по индексу.
     @param index - индекс элемента который надо вернуть
     */
    public T get(int index) {
        return (T) array[index];
    }

    /**
     Удаляет элемент списка по индексу. Все элементы справа от удаляемого
     перемещаются на шаг налево. Если после удаления элемента количество
     элементов стало в CUT_RATE раз меньше чем размер внутреннего массива,
     то внутренний массив уменьшается в два раза, для экономии занимаемого
     места.
     @param index - индекс элемента который надо удалить
     */
    public void removeIndex(int index) {
        for (int i = index; i<pointer; i++)
            array[i] = array[i+1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length/2); // если элементов в CUT_RATE раз меньше чем
        // длина массива, то уменьшу в два раза
    }
    /**
     Удаляет элемент равный полученному значению
     @param deleteValue - значение которое надо удалить из контейнера
     */
    public void removeValue(T deleteValue){
        int index=pointer;
        for (int i=0;i<pointer;i++ ) {
            if (array[i] == deleteValue) {
                index=i;
                break;
            }
        }
        for (int i=index;i<pointer;i++)
            array[i] = array[i+1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length/2);
    }

    /**
     * Метод который преобразует контейнер в строку
     * @return строку из нашего контейнера без элементов null
     */
    @Override
    public String toString() {
        Object[] arrayToOut = new Object[pointer];
        System.arraycopy(array, 0, arrayToOut, 0, pointer);
        return Arrays.toString(arrayToOut);
    }

    /**
     * Возвращает количество элементов в списке
     */
    public int size() {
        return pointer;
    }

    /**
     * Вспомогательный метод для масштабирования.
     * @param newLength - параметр указывающий новый размер массива
     * */
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}
