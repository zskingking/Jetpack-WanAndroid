package com.zs.zs_jetpack.ui.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zs.base_library.base.BaseViewModel
import com.zs.zs_jetpack.bean.ArticleListBean

/**
 * des 首页
 * @date 2020/6/22
 * @author zs
 */
class HomeVM : BaseViewModel() {

    private val repo by lazy { HomeRepo(viewModelScope,errorLiveData) }
    /**
     * 文章列表
     */
    val articleList = MutableLiveData<MutableList<ArticleListBean>>()

    /**
     * banner
     */
    val banner = MutableLiveData<MutableList<BannerBean>>()


    /**
     * 获取首页文章列表， 包括banner
     */
    fun getArticleList(isRefresh:Boolean) {
        repo.getArticleList(isRefresh,articleList,banner)
    }

    fun collect(id:Int){
        repo.collect(id,articleList)
    }

    /**
     * 取消收藏
     */
    fun unCollect(id:Int){
        repo.unCollect(id,articleList)
    }

}