package com.example.newbiechen.ireader.presenter.contract;

import com.example.newbiechen.ireader.model.bean.packages.SearchBookPackage;
import com.example.newbiechen.ireader.ui.base.BaseContract;

import java.util.List;

/**
 * Created by newbiechen on 17-6-2.
 */

public interface SearchContract extends BaseContract {

    interface View extends BaseView {

        void finishBooks(List<SearchBookPackage.BooksBean> books);

        void errorBooks();
    }

    interface Presenter extends BasePresenter<View> {
        void searchHotWord();

        //搜索书籍
        void searchBook(String query);
    }
}
