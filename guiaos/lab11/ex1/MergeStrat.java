package lab11.ex1;

import java.util.ArrayList;
import java.util.List;

public class MergeStrat implements Strategy {

    @Override
    public void sort(List<Telemovel> telemoveis, String criterio) {
        System.out.println("-- Merge --");
        mergeSort(telemoveis, criterio, 0, telemoveis.size() - 1);
    }

    private void mergeSort(List<Telemovel> telemoveis, String criterio, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(telemoveis, criterio, left, middle);
            mergeSort(telemoveis, criterio, middle + 1, right);

            merge(telemoveis, criterio, left, middle, right);
        }
    }

    private void merge(List<Telemovel> telemoveis, String criterio, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        List<Telemovel> leftList = new ArrayList<>(n1);
        List<Telemovel> rightList = new ArrayList<>(n2);

        for (int i = 0; i < n1; i++) {
            leftList.add(telemoveis.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightList.add(telemoveis.get(middle + 1 + j));
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            String attr1 = String.valueOf(leftList.get(i).get(criterio));
            String attr2 = String.valueOf(rightList.get(j).get(criterio));

            if (attr1.compareTo(attr2) <= 0) {
                telemoveis.set(k, leftList.get(i));
                i++;
            } else {
                telemoveis.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            telemoveis.set(k, leftList.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            telemoveis.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
}
