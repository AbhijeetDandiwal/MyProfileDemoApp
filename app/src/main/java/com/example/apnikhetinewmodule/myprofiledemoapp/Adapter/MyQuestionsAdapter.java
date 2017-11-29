package com.example.apnikhetinewmodule.myprofiledemoapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apnikhetinewmodule.myprofiledemoapp.Model.MyQuestionsBean;
import com.example.apnikhetinewmodule.myprofiledemoapp.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by gagandeep.k on 11/22/2017.
 */

public class MyQuestionsAdapter extends RecyclerView.Adapter<MyQuestionsAdapter.ViewHolder> {

    Context context;
    List<MyQuestionsBean> myQuestionsList;

    public MyQuestionsAdapter(Context context, List<MyQuestionsBean> myQuestionsList) {

        this.context = context;
        this.myQuestionsList = myQuestionsList;

    }

    @Override
    public MyQuestionsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_questions_items, parent, false);
        final MyQuestionsAdapter.ViewHolder viewHolder = new MyQuestionsAdapter.ViewHolder(view);


        return new MyQuestionsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyQuestionsAdapter.ViewHolder holder, int position) {

        holder.userName.setText(myQuestionsList.get(position).getUserName());
        holder.dateText.setText(myQuestionsList.get(position).getDate());
        holder.questionText.setText(myQuestionsList.get(position).getQuestion());

        holder.userName.setTag(position);

    }

    @Override
    public int getItemCount() {
        return myQuestionsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView userImage;
        TextView userName, dateText, questionText;

        public ViewHolder(View view) {
            super(view);

            userImage = (CircleImageView) view.findViewById(R.id.userImage);
            userName = (TextView) view.findViewById(R.id.userName);
            dateText = (TextView) view.findViewById(R.id.dateText);
            questionText = (TextView) view.findViewById(R.id.questionText);

        }
    }
}
