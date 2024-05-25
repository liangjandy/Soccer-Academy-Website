<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Player</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/sketchy/bootstrap.min.css">
</head>

<body class="container">
<#include "navbar.ftlh">

<div class="card mb-3">
    <div class="card-header">
        <h3>Add Player</h3>
    </div>
    <div class="card-body">
        <form method="post" class="form" action="/addplayer">
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" name="name" class="form-control" id="name" required>
            </div>
            <div class="mb-4">
                <label for="birthYear" class="form-label">Select Birth Year:</label>
                <select id="birthYear" name="birthYear" class="form-select">
                    <#list (currentYear - 4)..(currentYear - 12) as year>
                        <option value="${year?string["0"]}">${year?string["0"]}</option>
                    </#list>
                </select>
            </div>
            <div class="mb-3 form-group" id="gender">
                <label for="gender" class="form-label">Gender:</label>
                <div class="custom-control custom-radio custom-control-inline">
                    <input class="custom-control-input" type="radio" name="gender" id="male" value="M" required>
                    <label class="custom-control-label" for="male">Male</label>
                </div>
                <div class="custom-control custom-radio custom-control-inline">
                    <input type="radio" name="gender" id="female" value="F" class="custom-control-input" required>
                    <label class="custom-control-label" for="female">Female</label>
                </div>
            </div>


            <button type="submit" class="btn btn-primary mb-3">Add</button>
        </form>
        <a href="/players">Cancel</a>
    </div>
</div>

<#include "footer.ftlh">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>