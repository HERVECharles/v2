package grails_estia_23_24

class Address {

    String address
    String postCode
    String city

    static belongsTo = Ride

    static constraints = {
        address nullable: false, blank: false
        postCode nullable: false, blank: false
        city nullable: false, blank: false
    }
}
