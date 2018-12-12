package management.stuant.com.stuant.components;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.util.Property;
import android.view.View;

/**
 * Created by USER on 11/25/2018.
 */

class CustomAnimation {
    private View mContainer, mSlideOutChild, mSlideInChild, mTextContainer;
    private static final int DURATION = 600;
    private ObjectAnimator mViewUpwardTranslator, mChildFadeInAnimator;
    private ObjectAnimator mChildSlideOutTranslator, mChildSlideInTranslator;
    private ObjectAnimator mViewZTranslator;

    public CustomAnimation(View textContainer, View container, View slideOutChild, View slideInChild){
        mContainer = container;
        mSlideOutChild = slideOutChild;
        mSlideInChild = slideInChild;
        mTextContainer = textContainer;
    }

    public void startAnimation(){
        float lViewHeightOriginal = mTextContainer.getHeight();
        float lContainerYDisplacement = lViewHeightOriginal/2;
        float lChildYDisplacement = lContainerYDisplacement/2;
        mViewUpwardTranslator = getAnimator(mContainer, View.TRANSLATION_Y, 0, -lContainerYDisplacement, DURATION);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            mViewZTranslator = getAnimator(mContainer, View.TRANSLATION_Z, 0, 1000, DURATION);
        }
        mChildSlideOutTranslator = getAnimator(mSlideOutChild, View.TRANSLATION_Y, 1, lChildYDisplacement, DURATION);
        ObjectAnimator lChildFadeOutAnimator = getAnimator(mSlideOutChild, View.ALPHA,1, 0, DURATION);
        mChildSlideInTranslator = getAnimator(mSlideInChild, View.TRANSLATION_Y, 1, lChildYDisplacement-mSlideInChild.getHeight()/2, DURATION);
        mChildFadeInAnimator = getAnimator(mSlideInChild, View.ALPHA, 0,1,DURATION);
        playAnimations(mViewUpwardTranslator, mChildSlideOutTranslator, lChildFadeOutAnimator);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            playAnimations(mChildSlideInTranslator, mChildFadeInAnimator, mViewZTranslator);
        }else{
            playAnimations(mChildSlideInTranslator, mChildFadeInAnimator);
        }
        mSlideInChild.setVisibility(View.VISIBLE);

    }

    private ObjectAnimator getAnimator(View view, Property<View, Float> property, int animateFrom, float animateTo, int duration) {
        ObjectAnimator lAnimator = ObjectAnimator.ofFloat(view, property, animateFrom, animateTo);
        lAnimator.setDuration(duration);
        return lAnimator;
    }

    private void playAnimations(Animator... items) {
        AnimatorSet lAnimatorSet = new AnimatorSet();
        lAnimatorSet.playTogether(items);
        lAnimatorSet.start();
    }

    public void revertAnimation(){
        mViewUpwardTranslator.reverse();
        mChildSlideOutTranslator.reverse();
        getAnimator(mSlideOutChild, View.ALPHA, 0,1, DURATION*2).start();
        mChildSlideInTranslator.reverse();
        mChildFadeInAnimator.reverse();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            mViewZTranslator.reverse();
        }
    }
}

