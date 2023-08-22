#!/bin/bash

mvn clean verify -Dappium.hub=http://127.0.0.1:4723/wd/hub -Dwebdriver.driver=appium -Dappium.platformName=Android -Dappium.deviceName="Pixel_6_API_33" -Dcucumber.options="--tags '@ANDROID'" "$@"
mvn serenity:aggregate
