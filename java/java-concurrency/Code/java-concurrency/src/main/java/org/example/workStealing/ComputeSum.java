package org.example.workStealing;

import java.util.concurrent.RecursiveTask;

public class ComputeSum extends RecursiveTask<Integer> {

    int start;
    int end;

    ComputeSum(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end - start <= 4){
            int sum = 0;
            for(int i=start; i<=end;i++){
                sum+=start;
            }
            return sum;
        }else{
            int mid = (end + start)/2;
            ComputeSum leftSum = new ComputeSum(start,mid);
            ComputeSum rightSum = new ComputeSum(mid+1,end);

            //Fork will submit the task and add subsequents to work-stealing queue.
            leftSum.fork();
            rightSum.fork();

            int leftResult = leftSum.join();
            int rightResult = rightSum.join();

            return leftResult + rightResult;
        }
    }
}
