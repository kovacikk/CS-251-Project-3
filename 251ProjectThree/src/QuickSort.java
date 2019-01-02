import java.util.*;

/*
*  Quicksort Implementation with Five Pivot Choice techniques
*  and
*  Input Sequence Data Generator
* */


public class QuickSort
{
    private int comparisons;

    public int insertionSort(int [] array, int low, int high) {

        int N = high - low + 1;
        int temp;

        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                comparisons++;
                if (array[low + j] < array[low + j-1]) {
                    temp = array[low + j];
                    array[low + j] = array[low + j-1];
                    array[low + j - 1] = temp;
                }
                else {
                    break;
                }
            }
        }

        return comparisons;
    }

    class container {
        int i;
        char p;

        public container(int i, char p) {
            this.i = i;
            this.p = p;
        }

    }

    public int specialInsertion(container[] cont, int low, int high) {

        int N = high - low + 1;
        container temp;

        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                comparisons++;
                if (cont[low + j].i < cont[low + j-1].i) {
                    temp = cont[low + j];
                    cont[low + j] = cont[low + j-1];
                    cont[low + j - 1] = temp;
                }
                else {
                    break;
                }
            }
        }
        return comparisons;
    }

    public int QuickSortPivotA(int [] array)
    {
        /*
        Implement the quicksort with pivot as the last element of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */
        comparisons = 0;
        QuickSortPivotA(array, 0, array.length - 1);
        return comparisons;
    }

    private int QuickSortPivotA(int [] array, int low, int high)
    {
        int pivot = array[high];
        int temp;

        int i = low;

        for (int k = low; k < high; k++) {
            comparisons++;
            if (array[k] <= pivot) {
                    temp = array[k];
                    array[k] = array[i];
                    array[i] = temp;

                    i++;
            }
        }


        temp = array[i];
        array[i] = array[high];
        array[high] = temp;

        if ((i - 1 - low) + 1 >= 6) {
            QuickSortPivotA(array, low, i - 1);
        }
        else {
            insertionSort(array, low, i-1);
        }

        if ((high - (i + 1)) + 1 >= 6) {
            QuickSortPivotA(array, i + 1, high);
        }
        else {
            insertionSort(array, i + 1, high);
        }

        return 0;
    }

    public int QuickSortPivotB(int [] array)
    {
        /*
        Implement the quicksort with pivot as the first element of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */

        comparisons = 0;
        QuickSortPivotB(array, 0, array.length-1);
        return comparisons;
    }

    private int QuickSortPivotB(int [] array, int low, int high)
    {

        int pivot = array[low];
        int temp;

        temp = array[high]; //Put pivot at the end of the array
        array[high] = array[low];
        array[low] = temp;


        int i = low;


        for (int k = low; k < high; k++) {
            comparisons++;
            if (array[k] <= pivot) {
                temp = array[k];
                array[k] = array[i];
                array[i] = temp;

                i++;
            }
        }

        temp = array[i];
        array[i] = array[high];
        array[high] = temp;

        if ((i - 1 - low) + 1 >= 6) {
            QuickSortPivotB(array, low, i - 1);
        }
        else {
            insertionSort(array, low, i-1);
        }

        if ((high - (i + 1)) + 1 >= 6) {
            QuickSortPivotB(array, i + 1, high);
        }
        else {
            insertionSort(array, i + 1, high);
        }

        return 0;
    }

    public int QuickSortPivotC(int [] array)
    {
        /*
        Implement the quicksort with pivot as the middle element of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */

        comparisons = 0;
        QuickSortPivotC(array, 0, array.length-1);
        return comparisons;
    }

    private int QuickSortPivotC(int [] array, int low, int high)
    {

        int floorOfNOverTwo = ((high  + 1 - low) / 2) + low; // add low to get back to the correct section of the array
        int pivot = array[floorOfNOverTwo];
        int temp;

        temp = array[high]; //Put pivot at the end of the array
        array[high] = array[floorOfNOverTwo];
        array[floorOfNOverTwo] = temp;


        int i = low;


        for (int k = low; k < high; k++) {
            comparisons++;
            if (array[k] <= pivot) {
                temp = array[k];
                array[k] = array[i];
                array[i] = temp;

                i++;
            }
        }

        temp = array[i];
        array[i] = array[high];
        array[high] = temp;

        if ((i - 1 - low) + 1 >= 6) {
            QuickSortPivotC(array, low, i - 1);
        }
        else {
            insertionSort(array, low, i-1);
        }

        if ((high - (i + 1)) + 1 >= 6) {
            QuickSortPivotC(array, i + 1, high);
        }
        else {
            insertionSort(array, i + 1, high);
        }

        return 0;
    }

    public int QuickSortPivotD(int [] array)
    {
        /*
        Implement the quicksort with pivot as the median of the first, middle and last elements of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */
        comparisons = 0;
        QuickSortPivotD(array, 0, array.length-1);
        return comparisons;
    }

    private int QuickSortPivotD(int [] array, int low, int high)
    {

        int first = array[low];
        int middle = array[((high  + 1 - low) / 2) + low];
        int last = array[high];

        container cont[] = {new container(first, '0'), new container(middle, '1'), new container(last, '2')};
        specialInsertion(cont, 0, 2);

        int medianIndex;

        if (cont[1].p == '0') {
            medianIndex = low;
        }
        else if (cont[1].p == '1') {
            medianIndex = ((high  + 1 - low) / 2) + low;
        }
        else {
            medianIndex = high;
        }

        int pivot = array[medianIndex];
        int temp;

        temp = array[high]; //Put pivot at the end of the array
        array[high] = array[medianIndex];
        array[medianIndex] = temp;


        int i = low;


        for (int k = low; k < high; k++) {
            comparisons++;
            if (array[k] <= pivot) {
                temp = array[k];
                array[k] = array[i];
                array[i] = temp;

                i++;
            }
        }

        temp = array[i];
        array[i] = array[high];
        array[high] = temp;

        if ((i - 1 - low) + 1 >= 6) {
            QuickSortPivotD(array, low, i - 1);
        }
        else {
            insertionSort(array, low, i-1);
        }

        if ((high - (i + 1)) + 1 >= 6) {
            QuickSortPivotD(array, i + 1, high);
        }
        else {
            insertionSort(array, i + 1, high);
        }

        return 0;
    }

    public int QuickSortPivotE(int [] array)
    {
        /*
        Implement the quicksort with pivot as the median of five elements of the sequence, chosen to be roughly 10%,
         30%, 50%, 70% and 90% of the way through the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */
        comparisons = 0;
        QuickSortPivotE(array, 0, array.length-1);
        return comparisons;
    }

    private int QuickSortPivotE(int [] array, int low, int high)
    {
        int n = (high  + 1 - low);

        int first = array[(n / 10) + low];
        int second = array[((3 * n) / 10) + low];
        int third = array[((5 * n) / 10) + low];
        int fourth = array[((7 * n) / 10) + low];
        int fifth = array[((9 * n) / 10) + low];

        container cont[] = {new container(first, '0'), new container(second, '1'), new container(third, '2'), new container(fourth, '3'), new container(fifth, '4')};
        specialInsertion(cont, 0, 4);

        int medianIndex;

        if (cont[2].p == '0') {
            medianIndex = (n / 10) + low;
        }
        else if (cont[2].p == '1') {
            medianIndex = ((3 * n) / 10) + low;
        }
        else if (cont[2].p == '2') {
            medianIndex = ((5 * n) / 10) + low;
        }
        else if (cont[2].p == '3') {
            medianIndex = ((7 * n) / 10) + low;
        }
        else {
            medianIndex = ((9 * n) / 10) + low;
        }

        int pivot = array[medianIndex];
        int temp;

        temp = array[high]; //Put pivot at the end of the array
        array[high] = array[medianIndex];
        array[medianIndex] = temp;


        int i = low;


        for (int k = low; k < high; k++) {
            comparisons++;
            if (array[k] <= pivot) {
                temp = array[k];
                array[k] = array[i];
                array[i] = temp;

                i++;
            }
        }

        temp = array[i];
        array[i] = array[high];
        array[high] = temp;

        if ((i - 1 - low) + 1 >= 6) {
            QuickSortPivotE(array, low, i - 1);
        }
        else {
            insertionSort(array, low, i-1);
        }

        if ((high - (i + 1)) + 1 >= 6) {
            QuickSortPivotE(array, i + 1, high);
        }
        else {
            insertionSort(array, i + 1, high);
        }

        return 0;
    }


    /*
    *
    * Implement the rest of the functions required to do the quicksort for every variation.
    * */


    public int[] GenerateInputSequence1(int N)
    {
        /*
        * return an array with the sequence 1, 2, 3, ..., N (in increasing order).
        * For example, if N = 1000, then the sequence would be: 1, 2, 3, 4, 5, ..., 1000
        * */
        int array[] = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = i + 1;
        }

        return array;

    }

    public int[] GenerateInputSequence2(int N)
    {
        /*
         * return an array with The sequence N, N-1, ..., 2, 1 (in decreasing order).
         * For example, if N = 1000, then the sequence would be: 1000, 999, ..., 2, 1
         * */
        int array[] = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = N - i;
        }
        return array;
    }

    public int[] GenerateInputSequence3(int N)
    {
        /*
         * return an array with The sequence 1, 3, 5, ..., N-1, 2, 4, 6, ..., N.
         * For example,  if N = 1000, then the sequence would be: 1, 3, 5, ..., 999, 2, 4, 6, ..., 1000
         * */
        int array[] = new int[N];

        for (int i = 0; i < N/2; i++) { //generate odds
            array[i] = 1 + (2 * i);
        }

        for (int i = 0; i < N/2; i++) {
            array[i + (N/2)] = (2 * (i + 1));
        }

        return array;
    }

    public int[] GenerateInputSequence4(int N)
    {
        /*
         * return an array with the sequence 1, 3, 5, ..., N-3, N-1, N, N-2, N-4, ..., 4, 2.
          * For example,  if N = 1000, then the sequence would be: 1,3,5 ...,997,999,1000,998,996, ..., 4,2
         * */
        int array[] = new int[N];

        for (int i = 0; i < N/2; i++) {
            array[i] = 1 + (2 * i);
        }
        for (int i = 0; i < N/2; i++) {
            array[i + (N/2)] = N - (2 * i);
        }

        return array;
    }

    public int[] GenerateInputSequence5(int N)
    {
        /*
         * return an array with sequence 1, N, 2, N-1, 3, N-2, 4, N-3, ..., N/2, (N/2)+1.
         * For example,  if N = 1000, then the sequence would be: 1, 1000, 2, 999, 3, 998, 4, 997, ..., 500, 501
         * */
        int array[] = new int[N];

        for (int i = 0; i < N/2; i++) {
            array[2 * i] = i + 1;
        }

        for (int i = 0; i < N/2; i++) {
            array[(2 * i) + 1] = N - i;
        }

        return array;
    }


    public int[] GenerateInputSequence6(int N)
    {
        /*
         * return an array with the sequence: Each number is (7 + the previous number) mod N.
         * That is, a(i) = (7 + a(i-1)) mod N, a(0)=0
         * For example,  if N = 1000, then the sequence would be: 0, 7, 14, ..., 994, 1, 8, ..., 993
         */
        int array[] = new int[N];
        array[0] = 0;

        for (int i = 1; i < N; i++) {
            array[i] = (7 + array[i - 1]) % N;
        }

        return array;

    }


    public int[] GenerateInputSequence7(int N)
    {
        /*
         * return an array with The sequence: The first N Fibonacci numbers modulo N:
         * a(0) = 0; a(1) = 1; a(i) = (a(i-1) + a(i-2)) mod N for 1 < i < N.         *
         * */
        int array[] = new int[N];
        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i < N; i++) {
            array[i] = (array[i-1] + array[i-2]) % N;
        }

        return array;
    }


    public int[] GenerateInputSequence8(int N)
    {
        /*
         * return an array with The sequence The first N powers of 2 modulo N:
         * a(0) = 1; a(i) = (2*a(i-1)) mod N for 0 < i < N.
         * */
        int array[] = new int[N];
        array[0] = 1;

        for (int i = 1; i < N; i++) {
            array[i] = (2 * array[i-1]) % N;
        }
        return array;
    }


    public int[] GenerateInputSequence9(int N)
    {
        /*
         * return an array with The sequence: The first N powers of 3 modulo N:
         * a(0) = 1; a(i) = (3*a(i-1)) mod N for 0 < i < N.
         * */
        int array[] = new int[N];
        array[0] = 1;

        for (int i = 1; i < N; i++) {
            array[i] = (3 * array[i-1]) % N;
        }

        return array;
    }


    public int[] GenerateInputSequence10(int N, int RNG_Seed)
    {
        /*
         * return an array with The sequence N, N-1, ..., 2, 1 (in decreasing order).
         * A random sequence using the methods in java.util.Random: Use setSeed(long seed) to set the seed using
         * a nine-digit which will be an input to your method. Use nextInt()%10000 N times to get N random integers
          * between -9999 and 9999.  Use these in the order generated as the sequence.
          * Example:Random generator = new Random();
          * generator.setSeed(123456789);   // 123456789 is example, seed will be input
          * int num = generator.nextInt()%10000; // will be called N times to complete the sequence
          * */
        Random ran = new Random();
        ran.setSeed(RNG_Seed);

        int array[] = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = ran.nextInt()%10000;
        }

        return array;
    }


    public static void main(String[] args)
    {
        /*
        You can test you implementation of the quicksort here.
        Please do not change the function names as we will use them to
        grade your work.
        */


        /**for (int i = 0; i < array.length; i++) {
            System.out.println(i + ": " + array[i]);
        } */

        test('A', 1000, 123456789);


    }

    public static void test(char sortLetter, int N, int seed) {
        QuickSort q = new QuickSort();
        int[] array = new int[N];
        if (sortLetter == 'A') {
            System.out.println("Comparisons 1: " + q.QuickSortPivotA(array = q.GenerateInputSequence1(N)));
            System.out.println("Comparisons 2: " + q.QuickSortPivotA(array = q.GenerateInputSequence2(N)));
            System.out.println("Comparisons 3: " + q.QuickSortPivotA(array = q.GenerateInputSequence3(N)));
            System.out.println("Comparisons 4: " + q.QuickSortPivotA(array = q.GenerateInputSequence4(N)));
            System.out.println("Comparisons 5: " + q.QuickSortPivotA(array = q.GenerateInputSequence5(N)));
            System.out.println("Comparisons 6: " + q.QuickSortPivotA(array = q.GenerateInputSequence6(N)));
            System.out.println("Comparisons 7: " + q.QuickSortPivotA(array = q.GenerateInputSequence7(N)));
            System.out.println("Comparisons 8: " + q.QuickSortPivotA(array = q.GenerateInputSequence8(N)));
            System.out.println("Comparisons 9: " + q.QuickSortPivotA(array = q.GenerateInputSequence9(N)));
            System.out.println("Comparisons 10: " + q.QuickSortPivotA(array = q.GenerateInputSequence10(N, seed)));
        }
        else if (sortLetter == 'B') {
            System.out.println("Comparisons 1: " + q.QuickSortPivotB(array = q.GenerateInputSequence1(N)));
            System.out.println("Comparisons 2: " + q.QuickSortPivotB(array = q.GenerateInputSequence2(N)));
            System.out.println("Comparisons 3: " + q.QuickSortPivotB(array = q.GenerateInputSequence3(N)));
            System.out.println("Comparisons 4: " + q.QuickSortPivotB(array = q.GenerateInputSequence4(N)));
            System.out.println("Comparisons 5: " + q.QuickSortPivotB(array = q.GenerateInputSequence5(N)));
            System.out.println("Comparisons 6: " + q.QuickSortPivotB(array = q.GenerateInputSequence6(N)));
            System.out.println("Comparisons 7: " + q.QuickSortPivotB(array = q.GenerateInputSequence7(N)));
            System.out.println("Comparisons 8: " + q.QuickSortPivotB(array = q.GenerateInputSequence8(N)));
            System.out.println("Comparisons 9: " + q.QuickSortPivotB(array = q.GenerateInputSequence9(N)));
            System.out.println("Comparisons 10: " + q.QuickSortPivotB(array = q.GenerateInputSequence10(N, seed)));
        }
        else if (sortLetter == 'C') {
            System.out.println("Comparisons 1: " + q.QuickSortPivotC(array = q.GenerateInputSequence1(N)));
            System.out.println("Comparisons 2: " + q.QuickSortPivotC(array = q.GenerateInputSequence2(N)));
            System.out.println("Comparisons 3: " + q.QuickSortPivotC(array = q.GenerateInputSequence3(N)));
            System.out.println("Comparisons 4: " + q.QuickSortPivotC(array = q.GenerateInputSequence4(N)));
            System.out.println("Comparisons 5: " + q.QuickSortPivotC(array = q.GenerateInputSequence5(N)));
            System.out.println("Comparisons 6: " + q.QuickSortPivotC(array = q.GenerateInputSequence6(N)));
            System.out.println("Comparisons 7: " + q.QuickSortPivotC(array = q.GenerateInputSequence7(N)));
            System.out.println("Comparisons 8: " + q.QuickSortPivotC(array = q.GenerateInputSequence8(N)));
            System.out.println("Comparisons 9: " + q.QuickSortPivotC(array = q.GenerateInputSequence9(N)));
            System.out.println("Comparisons 10: " + q.QuickSortPivotC(array = q.GenerateInputSequence10(N, seed)));
        }
        else if (sortLetter == 'D') {
            System.out.println("Comparisons 1: " + q.QuickSortPivotD(array = q.GenerateInputSequence1(N)));
            System.out.println("Comparisons 2: " + q.QuickSortPivotD(array = q.GenerateInputSequence2(N)));
            System.out.println("Comparisons 3: " + q.QuickSortPivotD(array = q.GenerateInputSequence3(N)));
            System.out.println("Comparisons 4: " + q.QuickSortPivotD(array = q.GenerateInputSequence4(N)));
            System.out.println("Comparisons 5: " + q.QuickSortPivotD(array = q.GenerateInputSequence5(N)));
            System.out.println("Comparisons 6: " + q.QuickSortPivotD(array = q.GenerateInputSequence6(N)));
            System.out.println("Comparisons 7: " + q.QuickSortPivotD(array = q.GenerateInputSequence7(N)));
            System.out.println("Comparisons 8: " + q.QuickSortPivotD(array = q.GenerateInputSequence8(N)));
            System.out.println("Comparisons 9: " + q.QuickSortPivotD(array = q.GenerateInputSequence9(N)));
            System.out.println("Comparisons 10: " + q.QuickSortPivotD(array = q.GenerateInputSequence10(N, seed)));
        }
        else if (sortLetter == 'E') {
            System.out.println("Comparisons 1: " + q.QuickSortPivotE(array = q.GenerateInputSequence1(N)));
            System.out.println("Comparisons 2: " + q.QuickSortPivotE(array = q.GenerateInputSequence2(N)));
            System.out.println("Comparisons 3: " + q.QuickSortPivotE(array = q.GenerateInputSequence3(N)));
            System.out.println("Comparisons 4: " + q.QuickSortPivotE(array = q.GenerateInputSequence4(N)));
            System.out.println("Comparisons 5: " + q.QuickSortPivotE(array = q.GenerateInputSequence5(N)));
            System.out.println("Comparisons 6: " + q.QuickSortPivotE(array = q.GenerateInputSequence6(N)));
            System.out.println("Comparisons 7: " + q.QuickSortPivotE(array = q.GenerateInputSequence7(N)));
            System.out.println("Comparisons 8: " + q.QuickSortPivotE(array = q.GenerateInputSequence8(N)));
            System.out.println("Comparisons 9: " + q.QuickSortPivotE(array = q.GenerateInputSequence9(N)));
            System.out.println("Comparisons 10: " + q.QuickSortPivotE(array = q.GenerateInputSequence10(N, seed)));
        }
    }


}


