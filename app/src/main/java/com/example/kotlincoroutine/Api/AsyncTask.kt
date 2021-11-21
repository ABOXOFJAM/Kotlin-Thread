package com.example.kotlincoroutine.Api

import android.os.AsyncTask
import android.util.Log
import com.example.kotlincoroutine.Date.CoroutineView.BaseCoView


public class AsyncTask(override var coView: BaseCoView?): AsyncTask<String, Int, String>(),BaseCoTask {


    override fun onPreExecute() {
        coView?.txt_loading?.setText("加载中")
        //执行前显示
    }

    override fun doInBackground(vararg p0: String?): String? {
        try{
            var count = 0
            var length = 1
            while(count < 99){
                count += length
                //可调用publishProgress() 显示进度，之后将执行onProgressUpdate()
                publishProgress(count)
                //模拟耗时任务
                Thread.sleep(50)
            }

        }catch (e: InterruptedException){
            e.printStackTrace()
        }
        return null
    }
    override fun onProgressUpdate(vararg values: Int?) {
        coView!!.progressBar?.setProgress(values[0]!!)//!!表示当等于null的时候抛出异常
        coView!!.txt_loading?.setText("loading..." + values[0] + "%")
    }

    /**
     * 接收线程任务执行结果，将执行结果显示到UI组件
     */
    override fun onPostExecute(result: String?) {
        //执行完毕后，则更新UI
        coView!!.txt_loading?.setText("加载完毕")
    }

    override fun onCancelled() {
        coView!!.txt_loading?.setText("已经取消")
        coView!!.progressBar?.setProgress(0)
    }
    //实现baseTask的方法
    override fun start() {
        Log.d("START_THREAD_TASK","开始调用AsyncTask方法")
        this.execute()

    }

    override fun cancel() {
        this.cancel(true)
    }

}
