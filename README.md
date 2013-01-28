GlowPadBackport
===============

A backport of the Android 4.2 GlowPadView that works on the SDK on API levels 4+.

It is heavily based upon Google's own internal implementation of the GlowPadView found in Android 4.2 Jelly Bean, but ported to be able to run on the Android SDK up from version 1.6 (API level 4, codename Donut). It uses Reflection in a couple of method calls to access some hidden APIs, so it might break on some Android version, or in the future. I tried limiting the usage of Reflection as much as possible, but those three methods did not have any alternatives.

I'm releasing my own code under the same Apache 2.0 license the underlying Android code is licensed under. Android code is written by Google, and licensed under that same Apache 2.0 license.


## Installation

Clone the repository on your computer, then reference `GlowPadBackport` from your project. Already supplied is the [IntelliJ IDEA][1] project file for the library project. Importing in Eclipse should be just as easy, using the "create project from existing sources" function.

Note that `GlowPadBackport` relies on [`NineOldAndroids`][2], an awesome backport of the Android 3+ Animation APIs made by [Jake Wharton][3]. It is referenced as a submodule here; you might need to initialize the submodule after cloning, depending on your setup.


## Usage

In order to use the `GlowPadView` in your project, follow these steps:

  1. Reference the GlowPadView in an XML layout (or initialize it from code)

    <?xml version="1.0" encoding="utf-8"?>

    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                    xmlns:app="http://schemas.android.com/apk/res-auto"
                    android:layout_width="fill_parent"
                    android:layout_height="fill_parent">

        <net.sebastianopoggi.ui.GlowPadBackport.GlowPadView
                android:id="@+id/incomingCallWidget"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"
                android:layout_marginTop="-10dp"
                android:layout_marginBottom="-46dp"
                android:background="@android:color/black"
                android:visibility="visible"
                android:gravity="top"

                app:targetDrawables="@array/incoming_call_widget_2way_targets"
                app:handleDrawable="@drawable/ic_in_call_touch_handle"
                app:innerRadius="@dimen/glowpadview_inner_radius"
                app:outerRadius="@dimen/glowpadview_target_placement_radius"
                app:outerRingDrawable="@drawable/ic_lockscreen_outerring"
                app:snapMargin="@dimen/glowpadview_snap_margin"
                app:vibrationDuration="20"
                app:feedbackCount="1"
                app:glowRadius="@dimen/glowpadview_glow_radius"
                app:pointDrawable="@drawable/ic_lockscreen_glowdot"/>

    </RelativeLayout>

  2. ????
  3. Profit!

   [1]: http://www.jetbrains.com/idea/
   [2]: http://www.nineoldandroids.com/
   [3]: https://github.com/JakeWharton


## License

    Copyright 2013 Sebastiano Poggi

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
