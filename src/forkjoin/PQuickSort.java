package forkjoin;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
public class PQuickSort extends QuickSort {
    int border;
    public PQuickSort() {
        border=0;
    }
    public PQuickSort(int border) {
        this.border = border;
    }
    class MyParallelTask extends RecursiveAction {
        private int array[];
        int start;
        int end;
        public MyParallelTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        @Override
        protected void compute() {
            int j = split(array, start, end);
            MyParallelTask t1 = null, t2 = null;
            //border<=0 sorting is full parallel, border>0 bellow border elements sorting is recursive
            if(border<=0){
                if (start < j) {
                    t1 = new MyParallelTask(array, start, j - 1);
                    t1.fork();
                }
                if (j + 1 < end) {
                    t2 = new MyParallelTask(array, j + 1, end);
                    t2.fork();
                }
            }
            else{
                if (j-start>border) {
                    t1 = new MyParallelTask(array, start, j - 1);
                    t1.fork();
                }
                else if(j-start>0)
                    sort(array, start, j - 1);
                if (border < end-(j + 1)) {
                    t2 = new MyParallelTask(array, j + 1, end);
                    t2.fork();
                }
                else if(end-(j + 1)>0)
                    sort(array, j + 1, end);
            }
            if (t2 != null)
                t2.join();
            if (t1 != null)
                t1.join();
        }
    }
//    class MyParallelTask2 extends RecursiveAction {
//        private int array[];
//        int start;
//        int end;
//        public MyParallelTask2(int[] array, int start, int end) {
//            this.array = array;
//            this.start = start;
//            this.end = end;
//        }
//        @Override
//        protected void compute() {
//            int j = split(array, start, end);
//            List<MyParallelTask2> list = new ArrayList<>();
//            if (start < j)
//                list.add(new MyParallelTask2(array, start, j - 1));
//            if (j + 1 < end)
//                list.add(new MyParallelTask2(array, j + 1, end));
//            this.invokeAll(list);
//        }
//    }
    @Override
    public void sort(int[] tab) {
        ForkJoinPool forkJoin = new ForkJoinPool();
        MyParallelTask task = new MyParallelTask(tab, 0, tab.length -1);
        forkJoin.invoke(task);
    }
}