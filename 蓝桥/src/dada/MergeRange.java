package dada;

import java.util.ArrayList;

import java.util.Comparator;

/**
 * @author jjzmi
 * @description 给出一组区间，请合并所有重叠的区间。
 *               请保证合并后的区间按区间起点升序排列
 * @create 2021-03-20-12:14
 * @e-mail 2569401196@qq.com or jjz.miss.3344@outlook.com
 */
public class MergeRange {
    public static class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start - o2.start == 0) {
                    return o1.end - o2.end;
                } else {
                    return o1.start - o2.start;
                }
            }
        });

        for (int i = 0; i < intervals.size()-1; i++) {
            if (intervals.get(i).end >= intervals.get(i + 1).start) {
                if (intervals.get(i).end < intervals.get(i + 1).end) {
                    intervals.get(i).end = intervals.get(i + 1).end;
                }
                intervals.remove(i + 1);
                i--;
            }
        }
        return intervals;
    }

    /**
     * 这是一个main方法，是程序的入口
     */
    public static void main(String[] args) {

        ArrayList<Interval> lists = new ArrayList<>();
        lists.add(new Interval(20, 60));
        lists.add(new Interval(10, 30));
        lists.add(new Interval(80, 100));
        lists.add(new Interval(150, 180));
        ArrayList<Interval> intervals = merge(lists);

        System.out.println(intervals);


    }
}
