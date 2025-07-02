<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Plats</title>
</head>
<body>
    <h2>Liste des plats</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Intitulé</th>
            <th>Prix</th>
            <th>Date de création</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="plat" items="${plats}">
            <tr>
                <td>${plat.id}</td>
                <td>${plat.intitule}</td>
                <td>${plat.prix}</td>
                <td>${plat.dateCreation}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/plats/delete/${plat.id}">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="${pageContext.request.contextPath}/plats/new">Ajouter un nouveau plat</a>
</body>
</html>
