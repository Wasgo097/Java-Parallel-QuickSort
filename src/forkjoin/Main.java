package forkjoin;
import java.util.Arrays;
import java.util.Random;
public class Main {
    static int[] generate(int size){
        int tab[]=new int[size];
        Random rng=new Random();
        for(int i=0;i<size;i++)
            tab[i]=rng.nextInt(1000);
        return tab;
    }
    static int get_best_border(int[]tab){
        long t1,t2;
        int border=0;
        long t=100000000;
        for(int i=100;i<20000;i+=100){
            int []temp_arr=Arrays.copyOf(tab, tab.length);
            Sort pqs=new PQuickSort(i);
            t1=System.currentTimeMillis();
            pqs.sort(temp_arr);
            t2=System.currentTimeMillis();
            long time=t2-t1;
            if(time<t){
                t=time;
                border=i;
            }
        }
        System.out.println("Best time is "+t+" for "+border+" border");
        return border;
    }
    static boolean compare(int[]original_array){
        for(int j=0;j<100;j++) {
            int[] tmpArrqs = Arrays.copyOf(original_array,original_array.length);
            int[] tmpArrpqs = Arrays.copyOf(original_array,original_array.length);
            Sort qsort = new QuickSort();
            qsort.sort(tmpArrqs);
            Sort pqsort = new QuickSort();
            pqsort.sort(tmpArrpqs);
            for (int i = 0; i < original_array.length; i++)
                if (tmpArrqs[i] != tmpArrpqs[i]) {
                    System.out.println("Not this same");
                    return false;
                }
            System.out.println("this same");
        }
        return true;
    }
    public static void main(String[] args) {
        int[]original_arr=generate(1500000);
        long t1,t2;
        {
            System.out.println("---SZEREGOWO----");
            int[] tmpTab = Arrays.copyOf(original_arr, original_arr.length);
            Sort sort = new QuickSort();
            t1=System.currentTimeMillis();
            sort.sort(tmpTab);
            t2=System.currentTimeMillis();
            System.out.println("Pomiar 1 "+(t2-t1));
            tmpTab = Arrays.copyOf(original_arr, original_arr.length);
            t1=System.currentTimeMillis();
            sort.sort(tmpTab);
            t2=System.currentTimeMillis();
            System.out.println("Pomiar 2 "+(t2-t1));
            tmpTab = Arrays.copyOf(original_arr, original_arr.length);
            t1=System.currentTimeMillis();
            sort.sort(tmpTab);
            t2=System.currentTimeMillis();
            System.out.println("Pomiar 3 "+(t2-t1));
        }
        {
            System.out.println("----RÓWNOLEGLE---");
            int[] tmpTab = Arrays.copyOf(original_arr, original_arr.length);
            Sort sort = new PQuickSort(1700);
            t1=System.currentTimeMillis();
            sort.sort(tmpTab);
            t2=System.currentTimeMillis();
            System.out.println("Pomiar 1 "+(t2-t1));
            tmpTab = Arrays.copyOf(original_arr, original_arr.length);
            t1=System.currentTimeMillis();
            sort.sort(tmpTab);
            t2=System.currentTimeMillis();
            System.out.println("Pomiar 2 "+(t2-t1));
            tmpTab = Arrays.copyOf(original_arr, original_arr.length);
            t1=System.currentTimeMillis();
            sort.sort(tmpTab);
            t2=System.currentTimeMillis();
            System.out.println("Pomiar 3 "+(t2-t1));
        }
    }
}