$(document).ready(function(){
	$.post("LangManager", {"opt": "getLang"}, function(data){ chgLang(data); });
});


function chgLang(lang){
	
	jQuery.i18n.properties({
	    name:'locale', 
	    path:'js/locales/', 
	    mode:'map',
	    language:lang, 
	    callback: function() {
	    	updateDomText();
	    	$.post("LangManager", {"opt": "setLang", "lang": lang});
	    }
	});
}	

function updateDomText(){
	$(".i18n").each(function(i, element){
		if(element.tagName == "input")
			$(element).val(jQuery.i18n.prop(element.id));
		else
			$(element).html(jQuery.i18n.prop(element.id));
	});
}