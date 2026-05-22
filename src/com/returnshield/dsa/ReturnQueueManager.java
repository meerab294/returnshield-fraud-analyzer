package com.returnshield.dsa;

import com.returnshield.models.ReturnRequest;

import java.util.LinkedList;
import java.util.Queue;

public class ReturnQueueManager {

    private Queue<ReturnRequest> returnQueue;

    public ReturnQueueManager() {

        returnQueue = new LinkedList<>();
    }

    public void addRequest(ReturnRequest request) {

        returnQueue.offer(request);
    }

    public ReturnRequest processRequest() {

        return returnQueue.poll();
    }

    public Queue<ReturnRequest> getReturnQueue() {

        return returnQueue;
    }
}