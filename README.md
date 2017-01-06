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
**注意1：此处的name必须和自定义的view的类名一致**
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
    
    //获取到自定义属性
		TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.MyFooterTab);
		//取出相应信息
		String pic = ta.getString(R.styleable.MyFooterTab_footerPic);
		String text = ta.getString(R.styleable.MyFooterTab_footerText);
		//把ta回收
		ta.recycle();

------------
