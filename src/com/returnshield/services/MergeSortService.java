package com.returnshield.services;

import com.returnshield.models.ReturnRequest;

import java.util.ArrayList;

public class MergeSortService {

    public static void mergeSort(
            ArrayList<ReturnRequest> list,
            int left,
            int right) {

        if(left < right) {

            int mid = (left + right) / 2;

            mergeSort(list, left, mid);

            mergeSort(list, mid + 1, right);

            merge(list, left, mid, right);
        }
    }

    private static void merge(
            ArrayList<ReturnRequest> list,
            int left,
            int mid,
            int right) {

        int n1 = mid - left + 1;

        int n2 = right - mid;

        ArrayList<ReturnRequest> leftList =
                new ArrayList<>();

        ArrayList<ReturnRequest> rightList =
                new ArrayList<>();

        for(int i = 0; i < n1; i++) {

            leftList.add(list.get(left + i));
        }

        for(int j = 0; j < n2; j++) {

            rightList.add(list.get(mid + 1 + j));
        }

        int i = 0;

        int j = 0;

        int k = left;

        while(i < n1 && j < n2) {

            if(leftList.get(i)
                    .getFraudScore()

                    >=

                    rightList.get(j)
                            .getFraudScore()) {

                list.set(k, leftList.get(i));

                i++;
            }
            else {

                list.set(k, rightList.get(j));

                j++;
            }

            k++;
        }

        while(i < n1) {

            list.set(k, leftList.get(i));

            i++;
            k++;
        }

        while(j < n2) {

            list.set(k, rightList.get(j));

            j++;
            k++;
        }
    }
}