package grails_estia_23_24

class Ride {

    Address start
    Address destination
    Long starTime
    Long destTime
    Boolean everyDay = Boolean.FALSE
    Boolean everyWeek = Boolean.FALSE
    Integer roomAvailable
    Float price
    Date dateCreated
    Date lastUpdated

//    static belongsTo = [owner: User]

    static constraints = {
        start nullable: false
        destination nullable: false
        starTime nullable: true
        destTime nullable: true
        roomAvailable nullable: false, min: 1
        price min: 0F
    }
}
