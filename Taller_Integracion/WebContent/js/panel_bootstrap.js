$(window).load(function(){
	var typeWebsite = "normal"; /*    normal/responsive   */
	if($("#panel #advanced")[0]!=undefined){
		var wrapper = $("#wrapper"),
			advanced = $("#panel #advanced"),
			wrapperMargin=parseInt(advanced.css("marginTop")),
			MSIE8 = ($.browser.msie) && ($.browser.version == 8),
			panelePosition = "fixed",
			advancedHeight = advanced.height();
			
		if(typeWebsite == "normal"){
			panelePosition = "relative";
			wrapper.css({"marginTop":'-1px'});
		}
		$("head").append('<style>#panel>div.fixed#advanced{position:'+panelePosition+' !important;}</style>')
		if(wrapperMargin==0 && typeWebsite=="responsive"){
			wrapper.css({"marginTop":advancedHeight});
			wrapperMargin = advancedHeight;
		}else{
			wrapperMargin = 0;	
		}
		
		advanced.addClass("fixed");
		$(".trigger").click(
			function(){
				if(typeWebsite=="responsive"){
					if($.cookie("panel2")){
						wrapperMargin = advancedHeight;
						wrapper.animate({"marginTop":wrapperMargin},"fast");
					}else{
						wrapperMargin = 0;
						wrapper.animate({"marginTop":wrapperMargin},"fast");
					}
				}
			}
		)
	}
	$(window).resize(function(){
		if(!MSIE8){
			if($(document).outerWidth(true)<980){
				wrapper.css({"marginTop":'-1px'});
			}else{
				if(parseInt(advanced.css("marginTop"))==0){
					wrapper.css({"marginTop":wrapperMargin-1});
				}
			}
		}
	}).trigger("resize")
})