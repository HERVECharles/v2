<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                           default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-user" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <table>
        <thead>
        <tr>

            <th class="sortable"><a href="/user/index?sort=fname&amp;max=10&amp;order=asc">Fname</a></th>

            <th class="sortable"><a href="/user/index?sort=lname&amp;max=10&amp;order=asc">Lname</a></th>

            <th class="sortable"><a href="/user/index?sort=login&amp;max=10&amp;order=asc">Login</a></th>

            <th class="sortable"><a href="/user/index?sort=age&amp;max=10&amp;order=asc">Age</a></th>

            <th class="sortable"><a href="/user/index?sort=phone&amp;max=10&amp;order=asc">Phone</a></th>

            <th class="sortable"><a href="/user/index?sort=photos&amp;max=10&amp;order=asc">Photos</a></th>

        </tr>
        </thead>
        <tbody>

        <g:each in="${userList}" var="user">
            <tr class="even">
                <td>
                    <g:link controller="user" action="show" id="${user.id}">${user.login}</g:link>
                </td>
                <td>${user.lname}</td>
                <td>${user.fname}</td>
                <td>${user.age}</td>
                <td>${user.phone}</td>
                <td>
                    <g:each in="${user.photos}" var="photo">
                        <asset:image src="${photo.filename}"/>
                    </g:each>
                </td>

            </tr>
        </g:each>

        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${userCount ?: 0}"/>
    </div>
</div>
</body>
</html>