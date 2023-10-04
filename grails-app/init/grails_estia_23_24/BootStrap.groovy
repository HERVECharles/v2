package grails_estia_23_24

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: "ROLE_ADMIN").save()
        def adminUser = new User(fname: "admin", lname: "admin", age: 18, username: "admin", password: "admin", phone: "0123456789").save()
        UserRole.create(adminUser, adminRole, true)

        ["Alice", "Bob", "Charly", "Denis", "Etienne"].eachWithIndex {
            String fName, uIndex ->
                def userInstance = new User(fname: fName, lname: "lname", age: 18 + uIndex, username: fName, password: "password", phone: "0123456789")

                def carInstance = new Car(brand: "Peugeot", model: "106", color: "blue")
                (1..3).each {
                    userInstance.addToPhotos(new Illustration(filename: "grails.svg"))
                    carInstance.addToPhotos(new Illustration(filename: "grails.svg"))
                }
                userInstance.car = carInstance

                (1..3).each {
                    def startAddress = new Address(address: "Biarritz", postCode: "64210", city: "Biarritz")
                    def destAddress = new Address(address: "Nice", postCode: "06000", city: "Nice")
                    def rideInstance = new Ride(
                            start: startAddress,
                            destination: destAddress,
                            starTime: 1696327182,
                            destTime: 1696413582,
                            roomAvailable: 1,
                            price: 50F)
                    userInstance.addToRides(rideInstance)
                }
                userInstance.save(flush: true, failOnError: true)
        }

        User.list().each {
            User uFrom ->
                User.list().eachWithIndex {
                    User uTarget, index ->
                        new Rating(author: uFrom, target: uTarget, rating: index % 6).save(flush: true, failOnError: true)
                }
        }
    }
    def destroy = {}
}
