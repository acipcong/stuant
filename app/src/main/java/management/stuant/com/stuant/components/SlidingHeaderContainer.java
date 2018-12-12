package management.stuant.com.stuant.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import management.stuant.com.stuant.R;
import management.stuant.com.stuant.common.Utils;

/**
 * Created by USER on 11/25/2018.
 */

public class SlidingHeaderContainer extends RelativeLayout {

    private String mDefaultText;
    private String mSlidingInText;
    private float mHeaderTextSize, mSlideInHeaderTextSize;
    private Context mContext;
    private TextView mSlidingOutView, mSlidingInView;
    private int mDefaultTetColor, mSlidingInTextColor;
    private boolean alreadyAnimated;
    private CustomAnimation mCustomAnimation;

    public SlidingHeaderContainer(Context context, AttributeSet attrs){
        super (context, attrs);
        TypedArray lAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SlidingHeaderContainer, 0, 0);
        try{
            mDefaultText = lAttributes.getString(R.styleable.SlidingHeaderContainer_shc_defaultText);
            mSlidingInText = lAttributes.getString(R.styleable.SlidingHeaderContainer_shc_slidingInText);
            mHeaderTextSize = lAttributes.getInt(R.styleable.SlidingHeaderContainer_shc_defaultHeaderTextSize, 32);
            mSlideInHeaderTextSize = lAttributes.getInt(R.styleable.SlidingHeaderContainer_shc_slideInHeaderTextSize, 24);
            mDefaultTetColor = lAttributes.getColor(R.styleable.SlidingHeaderContainer_shc_defaultTextColor, getContext().getResources().getColor(R.color.blood_red));
            mSlidingInTextColor = lAttributes.getColor(R.styleable.SlidingHeaderContainer_shc_slidingInTextColor, getContext().getResources().getColor(R.color.blood_red));
        }finally{
            lAttributes.recycle();
        }
        createTextView();
    }

    private void createTextView() {
        mSlidingOutView = addHeaderLabel(mDefaultText, mDefaultTetColor, mHeaderTextSize, RelativeLayout.CENTER_VERTICAL);
        mSlidingInView = addHeaderLabel(mSlidingInText, mSlidingInTextColor, mSlideInHeaderTextSize, RelativeLayout.ALIGN_LEFT);
        mSlidingInView.setVisibility(View.INVISIBLE);
    }

    private TextView addHeaderLabel(String lText, int lTextColor, float textSize, int alignment) {
        LayoutParams lParams = getLayoutProperties(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, (int) Utils.convertDIPToPixels(getContext(), 30),0,0,0,alignment);
        TextView lLabel = new TextView(getContext());
        lLabel.setGravity(Gravity.LEFT);
        lLabel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSize);
        lLabel.setText(lText);
        lLabel.setTextColor(lTextColor);
        addView(lLabel, lParams);
        return lLabel;
    }

    private LayoutParams getLayoutProperties(int height, int width, int leftMargin, int topMargin, int rightMargin, int bottomMargin, int alignment) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
        layoutParams.setMargins(leftMargin, rightMargin, topMargin, bottomMargin);
        layoutParams.addRule(alignment);
        return layoutParams;
    }

    public void animateView(View container){
        if(!alreadyAnimated){
            alreadyAnimated = true;
            mCustomAnimation = new CustomAnimation(this, container, mSlidingOutView, mSlidingInView);
            mCustomAnimation.startAnimation();

        }
    }

    public void reverseAnimation(){
        if(alreadyAnimated){
            alreadyAnimated = false;
            mCustomAnimation.revertAnimation();
        }
    }

    public void addHeaders(String defaultHeader, String slidingInHeader){
        mSlidingOutView.setText(defaultHeader);
        mSlidingInView.setText(slidingInHeader);
    }

    public boolean isAlreadyAnimated() {
        return alreadyAnimated;
    }

    public void setAlreadyAnimated(boolean alreadyAnimated) {
        this.alreadyAnimated = alreadyAnimated;
    }
}

