var isSplash = true;

$(document).ready(function(){
	var MSIE8 = ($.browser.msie) && ($.browser.version == 8);
	$.fn.ajaxJSSwitch({
		topMargin:80,//mandatory property for decktop
		bottomMargin:370,//mandatory property for decktop
		topMarginMobileDevices:0,//mandatory property for mobile devices
		bottomMarginMobileDevices:0,//mandatory property for mobile devices
		bodyMinHeight:920,
		delaySubMenuHide:350,
		menuInit:function (classMenu, classSubMenu){
			classMenu.find(">li").each(function(){
				$(">a", this).append("<div class='openPart'></div>");
			})
		},
		buttonOver:function (item){
			if(MSIE8){
				item.css({"color":"#3dd731"});
				$(".openPart", item).css({"visibility":"visible"});

				$(".base_text", item).css({"color":"#3d3d3d"});
				$(".small_text", item).css({"color":"#fff"});
				$(".menu_hline", item).css({"backgroundColor":"#fff"});
			}else{
				item.stop(true).animate({"color":"#3dd731"}, 200, "easeOutCubic");
				$(".openPart", item).stop(true).animate({"opacity":"1","top":"0px"}, 400, "easeOutCubic");
				$(".base_text", item).stop(true).animate({"color":"#3d3d3d"}, 400, "easeOutCubic");
				$(".small_text", item).stop(true).animate({"color":"#fff"}, 400, "easeOutCubic");
				$(".menu_hline", item).stop(true).animate({"backgroundColor":"#fff"}, 400, "easeOutCubic");
			}
		},
		buttonOut:function (item){
			if(MSIE8){
				item.css({"color":"#fff"});
				$(".openPart", item).css({"visibility":"hidden"});

				$(".base_text", item).css({"color":"#fff"});
				$(".small_text", item).css({"color":"#3d3d3d"});
				$(".menu_hline", item).css({"backgroundColor":"#3d3d3d"});
			}else{
				item.stop(true).animate({"color":"#fff"}, 200, "easeOutCubic");
				$(".openPart", item).stop(true).animate({"opacity":"0","top":"-120px"}, 400, "easeOutCubic");
				$(".base_text", item).stop(true).animate({"color":"#fff"}, 400, "easeOutCubic");
				$(".small_text", item).stop(true).animate({"color":"#3d3d3d"}, 400, "easeOutCubic");
				$(".menu_hline", item).stop(true).animate({"backgroundColor":"#3d3d3d"}, 400, "easeOutCubic");
			}
		},
		subMenuButtonOver:function (item){ 
		      /*item.stop().animate({"color":"#fff"}, 300, "easeOutCubic");*/
        },
		subMenuButtonOut:function (item){
		      /*item.stop().animate({"color":"#000"}, 300, "easeOutCubic");*/
        },
		subMenuShow:function(subMenu){
            if(MSIE8){
				subMenu.css({"display":"block"});
			}else{
				subMenu.stop(true).css({"display":"block"}).animate({"opacity":"1"}, 400, "easeOutCubic");
			}
        },
		subMenuHide:function(subMenu){
            if(MSIE8){
				subMenu.css({"display":"none"});
			}else{
				subMenu.stop(true).delay(300).animate({"opacity":"0"}, 400, "easeOutCubic", function(){
					$(this).css({"display":"none"})
				});
			}
        },
		pageInit:function (pages){
		},
		currPageAnimate:function (page){
              page.css({left:$(window).width()*-1-20}).stop(true).css({"top":"0"}).delay(100).animate({left:0}, 500, "easeInOutExpo");
              isSplash = false;
              $(window).trigger('resize');   
        },
		prevPageAnimate:function (page){
              page.stop(true).animate({"left":$(window).width()+20}, 700, "easeInSine");
              $("#wrapper>section>#content_part").css({"visibility":"visible"}).stop(true).animate({"top":0}, 100, "easeInOutCubic");
              $("#splash").stop(true).delay(0).animate({opacity:0, marginLeft:"500px"}, 500, "easeInOutCubic");
              $("h1").stop(true).delay(0).animate({marginTop:"50px"}, 500, "easeInOutCubic");
              $("#dark_bg").stop(true).delay(0).animate({opacity:1}, 500, "easeInOutCubic");
              $("#footer_line").stop(true).delay(0).animate({top:"2px"}, 500, "easeInOutCubic");
      
        },
		backToSplash:function (){
		      isSplash = true;
              $("#wrapper>section>#content_part").stop(true).delay(500).animate({"top":$(window).height()+20}, 700, "easeInOutCubic", function(){$(this).css({"visibility":"hidden"})});
              $("#splash").stop(true).delay(0).animate({opacity:1, marginLeft:0}, 500, "easeInOutCubic");
              $("h1").stop(true).delay(0).animate({marginTop:"153px"}, 500, "easeInOutCubic");
              $("#dark_bg").stop(true).delay(0).animate({opacity:0}, 500, "easeInOutCubic");
              $("#footer_line").stop(true).delay(0).animate({top:"-6px"}, 500, "easeInOutCubic");
              $(window).trigger('resize');        
        },
		pageLoadComplete:function (){
			$('.slider_spl')
				.uCarousel({
					show:1
					,shift:0
					,rows:1
					,buttonClass:'button1'			
					,axis:'x'
					,blockAtEnd:true
					,clickable:false
				})
		},
	});
})
$(window).load(function(){	
	$("#webSiteLoader").delay(550).animate({opacity:0}, 800, "easeInCubic", function(){$("#webSiteLoader").remove()});


	$('#prev_arr, #next_arr')
	.sprites({
		method:'simple',
		duration:400,
		easing:'easeOutQuint',
		hover:true
	})

	 
				
			 $('.prev, .next, .btn_icon1, .btn_icon2, .btn_icon3')
				.sprites({
					method:'simple',
					hover:true
				})

	
	$('.social_icons > li').hoverSprite({onLoadWebSite:true}); 


//-----Window resize------------------------------------------------------------------------------------------
	$(window).resize(
        function(){
            resize_function();
        }
    ).trigger('resize');

	function resize_function(){
	    var h_cont = $('header').height();
	    var wh = $(window).height();
		m_top = ~~(wh-h_cont)/2-100;
            if(isSplash){
                /*$("header").stop(true).delay(300).animate({"top":m_top}, 350, "easeOutSine");*/
                /*$("footer").stop(true).animate({"height":88}, 350, "easeOutSine");*/
            }else{
                /*$("header").stop(true).animate({"top":0}, 500, "easeOutCubic");*/
            }          
    }
    $(document).resize(
        function(){}
    ).trigger('resize');


    $('#description li').each(function(){
        if($(this).index() != 0)
            $(this).fadeOut();
    })  

	//bgStretch ---------------------------------------------------------------------------------------------
            $('#bgStretch')
		.bgStretch({
			align:'rightTop',
			navigs:$('#bgNav').navigs({autoPlay:1200000000, prevBtn:$('#prev_arr'), nextBtn:$('#next_arr')})
		}).sImg({
			spinner:$('.gall_spinner')
		}) 


	


});