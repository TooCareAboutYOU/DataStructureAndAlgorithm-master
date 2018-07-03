package com.datastructureandalgorithm.main;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private static final String TAG = "MainActivity";

    String[] date=new String[]{"双向链表"};
    private LinkedList<Integer> linkedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,date);
        setListAdapter(adapter);

        linkedList=new LinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3,101);
//        linkedList.remove(2);
        int size=linkedList.size();
        for (int i = 0; i < size; i++) {
            System.out.println("第"+(i+1)+"个数为："+linkedList.get(i));
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {
            case 0:{
                linkedList.removeAll();
                int size=linkedList.size();
                for (int i = 0; i < size; i++) {
                    System.out.println("----");
                }
                System.out.println("链表长度："+size);

                /** 作业练习：
                 * 1、手写一个单链表 ，并且实现单链表元素的逆置，即A1,A2,A3,...,An -> An,... A3,A2,A1 ,
                 *  算法的空间复杂度和时间复杂度尽可能的低。
                 * 2、手写双链表，实现增、删、改、查，同时与LinkedList系统源码对比异同点
                 * 3、对比ArrayList与LinkedList系统源码的优缺点
                 */
                break;
            }
        }
    }
}
