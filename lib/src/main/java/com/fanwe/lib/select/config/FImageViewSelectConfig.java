/*
 * Copyright (C) 2017 zhengjun, fanwe (http://www.fanwe.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fanwe.lib.select.config;

import android.view.View;

import com.fanwe.lib.select.handler.BasePropertyHandler;
import com.fanwe.lib.select.handler.ImageViewImageResIdHandler;

/**
 * Created by zhengjun on 2017/9/15.
 */
public class FImageViewSelectConfig extends FViewSelectConfig
{
    private ImageViewImageResIdHandler mImageResIdHandler;

    FImageViewSelectConfig(View view)
    {
        super(view);
    }

    //---------- properties start ----------

    public FImageViewSelectConfig setImageResIdNormal(Integer value)
    {
        getImageResIdHandler().setValueNormal(value);
        return this;
    }

    public FImageViewSelectConfig setImageResIdSelected(Integer value)
    {
        getImageResIdHandler().setValueSelected(value);
        return this;
    }

    //---------- properties end ----------

    @Override
    protected void onReleaseHandler(BasePropertyHandler handler)
    {
        super.onReleaseHandler(handler);
        if (mImageResIdHandler == handler)
            mImageResIdHandler = null;
    }

    private ImageViewImageResIdHandler getImageResIdHandler()
    {
        if (mImageResIdHandler == null)
            mImageResIdHandler = new ImageViewImageResIdHandler(this);
        return mImageResIdHandler;
    }
}
