package com.example.apnikhetinewmodule.myprofiledemoapp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apnikhetinewmodule.myprofiledemoapp.Interface.ClickedPosition;
import com.example.apnikhetinewmodule.myprofiledemoapp.Model.MyCategoriesBean;
import com.example.apnikhetinewmodule.myprofiledemoapp.R;

import java.util.List;

/**
 * Created by gagandeep.k on 11/22/2017.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    Context context;
    List<MyCategoriesBean> myDataList;
    ClickedPosition clickedPosition;
    int rowIndex;


    public MyRecyclerAdapter(Context context, ClickedPosition clickedPosition, List<MyCategoriesBean> myDataList) {
        this.context = context;
        this.myDataList = myDataList;
        this.clickedPosition = clickedPosition;
        rowIndex = 0;

    }

    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_recycler_items, parent, false);
        final MyRecyclerAdapter.ViewHolder viewHolder = new MyRecyclerAdapter.ViewHolder(view);


        return new MyRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.ViewHolder holder, final int position) {

        holder.mainLinearLay.setTag(position);

        holder.mainLinearLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //    final int position = Integer.parseInt(viewHolder.mainLinearLay.getTag().toString());
                clickedPosition.getClickedPosition(position);
                rowIndex = position;
                notifyDataSetChanged();

            }
        });


        if (position == rowIndex) {

            holder.categoryIcon.setText(Html.fromHtml(myDataList.get(position).getCategoryImage()).toString());
            holder.simpleText.setText(myDataList.get(position).getCategoryName());
            holder.categoryIcon.setTextColor(Color.parseColor("#397CC2"));
            holder.categoryIcon.setBackgroundResource(R.drawable.blue_circle_bkg);
            holder.simpleText.setTextColor(Color.parseColor("#397CC2"));
            holder.mainLinearLay.setBackgroundColor(Color.parseColor("#50D3D3D3"));

        } else {

            holder.categoryIcon.setText(Html.fromHtml(myDataList.get(position).getCategoryImage()).toString());
            holder.simpleText.setText(myDataList.get(position).getCategoryName());
            holder.categoryIcon.setTextColor(Color.parseColor("#ff000000"));
            holder.categoryIcon.setBackgroundResource(R.drawable.black_circle_bkg);
            holder.simpleText.setTextColor(Color.parseColor("#ff000000"));
            holder.mainLinearLay.setBackgroundColor(Color.parseColor("#ffffffff"));


        }


    }

    @Override
    public int getItemCount() {
        return myDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView categoryIcon;
        TextView simpleText;
        LinearLayout mainLinearLay;

        public ViewHolder(View view) {
            super(view);
            categoryIcon = (TextView) view.findViewById(R.id.categoryIcon);
            simpleText = (TextView) view.findViewById(R.id.categoryName);
            mainLinearLay = (LinearLayout) view.findViewById(R.id.mainLinearLay);
        }
    }

}
