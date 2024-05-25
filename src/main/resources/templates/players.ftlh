<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Players</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/sketchy/bootstrap.min.css">
</head>
<body class="container">
<#include "navbar.ftlh">

<h1>Players</h1>

<a href="/addplayer" class="btn btn-primary btn-lg active float-right mb-3" role="button" aria-pressed="true">Add Player</a>


<table class="table table-borderless">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Team</th>
        <th></th>
    </tr>
    <#list playerList as player>
        <tr class = "border-bottom border-top border-dark">
            <td>${player.getId()}</td>
            <td>${player.getName()}</td>
            <td>${player.getAge()}</td>
            <td>${player.getTeamString()}</td>
            <td><a href="/edit/${player.getId()}">edit</a> </td>
        </tr>
    </#list>
</table>


<#include "footer.ftlh">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>