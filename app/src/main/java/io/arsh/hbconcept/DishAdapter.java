package io.arsh.hbconcept;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by arshdeep on 12/9/15.
 */
public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {



    protected Context mContext;
    protected Dish[] myDishes;


    public DishAdapter(Context theContext, List<Dish> theDishes) {
        mContext = theContext;
        Log.e("DishAdapter", theDishes.size() + " is dish list size");
        myDishes = new Dish[theDishes.size()];
        int count = 0;
        for (Dish C: theDishes) {
            Log.e("DishAdapter, in foreach", C.myMain);
            myDishes[count] = C;
            count++;
        }
    }



    @Override
    public DishViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dish_list_item, parent, false);

        DishViewHolder viewHolder = new DishViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(DishViewHolder holder, int position) {
        Log.e("DishAdapter", "position is " + position);
        holder.bindDish(myDishes[position]);
    }

    @Override
    public int getItemCount() {
        return myDishes.length;
    }






    public class DishViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public Dish aDish;
        public TextView myMain;
        public TextView mySide;


        public DishViewHolder (View itemView) {
            super(itemView);

            myMain = (TextView) itemView.findViewById(R.id.dishListMain);
            mySide = (TextView) itemView.findViewById(R.id.dishListSide);


            itemView.setOnClickListener(this);
        }


        public void bindDish(Dish dish) {
            aDish = dish;

            myMain.setText(dish.myMain);
            mySide.setText(dish.mySide);
        }



        @Override
        public void onClick(View v) {
            String name = myMain.getText().toString();
            Toast.makeText(mContext, "Showing you dish #" + aDish.myID + ": " + name, Toast.LENGTH_SHORT).show();

            //TODO add this dish to the foods that the user has eaten.

        }



    }



}
