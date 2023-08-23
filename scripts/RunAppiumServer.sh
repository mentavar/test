#!/bin/bash
set -ex
npm install -g appium
appium -v
appium driver install uiautomator2
appium driver update uiautomator2
appium server --address 127.0.0.1 --port 4723 --use-drivers uiautomator2 --base-path /wd/hub
