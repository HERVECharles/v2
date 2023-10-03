package grails_estia_23_24

class User {

    String fname
    String lname
    String login
    String password
    Integer age
    String phone
    Date dateCreated

    static hasOne = [car: Car]

    static hasMany = [photos: Illustration, rides: Ride]

    static constraints = {
        fname nullable: false, blank: false
        lname nullable: false, blank: false
        login nullable: false, blank: false, size: 3..55
        age min: 18
        phone nullable: false, blank: false
        car nullable: true
    }
}
