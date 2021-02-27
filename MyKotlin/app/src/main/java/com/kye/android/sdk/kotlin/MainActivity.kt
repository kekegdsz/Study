package com.kye.android.sdk.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test()
        var num = sum(5, 7)
        Log.i(TAG, num?.toString())
        vars(1, 2, 3, 4, 5)
        //模版
        var a = 1
        val s1 = "a is $a"
        Log.i(TAG, s1)
        a = 2
        val s2 = "${s1.replace("is", "was")},but now is $a"
        Log.i(TAG, s2)
        //类型后面加?表示可为空
        var age: String? = "23"
        //抛出空指针异常
        val ages = age!!.toInt()
        //不做处理返回 null
        val ages1 = age?.toInt()
        //age为空返回-1
        val ages2 = age?.toInt() ?: -1
    }

    fun vars(vararg v: Int) {
        for (vt in v) {
            Log.i(TAG, vt.toString())
        }
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun test() {
        Log.i(TAG, "test")
    }
}