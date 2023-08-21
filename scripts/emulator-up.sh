#!/bin/bash
#using shebang with -i to enable interactive mode (auto load .bashrc)
#this script was inspired from https://docs.travis-ci.com/user/languages/android/

set -e #stop immediately if any error happens

avd_name=$1

if [[ -z "$avd_name" ]]; then
  avd_name="test"
fi

#check if emulator work well
emulator -version

# create virtual device, default using Android 9 Pie image (API Level 28)
echo no | avdmanager create avd -n test -k "system-images;android-29;google_apis;x86"

# start the emulator
emulator -avd Pixel test -no-audio -no-window -no-accel &

# show connected virtual device
adb devices
