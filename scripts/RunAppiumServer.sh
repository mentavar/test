#!/bin/bash
set -ex
npm install -g appium
appium -v
appium --address 127.0.0.1 --port 4723 
appium driver install uiautomator2
appium &>/dev/null &
