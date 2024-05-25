<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hurricanes Soccer Academy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/sketchy/bootstrap.min.css">
</head>
<body class="container">
<#include "navbar.ftlh">

<h1>Welcome to Hurricanes Soccer Academy</h1>
<p class="fs-4">Teaching advanced Skills in a fun environment. Building confidence in players of all levels.</p>
<div class="row">
    <div id="left" class="col-sm-0 col-md-2 col-lg-3">
        <img class="img-fluid d-none d-md-block" src="https://cs3.calstatela.edu/~csun/soccergirl.jpg">
        <img class="img-fluid d-none d-md-block" src="https://cs3.calstatela.edu/~csun/soccerboy.jpg">
    </div>
    <div id="right" class="col-sm-12 col-md-10 col-lg-9">
        <div class="rounded text-start p-2 border border-dark mb-3 bg-warning">
            <p class="fs-3">No practice today due to rain and poor field conditions, Tuesday, 2-6-24</p>
        </div>
        <div class="rounded text-start p-2 border border-dark mb-3 bg-warning">
            <p class="fs-3"><a href="#">W23-24 Groupings/Game Schedules</a></p>
        </div>
        <div class="rounded text-start p-2 border border-dark mb-3 bg-warning">
            <p class="fs-3"><a href="#">W23-24 Practice Schedules</a>
        </div>
    </div>
</div>
<#include "footer.ftlh">

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>