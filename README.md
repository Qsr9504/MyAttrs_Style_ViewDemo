# MyAttrs_Style_ViewDemo
自定义组合控件+自定义属性+自定义style笔记Demo

##自定义属性步骤
###1.创建res/attrs.xml文件
	
	<resources>
    <!--此处的自定义属性的name必须和自定义的view类名一致-->
    <declare-styleable name="MyFooterTab">
        <attr name="footerPic" format="string"/>
        <attr name="footerText" format="string"/>
    </declare-styleable>
	</resources>
	
**注意1：此处的name必须和自定义的view的类名一致**</br>
**注意2：此处format有很多种匹配类型，可以设置多值**

###2.自定义控件在xml中引用，并使用自定义属性

	<com.qsr.myattrs_style_viewdemo.ui.MyFooterTab
	footer:footerPic="@string/footer_pic"
        footer:footerText="@string/footer_name"
        android:id="@+id/myFooterView"
        style="@style/MyFooterTab"
        />
        
**注意.添加属性引用标识：xmlns:footer="http://schemas.android.com/apk/res-auto"**

###3.自定义控件代码中获取xml中设置的文本
```java
//获取到自定义属性
TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.MyFooterTab);
//取出相应信息
String pic = ta.getString(R.styleable.MyFooterTab_footerPic);
String text = ta.getString(R.styleable.MyFooterTab_footerText);
//把ta回收
ta.recycle();
```

--------
**注意：必须记得将ta回收。ta.recycle();方便系统回收重用**
##自定义style使用
###1.在res/style.xml文件中定义一个新的style
```javascript
    <style name="MyFooterTab">
        <item name="android:layout_height">wrap_content</item>
        <item name="android:layout_width">wrap_content</item>
    </style>
```
###2.在xml文件中调用该style
```javascript
<com.qsr.myattrs_style_viewdemo.ui.MyFooterTab
        footer:footerPic="@string/footer_pic"
        footer:footerText="@string/footer_name"
        android:id="@+id/myFooterView"
        style="@style/MyFooterTab"
        />
```
##自定义组合控件
###1.自定义一个xml文件，作为组合控件的布局</br>（此处使用一个IconFontTextView自定义控件作为子控件）
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:orientation="vertical"
              android:layout_width="match_parent"
              android:layout_height="match_parent">
    <com.qsr.myattrs_style_viewdemo.ui.IconFontTextView
        android:id="@+id/myviewIcon"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
    <TextView
        android:id="@+id/myviewTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
</LinearLayout>
```
###2.新建一个java文件，并继承LinearLayout作为父类控件
```java
public class MyFooterTab extends LinearLayout{
}
```
#####1）实现其中三个构造函数
```java
	public MyFooterTab(Context context) {
		super(context);
}

	public MyFooterTab(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context,attrs);
	}

	public MyFooterTab(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView(context,attrs);
	}
```
#####2)initView中，添加布局以及获取其中控件
```java
private void initView(Context context, AttributeSet attrs) {
	if (view == null) {
		view = View.inflate(context, R.layout.ui_footer_tab, null);
		addView(view);
	}
	tabPic = (IconFontTextView) view.findViewById(R.id.tab_pic);
	tabText = (TextView) view.findViewById(R.id.tab_text);
}
```
**注意：必须要addView(),将当前布局添加到父类布局中**</br>
