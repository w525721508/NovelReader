package com.example.newbiechen.ireader.model.local;

import com.example.newbiechen.ireader.model.bean.AuthorBean;
import com.example.newbiechen.ireader.model.bean.DownloadTaskBean;

import java.util.List;

/**
 * Created by newbiechen on 17-4-28.
 */

public interface GetDbHelper {

    AuthorBean getAuthor(String id);

    /******************************/
    List<DownloadTaskBean> getDownloadTaskList();
}
