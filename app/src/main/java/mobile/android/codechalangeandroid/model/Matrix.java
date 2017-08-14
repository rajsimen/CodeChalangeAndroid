package mobile.android.codechalangeandroid.model;

/**
 * Created by Raj
 * on 8/11/2017.
 */

public class Matrix {

    private String count_First;
    private String count_Second;
    private String count_Three;
    private String count_Four;
    private String count_Five;

    public Matrix(String count_First,String count_Second, String count_Three,
                  String count_Four,String count_Five){
        this.count_First=count_First;
        this.count_Second=count_Second;
        this.count_Three=count_Three;
        this.count_Four=count_Four;
        this.count_Five=count_Five;
    }

    public String getCount_First() {
        return count_First;
    }

    public void setCount_First(String count_First) {
        this.count_First = count_First;
    }

    public String getCount_Second() {
        return count_Second;
    }

    public void setCount_Second(String count_Second) {
        this.count_Second = count_Second;
    }

    public String getCount_Three() {
        return count_Three;
    }

    public void setCount_Three(String count_Three) {
        this.count_Three = count_Three;
    }

    public String getCount_Four() {
        return count_Four;
    }

    public void setCount_Four(String count_Four) {
        this.count_Four = count_Four;
    }

    public String getCount_Five() {
        return count_Five;
    }

    public void setCount_Five(String count_Five) {
        this.count_Five = count_Five;
    }
}
