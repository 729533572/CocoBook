package com.thmub.cocobook.presenter;

import com.thmub.cocobook.model.bean.BookSearchBean;
import com.thmub.cocobook.model.local.BookRepository;
import com.thmub.cocobook.model.server.RemoteRepository;
import com.thmub.cocobook.presenter.contract.SearchContract;
import com.thmub.cocobook.base.RxPresenter;
import com.thmub.cocobook.utils.LogUtils;
import com.thmub.cocobook.utils.RxUtils;

import io.reactivex.disposables.Disposable;

/**
 * Created by zhouas666 on 17-6-2.
 * 搜书presenter
 */

public class SearchPresenter extends RxPresenter<SearchContract.View>
        implements SearchContract.Presenter{

    private static final String TAG = "SearchPresenter";

    @Override
    public void searchHotWord() {
        addDisposable(RemoteRepository.getInstance()
                .getHotWords()
                .compose(RxUtils::toSimpleSingle)
                .subscribe(
                        bean -> {
                            mView.finishHotWords(bean);
                        },
                        e -> {
                            LogUtils.e(e);
                        }
                ));
    }

    @Override
    public void searchKeyWord(String query) {
        addDisposable(RemoteRepository.getInstance()
                .getKeyWords(query)
                .compose(RxUtils::toSimpleSingle)
                .subscribe(
                        bean -> {
                            mView.finishKeyWords(bean);
                        },
                        e -> {
                            LogUtils.e(e);
                        }
                ));
    }

    @Override
    public void searchBook(String query) {
        addDisposable(RemoteRepository.getInstance()
                .getSearchBooks(query)
                .compose(RxUtils::toSimpleSingle)
                .subscribe(
                        bean -> {
                            mView.finishBooks(bean);
                        },
                        e -> {
                            LogUtils.e(e);
                            mView.errorBooks();
                        }
                ));
    }

    @Override
    public void searchRecord() {
        mView.finishRecord(BookRepository.getInstance().getSearchRecord());
    }

    @Override
    public void addSearchRecord(BookSearchBean bean) {
        BookRepository.getInstance().saveBookSearchRecord(bean);
        mView.finishAddRecord(bean);
    }
}
