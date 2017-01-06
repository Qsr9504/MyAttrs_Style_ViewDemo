package com.qsr.myattrs_style_viewdemo.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.qsr.myattrs_style_viewdemo.app.App;


/**************************************
 * FileName : com.qsr.graduationpro.ui
 * Author : qsr
 * Time : 2017/1/4 23:25
 * Description : iconfont的图片资源
 **************************************/
public class IconFontTextView extends TextView{
	private Typeface iconfont;
	public IconFontTextView(Context context) {
		super(context);
		initView();
	}

	public IconFontTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public IconFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView();
	}

	private void initView() {
		iconfont = Typeface.createFromAsset(App.mContext.getAssets(), "iconfont/iconfont.ttf");
		this.setTypeface(iconfont);
	}
	public void setIcon(CharSequence text){
		this.setText(text);
		this.setTypeface(iconfont);
	}
}
