#! /usr/bin/bash groovy

import com.app.Docker

def call() {
    return new Docker(this).login()
}
