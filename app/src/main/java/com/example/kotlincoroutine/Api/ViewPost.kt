package com.example.kotlincoroutine.Api

import android.util.Log
import com.example.kotlincoroutine.Date.CoroutineView.BaseCoView

public class ViewPost(override var coView: BaseCoView?) :BaseCoTask {
    var thread: Thread ?=null
    override fun start() {
        try {
            Log.d("START_THREAD_TASK","开始调用ViewPost方法")
            thread = Thread{
                //执行耗时操作
                var count = 0
                var length = 1
                while(count < 99){
                    count += length
                    //可调用publishProgress() 显示进度，之后将执行onProgressUpdate()
                    //模拟耗时任务
                        coView!!.progressBar?.post {
                            Log.d("START_THREAD_TASK","执行次数")
                            coView!!.progressBar?.setProgress(count)//!!表示当等于null的时候抛出异常
                        }
                        coView!!.txt_loading?.post{
                            coView!!.txt_loading?.setText("loading..." + count + "%")
                        }
                    Thread.sleep(50)
                    }

                }
            thread!!.start()
        }catch(e: InterruptedException){
            e.printStackTrace()
        }
    }

    override fun cancel() {
        thread?.interrupt()
        coView!!.txt_loading?.setText("已经取消")
        coView!!.progressBar?.setProgress(0)
    }
}