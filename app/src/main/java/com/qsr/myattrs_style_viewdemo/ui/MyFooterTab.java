package com.qsr.myattrs_style_viewdemo.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qsr.myattrs_style_viewdemo.R;

/**************************************
 * FileName : com.qsr.myattrs_style_viewdemo.ui
 * Author : qsr
 * Time : 2017/1/6 11:26
 * Description : 自定义的一个组合控件
 **************************************/
/*
 public View (Context context)是在java代码创建视图的时候被调用，如果是从xml填充的视图，就不会调用这个
 public View (Context context, AttributeSet attrs)这个是在xml创建但是没有指定style的时候被调用
 public View (Context context, AttributeSet attrs, int defStyle)
 */
public class MyFooterTab extends LinearLayout{
	private View view;
	private IconFontTextView fontTextView;
	private TextView textView;
	//如果使用自定义属性用不到第一个构造函数
//	public MyFooterTab(Context context) {
//		super(context);
//	}

	public MyFooterTab(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context,attrs);
	}

	public MyFooterTab(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView(context,attrs);
	}
	private void initView(Context context, AttributeSet attrs) {
		//首先加载布局
		view = View.inflate(context,R.layout.my_view,null);
		//取出对应的控件
		fontTextView = (IconFontTextView) view.findViewById(R.id.myviewIcon);
		textView = (TextView) view.findViewById(R.id.myviewTextView);


		//获取到自定义属性
		TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.MyFooterTab);
		//取出相应信息
		String pic = ta.getString(R.styleable.MyFooterTab_footerPic);
		String text = ta.getString(R.styleable.MyFooterTab_footerText);
		//把ta回收
		ta.recycle();

		Log.e("取出xml中的值",pic + "---" + text);

		//把值设置到界面
		fontTextView.setIcon(pic);
		textView.setText(text);

		//设置当前布局为垂直
		this.setOrientation(LinearLayout.VERTICAL);
		//把布局添加到父类LinearLayout布局上
		this.addView(view);
		//设置当前组合控件背景颜色，方便观察
		this.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
	}
}
