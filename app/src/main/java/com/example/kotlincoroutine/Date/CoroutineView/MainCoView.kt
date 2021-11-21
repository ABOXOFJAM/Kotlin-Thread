package com.example.kotlincoroutine.Date.CoroutineView

import android.widget.ProgressBar
import android.widget.TextView

public class MainCoView(txt_loading: TextView, progressBar: ProgressBar) : BaseCoView(txt_loading,
    progressBar,) {
    /**
     * 可以在这里添加其他需要的组件
     * 因为开闭原则，对修改关闭对拓展开放
     */
}