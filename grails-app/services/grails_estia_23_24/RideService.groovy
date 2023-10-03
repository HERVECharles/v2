package grails_estia_23_24

import grails.gorm.services.Service

@Service(Ride)
interface RideService {

    Ride get(Serializable id)

    List<Ride> list(Map args)

    Long count()

    void delete(Serializable id)

    Ride save(Ride ride)

}