#!/bin/bash

# Start the Android Emulator
emulator -avd test -no-window -no-audio &
echo "Waiting for the emulator to start..."
android-wait-for-emulator
