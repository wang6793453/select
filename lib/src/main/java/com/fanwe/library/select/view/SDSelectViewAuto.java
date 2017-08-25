package com.fanwe.library.select.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;
import java.util.WeakHashMap;

public abstract class SDSelectViewAuto extends SDSelectView
{
    public SDSelectViewAuto(Context context)
    {
        super(context);
    }

    public SDSelectViewAuto(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public SDSelectViewAuto(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    private Map<View, Integer> mMapViews = new WeakHashMap<>();

    @Override
    public void setContentView(int resId)
    {
        mMapViews.clear();
        super.setContentView(resId);
    }

    @Override
    public void setContentView(View view)
    {
        mMapViews.clear();
        super.setContentView(view);
    }

    @Override
    public void setContentView(View view, android.view.ViewGroup.LayoutParams params)
    {
        mMapViews.clear();
        super.setContentView(view, params);
    }

    /**
     * 添加自动根据选中状态变化的view
     *
     * @param views
     */
    protected void addAutoView(View... views)
    {
        if (views == null)
        {
            return;
        }
        for (View item : views)
        {
            mMapViews.put(item, 0);
        }
    }

    /**
     * 移除自动根据选中状态变化的view
     *
     * @param views
     */
    protected void removeAutoView(View... views)
    {
        if (views == null)
        {
            return;
        }
        for (View item : views)
        {
            mMapViews.remove(item);
        }
    }

    @Override
    public void onSelectedChanged(boolean selected)
    {
        if (mMapViews.isEmpty())
        {
            return;
        }

        for (Map.Entry<View, Integer> item : mMapViews.entrySet())
        {
            autoViewState(selected, item.getKey());
        }
    }

    protected void autoViewState(boolean selected, View view)
    {
        if (view == null)
        {
            return;
        }

        if (view instanceof TextView)
        {
            TextView tv = (TextView) view;
            updateTextView_textColor(selected, tv);
            updateTextView_textSize(selected, tv);
        } else if (view instanceof ImageView)
        {
            ImageView iv = (ImageView) view;
            updateImageView_imageResource(selected, iv);
        }

        updateView_alpha(selected, view);
        updateView_background(selected, view);
        updateView_size(selected, view);
        updateView_visibility(selected, view);
    }
}
