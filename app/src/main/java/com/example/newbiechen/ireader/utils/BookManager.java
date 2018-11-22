package com.example.newbiechen.ireader.utils;


import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by newbiechen on 17-5-20.
 * 处理书籍的工具类，配合PageFactory使用
 * 已弃用，
 */

public class BookManager {
    private static final String TAG = "BookManager";
    private String chapterName;
    private String bookId;
    private long position;
    private Map<String, Cache> cacheMap = new HashMap<>();
    private static volatile BookManager sInstance;

    public static BookManager getInstance() {
        if (sInstance == null) {
            synchronized (BookManager.class) {
                if (sInstance == null) {
                    sInstance = new BookManager();
                }
            }
        }
        return sInstance;
    }


    private void createCache() {
        //创建Cache
        if (!cacheMap.containsKey(chapterName)) {
            Cache cache = new Cache();
            File file = getBookFile(bookId, chapterName);
            //TODO:数据加载默认utf-8(以后会增加判断),FileUtils采用Reader获取数据的，可能用byte会更好一点
            char[] array = FileUtils.getFileContent(file).toCharArray();
            WeakReference<char[]> charReference = new WeakReference<char[]>(array);
            cache.size = array.length;
            cache.data = charReference;
            cacheMap.put(chapterName, cache);
        }
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public long getPosition() {
        return position;
    }


    //获取章节的内容
    public char[] getContent() {
        if (cacheMap.size() == 0) {
            return new char[1];
        }
        char[] block = cacheMap.get(chapterName).getData().get();
        if (block == null) {
            File file = getBookFile(bookId, chapterName);
            block = FileUtils.getFileContent(file).toCharArray();
            Cache cache = cacheMap.get(chapterName);
            cache.data = new WeakReference<char[]>(block);
        }
        return block;
    }


    /**
     * 创建或获取存储文件
     *
     * @param folderName
     * @param fileName
     * @return
     */
    public static File getBookFile(String folderName, String fileName) {
        return FileUtils.getFile(Constant.BOOK_CACHE_PATH + folderName
                + File.separator + fileName + FileUtils.SUFFIX_NB);
    }

    public static long getBookSize(String folderName) {
        return FileUtils.getDirSize(FileUtils
                .getFolder(Constant.BOOK_CACHE_PATH + folderName));
    }

    /**
     * 根据文件名判断是否被缓存过 (因为可能数据库显示被缓存过，但是文件中却没有的情况，所以需要根据文件判断是否被缓存
     * 过)
     *
     * @param folderName : bookId
     * @param fileName:  chapterName
     * @return
     */
    public static boolean isChapterCached(String folderName, String fileName) {
        File file = new File(Constant.BOOK_CACHE_PATH + folderName
                + File.separator + fileName + FileUtils.SUFFIX_NB);
        return file.exists();
    }

    public class Cache {
        private long size;
        private WeakReference<char[]> data;

        public WeakReference<char[]> getData() {
            return data;
        }

        public void setData(WeakReference<char[]> data) {
            this.data = data;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }
    }
}
