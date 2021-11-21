package com.example.kotlincoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.kotlincoroutine.Api.BaseCoTask
import com.example.kotlincoroutine.Api.RunOnUIThread
import com.example.kotlincoroutine.Api.ViewPost
import com.example.kotlincoroutine.Date.CoroutineView.BaseCoView
import com.example.kotlincoroutine.Date.CoroutineView.MainCoView


public class MainActivity : AppCompatActivity() {
    private var mTask:BaseCoTask ?= null
    private var mCoView: BaseCoView?= null
    private var load: Button ?= null
    private var cancel: Button ?= null
    private var text: TextView ?= null
    private var progressBar: ProgressBar ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //创建AsyncTask子类的实例对象
        initUI()
        initVM()

    }

    private fun initVM() {
         mCoView = MainCoView(text!!,progressBar!!)
        /**
         * 只要在这里修改对应的类就可以了
         */
        mTask = ViewPost(mCoView)

    }

    private fun initUI() {
        load = findViewById(R.id.btn_load)
        cancel = findViewById(R.id.btn_cancel)
        text = findViewById(R.id.txt_load)
        progressBar = findViewById(R.id.progressBar)
        load?.setOnClickListener{
            //必须中UI线程(主线程)中调用
            //传入需要使用的方法对象的实例
            mTask?.start()
        }
        cancel?.setOnClickListener {
            //取消一个正在执行的任务
            mTask?.cancel()
        }


    }
}