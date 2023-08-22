#!/bin/bash

# Start the Android Emulator
emulator -avd Pixel_6_API_33 -no-window -no-audio &
echo "Waiting for the emulator to start..."
android-wait-for-emulator
