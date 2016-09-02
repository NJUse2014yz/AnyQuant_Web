<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/introduction/detail.css" />


<script src="js/jquery-3.1.0.min.js"></script>

<title>detail</title>

<script type="text/javascript">

function slideSwitch() {
    var $active = $('#slideshow IMG.active');

    if ( $active.length == 0 ) $active = $('#slideshow IMG:last');

    // use this to pull the images in the order they appear in the markup
    var $next =  $active.next().length ? $active.next()
        : $('#slideshow IMG:first');

    // uncomment the 3 lines below to pull the images in random order
    
    // var $sibs  = $active.siblings();
    // var rndNum = Math.floor(Math.random() * $sibs.length );
    // var $next  = $( $sibs[ rndNum ] );


    $active.addClass('last-active');

    $next.css({opacity: 0.0})
        .addClass('active')
        .animate({opacity: 1.0}, 1000, function() {
            $active.removeClass('active last-active');
        });
}

$(function() {
    setInterval( "slideSwitch()", 2000 );
});

</script>

</head>
<body>

	<div id="content">
		<h1>${name}</h1>
		<p>${detail}</p>
	
		
	
	</div><!--end of content-->
	
	<!-- this will work with any number of images -->
	<!-- set the active class on whichever image you want to show up as the default 
	(otherwise this will be the last image) -->
	<div id="slideshow">
	    <img src="graphics/introduction/image1.jpg" alt="Slideshow Image 1" class="active" />
	    <img src="graphics/introduction/image2.jpg" alt="Slideshow Image 2" />
	    <img src="graphics/introduction/image3.jpg" alt="Slideshow Image 3" />
	    <img src="graphics/introduction/image1.jpg" alt="Slideshow Image 4" />
	    <img src="graphics/introduction/image2.jpg" alt="Slideshow Image 5" />
	</div>


</body>
</html>