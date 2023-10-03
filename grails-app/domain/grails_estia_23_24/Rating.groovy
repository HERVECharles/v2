package grails_estia_23_24

class Rating {

    User author
    User target
    Integer rating
    Date dateCreated

    static constraints = {
        author nullable: false
        target nullable: false
        rating size: 0..5
    }
}
