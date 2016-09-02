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
		<h1>Full Screen Background with content</h1>
		<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's 
		standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a 
		type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining 
		essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,
		and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum
		</p>
	
		<p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give 
		you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder 
		of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not 
		know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves 
		or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil 
		and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, 
		except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has 
		no annoying consequences, or one who avoids a pain that produces no resultant pleasure?
		</p>
	
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