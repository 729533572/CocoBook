package com.copasso.cocobook.model.bean.packages;

import com.copasso.cocobook.model.bean.BaseBean;
import com.copasso.cocobook.model.bean.BookTagBean;

import java.util.List;

/**
 * Created by zhouas666 on 18-2-1.
 */

public class BookTagPackage extends BaseBean {

    private List<BookTagBean> data;

    public List<BookTagBean> getData() {
        return data;
    }

    public void setData(List<BookTagBean> data) {
        this.data = data;
    }


}
