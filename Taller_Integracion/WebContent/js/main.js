require.config({
  paths: {
    angular     : '../lib/angular/angular',
    angularRoute  : '../lib/angular-route/angular-route',
    angularResource : '../lib/angular-resource/angular-resource',
    bootstrap   : '../lib/bootstrap/dist/js/bootstrap',
    bootstrapui   : '../lib/angular-bootstrap/ui-bootstrap-tpls',
    jquery      : '../lib/jquery/dist/jquery',
    moment      : '../lib/moment/moment.min',
    excellexport	: '../lib/excellexport/excellentexport'
  },
  shim:  {
    angular :{
      exports :"angular"
    },
    angularRoute :{
      deps  :["angular"]
    },
    angularResource :{
      deps  :["angular"]
    },
    jquery :{
      exports :"jquery"
    },
    bootstrap :{
      deps  :["jquery"]
    },
    bootstrapui :{
      deps  :["angular"]
    },
    moment :{
      exports :"moment"
    },
    app : {
      deps  :["angular"]
    }
  },
  config: {
    moment: {
      noGlobal: true
    }
  },
 // urlArgs: "bust=" + (new Date()).getTime(),
  waitSeconds: 0

});
requirejs(["app"]);
