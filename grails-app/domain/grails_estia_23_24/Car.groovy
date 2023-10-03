package grails_estia_23_24

class Car {

    String brand
    String model
    String color

    static belongsTo = [owner: User]

    static hasMany = [photos: Illustration]

    static constraints = {
        brand nullable: false, blank: false
        model nullable: false, blank: false
        color nullable: false, blank: false
    }

    @Override
    String toString() {
        return  brand+" - "+model+"("+color+")"
    }
}
