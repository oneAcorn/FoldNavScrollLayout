package com.acorn.library;

/**
 * Created by acorn on 2019/10/19.
 */
public interface IFoldNavListener {
    /**
     * 开始执行折叠动画
     */
    void onNavFoldBegin();

    /**
     * 折叠完成
     */
    void onNavFoldFinish();

    /**
     * 开始执行展开动画
     */
    void onNavExpandBegin();

    /**
     * 展开完成
     */
    void onNavExpandFinish();
}
