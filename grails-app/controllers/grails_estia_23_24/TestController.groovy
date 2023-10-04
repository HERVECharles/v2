package grails_estia_23_24

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class TestController {

    def index() {
        respond User.list()
    }
}
