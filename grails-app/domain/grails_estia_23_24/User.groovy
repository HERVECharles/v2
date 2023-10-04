package grails_estia_23_24

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    String fname
    String lname
    Integer age
    String phone
    Date dateCreated

    static hasOne = [car: Car]

    static hasMany = [photos: Illustration, rides: Ride]

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        fname nullable: false, blank: false
        lname nullable: false, blank: false
        age min: 18
        phone nullable: false, blank: false
        car nullable: true
    }

    static mapping = {
	    password column: '`password`'
    }
}
