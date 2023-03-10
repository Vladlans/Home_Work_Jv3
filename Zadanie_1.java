import java.util.Arrays;

    import java.util.Random;
        
    public class prog1 {
        public static void main(String[] args) {
            Random rnd = new Random();
            int[] mass = new int[10];
            for (int i = 0; i < mass.length; i++) {
                mass[i] = rnd.nextInt(100);
            }
            System.out.printf("Начальный массив: %s\n", Arrays.toString(mass));
            System.out.printf("Отсортированный массив:%s", Arrays.toString(mergeSortArray(mass)));
        }
        
        public static int[] mergeSortArray(int[] mass){
            int[] temp;
            int[] array = mass;
            int[] doubleArray = new int[array.length];
            int size = 1;
            while (size < mass.length){
                for (int i = 0; i < mass.length; i += 2 * size) {
                merge(array, i, array, i+ size, doubleArray, i, size);
                }
                temp = array;
                array = doubleArray;
                doubleArray = temp;
                size *= 2;
        }
            return array;
        }
        
        public static void merge (int[] array1, int start1, int[] array2, int start2, int[] resultArray, int startResult, int size){
            int index1 = start1;
            int index2 = start2;
    
            int array1End = Math.min(start1+size, array1.length);
            int array2End = Math.min(start2+size, array2.length);
    
            int count = array1End-start1 + array2End-start2;
            for (int i = startResult; i < startResult + count ; i++) {
                if(index1<array1End &&(index2 >= array2End || array1[index1] < array2[index2])){
                    resultArray[i] = array1[index1];
                    index1++;
                } else {
                    resultArray[i] = array2[index2];
                    index2++;
                }
            }
        }
    }
