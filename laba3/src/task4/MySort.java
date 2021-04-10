package task4;

import java.util.Comparator;

public interface MySort<T> {
    void sort(Comparator<? super T> comparator);
}
