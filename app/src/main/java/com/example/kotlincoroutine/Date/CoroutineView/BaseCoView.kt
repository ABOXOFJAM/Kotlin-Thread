package com.example.kotlincoroutine.Date.CoroutineView

import android.widget.ProgressBar
import android.widget.TextView

/**
 * 里氏替换原则
 */
public abstract class BaseCoView{
    public var txt_loading:TextView ? = null
    public var progressBar:ProgressBar ? = null
    constructor(textView:TextView,progressBar: ProgressBar){
        this.txt_loading = textView
        this.progressBar = progressBar
    }


}