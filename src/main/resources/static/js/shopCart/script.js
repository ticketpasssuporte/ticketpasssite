$('.color option:eq(1)').prop('selected', true).css('backgroundColor','black');

  $('a').children('i').hover(function() {
    $('table').css('transform', 'scale(0.8)').css('transition', 'all 1s');
	$('#totalAmount').css('transform', 'scale(0.8)').css('transition', 'all 1s');
	$('#mainContent').css('backgroundColor','rgba(211,211,211,0.6)');
	$('.hide').slideDown('slow');
  }, function() {
    // on mouseout, reset the background colour
    $('table').css('transform', '');
	$('#totalAmount').css('transform','');
	$('#mainContent').css('backgroundColor','');
	$('.hide').slideUp('slow');
  });
	
	$('.fa-minus').click(function() {
		var val_input = $(this).closest('tr').find('.qty');
		if (val_input.val() <= 0) { return; }
		val_input.val(parseInt(val_input.val() - 1));
		
		var price = $(this).closest('tr').find('.price');
		var cost = $(this).closest('tr').find('.cost');
		cost.val((parseFloat(price.val()) * val_input.val()).toFixed(2));
			
		total_cost();
	});

	$('.fa-plus').click(function() {
		var val_input = $(this).closest('tr').find('.qty');
    //alert(val_input.val());
		if (val_input.val() >=20) { return; }
		val_input.val(parseInt(val_input.val()) + 1);
		
		var price = $(this).closest('tr').find('.price');
		var cost = $(this).closest('tr').find('.cost');
		cost.val((parseFloat(price.val()) * val_input.val()).toFixed(2));
		
		total_cost();
	});

function total_cost() {
	var total = 0;
	$.each($('.cost'), function(index, value){
		total += parseFloat($(value).val());
		});
	total = total.toFixed(2);
	$('#total').val(total);
}
//restart the page
//$('#button').click(function(){
//  location.reload();
//});