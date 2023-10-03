package grails_estia_23_24

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RideController {

    RideService rideService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond rideService.list(params), model:[rideCount: rideService.count()]
    }

    def show(Long id) {
        respond rideService.get(id)
    }

    def create() {
        respond new Ride(params)
    }

    def save(Ride ride) {
        if (ride == null) {
            notFound()
            return
        }

        try {
            rideService.save(ride)
        } catch (ValidationException e) {
            respond ride.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ride.label', default: 'Ride'), ride.id])
                redirect ride
            }
            '*' { respond ride, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond rideService.get(id)
    }

    def update(Ride ride) {
        if (ride == null) {
            notFound()
            return
        }

        try {
            rideService.save(ride)
        } catch (ValidationException e) {
            respond ride.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ride.label', default: 'Ride'), ride.id])
                redirect ride
            }
            '*'{ respond ride, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        rideService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ride.label', default: 'Ride'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ride.label', default: 'Ride'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
