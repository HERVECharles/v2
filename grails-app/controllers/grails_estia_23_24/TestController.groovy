package grails_estia_23_24

class TestController {

    def index() {
        respond User.list()
    }
}
