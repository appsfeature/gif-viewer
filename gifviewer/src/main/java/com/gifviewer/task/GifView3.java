//package com.gifviewer.task;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Canvas;
//import android.graphics.ImageDecoder;
//import android.graphics.Movie;
//import android.graphics.drawable.AnimatedImageDrawable;
//import android.graphics.drawable.Drawable;
//import android.os.Build;
//import android.util.AttributeSet;
//import android.view.View;
//
//import androidx.annotation.RequiresApi;
//import androidx.appcompat.widget.AppCompatImageView;
//
//import com.gifviewer.R;
//
//import java.util.concurrent.Callable;
//
///**
// * @author Abhijit Rao Created on 11/02/2020.
// */
//public class GifView3 extends AppCompatImageView {
//
//    private AttributeSet attrs;
//    private int styleAttr;
//    private Context mContext;
//
//    private static final int DEFAULT_MOVIEW_DURATION = 1000;
//    private int mMovieResourceId;
//    private Movie mMovie;
//    private long mMovieStart = 0;
//    private int mCurrentAnimationTime = 0;
//
//    public GifView3(Context context) {
//        super(context);
//        initView();
//    }
//
//    public GifView3(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        this.mContext = context;
//        this.attrs = attrs;
//        initView();
//    }
//
//    public GifView3(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        this.mContext = context;
//        this.attrs = attrs;
//        this.styleAttr = defStyleAttr;
//        initView();
//    }
//
//
//    @SuppressLint("Recycle")
//    private void initView() {
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//
//        TypedArray arr = mContext.obtainStyledAttributes(attrs, R.styleable.GifView, styleAttr, 0);
//
//        int imageFile = arr.getResourceId(R.styleable.GifView_srcGif, 0);
//        if (imageFile != 0) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//                loadGif(imageFile);
//            } else {
//                setImageResource(imageFile);
//            }
//        }
//
//    }
//
//    public void setImageResource(int mvId) {
//        this.mMovieResourceId = mvId;
//        mMovie = Movie.decodeStream(getResources().openRawResource(mMovieResourceId));
//        requestLayout();
//    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        if (mMovie != null) {
//            setMeasuredDimension(mMovie.width(), mMovie.height());
//        } else {
//            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
//        }
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        if (mMovie != null) {
//            updateAnimtionTime();
//            drawGif(canvas);
//            invalidate();
//        } else {
//            drawGif(canvas);
//        }
//    }
//
//    private void updateAnimtionTime() {
//        long now = android.os.SystemClock.uptimeMillis();
//
//        if (mMovieStart == 0) {
//            mMovieStart = now;
//        }
//        int dur = mMovie.duration();
//        if (dur == 0) {
//            dur = DEFAULT_MOVIEW_DURATION;
//        }
//        mCurrentAnimationTime = (int) ((now - mMovieStart) % dur);
//    }
//
//    private void drawGif(Canvas canvas) {
//        mMovie.setTime(mCurrentAnimationTime);
//        mMovie.draw(canvas, 0, 0);
//        canvas.restore();
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.P)
//    public void loadGif(int resId) {
//        final ImageDecoder.Source source = ImageDecoder.createSource(getResources(), resId);
//
//        new TaskRunner().executeAsync(new Callable<Drawable>() {
//            @Override
//            public Drawable call() throws Exception {
//                return ImageDecoder.decodeDrawable(source);
//            }
//        }, new TaskRunner.Callback<Drawable>() {
//            @Override
//            public void onComplete(Drawable drawable) {
//                setImageDrawable(drawable);
//                if (drawable instanceof AnimatedImageDrawable) {
//                    ((AnimatedImageDrawable) drawable).start();
//                }
//            }
//        });
//    }
//}