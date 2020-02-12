package com.gifviewer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;


/**
 * @author Abhijit Rao Created on 11/02/2020.
 */
public class GifViewer extends ImageView {

    private AttributeSet attrs;
    private int styleAttr;
    private Context mContext;

    private static final int DEFAULT_MOVIEW_DURATION = 1000;
    private int mMovieResourceId;
    private Movie mMovie;
    private long mMovieStart = 0;
    private int mCurrentAnimationTime = 0;

    public GifViewer(Context context) {
        super(context);
        initView();
    }

    public GifViewer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.attrs = attrs;
        initView();
    }

    public GifViewer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        this.attrs = attrs;
        this.styleAttr = defStyleAttr;
        initView();
    }


    @SuppressLint("Recycle")
    private void initView() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        TypedArray arr = mContext.obtainStyledAttributes(attrs, R.styleable.GifViewer, styleAttr, 0);

        int imageFile = arr.getResourceId(R.styleable.GifViewer_srcGif, 0);
        if (imageFile != 0) {
            setImageResource(imageFile);
        }

    }

    public void setImageResource(int mvId) {
        this.mMovieResourceId = mvId;
        mMovie = Movie.decodeStream(getResources().openRawResource(mMovieResourceId));
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mMovie != null) {
            setMeasuredDimension(mMovie.width(), mMovie.height());
        } else {
            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mMovie != null) {
            updateAnimtionTime();
            drawGif(canvas);
            invalidate();
        } else {
            drawGif(canvas);
        }
    }

    private void updateAnimtionTime() {
        long now = android.os.SystemClock.uptimeMillis();

        if (mMovieStart == 0) {
            mMovieStart = now;
        }
        int dur = mMovie.duration();
        if (dur == 0) {
            dur = DEFAULT_MOVIEW_DURATION;
        }
        mCurrentAnimationTime = (int) ((now - mMovieStart) % dur);
    }

    private void drawGif(Canvas canvas) {
        mMovie.setTime(mCurrentAnimationTime);
        mMovie.draw(canvas, 0, 0);
        canvas.restore();
    }
}