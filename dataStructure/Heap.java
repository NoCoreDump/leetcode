package dataStructure;

import generator.GeneratorArray;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sunwb
 * @version 1.0.0
 * @ClassName Heap.java
 * @Description 堆，默认小根堆
 * @createTime 2020年06月28日
 */
public class Heap {
    private int size;
    private int usedSize;
    private int[] arr;
    public Heap() {
        size = 16;
        usedSize = 0;

    }
    public void add(int x) {
        if (arr == null || arr.length == 0) {
            arr = new int[size];
        }
        if (usedSize == size) {
            resize(2 * size);
        }
        arr[usedSize] = x;
        shiftUp(usedSize);
        usedSize++;

    }
    public int poll() {
        if (usedSize == 0) return -1;
        int ans = arr[0];
        arr[0] = arr[--usedSize];
        shiftDown(0);
        return ans;
    }

    public void resize(int newSize) {
        int[] data = new int[newSize];
        for (int i = 0; i < usedSize; i++) {
            data[i] = arr[i];
        }
        arr = null;
        arr = data;

    }
    public void shiftUp (int index) {
        if (index == 0) return;
        while (index > 0) {
            int parent = (index - 1) >>> 2;
            if (arr[parent] <= arr[index]) {
                break;
            } else {
                swap(arr, index, parent);
                index = parent;
            }
        }
    }
    public void shiftDown (int index) {
        int left = index * 2 + 1;
        while (left < usedSize) {
            int less = left + 1 < usedSize && arr[left + 1] < arr[left] ? left + 1 : left;
            less = arr[less] < arr[index] ? less : index;
            if (less == index) {
                break;
            }
            swap(arr, less, index);
            index = less;
            left = index * 2 + 1;
        }
    }
    public int peek() {
        if (!isEmpty()) {
            return arr[0];
        } else {
            return -1;
        }
    }
    public int size() {
        return usedSize;
    }
    public boolean isEmpty() {
        return usedSize == 0;
    }
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] arr = GeneratorArray.generateRandomArray(100, 10);
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            heap.add(arr[i]);
            System.out.println("add -- " + arr[i] + "    peek -- " + heap.peek());
        }
        heap.print();
        while (!heap.isEmpty()) {
            System.out.print("poll: " + heap.poll() + "    ");
        }

    }

}
