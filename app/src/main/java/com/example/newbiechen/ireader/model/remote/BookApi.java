package com.example.newbiechen.ireader.model.remote;

import com.example.newbiechen.ireader.model.bean.BookDetailBean;
import com.example.newbiechen.ireader.model.bean.packages.BillBookPackage;
import com.example.newbiechen.ireader.model.bean.packages.BillboardPackage;
import com.example.newbiechen.ireader.model.bean.packages.BookChapterPackage;
import com.example.newbiechen.ireader.model.bean.packages.BookListDetailPackage;
import com.example.newbiechen.ireader.model.bean.packages.BookListPackage;
import com.example.newbiechen.ireader.model.bean.packages.BookTagPackage;
import com.example.newbiechen.ireader.model.bean.packages.ChapterInfoPackage;
import com.example.newbiechen.ireader.model.bean.packages.CommentsPackage;
import com.example.newbiechen.ireader.model.bean.packages.HotCommentPackage;
import com.example.newbiechen.ireader.model.bean.packages.HotWordPackage;
import com.example.newbiechen.ireader.model.bean.packages.RecommendBookListPackage;
import com.example.newbiechen.ireader.model.bean.packages.SearchBookPackage;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by newbiechen on 17-4-20.
 */

public interface BookApi {
    /**
     * 获取书籍的章节总列表
     *
     * @param bookId
     * @param view   默认参数为:chapters
     * @return
     */
    @GET("/mix-atoc/{bookId}")
    Single<BookChapterPackage> getBookChapterPackage(@Path("bookId") String bookId, @Query("view") String view);

    /**
     * 章节的内容
     * 这里采用的是同步请求。
     *
     * @param url
     * @return
     */
    @GET("http://chapter2.zhuishushenqi.com/chapter/{url}")
    Single<ChapterInfoPackage> getChapterInfoPackage(@Path("url") String url);

    /**
     * 获取主题书单标签列表
     *
     * @return
     */
    @GET("/book-list/tagType")
    Single<BookTagPackage> getBookTagPackage();

    /**
     * 获取书单详情
     *
     * @return
     */
    @GET("/book-list/{bookListId}")
    Single<BookListDetailPackage> getBookListDetailPackage(@Path("bookListId") String bookListId);


    /*************************书籍详情**********************************/
    /**
     * 书籍详情
     *
     * @param bookId
     * @return
     */
    @GET("/book/{bookId}")
    Single<BookDetailBean> getBookDetail(@Path("bookId") String bookId);


    /************************************搜索书籍******************************************************/
    @GET("/book/hot-word")
    Single<HotWordPackage> getHotWordPackage();


    /**
     * 书籍查询
     *
     * @param query:作者名或者书名
     * @return
     */
    @GET("/book/fuzzy-search")
    Single<SearchBookPackage> getSearchBookPackage(@Query("query") String query);
}
