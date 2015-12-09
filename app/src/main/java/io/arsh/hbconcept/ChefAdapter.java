package io.arsh.hbconcept;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by arshdeep on 11/8/15.
 */
public class ChefAdapter extends RecyclerView.Adapter<ChefAdapter.ChefViewHolder>{

    protected Context mContext;
    protected Cook[] myChefs;


    public ChefAdapter(Context theContext, List<Cook> theChefs) {
        mContext = theContext;

        myChefs = new Cook[theChefs.size()];
        int count = 0;
        for (Cook C: theChefs) {
            myChefs[count] = C;
        }
    }


    @Override
    public ChefViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cook_list_item, parent, false);

        ChefViewHolder viewHolder = new ChefViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ChefViewHolder holder, int position) {
        holder.bindChef(myChefs[position]);
    }

    @Override
    public int getItemCount() {
        return myChefs.length;
    }


    public class ChefViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public Cook aChef;
        public TextView myChefName;
        public TextView myChefUserName;
        public TextView myCookID;

        public ChefViewHolder (View itemView) {
            super(itemView);

            myChefName = (TextView) itemView.findViewById(R.id.cookItemName);
            myChefUserName = (TextView) itemView.findViewById(R.id.cookItemUser);
            myCookID = (TextView) itemView.findViewById(R.id.cookItemID);

            itemView.setOnClickListener(this);
        }


        public void bindChef(Cook chef) {
            aChef = chef;

            myChefName.setText(chef.myFN + " " + chef.myLN);
            myChefUserName.setText(chef.myUN);
            myCookID.setText("Cook ID # " + chef.myID);
        }



        @Override
        public void onClick(View v) {
            String name = myChefName.getText().toString();
            Toast.makeText(mContext, "Showing you cook " + name, Toast.LENGTH_SHORT).show();

            TheCookUtil.setTheCook(aChef);

            Intent intent= new Intent(v.getContext(), CookProfileActivity.class);
            v.getContext().startActivity(intent);

        }



    }

}
