<!doctype html>
<html class="no-js">

<head>
  <meta charset="utf-8">
  <title></title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">
  <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
  <!-- build:css(.) styles/vendor.css -->
  <!-- bower:css -->
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css"/>
  <link rel="stylesheet" href="bower_components/AngularJS-Toaster/toaster.css"/>
  <link rel="stylesheet" href="bower_components/angular-loading-bar/build/loading-bar.css"/>
  <link rel="stylesheet" href="bower_components/angular-motion/dist/angular-motion.css"/>
  <link rel="stylesheet" href="bower_components/fullcalendar/dist/fullcalendar.css"/>
  <link rel="stylesheet" href="bower_components/select2/select2.css"/>
  <link rel="stylesheet" href="bower_components/bootstrap-markdown/css/bootstrap-markdown.min.css"/>
  <link rel="stylesheet" href="bower_components/datetimepicker/jquery.datetimepicker.css"/>
  <link rel="stylesheet" href="bower_components/ng-table/ng-table.css"/>
  <link rel="stylesheet" href="bower_components/ngQuickDate/dist/ng-quick-date.css"/>
  <link rel="stylesheet" href="bower_components/ngQuickDate/dist/ng-quick-date-default-theme.css"/>
  <!-- endbower -->
  <!-- endbuild -->
  <!-- build:css(.tmp) styles/main.css -->
  <link rel="stylesheet" href="styles/main.css">
  <!-- endbuild -->

  <%--<script type="text/javascript">--%>
    <%--var _contextPath = "${pageContext.request.contextPath}";--%>
  <%--</script>--%>
</head>
<!--
	ng-app is directive that declares that the element
	and its children will be handled by angular.js
-->

<body ng-app="webInvoicingApp">
<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
  your browser</a> to improve your experience.</p>
<![endif]-->

<!-- Add your site or application content here -->
<div class="page-container">
  <div ng-include="'nav/top.html'"></div>


  <div class="">
    <div class="">

      <!--
	    		ng-view is directive that declares that the element will be
	    		place holder for the partial files included through the router
	    	 -->
      <div ng-view class="col-xs-12"></div>
    </div>
  </div>

</div>


<!-- build:js(.) scripts/oldieshim.js -->
<!--[if lt IE 9]>
<script src="bower_components/es5-shim/es5-shim.js"></script>
<script src="bower_components/json3/lib/json3.js"></script>
<![endif]-->
<!-- endbuild -->

<!-- build:js(.) scripts/vendor.js -->
<!-- bower:js -->
<script src="bower_components/jquery/jquery.js"></script>
<script src="bower_components/angular/angular.js"></script>
<script src="bower_components/angular-route/angular-route.js"></script>
<script src="bower_components/angular-resource/angular-resource.js"></script>
<script src="bower_components/angular-cookies/angular-cookies.js"></script>
<script src="bower_components/angular-animate/angular-animate.js"></script>
<script src="bower_components/angular-sanitize/angular-sanitize.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script src="bower_components/jquery-cookie/jquery.cookie.js"></script>
<script src="bower_components/jquery-ui/jquery-ui.js"></script>
<script src="bower_components/angular-bootstrap/ui-bootstrap.js"></script>
<script src="bower_components/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="bower_components/angular-strap/dist/angular-strap.min.js"></script>
<script src="bower_components/angular-strap/dist/angular-strap.tpl.min.js"></script>
<script src="bower_components/AngularJS-Toaster/toaster.js"></script>
<script src="bower_components/angular-loading-bar/build/loading-bar.js"></script>
<script src="bower_components/angular-translate/angular-translate.js"></script>
<script src="bower_components/angular-translate-loader-static-files/angular-translate-loader-static-files.js"></script>
<script src="bower_components/angular-translate-storage-cookie/angular-translate-storage-cookie.js"></script>
<script src="bower_components/moment/moment.js"></script>
<script src="bower_components/fullcalendar/dist/fullcalendar.js"></script>
<script src="bower_components/angular-ui-calendar/src/calendar.js"></script>
<script src="bower_components/select2/select2.js"></script>
<script src="bower_components/angular-ui-select2/src/select2.js"></script>
<script src="bower_components/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="bower_components/datetimepicker/jquery.datetimepicker.js"></script>
<script src="bower_components/jquery-textcomplete/dist/jquery.textcomplete.js"></script>
<script src="bower_components/momentjs/moment.js"></script>
<script src="bower_components/marked/lib/marked.js"></script>
<script src="bower_components/d3/d3.js"></script>
<script src="bower_components/nvd3/nv.d3.js"></script>
<script src="bower_components/angularjs-nvd3-directives/dist/angularjs-nvd3-directives.js"></script>
<script src="bower_components/ng-file-upload/angular-file-upload.js"></script>
<script src="bower_components/ng-table/ng-table.js"></script>
<script src="bower_components/ng-table-export/ng-table-export.js"></script>
<script src="bower_components/ngQuickDate/dist/ng-quick-date.js"></script>
<script src="bower_components/angular-charts/dist/angular-charts.js"></script>
<script src="bower_components/d3-tip/index.js"></script>
<script src="bower_components/webcam-directive/dist/webcam.min.js"></script>
<script src="bower_components/underscore/underscore.js"></script>
<!-- endbower -->
<!-- endbuild -->

<!-- These scripts hold the code of the application -->
<!-- build:js({.tmp,app}) scripts/scripts.js -->
<!-- The definition and the configuration of the application module -->
<script src="scripts/app.js"></script>
<!-- The route configuration -->
<script src="scripts/router.js"></script>
<script src="scripts/config.js"></script>

<!-- controllers definition -->
<script src="scripts/controllers/main.js"></script>
<script src="scripts/controllers/city.js"></script>
<script src="scripts/controllers/country.js"></script>
<script src="scripts/controllers/category.js"></script>
<script src="scripts/controllers/book.js"></script>
<script src="scripts/controllers/login.js"></script>
<script src="scripts/controllers/browse-category.js"></script>
<script src="scripts/controllers/search.js"></script>
<script src="scripts/controllers/order.js"></script>
<script src="scripts/controllers/language.js"></script>
<script src="scripts/controllers/item.js"></script>
<script src="scripts/controllers/partner.js"></script>
<script src="scripts/controllers/register.js"></script>
<script src="scripts/controllers/new-invoice.js"></script>
<script src="scripts/controllers/invoice.js"></script>
<script src="scripts/controllers/invoices.js"></script>
<!-- Services definition -->
<script src="scripts/services/category.js"></script>
<script src="scripts/services/crud.js"></script>
<script src="scripts/services/user.js"></script>
<script src="scripts/services/books.js"></script>
<script src="scripts/services/orders.js"></script>
<script src="scripts/services/items.js"></script>
<script src="scripts/services/invoice.js"></script>

<script src="scripts/directives/combo.js"></script>
<script src="scripts/directives/book-display.js"></script>
<!-- endbuild -->

<toaster-container toaster-options="{'time-out': 3000}"></toaster-container>
</body>

</html>

