#!/bin/bash

# Start the Android Emulator
emulator -avd Pixel 6 API 33 -no-window -no-audio &
echo "Waiting for the emulator to start..."
android-wait-for-emulator
