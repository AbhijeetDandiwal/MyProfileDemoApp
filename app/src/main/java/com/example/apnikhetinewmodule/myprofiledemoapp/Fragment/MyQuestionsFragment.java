package com.example.apnikhetinewmodule.myprofiledemoapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apnikhetinewmodule.myprofiledemoapp.Adapter.MyQuestionsAdapter;
import com.example.apnikhetinewmodule.myprofiledemoapp.Model.MyQuestionsBean;
import com.example.apnikhetinewmodule.myprofiledemoapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gagandeep.k on 11/22/2017.
 */

public class MyQuestionsFragment extends Fragment {

    RecyclerView informationRecyclerView;
    MyQuestionsAdapter myQuestionsAdapter;
    List<MyQuestionsBean> myQuestionsList;
    MyQuestionsBean myQuestionsBean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.my_questions_fragment_lay, container, false);

        findIds(v);

        return v;
    }

    private void findIds(View v) {

        informationRecyclerView = (RecyclerView) v.findViewById(R.id.informationRecyclerView);

        myQuestionsList = new ArrayList<>();

        myQuestionsBean = new MyQuestionsBean();
        myQuestionsBean.setUser_image(R.mipmap.ic_launcher);
        myQuestionsBean.setUserName("Gagan");
        myQuestionsBean.setDate("22-11-2017");
        myQuestionsBean.setQuestion("How to prevent our field from rats. It becomes difficult to handle the situation.");
        myQuestionsList.add(myQuestionsBean);

        myQuestionsBean = new MyQuestionsBean();
        myQuestionsBean.setUser_image(R.mipmap.ic_launcher);
        myQuestionsBean.setUserName("Vikram");
        myQuestionsBean.setDate("22-11-2017");
        myQuestionsBean.setQuestion("Roots of my apple tree is becoming dry. How to prevent that ?");
        myQuestionsList.add(myQuestionsBean);

        myQuestionsAdapter = new MyQuestionsAdapter(getActivity(), myQuestionsList);
        informationRecyclerView.setAdapter(myQuestionsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        informationRecyclerView.setLayoutManager(layoutManager);

    }
}
