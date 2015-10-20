//include('request_url.js');
//----jquery-plagins----
include('jquery-1.8.3.min.js');
include('jquery.ba-resize.min.js');
include('jquery.easing.1.3.js');
include('jquery.animate-colors-min.js');
include('jquery.backgroundpos.min.js');
include('jquery.mousewheel.js');
//----bootstrap----
include('panel_bootstrap.js');
include('jquery.cookie.js');
//----All-Scripts----
/*include('jquery.mobilemenu.js');*/
include('bgStretch.js');
include('forms.js');
include('sImg.js');
include('jquery.fancybox.pack.js');
include('uCarousel.js');
include('hoverSprite.js');
include('sprites.js');
include('ajax.js.switch.js');
include('jquery.equalheights.js');
include('script.js');
//----Include-Function----
function include(url){ 
  document.write('<script type="text/javascript" src="template/classic/js/'+ url + '"></script>'); 
  return false ;
}