#! /usr/bin/env  groovy
package com.app

class Docker implements Serializable {

    def script

    Docker (script){
        this.script = script
    }

    def buildImage(String imageName,String imageTag) {
        script.sh "docker build -t $imageName:$imaTag ."
    }

    def login() {
        script.withCredentials(
                [script.usernamePassword(
                    credentialsId: 'docker-hub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]
                ) {
                    script.sh "echo $script.PASSWORD | docker login -u $script.USERNAME --password-stdin "
                }
    }

    def pushImage(String imageName,String imageTag) {
        script.sh "docker push  $imageName:$imageTag"
    }
}
