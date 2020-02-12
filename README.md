# GifViewer

Library for playing gifs on Android
Simple android view to display gifs efficiently. 

## Setup Project

Add this to your project build.gradle

Project-level build.gradle (<project>/build.gradle):

``` gradle 
allprojects {
    repositories {
        google()
        jcenter() 
        maven { url 'https://jitpack.io' } 
    }
}
```

Add this to your project build.gradle

Module-level build.gradle (<module>/build.gradle): 

#### [![](https://jitpack.io/v/org.bitbucket.amitresearchdev/gif-viewer.svg)](https://jitpack.io/#org.bitbucket.amitresearchdev/gif-viewer)
```gradle  

dependencies {
    implementation 'org.bitbucket.amitresearchdev:gif-viewer:x.y'
} 
```


#### In your layout.xml file
```xml
   <com.gifviewer.GifViewer
       android:id="@+id/gif_view"
       android:layout_width="100dp"
       android:layout_height="100dp"
       app:srcGif="@drawable/hour_glass"  />

```

## -OR-

#### In your activity class
```java
       GifViewer gifViewer = findViewById(R.id.gif_view);
       gifViewer.setImageResource(R.drawable.hour_glass);
```


#### Useful Links:
1. https://console.developers.google.com 