package com.thmub.cocobook.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import com.thmub.cocobook.R;
import com.thmub.cocobook.base.BaseFragment;
import com.thmub.cocobook.base.adapter.BaseRecyclerAdapter;
import com.thmub.cocobook.model.bean.SectionBean;
import com.thmub.cocobook.model.type.FindType;
import com.thmub.cocobook.ui.activity.BookRankActivity;
import com.thmub.cocobook.ui.activity.BookListActivity;
import com.thmub.cocobook.ui.activity.BookSortActivity;
import com.thmub.cocobook.ui.adapter.SectionAdapter;
import com.thmub.cocobook.widget.itemdecoration.DividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by zhouas666 on 18-1-23.
 * 社区fragment
 */

public class DiscoverFragment extends BaseFragment implements BaseRecyclerAdapter.OnItemClickListener{

    @BindView(R.id.discover_rv_content)
    RecyclerView mRvContent;
    /***************************视图********************************/
    private SectionAdapter mAdapter;

    /***************************初始化********************************/
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void initWidget(Bundle savedInstanceState) {
        initAdapter();
    }

    private void initAdapter(){
        ArrayList<SectionBean> sections = new ArrayList<>();

        for (FindType type : FindType.values()){
            sections.add(new SectionBean(type.getTypeName(),type.getIconId()));
        }

        mAdapter = new SectionAdapter();
        mRvContent.setHasFixedSize(true);
        mRvContent.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvContent.addItemDecoration(new DividerItemDecoration(getContext()));
        mRvContent.setAdapter(mAdapter);
        mAdapter.addItems(sections);
    }

    @Override
    protected void initClick() {
        mAdapter.setOnItemClickListener(this);
    }

    /***************************事件处理********************************/
    @Override
    public void onItemClick(View view, int pos) {
        //根据类型，启动相应的Discussion区
        FindType type = FindType.values()[pos];
        Intent intent;
        //跳转
        switch (type){
            case TOP:
                intent = new Intent(getContext(),BookRankActivity.class);
                startActivity(intent);
                break;
            case SORT:
                intent = new Intent(getContext(), BookSortActivity.class);
                startActivity(intent);
                break;
            case TOPIC:
                intent = new Intent(getContext(), BookListActivity.class);
                startActivity(intent);
                break;
        }
    }
}
