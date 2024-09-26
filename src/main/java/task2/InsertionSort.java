package task2;

import java.util.ArrayList;

class InsertionSort {
    static ArrayList<Double> GetSortedList(ArrayList<Double> list) {
        for (int i = 1; i < list.size(); ++i) {
            var t = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > t) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, t);
        }
        return list;
    }
}
