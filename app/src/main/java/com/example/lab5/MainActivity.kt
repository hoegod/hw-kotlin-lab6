package com.example.lab5

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class azMainActivity : AppCompatActivity() {
    @Override
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(view: View?) {
                val dialog: AlertDialog.Builder = Builder(this@MainActivity)
                dialog.setTitle("請選擇功能")
                dialog.setMessage("請根據下方按鈕選擇要顯示的物件")
                dialog.setNeutralButton("取消", object : OnClickListener() {
                    @Override
                    fun onClick(dialog: DialogInterface?, i: Int) {
                        Toast.makeText(this@MainActivity, "dialog關閉", Toast.LENGTH_SHORT).show()
                    }
                })
                dialog.setNegativeButton("自定義Toast", object : OnClickListener() {
                    fun onClick(dialogInterface: DialogInterface?, i: Int) {
                        showToast()
                    }
                })
                dialog.setPositiveButton("顯示list", object : OnClickListener() {
                    @Override
                    fun onClick(dialog: DialogInterface?, i: Int) {
                        showListDialog()
                    }
                })
                dialog.show()
            }
        })
    }

    private fun showToast() {
        val toast = Toast(this@MainActivity)
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.setDuration(Toast.LENGTH_SHORT)
        val inflater: LayoutInflater = getLayoutInflater()
        val layout: View = inflater.inflate(
            R.layout.custom_toast, findViewById(R.id.custom_toast_root) as ViewGroup?
        )
        toast.setView(layout)
        toast.show()
    }

    private fun showListDialog() {
        val list = arrayOf("message1", "message2", "message3", "message4", "message5")
        val dialog_list: AlertDialog.Builder = Builder(this@MainActivity)
        dialog_list.setTitle("使用LIST呈現")
        dialog_list.setItems(list, object : OnClickListener() {
            @Override
            fun onClick(dialog: DialogInterface?, i: Int) {
                Toast.makeText(
                    this@MainActivity, "你還得是" + list[i], Toast.LENGTH_SHORT
                ).show()
            }
        })
        dialog_list.show()
    }
}