package com.lacviet.surenews.MainScreenTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lacviet.surenews.Adapter.HomeTabRCVAdapter;
import com.lacviet.surenews.Model.HomeNewsModel;
import com.lacviet.surenews.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class TabRelicsFragment extends Fragment {
    private RecyclerView recyclerView;
    private HomeTabRCVAdapter mAdapter;
    private ArrayList<HomeNewsModel> listHomeNews;
    ProgressBar pbTabhome;
    //
    String url = "http://baclieu.gov.vn/gioithieu/lists/posts/post.aspx?Source=%2fgioithieu&Category=Di+t%C3%ADch+l%E1%BB%8Bch+s%E1%BB%AD+v%C3%A0+ki%E1%BA%BFn+tr%C3%BAc&Mode=2";
    String baseSrcUrl = "http://baclieu.gov.vn/";
    public TabRelicsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_relics, container, false);
        addControl(view);
        showDataToRecyclerView();
        loadData();
        return view;
    }

    private void loadData() {
        listHomeNews = new ArrayList<>();
        //
        Toast.makeText(getActivity(), "bbbbbbbbbbbbb", Toast.LENGTH_SHORT).show();
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(), "on show", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(stringRequest);
    }


    private void addControl(View view) {
        recyclerView = view.findViewById(R.id.rcvTabRelics);
        pbTabhome =view.findViewById(R.id.pbTabRelics);
    }

    private void showDataToRecyclerView() {
        mAdapter = new HomeTabRCVAdapter(getContext(), new ArrayList<HomeNewsModel>(0), new HomeTabRCVAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {

            }
        });
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

    }
}