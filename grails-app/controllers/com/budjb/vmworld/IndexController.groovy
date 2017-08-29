package com.budjb.vmworld

import grails.util.GrailsMetaClassUtils

class IndexController {
    NetworkStatsService networkStatsService

    def index() {
        [:]
    }

    def version() {
        render contentType: 'text/plain', text: grailsApplication.metadata['info.app.version']
    }
}
