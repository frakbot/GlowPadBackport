GlowPadBackport
===============

**A backport of the Android 4.2 GlowPadView that works on the SDK on API levels 4+.**

It is heavily based upon Google's own internal implementation of the GlowPadView found in Android 4.2 Jelly Bean, but ported to be able to run on the Android SDK up from version 1.6 (API level 4, codename Donut). It uses Reflection in a couple of method calls to access some hidden APIs, so it might break on some Android version, or in the future. I tried limiting the usage of Reflection as much as possible, but those three methods did not have any alternatives.

I'm releasing my own code under the same Apache 2.0 license the underlying Android code is licensed under. Android code is written by Google, and licensed under that same Apache 2.0 license.

**GlowPadBackport** relies on [`NineOldAndroids`][2], an awesome backport of the Android 3+ Animation APIs made by [Jake Wharton][3].


## What is a GlowPad?

The `GlowPadView` is the view that Google uses in Android 4.1 and 4.2 (and, in a slightly different flavour, on Android 4.0 as well) on both the insecure lockscreen and the Incoming call Activity. It's the circular grid of dots, with a central handle that the user can grab to various customizable targets.

Google decided to only provide a private implementation of that view in AOSP. It's not an SDK-facing view, it has lots of internal APIs references, and doesn't work in older versions of Android. What I have done is I have rewritten part of the code to work on Android SDK versions starting with Android 1.6 Donut, which is to mean it runs pretty much on any hardware out there.

Of course performance is not going to be buttery smooth on older OS versions if the hardware is not up to it. Still, it can work decently even on underpowered hardware such as the [i'm Watch](http://www.imsmart.com/en/i-m-watch/overview) Android smartwatch (you have to decrease the points count multiplier to 3-4 from the default of 8 thou).

I also exposed a couple more functions that aren't available on the AOSP internal version, such as the ability to change the points count. This means you can use the `GlowPadView` in any of your apps, and create custom Holo-like lockscreens for older versions of Android.


## Usage

In order to use the `GlowPadView` in your project, follow these steps:

  1. Ensure you have the Maven Central repository configured in your `build.gradle` file, eg.:

  ```groovy
  repositories {
      mavenCentral()
  }
  ```
  
  This has to be in your app module's `build.gradle` or in the project's top-level `build.gradle` file. Android Studio puts it into the top-level file by default.

  2. Add the dependency to your app's module `build.gradle` file, eg.:

  ```groovy
  dependencies {
      // Your other dependencies...
      compile 'net.frakbot.glowpadbackport:glowpadbackport:2.1.0'
  }
  ```

  3. Reference the GlowPadView in an XML layout (or initialise it from code)

    ```xml
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
    ```

  2. ????
  3. Profit!


## Sample app

You can find the `GlowPadSample` app on the [Google Play Store][4].

Please note that **the demo app has not been updated for v2.0** on the Play Store (and probably never will). You can try out the v2.0 demo from the [**Releases** section](https://github.com/frakbot/GlowPadBackport/releases/tag/v2.0.0) of this repo.

[![GlowPadSample on Google Play Store](http://developer.android.com/images/brand/en_generic_rgb_wo_60.png)][4]


## Building from source

Clone the repository on your computer. The old IntelliJ IDEA and Eclipse-style projects have been
discontinued, and the library has been moved to the new Gradle-based build system, and [Android Studio][1].
You can of course continue to use this library in IntelliJ IDEA, but you'll have to build it using Gradle.

Before being able to build the project, you will need to rename the `keystore.properties.example` and `local.properties.example`
files in the repo root, removing the `.example` suffix. Please note that you _will_ need to provide valid values in
both files, in place of the placeholders, before being able to complete a build.


## License

    Copyright 2013-4 Sebastiano Poggi

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.




   [1]: http://developer.android.com/sdk/installing/studio.html
   [2]: http://www.nineoldandroids.com/
   [3]: https://github.com/JakeWharton
   [4]: http://play.google.com/store/apps/details?id=net.frakbot.glowpadbackportsample
