package com.example.apnikhetinewmodule.myprofiledemoapp.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.apnikhetinewmodule.myprofiledemoapp.Adapter.MyRecyclerAdapter;
import com.example.apnikhetinewmodule.myprofiledemoapp.Fragment.InformationFragment;
import com.example.apnikhetinewmodule.myprofiledemoapp.Fragment.MyAnswersFragment;
import com.example.apnikhetinewmodule.myprofiledemoapp.Fragment.MyQuestionsFragment;
import com.example.apnikhetinewmodule.myprofiledemoapp.Fragment.StatsFragment;
import com.example.apnikhetinewmodule.myprofiledemoapp.Fragment.WalletFragment;
import com.example.apnikhetinewmodule.myprofiledemoapp.Interface.ClickedPosition;
import com.example.apnikhetinewmodule.myprofiledemoapp.Model.MyCategoriesBean;
import com.example.apnikhetinewmodule.myprofiledemoapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickedPosition {

    ImageView userImage;
    RecyclerView myRecycler;
    MyRecyclerAdapter myRecyclerAdapter;
    List<MyCategoriesBean> myDataList;
    MyCategoriesBean myCategoryBean;
    FrameLayout frameLayout;
    Spinner sp_state, sp_district, sp_tehsil, sp_village;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findIds();

    }

    private void findIds() {

        userImage = (ImageView) findViewById(R.id.userImage);
        myRecycler = (RecyclerView) findViewById(R.id.myRecycler);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);

        sp_state = (Spinner) findViewById(R.id.sp_state);
        sp_district = (Spinner) findViewById(R.id.sp_district);
        sp_tehsil = (Spinner) findViewById(R.id.sp_tehsil);
        sp_village = (Spinner) findViewById(R.id.sp_village);


        ArrayList<String> stateDataList = new ArrayList<>();
        stateDataList.add("Choose State");
        stateDataList.add("Punjab");
        stateDataList.add("Haryana");
        stateDataList.add("Himachal");
        stateDataList.add("Delhi");
        ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, stateDataList);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_state.setAdapter(stateAdapter);

        ArrayList<String> districtDataList = new ArrayList<>();
        districtDataList.add("Choose District");
        districtDataList.add("Barnala");
        districtDataList.add("Sangrur");
        districtDataList.add("Ludhiana");
        districtDataList.add("Patiala");
        ArrayAdapter<String> districtAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, districtDataList);
        districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_district.setAdapter(districtAdapter);

        ArrayList<String> tehsilDataList = new ArrayList<>();
        tehsilDataList.add("Choose Tehsil");
        tehsilDataList.add("Barnala");
        tehsilDataList.add("Tapa");
        tehsilDataList.add("Barnala");
        tehsilDataList.add("Tapa");
        ArrayAdapter<String> tehsilDataAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, tehsilDataList);
        tehsilDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_tehsil.setAdapter(tehsilDataAdapter);

        ArrayList<String> villageDataList = new ArrayList<>();
        villageDataList.add("Choose Village");
        villageDataList.add("Pharwahi");
        villageDataList.add("Rajgarh");
        villageDataList.add("Upli");
        villageDataList.add("Kattu");
        ArrayAdapter<String> villageDataAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, villageDataList);
        villageDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_village.setAdapter(villageDataAdapter);

        InformationFragment informationFragment = new InformationFragment();
        setFragment(informationFragment);

        myDataList = new ArrayList<>();

        myCategoryBean = new MyCategoriesBean();
        myCategoryBean.setCategoryName("Information");
        myCategoryBean.setCategoryImage("&#xf129;");
        myDataList.add(myCategoryBean);

        myCategoryBean = new MyCategoriesBean();
        myCategoryBean.setCategoryName("My Questions");
        myCategoryBean.setCategoryImage("&#xf128;");
        myDataList.add(myCategoryBean);

        myCategoryBean = new MyCategoriesBean();
        myCategoryBean.setCategoryName("My Answers");
        myCategoryBean.setCategoryImage("&#xf00c;");
        myDataList.add(myCategoryBean);

        myCategoryBean = new MyCategoriesBean();
        myCategoryBean.setCategoryName("Wallet");
        myCategoryBean.setCategoryImage("&#xf156;");
        myDataList.add(myCategoryBean);

        myCategoryBean = new MyCategoriesBean();
        myCategoryBean.setCategoryName("Stats");
        myCategoryBean.setCategoryImage("&#xf080;");
        myDataList.add(myCategoryBean);

        myRecyclerAdapter = new MyRecyclerAdapter(MainActivity.this, MainActivity.this, myDataList);
        myRecycler.setAdapter(myRecyclerAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        myRecycler.setLayoutManager(layoutManager);

    }


    protected void setFragment(Fragment fragment) {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.frameLayout, fragment);
        t.commit();
    }

    @Override
    public void getClickedPosition(int position) {
        switch (position) {

            case 0:

                InformationFragment informationFragment = new InformationFragment();
                setFragment(informationFragment);

                break;

            case 1:

                MyQuestionsFragment questionsFragment = new MyQuestionsFragment();
                setFragment(questionsFragment);

                break;

            case 2:

                MyAnswersFragment answersFragment = new MyAnswersFragment();
                setFragment(answersFragment);

                break;

            case 3:

                WalletFragment walletFragment = new WalletFragment();
                setFragment(walletFragment);

                break;

            case 4:

                StatsFragment statsFragment = new StatsFragment();
                setFragment(statsFragment);

                break;

            default:

                break;

        }
    }
}
