package grails_estia_23_24

import grails.converters.JSON
import grails.converters.XML

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class ApiController {


    /**
     * On doit gérer les "User", "Ride" et "Rating"
     * On va gérer pour les ressources singleton : GET, PUT, PATCH, DELETE
     * Pour les ressources collection on gèrera : GET et POST
     */

    /**
     * User Singleton
     * Gestion de GET, PUT, PATCH et DELETE
     */
    def user()
    {
        switch (request.getMethod())
        {
            case "GET":
                // On doit renvoyer les informations sur l'utilisateur spécifié
                // On vérifie que la requête contienne bien un identifiant
                if (!params.id)
                    render status: 400, text: "Missing id"
                // On récupère l'utilisateur
                def userInstance = User.get(params.id)
                // On vérifie l'existance de l'utilisateur
                if (!userInstance)
                    return response.status = 404
                // L'utilisateur existe, on le retourne en réponse
                renderThis(userInstance, request.getHeader("Accept"))
            break
            case "PUT":
            break
            case "PATCH":
            break
            case "DELETE":
            break
            default:
                return response.status = 406
                break
        }
    }

    def users()
    {

    }

    def renderThis(Object o, String acceptHeader) {
        switch (acceptHeader) {
            case "xml":
            case "application/xml":
            case "text/xml":
                render o as XML
                break
            case "json":
            case "application/json":
            case "text/json":
            default:
                render o as JSON
                break
        }
    }

}
