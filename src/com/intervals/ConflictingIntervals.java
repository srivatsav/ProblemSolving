package com.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of intervals representing ‘N’ appointments, find out if a
 * person can attend all the appointments.
 * 
 * Example 1:
 * 
 * Appointments: [[1,4], [2,5], [7,9]] Output: false Explanation: Since [1,4]
 * and [2,5] overlap, a person cannot attend both of these appointments. Example
 * 2:
 * 
 * Appointments: [[6,7], [2,4], [8,12]] Output: true Explanation: None of the
 * appointments overlap, therefore a person can attend all of them. Example 3:
 * 
 * Appointments: [[4,5], [2,3], [3,6]] Output: false Explanation: Since [4,5]
 * and [3,6] overlap, a person cannot attend both of these appointments.
 */
public class ConflictingIntervals {
    public static void main(String[] args) {

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 5));
        intervals.add(new Interval(7, 9));

        System.out.println(checkIfIntervalsOverlap(intervals));
    }

    private static final boolean checkIfIntervalsOverlap(List<Interval> intervals) {

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end)
                return false;
        }
        return true;
    }
}