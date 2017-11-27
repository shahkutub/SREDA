package com.sadi.sreda.fragement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sadi.sreda.R;
import com.sadi.sreda.adapter.ReGenerationAdapter;
import com.sadi.sreda.adapter.ReGenerationInfo;
import com.sadi.sreda.utils.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.*;


/**
 * Created by User on 7/20/2016.
 */
public class RegenerationReportFragement extends BaseFragment {
    Context con;
    RecyclerView recyclerView;
   // View view;
    private RecyclerView recycler_view;
    private ReGenerationAdapter adapter;
    private List<ReGenerationInfo> reGenerationInfos = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        con = getActivity();
        Toast.makeText(con, "onCreateView", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.report_regeneration, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        con = getActivity();
        Toast.makeText(con, "onViewCreated", Toast.LENGTH_SHORT).show();
        ReGenerationInfo h1 = new ReGenerationInfo();
        ReGenerationInfo h2 = new ReGenerationInfo();
        h2.setProjectName("Full Name");
        h2.setCapacity("2334r");
        h2.setCompletionDate("12/12/2017");
        h2.setFinance("japan");
        h2.setLocation("rup pur");
        h2.setPresentStatus("On working");
        h2.setTechnologyType("Solar");


        ReGenerationInfo h3 = new ReGenerationInfo();
        h3.setProjectName("Full Name");
        h3.setCapacity("2334r");
        h3.setCompletionDate("12/12/2017");
        h3.setFinance("japan");
        h3.setLocation("rup pur");
        h3.setPresentStatus("On working");
        h3.setTechnologyType("Solar");

        ReGenerationInfo h4 = new ReGenerationInfo();
        h4.setProjectName("Full Name");
        h4.setCapacity("2334r");
        h4.setCompletionDate("12/12/2017");
        h4.setFinance("japan");
        h4.setLocation("rup pur");
        h4.setPresentStatus("On working");
        h4.setTechnologyType("Solar");


        ReGenerationInfo h5 = new ReGenerationInfo();
        h5.setProjectName("Full Name");
        h5.setCapacity("2334r");
        h5.setCompletionDate("12/12/2017");
        h5.setFinance("japan");
        h5.setLocation("rup pur");
        h5.setPresentStatus("On working");
        h5.setTechnologyType("Solar");


        ReGenerationInfo h6 = new ReGenerationInfo();
        h6.setProjectName("Full Name");
        h6.setCapacity("2334r");
        h6.setCompletionDate("12/12/2017");
        h6.setFinance("japan");
        h6.setLocation("rup pur");
        h6.setPresentStatus("On working");
        h6.setTechnologyType("Solar");


//        ReGenerationInfo h7 = new ReGenerationInfo();
//        ReGenerationInfo h8 = new ReGenerationInfo();
//
//        ReGenerationInfo h9 = new ReGenerationInfo();
//        ReGenerationInfo h10 = new ReGenerationInfo();
//        ReGenerationInfo h11 = new ReGenerationInfo();
//        ReGenerationInfo h12 = new ReGenerationInfo();

        reGenerationInfos.add(h1);
        reGenerationInfos.add(h2);
        reGenerationInfos.add(h3);
        reGenerationInfos.add(h4);

        reGenerationInfos.add(h5);
        reGenerationInfos.add(h6);
//        reGenerationInfos.add(h7);
//        reGenerationInfos.add(h8);
//
//        reGenerationInfos.add(h9);
//        reGenerationInfos.add(h10);
//        reGenerationInfos.add(h11);
//        reGenerationInfos.add(h12);

        recycler_view = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), VERTICAL, false);
        recycler_view.setLayoutManager(layoutManager);
        //recycler_view.addItemDecoration(new SimpleDividerItemDecoration(con));
        adapter = new ReGenerationAdapter(reGenerationInfos,R.layout.raw_regen_report,con);

        recycler_view.setAdapter(adapter);;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        con = getActivity();
        Toast.makeText(con, "onActivityCreated", Toast.LENGTH_SHORT).show();

    }


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Toast.makeText(con, "onAttach", Toast.LENGTH_SHORT).show();
//    }


//    @Override
//    public void onDetach() {
//        super.onDetach();
//        Toast.makeText(con, "onDetach", Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(con, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(con, "onDestroyView", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(con, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(con, "onStart", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(con, "onStop", Toast.LENGTH_SHORT).show();
    }


}
