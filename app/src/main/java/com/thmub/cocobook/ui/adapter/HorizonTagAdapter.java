package com.thmub.cocobook.ui.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.thmub.cocobook.base.adapter.BaseRecyclerAdapter;
import com.thmub.cocobook.ui.adapter.holder.HorizonTagHolder;
import com.thmub.cocobook.base.adapter.IViewHolder;
import com.thmub.cocobook.base.adapter.BaseViewHolder;

/**
 * Created by zhouas666 on 18-2-2.
 */

public class HorizonTagAdapter extends BaseRecyclerAdapter<String> {
    private int currentSelected = 0;

    @Override
    protected IViewHolder<String> createViewHolder(int viewType) {
        return new HorizonTagHolder();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder,position);

        //配置点击事件改变状态
        IViewHolder iHolder = ((BaseViewHolder) holder).holder;
        HorizonTagHolder horizonTagHolder = (HorizonTagHolder) iHolder;
        if (position == currentSelected){
            horizonTagHolder.setSelectedTag();
        }
    }

    /***
     * 设定当前的点击事件
     * @param pos
     */
    public void setCurrentSelected(int pos){
        selectTag(pos);
    }

    @Override
    protected void onItemClick(View v, int pos) {
        super.onItemClick(v, pos);
        selectTag(pos);
    }

    private void selectTag(int position){
        currentSelected = position;
        notifyDataSetChanged();
    }
}
