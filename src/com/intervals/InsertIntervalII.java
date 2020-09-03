package com.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of non-overlapping intervals sorted by their start time, insert
 * a given interval at the correct position and merge all necessary intervals to
 * produce a list that has only mutually exclusive intervals.
 * 
 * Example 1:
 * 
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6] Output: [[1,3],
 * [4,7], [8,12]] Explanation: After insertion, since [4,6] overlaps with [5,7],
 * we merged them into one [4,7]. Example 2:
 * 
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10] Output: [[1,3],
 * [4,12]] Explanation: After insertion, since [4,10] overlaps with [5,7] &
 * [8,12], we merged them into [4,12]. Example 3:
 * 
 * Input: Intervals=[[2,3],[5,7]], New Interval=[1,4] Output: [[1,4], [5,7]]
 * Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them
 * into one [1,4].
 */
public class InsertIntervalII {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        // intervals.add(new Interval(8, 12));

        List<Interval> mergedIntervals = insert(intervals, new Interval(2, 5));

        for (Interval interval : mergedIntervals) {
            System.out.println(interval.start + "--->" + interval.end);
        }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();

        if (intervals.isEmpty())
            return mergedIntervals;

        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            mergedIntervals.add(intervals.get(i++));

        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }

        mergedIntervals.add(newInterval);

        while (i < intervals.size())
            mergedIntervals.add(intervals.get(i++));

        return mergedIntervals;
    }
}