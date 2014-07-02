$('#values_list li').hover(function() {
	$('#values_list li').removeClass('active');
	var item = $(this);
	item.addClass('active');
	$('#user_title').html(item.attr('data-title'));
	$('#user_value').html(item.attr('data-value'));
});

$
		.ajax({
			url : 'http://api.randomuser.me/',
			dataType : 'json',
			success : function(data) {
				var user = data.results[0].user;

				// Assign Data
				$('#user_photo img').attr('src', user.picture);

				$('li[data-label="name"]').attr('data-value',
						user.name.first + ' ' + user.name.last);
				$('#user_value').html(user.name.first + ' ' + user.name.last);

				$('li[data-label="email"]').attr('data-value', user.email);
				$('li[data-label="birthday"]').attr('data-value', user.dob);
				$('li[data-label="location"]').attr('data-value',
						user.location.street);
				$('li[data-label="phone"]').attr('data-value', user.cell);
				$('li[data-label="pass"]').attr('data-value', user.password);
			}
		});