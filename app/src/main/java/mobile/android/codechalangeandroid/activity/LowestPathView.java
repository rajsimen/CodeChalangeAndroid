package mobile.android.codechalangeandroid.activity;


import java.util.List;

import mobile.android.codechalangeandroid.model.Matrix;

/**
 * Created by Raj
 * on 8/12/2017.
 */

public interface LowestPathView {

    void errorMessageForEnterbelow10();
    void errorMessageForEnterInputMatrix();
    void displayToSelectOutput();
    void printTheColumnTex(String columnName);
    void printTheRowsAndColumn(int[][] selectedMatrix);
    void loadTheStaticKeyboadToRecyclerView(List<Matrix> matrixList, String inputX, String input);
}
