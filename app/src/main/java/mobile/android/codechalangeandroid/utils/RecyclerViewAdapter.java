package mobile.android.codechalangeandroid.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

import mobile.android.codechalangeandroid.R;
import mobile.android.codechalangeandroid.activity.LowestPathView;
import mobile.android.codechalangeandroid.model.Matrix;

/**
 * Created by Raj
 * on 8/12/2017.
 */


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>  {

    private List<Matrix> matrixList;
    private Context context;
    private LowestPathView lowestPathView;
    private String selectedItem;
    private String inputX,inputY;
    private int incrementRow=0,incrementcolumn=0;
    private int [][] userSelectedMatrixGrid;
    private boolean isButtonFocused=true;


    public class MyViewHolder extends RecyclerView.ViewHolder{
        private Button button_one,button_two,button_three,button_four,button_five;

        private MyViewHolder(View itemView) {
            super(itemView);
            button_one=(Button)itemView.findViewById(R.id.button_one);
            button_two=(Button)itemView.findViewById(R.id.button_two);
            button_three=(Button)itemView.findViewById(R.id.button_three);
            button_four=(Button)itemView.findViewById(R.id.button_four);
            button_five=(Button)itemView.findViewById(R.id.button_five);
        }
    }
    public RecyclerViewAdapter(LowestPathView lowestPathView,Context context, List<Matrix> matrixList,String inputX,String inputY){
        this.lowestPathView=lowestPathView;
        this.context=context;
        this.matrixList=matrixList;
        this.inputX=inputX;
        this.inputY=inputY;
        this.userSelectedMatrixGrid=new int[Integer.parseInt(inputX)][Integer.parseInt(inputY)];
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_rowcount, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Matrix matrix=matrixList.get(position);
        holder.button_one.setText(String.valueOf(matrix.getCount_First()));
        holder.button_two.setText(String.valueOf(matrix.getCount_Second()));
        holder.button_three.setText(String.valueOf(matrix.getCount_Three()));
        holder.button_four.setText(String.valueOf(matrix.getCount_Four()));
        holder.button_five.setText(String.valueOf(matrix.getCount_Five()));
        holder.button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.v("Button_ ID:::",String.valueOf(matrix.getCount_First()));
                selectedItem=matrix.getCount_First();
                selectedItemsFromKeypad(selectedItem);
            }
        });

        holder.button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.v("Button_ ID:::",String.valueOf(matrix.getCount_Second()));
                selectedItem=matrix.getCount_Second();
                selectedItemsFromKeypad(selectedItem);
            }
        });

        holder.button_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Log.v("Button_ ID:::",String.valueOf(matrix.getCount_Three()));
                selectedItem=matrix.getCount_Three();
                selectedItemsFromKeypad(selectedItem);
            }
        });

        holder.button_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Log.v("Button_ ID:::",String.valueOf(matrix.getCount_Four()));
                selectedItem=matrix.getCount_Four();
                selectedItemsFromKeypad(selectedItem);
            }
        });

        holder.button_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Log.v("Button_ ID:::",String.valueOf(matrix.getCount_Five()));
                selectedItem=matrix.getCount_Five();
                selectedItemsFromKeypad(selectedItem);
            }
        });

    }

    @Override
    public int getItemCount() {
        return matrixList.size();
    }

    private void selectedItemsFromKeypad(String selectedItem){
// store the value in 2d (0,0)(0,1)(0,1) like

        if (isButtonFocused) {
            if (incrementRow < Integer.parseInt(inputX)) {
                if (selectedItem.matches("[a-zA-Z]")){
                    userSelectedMatrixGrid[incrementRow][incrementcolumn] = selectedItem.charAt(0);
                }else {
                    userSelectedMatrixGrid[incrementRow][incrementcolumn] = Integer.parseInt(selectedItem);
                }
                incrementRow++;
            } else if (incrementcolumn < Integer.parseInt(inputY)) {
                incrementRow = 0;
                incrementcolumn++;
            }
            //lowestPathView.printTheColumnTex(String.valueOf(incrementcolumn + 1));

            if (incrementcolumn == Integer.parseInt(inputY)) {
                Log.v("UserInputValue", Arrays.deepToString(userSelectedMatrixGrid));
                // update the Ui to print the User Selected 2D array
                lowestPathView.printTheRowsAndColumn(userSelectedMatrixGrid);
                isButtonFocused=false;
            }
        }else {
            lowestPathView.displayToSelectOutput();
        }

    }


}
