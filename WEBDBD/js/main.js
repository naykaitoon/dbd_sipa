
$('.regis').fancybox({
		maxWidth	: 800,
		maxHeight	: 600,
		fitToView	: false,
		width		: '80%',
		height		: '80%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'none',
		closeEffect	: 'none',
		padding     : 0
	
});
$('.editGroup').fancybox({
		openEffect  : 'fade',
		closeEffect : 'fade',
		maxWidth	: 850,
		maxHeight	: 350,
		minWidth	: 850,
		minHeight	: 350,
		fitToView	: true,
		padding     : 5,
		beforeClose : function() {
					
       		 window.location.href='/index.php/dbdHome/page/magGuoup';
    }
	
});

$('.deleteGroup').fancybox({
		openEffect  : 'fade',
		closeEffect : 'fade',
		maxWidth	: 450,
		maxHeight	: 200,
		minWidth	: 450,
		minHeight	: 200,
		fitToView	: true,
		padding     : 5,
		beforeClose : function() {
					
       		 window.location.href='/index.php/dbdHome/page/magGuoup';
    }
	
});
	

$('.editType').fancybox({
		openEffect  : 'fade',
		closeEffect : 'fade',
		maxWidth	: 850,
		maxHeight	: 350,
		minWidth	: 850,
		minHeight	: 350,
		fitToView	: true,
		padding     : 5,
		beforeClose : function() {
					
       		 window.location.href='/index.php/dbdHome/page/magType';
    }
	
});

$('.deleteType').fancybox({
		openEffect  : 'fade',
		closeEffect : 'fade',
		maxWidth	: 450,
		maxHeight	: 200,
		minWidth	: 450,
		minHeight	: 200,
		fitToView	: true,
		padding     : 5,
		beforeClose : function() {
					
       		 window.location.href='/index.php/dbdHome/page/magType';
    }
	
});

	$('.detial').fancybox({
		maxWidth	: 1000,
		maxHeight	: 800,
		fitToView	: false,
		width		: '90%',
		height		: '90%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'none',
		closeEffect	: 'none',
		padding     : 0
	
});
	$('.budgetandfinace').fancybox({
		maxWidth	: 1500,
		maxHeight	: 1200,
		fitToView	: false,
		width		: '90%',
		height		: '90%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'none',
		closeEffect	: 'none',
		padding     : 0
	
});

$('.deleteGroupSeaech').fancybox({
		openEffect  : 'fade',
		closeEffect : 'fade',
		maxWidth	: 450,
		maxHeight	: 200,
		minWidth	: 450,
		minHeight	: 200,
		fitToView	: true,
		padding     : 5,
		beforeClose : function() {
					
       		 window.location.href='/index.php/dbdHome/page/listSearchGroup';
    }
	
});

$('.magProfi').fancybox({
		maxWidth	: 1500,
		maxHeight	: 1200,
		fitToView	: false,
		width		: '90%',
		height		: '90%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'none',
		closeEffect	: 'none',
		padding     : 0,
		beforeClose : function() {
					
       		 window.location.href='/index.php/dbdHome/page/magProfi';
    }
	
});
$('.addGroup').fancybox({
		maxWidth	: 1500,
		maxHeight	: 1200,
		fitToView	: false,
		width		: '90%',
		height		: '90%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'none',
		closeEffect	: 'none',
		padding     : 0,
		beforeClose : function() {
					
       		 window.location.href='/index.php/dbdHome/page/magGuoup';
    }
	
});