#!/bin/bash
set -ex
npm install -g appium
appium -v
appium driver install uiautomator2
appium driver update uiautomator2
