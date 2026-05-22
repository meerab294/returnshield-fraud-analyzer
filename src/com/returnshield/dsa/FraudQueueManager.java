package com.returnshield.dsa;

import com.returnshield.models.ReturnRequest;

import java.util.PriorityQueue;

public class FraudQueueManager {

    private PriorityQueue<ReturnRequest> fraudQueue;

    public FraudQueueManager() {

        fraudQueue = new PriorityQueue<>(
                (a, b) ->
                        b.getFraudScore() - a.getFraudScore()
        );
    }

    public void addFraudCase(ReturnRequest request) {

        fraudQueue.offer(request);
    }

    public ReturnRequest getHighestFraudCase() {

        return fraudQueue.poll();
    }

    public PriorityQueue<ReturnRequest> getFraudQueue() {

        return fraudQueue;
    }
}