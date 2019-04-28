# FoldNavScrollLayout
### 使用NestedScrollingParent实现的导航栏滑动折叠效果的ViewGroup

![github](https://github.com/oneAcorn/FoldNavScrollLayout/blob/master/20190428_164505.gif)

### 一 引用方法

##### 1.在root build.gradle中加入

```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

##### 2.在项目的 build.gradle中加入

```gradle
dependencies {
	        implementation 'com.github.oneAcorn:FoldNavScrollLayout:1.0'
	}
```

### 二 使用方法

##### 1.在xml中声明(FoldNavScrollLayout内的View只是示例,只要id是对的就行)

```xml
<?xml version="1.0" encoding="utf-8"?>
<com.acorn.library.FoldNavScrollLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <RelativeLayout
        android:id="@id/fold_nav_layout"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:background="#ffffff"/>

    <android.support.design.widget.TabLayout
        android:id="@id/fold_tab_layout"
        android:layout_width="match_parent"
        android:layout_height="34dp"
        />

    <android.support.v4.view.ViewPager
        android:id="@id/fold_content_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />
</com.acorn.library.FoldNavScrollLayout>
```
###请注意,FoldNavScrollLayout内第一层childView需要至少有3个如下id的View存在
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <item name="fold_nav_layout" type="id"/>
    <item name="fold_tab_layout" type="id"/>
    <item name="fold_content_layout" type="id"/>
</resources>
```
作用分别是
fold_nav_layout 导航栏,拖动时根据方向显示/隐藏
fold_tab_layout 位置固定的View,不一定是TabLayout
fold_content_layout 可竖向滑动的View

##### 2.完成,就当它是个LinearLayout,该怎么用就怎么用
