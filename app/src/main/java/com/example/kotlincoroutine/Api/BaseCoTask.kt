package com.example.kotlincoroutine.Api

import com.example.kotlincoroutine.Date.CoroutineView.BaseCoView


public interface BaseCoTask{
    var coView : BaseCoView?
    //开始执行需求
    public fun start()
    //取消需求
    public fun cancel()
}