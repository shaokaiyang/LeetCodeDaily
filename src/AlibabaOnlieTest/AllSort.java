/**
 * description:所有的排序算法总结
 */

import java.util.*;

public class AllSort {

    //冒泡排序
    public static int[] bubbleSort(int[] nums){
        if(nums.length == 0){
            return nums;
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length-1-i; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }

    //选择排序
    public static int[] selectionSort(int[] nums){
        if(nums.length == 0){
            return nums;
        }
        for(int i = 0; i < nums.length; i++){
            int minIndex = i;
            for(int j = i; j < nums.length; j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    //插入排序
    public static int[] insertionSort(int[] nums){
        if(nums.length == 0){
            return nums;
        }
        //表示当前需要排序的元素
        int current;
        for(int i = 0; i < nums.length-1; i++){
            current = nums[i+1];
            int preIndex = i;
            while(preIndex >= 0 && current < nums[preIndex]){
                nums[preIndex+1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex+1] = current;
        }
        return nums;
    }

    //希尔排序
    public static int[] shellSort(int[] nums){
        if(nums.length == 0){
            return nums;
        }
        int len = nums.length;
        int temp, gap = len/2;
        while(gap > 0){
            for(int i = gap; i < len; i++){
                temp = nums[i];
                int preIndex = i - gap;
                while(preIndex >= 0 && nums[preIndex] > temp){
                    nums[preIndex+gap] = nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex+gap] = temp;
            }
            gap /= 2;
        }
        return nums;
    }

    //归并排序
    public static int[] mergeSort(int[] nums){
        if(nums.length == 0 || nums.length == 1){
            return nums;
        }
        int mid = nums.length/2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] rirht = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(mergeSort(left), mergeSort(rirht));
    }

    public static int[] merge(int[] left, int[] right){
        int[] result = new  int[left.length + right.length];
        for(int index = 0, i = 0, j = 0; index < result.length; index++){
            if(i >= left.length)
                result[index] = right[j++];
            else if(j >= right.length)
                result[index] = left[i++];
            else if(left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

    /**
     * 快速排序方法
     * @param array
     * @param start 待排序的启示位置
     * @param end
     * @return
     */
    public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            QuickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            QuickSort(array, smallIndex + 1, end);
        return array;
    }
    /**
     * 快速排序算法——partition
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }

    public static int partition2(int[] array, int start, int end){
        int key = array[end];
        while(start < end){
            while(start < end && array[start] <= key){
                start++;
            }
            array[end] = array[start];
            while (start < end && array[end] >= key){
                end--;
            }
            array[start] = array[end];
        }
        array[start] = key;
        return start;
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    //快速排序非递归实现
    public static int[] QuickSortNotR(int[] nums, int left, int right){
        if(nums.length == 0){
            return nums;
        }
        //栈中记录前后两个子序列的起始位置；
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while(!stack.empty()){
            int rightIndex = stack.peek();
            stack.pop();
            int leftIndex = stack.peek();
            stack.pop();

            int index = partition(nums, leftIndex, rightIndex);
            if((index - 1) > leftIndex){
                stack.push(leftIndex);
                stack.push(index-1);
            }
            if((index + 1) < rightIndex){
                stack.push(index+1);
                stack.push(rightIndex);
            }
        }
        return nums;
    }


    /**
     * 堆排序算法
     *
     * @param array
     * @return
     */
    public static int[] HeapSort(int[] array) {
        int len = array.length;
        if (len < 1) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }
    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        int len = array.length;
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len/2 - 1); i >= 0; i--) {
            adjustHeap(array, i);
        }
    }
    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        int len = array.length;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }


    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static int[] CountingSort(int[] array) {
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }



    /**
     * 桶排序
     *
     * @param array
     * @param bucketSize
     * @return
     */
    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) { // 如果带排序数组中有重复数字时
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1)
                    bucketSize--;
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }

    /**
     * 基数排序
     * @param array
     * @return
     */
    public static int[] RadixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }

    public static void  main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[] {1,3,2,5,4};
        System.out.println(Arrays.toString(insertionSort(nums)));
    }
}
