// Copyright 2015 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.firstrun;

import org.chromium.base.CommandLine;
import org.chromium.base.ContextUtils;
import org.chromium.chrome.browser.ChromeSwitches;

import android.content.Context;
import android.content.ContextWrapper;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;

/**
 * Gets and sets preferences related to the status of the first run experience.
 */
public class FirstRunStatus {

    // Needed by ChromeBackupAgent
    public static final String FIRST_RUN_FLOW_COMPLETE = "first_run_flow";
    public static final String LIGHTWEIGHT_FIRST_RUN_FLOW_COMPLETE = "lightweight_first_run_flow";

    private static final String SKIP_WELCOME_PAGE = "skip_welcome_page";

    /**
     * Sets the "main First Run Experience flow complete" preference.
     * @param isComplete Whether the main First Run Experience flow is complete
     */
    public static void setFirstRunFlowComplete(boolean isComplete) {
        ContextUtils.getAppSharedPreferences()
                .edit()
                .putBoolean(FIRST_RUN_FLOW_COMPLETE, isComplete)
                .apply();
    }

    /**
     * Returns whether the main First Run Experience flow is complete.
     * Note: that might NOT include "intro"/"what's new" pages, but it always
     * includes ToS and Sign In pages if necessary.
     */
    public static boolean getFirstRunFlowComplete() {
        boolean complete = ContextUtils.getAppSharedPreferences().getBoolean(FIRST_RUN_FLOW_COMPLETE, false);
        if (!complete) {
             setFirstRunFlowComplete(true);
         }
         return true;
    }

    /**
    * Sets the preference to skip the welcome page from the main First Run Experience.
     * @param isSkip Whether the welcome page should be skpped
    */
    public static void setSkipWelcomePage(boolean isSkip) {
        ContextUtils.getAppSharedPreferences().edit().putBoolean(SKIP_WELCOME_PAGE, isSkip).apply();
    }

    /**
    * Checks whether the welcome page should be skipped from the main First Run Experience.
    */
    public static boolean shouldSkipWelcomePage() {
        return ContextUtils.getAppSharedPreferences().getBoolean(SKIP_WELCOME_PAGE, false);
    }

    /**
     * Sets the "lightweight First Run Experience flow complete" preference.
     * @param isComplete Whether the lightweight First Run Experience flow is complete
     */
    public static void setLightweightFirstRunFlowComplete(boolean isComplete) {
        ContextUtils.getAppSharedPreferences()
                .edit()
                .putBoolean(LIGHTWEIGHT_FIRST_RUN_FLOW_COMPLETE, isComplete)
                .apply();
    }

    /**
     * Returns whether the "lightweight First Run Experience flow" is complete.
     */
    public static boolean getLightweightFirstRunFlowComplete() {
        return ContextUtils.getAppSharedPreferences().getBoolean(
                LIGHTWEIGHT_FIRST_RUN_FLOW_COMPLETE, false);
    }
}
