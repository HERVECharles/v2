<%@ page import="grails_estia_23_24.Car" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>
<a href="#edit-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                           default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="edit-user" class="content scaffold-edit" role="main">
    <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.user}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.user}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form controller="user" action="update" id="${user.id}" method="POST">
        <g:hiddenField name="version" value="${this.user?.version}"/>
        <fieldset class="form">

            <div class="fieldcontain required">
                <label for="fname">Fname
                    <span class="required-indicator">*</span>
                </label>
                <input type="text" name="fname" value="${user.fname}" required="" id="fname">
            </div>

            <div class="fieldcontain required">
                <label for="lname">Lname
                    <span class="required-indicator">*</span>
                </label><input type="text" name="lname" value="${user.lname}" required="" id="lname">
            </div>

            <div class="fieldcontain required">
                <label for="login">Login
                    <span class="required-indicator">*</span>
                </label><input type="text" name="login" value="${user.login}" required="" maxlength="55" id="login">
            </div>

            <div class="fieldcontain required">
                <label for="password">Password
                    <span class="required-indicator">*</span>
                </label>
                <input type="password" name="password" value="${user.password}" required="" id="password">
            </div>

            <div class="fieldcontain required">
                <label for="age">Age
                    <span class="required-indicator">*</span>
                </label><input type="number" name="age" value="${user.age}" required="" min="18" id="age">
            </div>

            <div class="fieldcontain required">
                <label for="phone">Phone
                    <span class="required-indicator">*</span>
                </label><input type="text" name="phone" value="${user.phone}" required="" id="phone">
            </div>

            <div class="fieldcontain">
                <label for="car">Car</label>
                <g:select name="car.id" from="${Car.list()}" id="id"/>
            </div>

            <div class="fieldcontain">
                <label for="photos">Photos</label>
                <g:each in="${user.photos}" var="photo">
                    <asset:image src="${photo.filename}"/>
                </g:each>
            </div>

            <div class="fieldcontain">
                <label for="photos">Photos</label>
                <input style="display: inline;" type="file" name="newPhoto"/>
            </div>

        </fieldset>
        <fieldset class="buttons">
            <input class="save" type="submit"
                   value="${message(code: 'default.button.update.label', default: 'Update')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
