Cufon.now();

$(function() {
	$('.slider')._TMS({
		prevBu : '.prev',
		nextBu : '.next',
		playBu : '.play',
		duration : 800,
		easing : 'easeOutQuad',
		preset : 'simpleFade',
		pagination : false,
		slideshow : 3000,
		numStatus : false,
		pauseOnHover : true,
		banners : true,
		waitBannerAnimation : false,
		bannerShow : function(banner) {
			banner.hide().fadeIn(500)
		},
		bannerHide : function(banner) {
			banner.show().fadeOut(500)
		}
	});
})
