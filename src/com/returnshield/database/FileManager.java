package com.returnshield.database;

import com.returnshield.models.ReturnRequest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void saveReturnRequest(
            ReturnRequest request) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(
                                    "returns.txt",
                                    true
                            )
                    );

            writer.write(
                    request.getCustomer()
                            .getName()
                            + ","
                            + request.getProduct()
                            .getProductName()
                            + ","
                            + request.getFraudScore()
            );

            writer.newLine();

            writer.close();

        }
        catch(IOException e) {

            e.printStackTrace();
        }
    }
}