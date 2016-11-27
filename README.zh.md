# AutoFinder

在 Android 上自动 findViewById.

## 英文太挫没有表述出来的内容

Butterknife 已经足够好了，但是有时仅仅写个 Demo 用它感觉配置起来很麻烦。想省事又不在乎效率的话，约定优于配置和运行时反射还是方便一些，所以花了一个小时造了这么个有点多余的轮子。

另外，不建议在正式项目中使用（我自己都不用）。

[English](README.md)

## 用法

一个 id 为 hello_finder 的 TextView

```xml
<!-- avoid other attrs-->
<TextView
    android:id="@+id/hello_finder"/> 
```

和一个 Activity:

```java
class AutoActivity extends Activity {

  TextView hello_finder; // 默认使用变量名去寻找 view 中的 id

  onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.id.layout);
    
    // 只要做下面一行代码
    AutoFinder.find(this);
    // 绑定就完成了
    
    hello_finder.setText("found it.");
  }
}
```

## 其他细节

1. 使用运行时注解实现，效率可能不高
2. 可以使用自定义的匹配器。默认使用变量名去寻找 id 完全相符的 view，你也可以使用内置的[CamelCaseNameMatcher](library/src/main/java/com/twiceyuan/autofinder/CamelCaseNameMatcher.java) 来根据变量名 'mTvName' 匹配到 id 为 'tv_name' 的 view。或者实现你自己想要的匹配器。

## 许可

[Apache License Version 2.0](LICENSE)
