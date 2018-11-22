package com.example.newbiechen.ireader.presenter.contract;

import com.example.newbiechen.ireader.model.bean.BookDetailBean;
import com.example.newbiechen.ireader.model.bean.CollBookBean;
import com.example.newbiechen.ireader.ui.base.BaseContract;


/**
 * Created by newbiechen on 17-5-4.
 */

public interface BookDetailContract {
    interface View extends BaseContract.BaseView {
        void finishRefresh(BookDetailBean bean);

        void waitToBookShelf();

        void errorToBookShelf();

        void succeedToBookShelf();
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void refreshBookDetail(String bookId);

        //添加到书架上
        void addToBookShelf(CollBookBean collBook);
    }
}
