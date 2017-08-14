package mobile.android.codechalangeandroid.presenter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mobile.android.codechalangeandroid.activity.LowestPathView;
import mobile.android.codechalangeandroid.model.Matrix;

/**
 * Created by  Raj
 * on 8/12/2017.
 */

public class LowestCostPathPresenter {

    private List<Matrix> matrixList;
    private Map<String,int[][]> lowestPath;
    private LowestPathView lowestPathView;

    public LowestCostPathPresenter(LowestPathView lowestPathView){
        this.lowestPathView=lowestPathView;
    }
    public void validateUserMatrixXY(String inputX,String inputY){
        // validate the User input for Matrix Size
        if(inputX != null && !inputX.isEmpty() && inputY != null && !inputY.isEmpty()){

            if (Integer.parseInt(inputX)>=10 && Integer.parseInt(inputY)>=10){
                lowestPathView.errorMessageForEnterbelow10();
            }else if (Integer.parseInt(inputX)<=0 && Integer.parseInt(inputY)<=0){
                lowestPathView.errorMessageForEnterInputMatrix();
            }else {
                lowestPathView.loadTheStaticKeyboadToRecyclerView(loadStaticKeyboard(),inputX,inputY);
            }
        }else {
            lowestPathView.errorMessageForEnterInputMatrix();
        }
    }

    public Map<String,int[][]> initializeData(String [] testCases){
        lowestPath =new HashMap<>();
       // String [] testCases= getResources().getStringArray(R.array.test_cases);

        lowestPath.put(testCases[0],new int [][]{{3, 4 ,1 ,2, 8, 6},
                {6 ,1 ,8 ,2, 7 ,4},
                {5 ,9 ,3 ,9 ,9 ,5},
                {8 ,4 ,1 ,3 ,2 ,6}
                ,{3 ,7 ,2 ,8 ,6 ,4}});
        lowestPath.put(testCases[1],new int[][]{{3, 4 ,1 ,2, 8, 6},
                {6 ,1 ,8 ,2, 7 ,4},
                {5 ,9 ,3 ,9 ,9 ,5},
                {8 ,4 ,1 ,3 ,2 ,6}
                ,{3 ,7 ,2 ,1,2,3}});
        lowestPath.put(testCases[2], new int[][]{{5 ,8 ,5 ,3, 5},});
        lowestPath.put(testCases[3],new int[][]{{5} ,{8} ,{5} ,{3}, {5}});

        lowestPath.put(testCases[4], new int[][]{{69, 10, 19, 10, 19},
                {51, 23, 20, 19, 12},
                {60, 12, 20, 11, 10}});
        lowestPath.put(testCases[5], new int[][] {{60, 3, 3, 6},
                {6, 3, 7, 9},
                {5, 6, 8, 3}});
        lowestPath.put(testCases[6],new int[][]{{6,3,-5,9},
                {-5,2,4,10},
                {3,-2,6,10},
                {6,-1,-2,10}});
        lowestPath.put(testCases[7], new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}});

        return lowestPath;
    }



    public List<Matrix> loadStaticKeyboard(){
        matrixList=new ArrayList<>();
        Matrix matrix;
        int column=0;
        for (int row=0; row<3; row++){
            // Adding Numeric Value
            matrix=new Matrix(String.valueOf(column+1),String.valueOf(column+2),String.valueOf(column+3),String.valueOf(column+4),
                    String.valueOf(column+5));
            column=column+5;
            matrixList.add(matrix);
        }
        // Adding large number
        matrix =new Matrix(String.valueOf(60),String.valueOf(77),String.valueOf(64),String.valueOf(88),String.valueOf(47));
        matrixList.add(matrix);
        // Adding negative numeric
        matrix =new Matrix("-7","-8","-4","-11","-3");
        matrixList.add(matrix);


        return matrixList;
    }
}
