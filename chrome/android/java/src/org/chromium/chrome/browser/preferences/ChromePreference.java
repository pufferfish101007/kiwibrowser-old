// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.preferences;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.graphics.Color;
import android.view.View;

import org.chromium.base.ContextUtils;

import android.preference.Preference;

public class ChromePreference extends Preference {

    /**
     * Constructor for use in Java.
     */
    public ChromePreference(Context context) {
        super(context);
    }

    /**
     * Constructor for inflating from XML.
     */
    public ChromePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        if (ContextUtils.getAppSharedPreferences().getBoolean("user_night_mode_enabled", false) || ContextUtils.getAppSharedPreferences().getString("active_theme", "").equals("Diamond Black")) {
            if (((TextView) view.findViewById(android.R.id.title)) != null)
              ((TextView) view.findViewById(android.R.id.title)).setTextColor(Color.WHITE);
            if (((TextView) view.findViewById(android.R.id.summary)) != null)
              ((TextView) view.findViewById(android.R.id.summary)).setTextColor(Color.GRAY);
        }
    }
}
