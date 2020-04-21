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
    public static void main(String[] args) {
        int[]tab=generate(1500000);
        int[] tmpArrqs = Arrays.copyOf(tab, tab.length);
        Sort qsort = new QuickSort();
        qsort.sort(tmpArrqs);
        int[] tmpArrpqs = Arrays.copyOf(tab, tab.length);
        Sort pqsort = new QuickSort();
        pqsort.sort(tmpArrpqs);
        for(int i=0;i<tab.length;i++)
            if(tmpArrqs[i]!=tmpArrpqs[i]){
                System.out.println("Not this same");
                break;
            }
//        long t1,t2;
//        {
//            System.out.println("---SZEREGOWO----");
//            int[] tmpTab = Arrays.copyOf(tab, tab.length);
//            Sort sort = new QuickSort();
//            t1=System.currentTimeMillis();
//            sort.sort(tmpTab);
//            t2=System.currentTimeMillis();
//            System.out.println("Pomiar 1 "+(t2-t1));
//            tmpTab = Arrays.copyOf(tab, tab.length);
//            t1=System.currentTimeMillis();
//            sort.sort(tmpTab);
//            t2=System.currentTimeMillis();
//            System.out.println("Pomiar 2 "+(t2-t1));
//            tmpTab = Arrays.copyOf(tab, tab.length);
//            t1=System.currentTimeMillis();
//            sort.sort(tmpTab);
//            t2=System.currentTimeMillis();
//            System.out.println("Pomiar 3 "+(t2-t1));
//        }
//        {
//            System.out.println("----RÓWNOLEGLE---");
//            int[] tmpTab = Arrays.copyOf(tab, tab.length);
//            Sort sort = new PQuickSort();
//            t1=System.currentTimeMillis();
//            sort.sort(tmpTab);
//            t2=System.currentTimeMillis();
//            System.out.println("Pomiar 1 "+(t2-t1));
//            tmpTab = Arrays.copyOf(tab, tab.length);
//            t1=System.currentTimeMillis();
//            sort.sort(tmpTab);
//            t2=System.currentTimeMillis();
//            System.out.println("Pomiar 2 "+(t2-t1));
//            tmpTab = Arrays.copyOf(tab, tab.length);
//            t1=System.currentTimeMillis();
//            sort.sort(tmpTab);
//            t2=System.currentTimeMillis();
//            System.out.println("Pomiar 3 "+(t2-t1));
//        }

//        {
//            System.out.println("------------------------------------");
//            int[] tmpTab = Arrays.copyOf(tab, tab.length);
//            //System.out.println(Arrays.toString(tmpTab));
//            Sort sort = new PQuickSort();
//            sort.sort(tmpTab);
//            //System.out.println(Arrays.toString(tmpTab));
//        }
    }
}