<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex">
    <title>UI Demo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="style.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="https://raw.githubusercontent.com/debianmaster/ui-welcome/master/script.js"></script>
</head>
<body ng-app="myApp">
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <img alt="Brand" src="https://www.openshift.com/images/logos/powered_by_openshift_reverse.png">
        </div>
    </div>
</nav>
<div class="container" ng-controller="appController">
    <div class="panel-body">
        <table class="table table-striped" ng-show="customers.length!=0">
            <tr><th>Username</th><th>Age</th></tr>
            <tr ng-repeat="customer in customers">
                <td>{{ customer.NAME }}</td>
                <td>{{ customer.AGE }}</td>
            </tr>
        </table>
    </div>
</div>
</body>