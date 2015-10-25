/**
 * 
 */
function addChange(id, data){
	var _thead = $('thead[id="'+id+'"]','#tb-change').attr('id');
	
	if (typeof _thead != 'undefined') {
		var _tbody = $('tbody[id="'+id+'"]','#tb-change');
		_tbody.append($(document.createElement('tr')).attr({id:"tr"+data.uuid})
				//.append($(document.createElement('td')).css({'width':'5%', 'text-align': 'center'}).text(data.code))
				.append($(document.createElement('td')).css({'width':'5%', 'text-align': 'center'}).text(data.course.cycle))
				.append($(document.createElement('td')).html(data.course.code + '&nbsp;' + data.course.name))
				.append($(document.createElement('td')).html(data.description))
				.append($(document.createElement('td')).css({'width':'5%', 'text-align': 'center'})
						.append($(document.createElement('button')).val(data.uuid).attr({onclick:'javascript:changeRemove(this.value)'})
									.addClass('ui-action-icons')
									.append('Remover')
									.button(
											{
												 icons: {
												 primary: "ui-icon-trash"
												 },
												 text: false
											}
									)))
				.append($(document.createElement('td')).css({'width':'5%', 'text-align': 'center'})
						.append($(document.createElement('input')).val(data.uuid).attr({type:'checkbox', checked:true, id:data.uuid, onclick:'javascript:changeState(this.value)'})))
		)
	} else {
		$('#tb-change')
		.append($(document.createElement('thead')).attr('id',id)
				.append($(document.createElement('tr'))
						.append($(document.createElement('th')).attr('colspan', 6).text(data.name))
				)
				.append($(document.createElement('tr'))
						//.append($(document.createElement('th')).html('&nbsp;').css('width','5%'))
						.append($(document.createElement('th')).html('Ciclo').css('width','5%'))
						.append($(document.createElement('th')).html('Curso').css('width','25%'))
						.append($(document.createElement('th')).html('Cambio').css('width','60%'))
						.append($(document.createElement('th')).html('Eliminar').css({'width':'5%', 'text-align': 'center'}))
						.append($(document.createElement('th')).html('Habilitar').css({'width':'5%', 'text-align': 'center'}))
				)
		);
		
		$('#tb-change')
		.append($(document.createElement('tbody')).attr('id',id)
				.append($(document.createElement('tr')).attr({id:"tr"+data.uuid})
						//.append($(document.createElement('td')).css({'width':'5%', 'text-align': 'center'}).text(data.code))
						.append($(document.createElement('td')).css({'width':'5%', 'text-align': 'center'}).text(data.course.cycle))
						.append($(document.createElement('td')).html(data.course.code + '&nbsp;' + data.course.name))
						.append($(document.createElement('td')).html(data.description))
						.append($(document.createElement('td')).css({'width':'5%', 'text-align': 'center'})
								.append($(document.createElement('button')).val(data.uuid).attr({onclick:'javascript:changeRemove(this.value)'})
											.addClass('ui-action-icons')
											.append('Remover')
											.button(
													{
														 icons: {
														 primary: "ui-icon-trash"
														 },
														 text: false
													}
											)))
						.append($(document.createElement('td')).css({'width':'5%', 'text-align': 'center'})
								.append($(document.createElement('input')).val(data.uuid).attr({type:'checkbox', checked:true, id:data.uuid, onclick:'javascript:changeState(this.value)'})))			
				)
		);
	}
	
	$('#tb-change').tableDnD();
}

function addNotification(message) {
	var _count = parseInt($('#ncount').text());
	_count=_count+1;
	$('#ncount').text(_count);
	$('#ol-notifications').append($(document.createElement('li')).html(message));
}

function changeState(_uuid) {
	var _state = $('#' + _uuid).is(":checked");
	$.ajax({
		method 		: "GET",
		url 		: "changeState",
		data		: { uuid: _uuid, state: _state },
		dataType 	: "text",
		cache : false
	}).done(function(data) {
		console.log(_uuid + ":" + _state);
	}).fail(function() {
		console.log("fail: "+_uuid + ":" + _state);
	});
}

function changeRemove(_uuid) {
	$.ajax({
		method 		: "GET",
		url 		: "changeRemove",
		data		: { uuid: _uuid },
		dataType 	: "text",
		cache : false
	}).done(function(data) {
		$('#tr' + _uuid,'#tb-change').remove();
		console.log(_uuid);
	}).fail(function() {
		console.log("fail: "+_uuid);
	});
}