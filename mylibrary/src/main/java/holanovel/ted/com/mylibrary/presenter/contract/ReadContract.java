package holanovel.ted.com.mylibrary.presenter.contract;


import java.util.List;

import holanovel.ted.com.mylibrary.BookChapterBean;
import holanovel.ted.com.mylibrary.TxtChapter;
import holanovel.ted.com.mylibrary.base.BaseContract;

/**
 * Created by newbiechen on 17-5-16.
 */

public interface ReadContract extends BaseContract {
    interface View extends BaseContract.BaseView {
        void showCategory(List<BookChapterBean> bookChapterList);
        void finishChapter();
        void errorChapter();
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void loadCategory(String bookId);
        void loadChapter(String bookId, List<TxtChapter> bookChapterList);
    }
}
