#! /usr/bin/env groovy

import com.app.Docker

def call(String imageName, String imageTag) {
    return new Docker(this).pushImage(imageName, imageTag)
}
