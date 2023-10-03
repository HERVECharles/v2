package grails_estia_23_24

class Illustration {

    String filename

    static constraints = {
        filename nullable: false, blank: false
    }
}
