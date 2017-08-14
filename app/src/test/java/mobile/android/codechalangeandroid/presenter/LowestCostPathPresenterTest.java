package mobile.android.codechalangeandroid.presenter;


import org.junit.Test;
import org.mockito.Mock;

import mobile.android.codechalangeandroid.activity.LowestPathView;

import static org.mockito.Mockito.verify;

/**
 * Created by Raj
 * on 8/12/2017.
 */
public class LowestCostPathPresenterTest {

    LowestCostPathPresenter lowestCostPathPresenter;

    @Mock
    LowestPathView lowestPathView;

    @Test
    public void checkTheValidUserXYindex0(){
        lowestCostPathPresenter=new LowestCostPathPresenter(lowestPathView);
        lowestCostPathPresenter.validateUserMatrixXY("0","0");
        verify(lowestPathView).errorMessageForEnterInputMatrix();
    }

    @Test
    public void checkTheValidUserXYindexabove10(){
        lowestCostPathPresenter=new LowestCostPathPresenter(lowestPathView);
        lowestCostPathPresenter.validateUserMatrixXY("11","11");
        verify(lowestPathView).errorMessageForEnterbelow10();
    }


}