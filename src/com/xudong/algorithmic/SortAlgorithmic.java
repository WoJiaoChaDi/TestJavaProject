package com.xudong.algorithmic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;


/**
 * 排序算法
 * @author    XuDong
 * @version   V1.0 2018年3月20日
 */
public class SortAlgorithmic {

	/**
	 * 插入排序
	 * 将一个无序的序列，一次一次的插入有序的序列中
	 * 从有序序列最后比较，如果选择的无序序列小于有序序列的数，则有序序列将该数位置后移一位，以此类推，直到不需要后移的时候，则将该无序序列的数插入该位置
	 * @param arr
	 */
	public void insertSort(int[] arr){
		int tmp;
        for (int i = 1; i < arr.length; i++) {
             tmp = arr[i]; // array[i]的拷贝
             // 如果右侧无序区第一个元素array[i] < 左侧有序区最大的array[i-1]，
             // 需要将有序区比array[i]大的元素向后移动。
             if (tmp < arr[i - 1]) {
                  int j = i - 1;
                  // 从右到左扫描有序区
                  while (j >= 0 && tmp < arr[j]) { 
                  // 将左侧有序区中元素比array[i]大的array[j+1]后移
                       arr[j + 1] = arr[j]; 
                       j--;
                  }
                  // 如果array[i]>=左侧有序区最大的array[i-1]，或者经过扫描移动后，找到一个比array[i]小的元素
                  // 将右侧无序区第一个元素tmp = array[i]放到正确的位置上
                  arr[j + 1] = tmp;
             }
        }
        
        //输出
        systemOutArr(arr);
	}
	
	/**
	 * 希尔排序，shell排序（缩小增量排序）（是直接插入排序的优化算法）
	 * 希尔排序先要将排序的一组数据按照某个增量分成若干组，相隔增量个的元素组成一组分别进行
	 * 插入排序，然后缩小增量，不断重复上述过程。直到将增量减小到1时，整个要排序的结果只能分成一组，并对其进行插入排序，即可完成。
	 * 
	 * d为间隔，每次进行shell排序，间隔组成的数据是已经进行排序的
	 * 比如：{6,1,2,7,9,3,4,5,10,8} 当shellPass的d为5的时候，进行一次shell排序后得到{3,1,2,7,8,6,4,5,10,9}，
	 * 按照d分组就是{3,6}{1,4}{2,5}{7,10}{8,9}各个有序的小组
	 * 
	 * 比如：{6,1,2,7,9,3,4,5,10,8} 当shellPass的d为3的时候，进行一次shell排序后得到{4,1,2,6,5,3,7,9,10,8}，
	 * 按照d分组就是{4,6,7,8}{1,5,10}{2,3,10}各个有序的小组
	 * 
	 * 按照这样排序，直至d为1的时候，完成整个数据的排序
	 * 
	 * 开始时gap的值较大，子序列中的元素较少，排序速度比较快；随着排序进展，gap的值逐渐减小，子序列中的元素增多，不过由于前面排序工作的基础，大多数元素已基本有序，所以排序速度依然是比较快的。
	 * 
	 */
	public void shellSort(int[] arr) {
		int d = arr.length;
		do {
			d = d/2;
			shellPass(arr, d); // 根据逐渐减小的间隔增量，循环调用一趟排序
		} while (d > 1);

		//输出
		systemOutArr(arr);
	}

	/**
	 * 希尔一趟排序
	 * 
	 * @param d间隔增量
	 */
	private void shellPass(int[] arr, int d) {
		int tmp;
		for (int i = d; i < arr.length; i++) { // 数组下标从0开始，初始i=d表示一趟排序中第二个元素
			tmp = arr[i]; // array[i]的拷贝
			// 如果待处理的无序区第一个元素array[i] < 有序区最大的元素array[i-d]
			// 需要将有序区比array[i]大的元素向后移动
			if (tmp < arr[i - d]) {
				int j = i - d;
				while (j >= 0 && tmp < arr[j]) {
					arr[j + d] = arr[j]; // 将左侧有序区中元素比array[i]大的array[j+d]后移
					j = j - d;
				}
				// 如果array[i] >= 左侧有序区最大的array[i-d]，或者经过扫描移动后，找到一个比array[i]小的元素
				// 将右侧无序区第一个元素tmp = array[i]放到正确的位置上
				arr[j + d] = tmp;
			}
		}
	}
	
	/**
	 * 选择排序
	 * 每次找到最小的数的位置，将最小数和循环数交互位置
	 * @param arr
	 */
	public void selectSort(int[] arr) {
		int minIndex = 0;
		int temp = 0;
		if ((arr == null) || (arr.length == 0))
			return;
		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;// 无序区的最小数据数组下标
			for (int j = i + 1; j < arr.length; j++) {
				// 在无序区中找到最小数据并保存其数组下标
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				// 如果不是无序区的最小值位置不是默认的第一个数据，则交换之。
				temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}

		//输出
	    systemOutArr(arr);
	}
	
	/**
     * (最大)堆的向下调整算法
     *
     * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
     *     end   -- 截至范围(一般为数组中最后一个元素的索引)
     */
    private void maxHeapDown(int[] arr, int start, int end) {
        int c = start;            // 当前(current)节点的位置
        int l = 2*c + 1;        // 左(left)孩子的位置
        int tmp = arr[c];            // 当前(current)节点的大小

        for (; l <= end; c=l,l=2*l+1) {
            // "l"是左孩子，"l+1"是右孩子
            if ( l < end && arr[l] < arr[l+1]){
            	l++;        // 左右两孩子中选择较大者，即m_heap[l+1]
            }
            if (tmp >= arr[l]){
            	break;        // 调整结束
            } else {            // 交换值
                arr[c] = arr[l];
                arr[l]= tmp;
            }
        }
    }

    /**
     * 堆排序(从小到大)
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     n -- 数组的长度
     */
    public void heapSortAsc(int[] arr, int n) {
        int i,tmp;

        // 从(n/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉堆。
        for (i = n / 2 - 1; i >= 0; i--){
        	maxHeapDown(arr, i, n-1);
        }

        // 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        for (i = n - 1; i > 0; i--) {
            // 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的。
            tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
            // 即，保证a[i-1]是a[0...i-1]中的最大值。
            maxHeapDown(arr, 0, i-1);
        }
        
        systemOutArr(arr);
    }

	/**
	 * (最小)堆的向下调整算法
	 * 
	 * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
	 * 其中，N为数组下标索引值，如数组中第1个数对应的N为0。
	 * 
	 * 参数说明： a -- 待排序的数组 start -- 被下调节点的起始位置(一般为0，表示从第1个开始) end --
	 * 截至范围(一般为数组中最后一个元素的索引)
	 */
	private void minHeapDown(int[] a, int start, int end) {
		int c = start; // 当前(current)节点的位置
		int l = 2 * c + 1; // 左(left)孩子的位置
		int tmp = a[c]; // 当前(current)节点的大小

		for (; l <= end; c = l, l = 2 * l + 1) {
			// "l"是左孩子，"l+1"是右孩子
			if (l < end && a[l] > a[l + 1])
				l++; // 左右两孩子中选择较小者
			if (tmp <= a[l])
				break; // 调整结束
			else { // 交换值
				a[c] = a[l];
				a[l] = tmp;
			}
		}
	}

	/**
	 * 堆排序(从大到小)
	 * 
	 * 参数说明： a -- 待排序的数组 n -- 数组的长度
	 */
	public void heapSortDesc(int[] a, int n) {
		int i, tmp;

		// 从(n/2-1) --> 0逐次遍历每。遍历之后，得到的数组实际上是一个最小堆。
		for (i = n / 2 - 1; i >= 0; i--)
			minHeapDown(a, i, n - 1);

		// 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
		for (i = n - 1; i > 0; i--) {
			// 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最小的。
			tmp = a[0];
			a[0] = a[i];
			a[i] = tmp;
			// 调整a[0...i-1]，使得a[0...i-1]仍然是一个最小堆。
			// 即，保证a[i-1]是a[0...i-1]中的最小值。
			minHeapDown(a, 0, i - 1);
		}
	}
	
	/**
	 * 冒泡排序
	 * 
	 * 每将一个数归位我们将其称为“一趟”。
	 * 如果有n个数进行排序，只需将n-1个数归位，也就是说要进行n-1趟操作。而“每一趟”都需要从第1位开始进行相邻两个数的比较， 将较小的一个数放在后面，比较完毕后向后挪一位继续比较下面两个相邻数的大小，重复此步骤，直到最后一个尚未归位的数，已经归位的数则无需再进行比较
	 * 
	 * 时间复杂度：O(N2)
	 * 
	 * 假如我们的计算机每秒钟可以运行10亿次，那么对1亿个数进行排序，桶排序则只需要0.1秒，而冒泡排序则需要1千万秒，达到115天之久，是不是很吓人。
	 * @Title bubbleSort
	 * @param arr
	 * @return
	 */
	public void bubbleSort(int[] arr){
		
		for (int j = arr.length -1; j > 0; j--) {
			for (int i = 0; i < arr.length-1; i++) {
				if(arr[i] > arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}
		
		//输出
		systemOutArr(arr);
	}
	
	/**
	 * 快速排序
	 * 快速排序之所比较快，因为相比冒泡排序，每次交换是跳跃式的。每次排序的时候设置一个基准点，将小于等于基准点的数全部放到基准点的左边，将大于等于基 准点的数全部放到基准点的右边。
	 * 这样在每次交换的时候就不会像冒泡排序一样每次只能在相邻的数之间进行交换，交换的距离就大的多了。因此总的比较和交换次 数就少了，速度自然就提高了。当然在最坏的情况下，仍可能是相邻的两个数进行了交换。
	 * 因此快速排序的最差时间复杂度和冒泡排序是一样的都是O(N2)，它的平均时间复杂度为O(NlogN)。其实快速排序是基于一种叫做“二分”的思想。
	 * 
	 * 桶排序是最快的，桶排序的时间复杂度是O(N+M)；冒泡排序是O(N2)；快速排序是O(NlogN)。
	 * @Title quickSort
	 * @param arr
	 * @return
	 */
	public void quickSort(int[] arr, int left,int right){
		int i, j, baseT;
		if (left >= right)
			return;

		baseT = arr[left]; // temp中存的就是基准数
		i = left;
		j = right;
		while (i < j) {
			// 顺序很重要，要先从右边开始找比基数小的数的位置
			while (i < j && arr[j] >= baseT){
				j--;
			}
			// 再找左边的比基数大的数的位置
			while (i < j && arr[i] <= baseT){
				i++;
			}
			// 交换两个数在数组中的位置
			if (i < j) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		// 最终将基准数归位
		arr[left] = arr[i];
		arr[i] = baseT;

		//左右分别开始递归
		if(left < (i-1)){
			quickSort(arr, left, i-1);
		}
		if((i+1) < right){
			quickSort(arr, i+1, right);
		}
	}
	
	/**
	 * 快排测试
	 * 
	 * @Title quickSortTest
	 * @param arr
	 * @param low
	 * @param high
	 */
	public void quickSortTest(int arr[], int low, int high){
		quickSort(arr, low, high);
		
		//输出
		systemOutArr(arr);
	}
	
//	public void quickSort2(int arr[], int low, int high) {
//    int l = low; 
//    int h = high; 
//    int povit = arr[low];
//
//    while (l < h) {
//        while (l < h && arr[h] >= povit){
//        	h--;
//        }
//        if (l < h) {
//            int temp = arr[h]; 
//            arr[h] = arr[l]; 
//            arr[l] = temp; 
//            l++;
//        }
//
//        while (l < h && arr[l] <= povit){
//        	l++;
//        }
//        if (l < h) {
//            int temp = arr[h]; 
//            arr[h] = arr[l]; 
//            arr[l] = temp; 
//            h--;
//        }
//    }
//    
////    print(arr); 
//    String a = "";
//	for (int i = 0; i < arr.length; i++) {
//		a += arr[i] + ",";
//	}
//	System.out.println(a);
//    
//    System.out.print("l=" + (l + 1) + "h=" + (h + 1) + "povit=" + povit + "\n");
//    if (l > low) quickSort(arr, low, l - 1);
//    if (h < high) quickSort(arr, l + 1, high);
//}
//
///**
// * 快排测试
// * 
// * @Title quickSortTest
// * @param arr
// * @param low
// * @param high
// */
//public void quickSort2Test(int arr[], int low, int high){
//	quickSort2(arr, low, high);
//	
//	List list = new ArrayList();
//	for (int i = 0; i < arr.length; i++) {
//		list.add(arr[i]);
//	}
//	System.out.println(list);
//}
	
	
	/**
	 * 将有二个有序数列a[first...mid]和a[mid...last]合并。  
	 * 归并排序，思想是分治法   先分，再治
	 * 分成一个数，则有序，然后再治  合并成两个有序的数
	 * @param arr
	 * @param first
	 * @param mid
	 * @param last
	 * @param temp
	 */
	private void mergeArr(int arr[], int first, int mid, int last, int temp[])  
	{  
	    int i = first, j = mid + 1;  
	    int m = mid,   n = last;  
	    int k = 0;  
	      
	    while (i <= m && j <= n)  
	    {  
	        if (arr[i] <= arr[j])  
	            temp[k++] = arr[i++];  
	        else  
	            temp[k++] = arr[j++];  
	    }  
	      
	    while (i <= m)  
	        temp[k++] = arr[i++];  
	      
	    while (j <= n)  
	        temp[k++] = arr[j++];  
	      
	    for (i = 0; i < k; i++)  
	        arr[first + i] = temp[i];  
	}  
	
	public void mergeSort(int arr[], int first, int last, int temp[])  
	{  
	    if (first < last)  
	    {  
	        int mid = (first + last) / 2;//一直拆成一个数，一个数就是有序的数组了，然后再慢慢往上合并成多个数的两个有序数组
	        mergeSort(arr, first, mid, temp);    //左边有序  
	        mergeSort(arr, mid + 1, last, temp); //右边有序  
	        mergeArr(arr, first, mid, last, temp); //再将二个有序数列合并  
	        System.out.println(arr);
	    }  
	    
	}  
	
	public void mergeSortTest(int arr[], int first, int last, int temp[]){
		mergeSort(arr, first, last, temp);
		
		//输出
		systemOutArr(arr);
	}
	
	/**
	 * 基数排序(桶排序的拓展)
	 * 
	 * 基本思想是：将整数按位数切割成不同的数字，然后按每个位数分别比较。
	 * 将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
	 * @Title radixSort
	 * @param arr
	 * @return
	 */
	
    /**
     * 获取数组a中最大值
     *
     * 参数说明：
     *     arr -- 数组
     *     n -- 数组长度
     */
    private int getMax(int[] arr) {
        int max;

        max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];

        return max;
    }

    /**
     * 对数组按照"某个位数"进行排序(桶排序)
     *
     * 参数说明：
     *     a -- 数组
     *     exp -- 指数。对数组a按照该指数进行排序。
     *
     * 例如，对于数组a={50, 3, 542, 745, 2014, 154, 63, 616}；
     *    (01) 当exp=1表示按照"个位"对数组a进行排序
     *    (02) 当exp=10表示按照"十位"对数组a进行排序
     *    (03) 当exp=100表示按照"百位"对数组a进行排序
     *    ...
     */
    private void countSort(int[] arr, int exp) {
        //int output[a.length];    // 存储"被排序数据"的临时数组
        int[] output = new int[arr.length];    // 存储"被排序数据"的临时数组
        int[] buckets = new int[10];

        // 将数据出现的次数存储在buckets[]中
        for (int i = 0; i < arr.length; i++){
        	buckets[ (arr[i]/exp)%10 ]++;
        }

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i < 10; i++){
        	buckets[i] += buckets[i - 1];
        }

        // 将数据存储到临时数组output[]中
        for (int i = arr.length - 1; i >= 0; i--) {
            output[buckets[ (arr[i]/exp)%10 ] - 1] = arr[i];
            buckets[ (arr[i]/exp)%10 ]--;
        }

        // 将排序好的数据赋值给a[]
        for (int i = 0; i < arr.length; i++){
        	arr[i] = output[i];
        }

        output = null;
        buckets = null;
    }

    /**
     * 基数排序
     *
     * 参数说明：
     *     a -- 数组
     */
    public void radixSort(int[] arr) {
        int exp;    // 指数。当对数组按各位进行排序时，exp=1；按十位进行排序时，exp=10；...
        int max = getMax(arr);    // 数组arr中的最大值

        // 从个位开始，对数组arr按"指数"进行排序
        for (exp = 1; max/exp > 0; exp *= 10)
            countSort(arr, exp);
    }
    
    /**
	 * 计数排序(桶排序简化版)
	 * 有0~10之间的整数，对该整数进行排序
	 * 
	 * 用于事先已经知道数据的范围，桶排序的递归深度可以是常数，而不像上述快排方法一，递归深度和数据量 n 有关。
	 * @Title countingSort
	 * @param arr
	 * @return
	 */
	public void countingSort(int[] arr){
		
		//需要最小数字和最大数字之间长度的数组，每个数据的下标标识有该下标数字大小的值的个数
		int[] bucket = new int[11];
		
		//将乱的数组arr放入与桶下标相同的桶内bucket,
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < bucket.length; j++) {
				if(arr[i] == j){
					bucket[j]++;
				}
			}
		}
		
		//如果桶内有数，则从桶的下标排序取数，桶的下标就是桶内数字的大小
		List list = new ArrayList();
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 1; j <= bucket[i]; j++) {
				list.add(i);
			}
		}
		System.out.println(list);
	}
	
	
	/**
	 * 数组输出方法
	 * @param arr
	 */
	void systemOutArr(int[] arr) {
	    List list = new ArrayList();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		System.out.println(list);
	}
	
	@Test
	public void Test(){

		/*----------------------插入排序----------------------*/
		//直接插入排序
//		int[] arr = {6,1,2,7,9,3,4,5,10,8};
//		insertSort(arr);
		
		//shell排序
//		int[] arr = {9,8,7,6,5,4,3,2,1,0};
//		int[] arr = {9,8,7,6,5,4,3};
//		int[] arr = {6,1,2,7,9,3,4,5,10,8};
//		shellSort(arr);

		/*----------------------选择排序----------------------*/
		//直接选择排序
//		int[] arr = {6,1,2,7,9,3,4,5,10,8};
//		selectSort(arr);
				
		//堆排序
//		int[] arr = {6,1,2,7,9,3,4,5,10,8};
////		int[] arr = {1,3,2,5,7,6,9,4,10};
//		heapSortAsc(arr, arr.length);

		/*----------------------交换排序----------------------*/
		//冒泡排序
//		int[] arr = {5,2,7,5,1,9,63,89,6,4,324,1};
//		int[] arr = {1,3,2,5,7,6,9,4,10};
//		bubbleSort(arr);
				
		//快速排序
//		int[] arr = {6,1,2,7,9,5,4,3,10,8};
////		int[] arr = {10,9,8,7,6,5,4,3,2,1};
//		quickSortTest(arr, 0, arr.length - 1);
		
		/*----------------------其他排序----------------------*/
		//归并排序
//		int[] arr = {6,1,2,7,9,3,4,5,10,8};
//		mergeSortTest(arr, 0, 9, new int[10]);
		
		//基数排序(桶排序拓展版)
		int[] arr = {5,4,15,32,102,15,66,332,845,9,75,45,53,12,45,55,20};
		radixSort(arr);
		
		//计数排序(桶排序简化版)
//		int[] arr = {5,4,5,8,3,2,1,9,6};
//		countingSort(arr);
	}
}
