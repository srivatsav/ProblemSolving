package com.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of intervals, merge all the overlapping intervals to produce a
 * list that has only mutually exclusive intervals.
 * 
 * Example 1:
 * 
 * Intervals: [[1,4], [2,5], [7,9]] Output: [[1,5], [7,9]] Explanation: Since
 * the first two intervals [1,4] and [2,5] overlap, we merged them into one
 * [1,5].
 */
public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(3, 3));

        List<Interval> res = MergeIntervals.merge(input);
        for (Interval interval : res) {
            System.out.println(interval.start + "-->" + interval.end);
        }

    }

    public static List<Interval> merge(List<Interval> intervals) {

        if (intervals.size() < 2)
            return intervals;

        // sorting the intervals by start time.
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        List<Interval> mergedIntervals = new ArrayList<>();

        Interval prevInterval = intervals.get(0);
        int start = prevInterval.start;
        int end = prevInterval.end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            if (currentInterval.start <= prevInterval.end) {
                end = Math.max(currentInterval.end, end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = currentInterval.start;
                end = currentInterval.end;
            }
        }

        // adding th elast interval
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }
}