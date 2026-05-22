package com.returnshield.services;

import com.returnshield.dsa.CustomerManager;
import com.returnshield.dsa.FraudQueueManager;
import com.returnshield.dsa.ReturnQueueManager;
import com.returnshield.dsa.TransactionHistoryManager;
import com.returnshield.dsa.UndoManager;

public class AppData {

    public static CustomerManager customerManager =
            new CustomerManager();

    public static ReturnQueueManager returnQueueManager =
            new ReturnQueueManager();

    public static FraudQueueManager fraudQueueManager =
            new FraudQueueManager();

    public static TransactionHistoryManager
            transactionHistoryManager =
            new TransactionHistoryManager();

    public static UndoManager undoManager =
            new UndoManager();
}