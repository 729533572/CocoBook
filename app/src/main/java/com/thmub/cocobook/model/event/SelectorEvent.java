package com.thmub.cocobook.model.event;

import com.thmub.cocobook.model.type.BookDistillate;
import com.thmub.cocobook.model.type.BookSortType;
import com.thmub.cocobook.model.type.BookType;

/**
 * Created by zhouas666 on 17-4-21.
 */

public class SelectorEvent {

    public BookDistillate distillate;

    public BookType type;

    public BookSortType sort;

    public SelectorEvent(BookDistillate distillate,
                         BookType type,
                         BookSortType sort) {
        this.distillate = distillate;
        this.type = type;
        this.sort = sort;
    }
}
