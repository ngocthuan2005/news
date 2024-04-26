<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <!-- ==== Document Title ==== -->
	<title><decorator:title default="Layout" /></title>

    <!-- ==== Document Meta ==== -->
    <meta name="author" content="" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <!--Font awesome icon-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" />

    <!-- ==== Favicons ==== -->
    <link rel="icon" href="<c:url value="/public/user/frontend/img/KCN.png"/>" type="<c:url value="/public/user/frontend/img/KCN.png"/>" />

    <!-- ==== Google Font ==== -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600,700" />

    <!-- ==== Font Awesome ==== -->
    <link rel="stylesheet" href="<c:url value="/public/user/frontend/css/font-awesome.min.css"/>" />
    
    <!-- ==== Bootstrap Framework ==== -->
    <link rel="stylesheet" href="<c:url value="/public/user/frontend/css/bootstrap.min.css"/>"/>

    <!-- ==== Bar Rating Plugin ==== -->
    <link rel="stylesheet" href="<c:url value="/public/user/frontend/css/fontawesome-stars-o.min.css"/>" />

    <!-- ==== Main Stylesheet ==== -->
    <link rel="stylesheet" href="<c:url value="/public/user/frontend/style.css"/>" />

    <!-- ==== Responsive Stylesheet ==== -->
    <link rel="stylesheet" href="<c:url value="/public/user/frontend/css/responsive-style.css"/>" />

    <!-- ==== Theme Color Stylesheet ==== -->
    <link rel="stylesheet" href="<c:url value="/public/user/frontend/css/colors/theme-color-1.css"/>" id="changeColorScheme" />

	<!-- ==== Custom css === -->
    <link rel="stylesheet" href="<c:url value="/public/user/frontend/css/custom.css"/>" />
    <link rel="stylesheet" href="<c:url value="/public/custom/css/style.css"/>" />
    
<decorator:head />
</head>
<body class="boxed" data-bg-img="<c:url value="/public/user/frontend/img/bg-pattern.png"/>">
    <div class ="wrapper">

		<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>

		<decorator:body/>

		<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>
	</div>
        <!-- Back To Top Button Start -->
    <div id="backToTop">
        <a><i class="fa fa-angle-double-up"></i></a>
    </div>
    <!-- Back To Top Button End -->

    <!-- ==== jQuery Library ==== -->
    <script src="<c:url value="/public/user/frontend/js/jquery-3.2.1.min.js"/>"></script>

    <!-- ==== Bootstrap Framework ==== -->
    <script src="<c:url value="/public/user/frontend/js/bootstrap.min.js"/>"></script>

    <!-- ==== StickyJS Plugin ==== -->
    <script src="<c:url value="/public/user/frontend/js/jquery.sticky.min.js"/>"></script>

    <!-- ==== HoverIntent Plugin ==== -->
    <script src="<c:url value="/public/user/frontend/js/jquery.hoverIntent.min.js"/>"></script>

    <!-- ==== Marquee Plugin ==== -->
    <script src="<c:url value="/public/user/frontend/js/jquery.marquee.min.js"/>"></script>

    <!-- ==== Validation Plugin ==== -->
    <script src="<c:url value="/public/user/frontend/js/jquery.validate.min.js"/>"></script>

    <!-- ==== Isotope Plugin ==== -->
    <script src="<c:url value="/public/user/frontend/js/isotope.min.js"/>"></script>

    <!-- ==== Resize Sensor Plugin ==== -->
    <script src="<c:url value="/public/user/frontend/js/resizesensor.min.js"/>"></script>

    <!-- ==== Sticky Sidebar Plugin ==== -->
    <script src="<c:url value="/public/user/frontend/js/theia-sticky-sidebar.min.js"/>"></script>

    <!-- ==== Zoom Plugin ==== -->
    <script src="<c:url value="/public/user/frontend/js/jquery.zoom.min.js"/>"></script>

    <!-- ==== Bar Rating Plugin ==== -->
    <script src="<c:url value="/public/user/frontend/js/jquery.barrating.min.js"/>"></script>

    <!-- ==== Countdown Plugin ==== -->
    <script src="<c:url value="/public/user/frontend/js/jquery.countdown.min.js"/>"></script>

    <!-- ==== RetinaJS Plugin ==== -->
    <script src="<c:url value="/public/user/frontend/js/retina.min.js"/>"></script>

    <!-- ==== Main JavaScript ==== -->
    <script src="<c:url value="/public/user/frontend/js/main.js"/>"></script>
	<!-- ==== Custum JavaScript -->
    <script src="<c:url value="/public/custom/js/main.js"/>"></script>
	<decorator:getProperty property="page.script"></decorator:getProperty>
</body>
</html>
