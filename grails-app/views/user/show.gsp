<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-user" class="content scaffold-show" role="main">
            <h1>Show</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>

            <ol class="property-list user">


                <h1>User</h1>

                <li class="fieldcontain">
                    <span id="fname-label" class="property-label">Fname</span>
                    <div class="property-value" aria-labelledby="fname-label">${user.fname}</div>
                </li>

                <li class="fieldcontain">
                    <span id="lname-label" class="property-label">Lname</span>
                    <div class="property-value" aria-labelledby="lname-label">${user.lname}</div>
                </li>

                <li class="fieldcontain">
                    <span id="username-label" class="property-label">Login</span>
                    <div class="property-value" aria-labelledby="username-label">${user.username}</div>
                </li>

                <li class="fieldcontain">
                    <span id="age-label" class="property-label">Age</span>
                    <div class="property-value" aria-labelledby="age-label">${user.age}</div>
                </li>

                <li class="fieldcontain">
                    <span id="phone-label" class="property-label">Phone</span>
                    <div class="property-value" aria-labelledby="phone-label">${user.phone}</div>
                </li>

                <li class="fieldcontain">
                    <span id="photos-label" class="property-label">Photos</span>
                    <div class="property-value" aria-labelledby="photos-label">
                        <g:each in="${user.photos}" var="photo">
                            <asset:image src="${photo.filename}"/>
                        </g:each>
                    </div>
                </li>

                <g:if test="${user.car}">
                <h1>Car</h1>

                <li class="fieldcontain">
                    <span id="brand-label" class="property-label">Login</span>
                    <div class="property-value" aria-labelledby="username-label">${user.car.brand}</div>
                </li>

                <li class="fieldcontain">
                    <span id="model-label" class="property-label">Login</span>
                    <div class="property-value" aria-labelledby="username-label">${user.car.model}</div>
                </li>

                <li class="fieldcontain">
                    <span id="color-label" class="property-label">Login</span>
                    <div class="property-value" aria-labelledby="username-label">${user.car.color}</div>
                </li>

                <li class="fieldcontain">
                    <span id="photos-car-label" class="property-label">Photos</span>
                    <div class="property-value" aria-labelledby="photos-label">
                        <g:each in="${user.car.photos}" var="photo">
                            <asset:image src="${photo.filename}"/>
                        </g:each>
                    </div>
                </li>
                </g:if>

            </ol>

            <g:form resource="${this.user}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.user}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
