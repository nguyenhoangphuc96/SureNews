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

import com.lacviet.surenews.Adapter.HomeTabRCVAdapter;
import com.lacviet.surenews.Model.HomeNewsModel;
import com.lacviet.surenews.R;

import java.util.ArrayList;
import java.util.List;

public class TabHomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private HomeTabRCVAdapter mAdapter;
    private List<HomeNewsModel> listHomeNews;
    public TabHomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_home,container,false);
        addControl(view);
        showDataToRecyclerView();
        addData();

        return view;
    }

    private void addData() {
        listHomeNews = new ArrayList<>();
        listHomeNews.add(new HomeNewsModel(1,"Colombia dập tắt hy vọng đi tiếp của Ba Lan",
                "Ramadel Falcao cùng các đồng đội giành chiến thắng 3-0 trong loạt trận thứ hai của bảng H World Cup 2018 tối 24/6.",
                "https://i-thethao.vnecdn.net/2018/06/25/4D98897F000005785880293imagea2-3893-8239-1529885030_500x300.jpg",
                "2h trước"));
        listHomeNews.add(new HomeNewsModel(2,"Petit: 'Messi không có tố chất thủ lĩnh như Ronaldo'",
                "Danh thủ Barca, Emmanuel Petit cho rằng Messi là cầu thủ thiên tài, nhưng không đủ mạnh mẽ để sắm vai thủ lĩnh ở cấp đội tuyển quốc gia.",
                "https://i-thethao.vnecdn.net/2018/06/24/a0-7735-1529831495.jpg",
                "3h trước"));
        listHomeNews.add(new HomeNewsModel(3,"Những chỉ số định đoạt vị trí ở vòng bảng World Cup 2018",
                "Điểm số chơi đẹp dựa trên thẻ phạt là chỉ số đứng thứ năm để phân hạng các đội tuyển ở vòng bảng. ",
                "https://i-thethao.vnecdn.net/2018/06/23/Untitled-1-3359-1529771336_180x108.jpg",
                "4h trước"));
        listHomeNews.add(new HomeNewsModel(4,"Colombia dập tắt hy vọng đi tiếp của Ba Lan",
                "Ramadel Falcao cùng các đồng đội giành chiến thắng 3-0 trong loạt trận thứ hai của bảng H World Cup 2018 tối 24/6.",
                "https://i-thethao.vnecdn.net/2018/06/25/a0-6799-1529891561_500x300.jpg",
                "24/6/2018"));
        listHomeNews.add(new HomeNewsModel(5,"Colombia dập tắt hy vọng đi tiếp của Ba Lan",
                "Ramadel Falcao cùng các đồng đội giành chiến thắng 3-0 trong loạt trận thứ hai của bảng H World Cup 2018 tối 24/6.",
                "https://i-thethao.vnecdn.net/2018/06/25/4D98897F000005785880293imagea2-3893-8239-1529885030_500x300.jpg",
                "23/6/2018"));
        listHomeNews.add(new HomeNewsModel(6,"Colombia dập tắt hy vọng đi tiếp của Ba Lan",
                "Ramadel Falcao cùng các đồng đội giành chiến thắng 3-0 trong loạt trận thứ hai của bảng H World Cup 2018 tối 24/6.",
                "https://i-thethao.vnecdn.net/2018/06/24/neymar-7352-1529784386_180x108.jpg",
                "2h trước"));
        listHomeNews.add(new HomeNewsModel(7,"Petit: 'Messi không có tố chất thủ lĩnh như Ronaldo'",
                "Danh thủ Barca, Emmanuel Petit cho rằng Messi là cầu thủ thiên tài, nhưng không đủ mạnh mẽ để sắm vai thủ lĩnh ở cấp đội tuyển quốc gia.",
                "https://i-thethao.vnecdn.net/2018/06/24/a0-7735-1529831495.jpg",
                "3h trước"));
        listHomeNews.add(new HomeNewsModel(8,"Những chỉ số định đoạt vị trí ở vòng bảng World Cup 2018",
                "Điểm số chơi đẹp dựa trên thẻ phạt là chỉ số đứng thứ năm để phân hạng các đội tuyển ở vòng bảng. ",
                "https://i-thethao.vnecdn.net/2018/06/23/Untitled-1-3359-1529771336_180x108.jpg",
                "4h trước"));
        listHomeNews.add(new HomeNewsModel(9,"Colombia dập tắt hy vọng đi tiếp của Ba Lan",
                "Ramadel Falcao cùng các đồng đội giành chiến thắng 3-0 trong loạt trận thứ hai của bảng H World Cup 2018 tối 24/6.",
                "https://i-thethao.vnecdn.net/2018/06/25/a0-6799-1529891561_500x300.jpg",
                "24/6/2018"));
        listHomeNews.add(new HomeNewsModel(10,"Colombia dập tắt hy vọng đi tiếp của Ba Lan",
                "Ramadel Falcao cùng các đồng đội giành chiến thắng 3-0 trong loạt trận thứ hai của bảng H World Cup 2018 tối 24/6.",
                "https://i-thethao.vnecdn.net/2018/06/24/neymar-7352-1529784386_180x108.jpg",
                "23/6/2018"));
        mAdapter.updateAnswers(listHomeNews);

    }

    private void addControl(View view) {
        recyclerView = view.findViewById(R.id.rcvTabHome);
    }

    private void showDataToRecyclerView() {
        mAdapter = new HomeTabRCVAdapter(getContext(), new ArrayList<HomeNewsModel>(0), new HomeTabRCVAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {

            }
        });
        /*RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);*/
        //GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        //recyclerView.setLayoutManager(layoutManager);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        /*EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {

            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (isFilter) {
                    showMoreResultByStuffId(page, size, stuffId);
                } else {
                    loadMoreAnswers(page, size);

                }
            }
        };
        recyclerView.addOnScrollListener(scrollListener);*/
    }
}
