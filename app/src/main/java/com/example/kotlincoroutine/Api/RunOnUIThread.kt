package com.example.kotlincoroutine.Api

import android.app.Activity
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincoroutine.Date.CoroutineView.BaseCoView
import com.example.kotlincoroutine.Date.CoroutineView.MainCoView
import com.example.kotlincoroutine.MainActivity

public class RunOnUIThread(override var coView: BaseCoView?,var activity: Activity) :BaseCoTask {
    var thread:Thread ? = null
    override fun start() {
        try{
            Log.d("START_THREAD_TASK","开始调用RunOnUIThread方法")
            thread = Thread(Runnable {
                //执行耗时操作
                var count = 0
                var length = 1
                while(count < 99){
                    count += length
                    //可调用publishProgress() 显示进度，之后将执行onProgressUpdate()
                    //模拟耗时任务
                    activity.runOnUiThread{
                        coView!!.progressBar?.setProgress(count)//!!表示当等于null的时候抛出异常
                        coView!!.txt_loading?.setText("loading..." + count + "%")

                    }
                    Thread.sleep(50)
                }
            })
            thread!!.start()
        }catch (e: InterruptedException){
            e.printStackTrace()
        }

    }

    override fun cancel() {
        thread?.interrupt()
        coView!!.txt_loading?.setText("已经取消")
        coView!!.progressBar?.setProgress(0)
    }

}