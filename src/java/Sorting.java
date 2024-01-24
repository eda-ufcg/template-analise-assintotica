import java.util.*;

public class Sorting {

    public static int[] countingSort(int[] a, int k) {
        int[] c = new int[k];
        // freq
        for (int i = 0; i < a.length; i++)
            c[a[i]-1] += 1;

        // cumulativa
        for (int i = 1; i < c.length; i++)
            c[i] += c[i-1];

        int[] b = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
                b[c[a[i] - 1] - 1] = a[i];
                c[a[i] - 1]--;
        }
        return b;
    }


    public static void insertionSort(int[] v) {
       for (int i = 1; i < v.length; i++) {
            int j = i;
            while (j > 0 && v[j] < v[j-1]) {
                swap(v, j, j-1);
                j--;
            }

        }   

    }

    public static void selectionSort(int[] v) {
        for (int i = 0; i < v.length; i++) {
            int indiceMenor = i;
            for (int j = i+1; j < v.length; j++) {
                if (v[j] < v[indiceMenor]) {
                    indiceMenor = j;
                }        
            }
            swap(v, i, indiceMenor);
        }
    } 

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public static void quickSort(int[] v, int ini, int fim) {
        
        if (ini < fim) {
            int indicePivot = particiona(v, ini, fim);
            quickSort(v, ini, indicePivot - 1);
            quickSort(v, indicePivot +1, fim);
        }

    }

    public static int particiona(int[] v, int ini, int fim) {
        
        int i = ini;
        int pivot = v[ini];
        for (int j = i + 1; j <= fim; j++) {
            if (v[j] <= pivot) {
                i++;
                swap(v, i, j);
            }
        }

        swap(v, i, ini);
        return i;
    }
        

    public static void mergeSort(int[] v, int ini, int fim) {
        
        if (ini < fim) {
            int meio = (ini + fim) / 2;
            mergeSort(v, ini, meio);
            mergeSort(v, meio+1, fim);
            merge(v, ini, fim);
        }

    }

    public static void merge(int[] v, int ini, int fim) {
        int[] helper = new int[v.length];
        for (int i = ini; i <= fim; i++)
            helper[i] = v[i];

        int i = ini;
        int meio = (ini + fim)/2;
        int j = meio + 1;
        int k = ini;

        while (i <= meio && j <= fim) {
            if (helper[i] < helper[j]) {
                v[k++] = helper[i++];
            } else {
                v[k++] = helper[j++];
            }
        }

        while (i <= meio) {
            v[k++] = helper[i++];
        }

        while (j <= fim) {
            v[k++] = helper[j++];
        }

    }

    public static void main(String[] args) {
        int[] v = new int[]{8, 4, 2, 1, 9, 9, 12, 4};
        int[] b = countingSort(v, 12);
        System.out.println(Arrays.toString(b));
    }
}
