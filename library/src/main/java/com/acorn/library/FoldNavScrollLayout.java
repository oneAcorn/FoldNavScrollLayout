package com.acorn.library;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;


/**
 * 折叠
 * Created by Acorn on 2018/1/4.
 */
public class FoldNavScrollLayout extends LinearLayout implements NestedScrollingParent {
    private View navView, tabView, contentView;
    //    private int statusBarHeight;
    private int navHeight;
    private ValueAnimator navAnim;
    private static final int dySlop = 40;
    private int dyOffset;
    private boolean lastDirectionIsDown; //上次的方向,;
    private boolean isAniming;
    private boolean isExpand = true;
    private IFoldNavListener mListener;

    public FoldNavScrollLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        navView = findViewById(R.id.fold_nav_layout);
        tabView = findViewById(R.id.fold_tab_layout);
        contentView = findViewById(R.id.fold_content_layout);
        navView.post(new Runnable() {
            @Override
            public void run() {
                navHeight = navView.getHeight();
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        navView.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        ViewGroup.LayoutParams params = contentView.getLayoutParams();
        params.height = getMeasuredHeight() - tabView.getMeasuredHeight();
//        LogUtil.i("acorn onMeasure getMeasuredHeight " + getMeasuredHeight() + ",params.height " + params.height+", child2 height "+getChildAt(2).getMeasuredHeight()+
//                ", child1 height "+getChildAt(1).getMeasuredHeight());
        setMeasuredDimension(getMeasuredWidth(), navView.getMeasuredHeight() + tabView.getMeasuredHeight() + params.height);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {

    }

    @Override
    public void onStopNestedScroll(View target) {
//        LogUtil.i("acorn onStopNestedScroll " + target);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {

    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        if (isAniming)
            return;
        if (lastDirectionIsDown && dy < 0) {
            dyOffset += Math.abs(dy);
        } else if (!lastDirectionIsDown && dy > 0) {
            dyOffset += dy;
        } else {
            dyOffset = 0;
        }
        if (dyOffset > dySlop) {
            if (lastDirectionIsDown && !isExpand) {
                dyOffset = 0;
                startAnim(lastDirectionIsDown);
            } else if (!lastDirectionIsDown && isExpand) {
                dyOffset = 0;
                startAnim(lastDirectionIsDown);
            }
        }
        lastDirectionIsDown = dy < 0;
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public int getNestedScrollAxes() {
        return 0;
    }


    public void startAnim(final boolean isAnimExpand) {
//        LogUtil.i("acorn startAnim " + isAnimExpand);
        isExpand = isAnimExpand;
        if (navAnim == null) {
            navAnim = new ValueAnimator();
            navAnim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    isAniming = true;
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    isAniming = false;
                    if (null != mListener) {
                        if (isExpand) {
                            mListener.onNavExpandFinish();
                        } else {
                            mListener.onNavFoldFinish();
                        }
                    }
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            navAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    scrollTo(0, (Integer) animation.getAnimatedValue());
                }
            });
            navAnim.setInterpolator(new DecelerateInterpolator());
        } else {
            navAnim.cancel();
        }
        if (isAnimExpand) {
            navAnim.setIntValues(navHeight, 0);
        } else {
            navAnim.setIntValues(0, navHeight);
        }
        if (null != mListener) {
            if (isExpand) {
                mListener.onNavExpandBegin();
            } else {
                mListener.onNavFoldBegin();
            }
        }
        navAnim.start();
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setOnFoldNavListener(IFoldNavListener listener) {
        this.mListener = listener;
    }
}
