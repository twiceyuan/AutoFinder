# AutoFinder

Auto find view by field name on Android.

[中文](README.zh.md)

## Usage

there is a view that it's id like this:
```xml
<!-- avoid other attrs-->
<TextView
    android:id="@+id/hello_finder"/> 
```

and a activity:

```java
class AutoActivity extends Activity {

  TextView hello_finder; // default name matcher use field name to match view id

  onCreate(Bundle savedInstance) {
    super.onCreate(savedInstance);
    setContentView(R.id.layout);
    
    // Just do this
    AutoFinder.find(this);
    // Everything is done.
    
    hello_finder.setText("found it.");
  }
}
```

## Details

1. Implement by runtime reflection
2. Custom name matcher. Default matcher use field to find view, you can use [CamelCaseNameMatcher](library/src/main/java/com/twiceyuan/autofinder/CamelCaseNameMatcher.java) field name 'mTvName' to find view that its id is 'tv_name'. or other matcher rule you want to do.

## License

[Apache License Version 2.0](LICENSE)
