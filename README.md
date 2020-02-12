# GifViewer

Library for playing gifs on Android

Simple android view to display gifs efficiently. 

<p align="center">
  <img src="https://raw.githubusercontent.com/appsfeature/gif-viewer/master/screenshots/sample1.gif" alt="Preview 1" width="350" /> 
  <img src="https://raw.githubusercontent.com/appsfeature/gif-viewer/master/screenshots/sample2.gif" alt="Preview 2" width="350" />  
</p>

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

#### [![](https://jitpack.io/v/appsfeature/gif-viewer.svg)](https://jitpack.io/#appsfeature/gif-viewer)
```gradle  

dependencies {
    implementation 'com.github.appsfeature:gif-viewer:x.y'
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
1. http://appsfeature.com 
