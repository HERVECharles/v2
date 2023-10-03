package grails_estia_23_24

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RideServiceSpec extends Specification {

    RideService rideService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Ride(...).save(flush: true, failOnError: true)
        //new Ride(...).save(flush: true, failOnError: true)
        //Ride ride = new Ride(...).save(flush: true, failOnError: true)
        //new Ride(...).save(flush: true, failOnError: true)
        //new Ride(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ride.id
    }

    void "test get"() {
        setupData()

        expect:
        rideService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Ride> rideList = rideService.list(max: 2, offset: 2)

        then:
        rideList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        rideService.count() == 5
    }

    void "test delete"() {
        Long rideId = setupData()

        expect:
        rideService.count() == 5

        when:
        rideService.delete(rideId)
        sessionFactory.currentSession.flush()

        then:
        rideService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Ride ride = new Ride()
        rideService.save(ride)

        then:
        ride.id != null
    }
}
